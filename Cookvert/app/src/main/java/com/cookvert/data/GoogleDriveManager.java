package com.cookvert.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.MimeTypeMap;

import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.util.Cookvert;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;

public class GoogleDriveManager {

    private static GoogleDriveManager manager = new GoogleDriveManager();

    public static final String TAG = "GoogleDriveManager";

    private boolean unsavedData; // when true, calling save method sends the data to drive.

    private GoogleSignInClient googleSignInClient;
    private DriveClient driveClient;
    private DriveResourceClient driveResourceClient;
    private GoogleSignInAccount account;

    private Query databaseQuery;

    private GoogleDriveManager(){
        databaseQuery = new Query.Builder().addFilter(Filters.eq(SearchableField.TITLE, "recipes.db")).build();
        unsavedData = false;

    }

    public GoogleSignInAccount getAccount() {
        return account;
    }

    public boolean isUnsavedData() {
        return unsavedData;
    }

    public void setAccount(GoogleSignInAccount account) {
        this.account = account;
    }

    public void setUnsavedData(boolean unsavedData) {
        this.unsavedData = unsavedData;
    }

    public static GoogleDriveManager getInstance(){
        return manager;
    }

    public GoogleSignInClient getGoogleSignInClient() {
        return googleSignInClient;
    }

    public void setGoogleSignInClient(GoogleSignInClient googleSignInClient) {
        this.googleSignInClient = googleSignInClient;
    }

    public DriveClient getDriveClient() {
        return driveClient;
    }

    public void setDriveClient(DriveClient mDriveClient) {
        this.driveClient = mDriveClient;
    }

    public DriveResourceClient getDriveResourceClient() {
        return driveResourceClient;
    }

    public void setDriveResourceClient(DriveResourceClient mDriveResourceClient) {
        this.driveResourceClient = mDriveResourceClient;
    }



    //*********************************************************************************************
    //                                      PUBLIC METHODS
    //*********************************************************************************************



    /**
     * Gets app folder and database file from Drive
     * and replaces local database file with the loaded file, if it exists.
     * @param activity
     */
    public void loadAppDataFromDrive(Activity activity){
        getAppFolderFromDrive(activity, false);
    }

    /**
     * Gets app folder and database file from Drive
     * and replaces the file in Drive with copy of local database.
     * @param activity
     */
    public void saveAppDataToDrive(Activity activity){
        if(unsavedData) {
            getAppFolderFromDrive(activity, true);
        }
    }

    // Returns true if Google Drive clients are already extracted.
    public boolean signedIn(){
        if(driveClient == null || driveResourceClient == null){
            return false;
        }else{
            return true;
        }
    }

    public void signOut(){
        googleSignInClient = null;
        driveResourceClient = null;
        driveClient = null;
        account = null;
    }


    //*********************************************************************************************
    //                                      PRIVATE METHODS
    //*********************************************************************************************

    /**
     * Builds a new sign in client.
     */
    public void buildGoogleSignInClient(Context context) {
        GoogleSignInOptions signInOptions =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestScopes(Drive.SCOPE_APPFOLDER)
                        .build();
        googleSignInClient = GoogleSignIn.getClient(context, signInOptions);
    }



    /**
     * Creates a new database file to app folder.
     * @param activity
     */
    private void createDatabaseInAppFolder(final Activity activity) {
        final Task<DriveFolder> appFolderTask = getDriveResourceClient().getAppFolder();
        final Task<DriveContents> createContentsTask = getDriveResourceClient().createContents();
        Tasks.whenAll(appFolderTask, createContentsTask)
                .continueWithTask(new Continuation<Void, Task<DriveFile>>() {
                    @Override
                    public Task<DriveFile> then(@NonNull Task<Void> task) throws Exception {
                        DriveFolder parent = appFolderTask.getResult();
                        DriveContents contents = createContentsTask.getResult();
                        java.io.File file = new java.io.File(DBHelper.getDbPath() + DBHelper.DATABASE_NAME);
                        try (OutputStream out = contents.getOutputStream()) {
                            FileInputStream in = new FileInputStream(file);
                            byte[] buffer = new byte[1024];
                            int len;
                            while ((len = in.read(buffer)) != -1) {
                                out.write(buffer, 0, len);
                                out.flush();
                            }
                            out.close();
                            in.close();
                        }

                        MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                                .setTitle(DBHelper.DATABASE_NAME)
                                .setMimeType("application/octet-stream")
                                .setStarred(true)
                                .build();

                        return getDriveResourceClient().createFile(parent, changeSet, contents);
                    }
                })
                .addOnSuccessListener(activity,
                        new OnSuccessListener<DriveFile>() {
                            @Override
                            public void onSuccess(DriveFile driveFile) {
                                Log.i(TAG, "File created successfully");
                                unsavedData = false;
                            }
                        })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("GoogleDriveManager", "Unable to create file", e);
                    }
                });
    }



    /**
     * Copies the database file from Drive and overwrites the database file in local data folder,
     * @param activity
     */
    private void copyDatabaseFromDrive(final Activity activity, DriveFile dbFile){
        final Task<DriveContents> openTask = getDriveResourceClient().openFile(dbFile, DriveFile.MODE_READ_ONLY);
        openTask.continueWithTask(new Continuation<DriveContents, Task<Void>>() {
            @Override
            public Task<Void> then(@NonNull Task<DriveContents> task) throws Exception {
                DriveContents driveContents = task.getResult();
                try (InputStream in = driveContents.getInputStream()) {

                    java.io.File localFile = new java.io.File(DBHelper.getDbPath() + DBHelper.DATABASE_NAME);
                    // Create an output stream to local file with override setting.
                    FileOutputStream out = new FileOutputStream(localFile, false);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                        out.flush();
                    }
                    out.close();
                    in.close();
                }

                Task<Void> discardTask = getDriveResourceClient().discardContents(driveContents);
                return discardTask;
            }
        })
                .addOnSuccessListener(activity,
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.i(TAG, "Contents was successfully downloaded");
                            }
                        })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Unable to download contents", e);
                    }
                });
    }



    private void getAppFolderFromDrive(final Activity activity, final boolean savingFile){
        final Task<DriveFolder> appFolderTask = driveResourceClient.getAppFolder();
        appFolderTask.addOnSuccessListener(activity, new OnSuccessListener<DriveFolder>() {
            @Override
            public void onSuccess(DriveFolder driveFolder) {
                Log.i(TAG, "App folder retrieved");
                getDatabaseFileFromDrive(activity, driveFolder, savingFile);
            }
        });

        appFolderTask.addOnFailureListener(activity, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "App folder retrieval failed");
            }
        });
    }


    private void getDatabaseFileFromDrive(final Activity activity, DriveFolder appFolder, final boolean savingFile){
        Task<MetadataBuffer> queryTask = driveResourceClient.queryChildren(appFolder, databaseQuery);
        queryTask.addOnSuccessListener(activity, new OnSuccessListener<MetadataBuffer>() {
            @Override
            public void onSuccess(MetadataBuffer metadatas) {

                if(metadatas.getCount() > 0){

                    SharedPreferences prefs = activity.getSharedPreferences(Cookvert.PREFS_NAME, 0);
                    long localEditDate = prefs.getLong(Cookvert.PREFS_DB_LAST_EDITED, 0L);
                    long driveEditDate = metadatas.get(0).getModifiedDate().getTime();

                    // data is being saved and local db was edited last
                    if(savingFile && localEditDate > driveEditDate){
                        DriveId databaseDriveId = metadatas.get(0).getDriveId();
                        metadatas.get(0).getModifiedDate();
                        Log.i(TAG, "Database file retrieved");
                        saveDatabaseToAppFolder(activity, databaseDriveId.asDriveFile());
                    }
                    // data is being loaded and drive db was edited last
                    else if(localEditDate < driveEditDate){
                        DriveId databaseDriveId = metadatas.get(0).getDriveId();
                        Log.i(TAG, "Database file retrieved");
                        copyDatabaseFromDrive(activity, databaseDriveId.asDriveFile());
                    }
                }

                //No files in app folder, create a new file and write local database into it.
                else if(metadatas.getCount() == 0){
                    Log.i(TAG, " No database file found, creating a new one");
                    createDatabaseInAppFolder(activity);
                }
                metadatas.release();
            }
        });

        queryTask.addOnFailureListener(activity, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Database file retrieval failed");
            }
        });
    }



    /**
     * Retrieves Drive clients if sign in task succeeds.
     * @param task
     * @param context
     */
    public void googleSignInAccountTask(Task<GoogleSignInAccount> task, final Context context, final Activity activity) {
        Log.i("GoogleSignIn", "Update view with sign in account task");
        task.addOnSuccessListener(
                new OnSuccessListener<GoogleSignInAccount>() {
                    @Override
                    public void onSuccess(GoogleSignInAccount googleSignInAccount) {
                        Log.i(TAG, "Sign in success");
                        // Build a drive client.
                        driveClient = Drive.getDriveClient(context, googleSignInAccount);
                        // Build a drive resource client.
                        driveResourceClient =
                                Drive.getDriveResourceClient(context, googleSignInAccount);

                        // Save or load app data on sign in, depending on the timestamp of last edit.
                        try{
                            saveAppDataToDrive(activity);
                            loadAppDataFromDrive(activity);
                        }catch (Exception e){
                            Log.e(TAG, "Loading data from Drive failed", e);
                        }
                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Sign in failed", e);
                            }
                        });
    }



    /**
     * Opens given Drive file and overwrites it with the local database file.
     * @param activity
     * @param dbFile
     */
    private void saveDatabaseToAppFolder(Activity activity, DriveFile dbFile){

        Task<DriveContents> openTask = getDriveResourceClient().openFile(dbFile, DriveFile.MODE_WRITE_ONLY);
        openTask.continueWithTask(new Continuation<DriveContents, Task<Void>>() {
            @Override
            public Task<Void> then(@NonNull Task<DriveContents> task) throws Exception {
                DriveContents driveContents = task.getResult();
                java.io.File file = new java.io.File(DBHelper.getDbPath() + DBHelper.DATABASE_NAME);
                try (OutputStream out = driveContents.getOutputStream()) {
                    FileInputStream in = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                        out.flush();
                    }
                    out.close();
                    in.close();
                }

                MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                        .setStarred(true)
                        .setLastViewedByMeDate(new Date())
                        .build();
                Task<Void> commitTask =
                        getDriveResourceClient().commitContents(driveContents, changeSet);


                return commitTask;
            }
        })
                .addOnSuccessListener(activity,
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.i(TAG, "Database in Drive was updated successfully");
                                unsavedData = false;
                            }
                        })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Unable to update contents", e);
                    }
                });
    }





}
