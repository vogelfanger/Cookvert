package com.cookvert.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
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
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.query.internal.zzj;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
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
    public static final String APP_FOLDER_NAME = "cookvert_data";
    public static final String CUSTOM_PROPERTY_KEY_APP_FOLDER = "CookvertAppFolder";
    public static final String CUSTOM_PROPERTY_KEY_DB_FILE = "CookvertDatabaseFile";

    private boolean unsavedData; // when true, calling save method sends the data to drive.

    private GoogleSignInClient googleSignInClient;
    private DriveClient driveClient;
    private DriveResourceClient driveResourceClient;
    private GoogleSignInAccount account;

    private Query databaseQuery;
    private Query appFolderQuery;

    // Custom property to identify the folder in queries
    private CustomPropertyKey appFolderPropertyKey;
    private CustomPropertyKey DBPropertyKey;

    private GoogleDriveManager(){
        appFolderPropertyKey = new CustomPropertyKey(CUSTOM_PROPERTY_KEY_APP_FOLDER, CustomPropertyKey.PUBLIC);
        DBPropertyKey = new CustomPropertyKey(CUSTOM_PROPERTY_KEY_DB_FILE, CustomPropertyKey.PUBLIC);

        // Database file query searches for untrashed files with the database name and custom property.
        databaseQuery = new Query.Builder().addFilter(Filters.and(Filters.eq(SearchableField.TRASHED, false),
                Filters.and(Filters.eq(SearchableField.TITLE, DBHelper.DATABASE_NAME),
                Filters.eq(DBPropertyKey, "true"))))
                .build();
        // App folder query seaches for untrashed folders with the app folder name and custom property.
        appFolderQuery = new Query.Builder()
                .addFilter(Filters.and(Filters.eq(SearchableField.TRASHED, false),
                        Filters.and(Filters.eq(SearchableField.TITLE, APP_FOLDER_NAME),
                        Filters.and(Filters.eq(appFolderPropertyKey, "true"),
                                Filters.eq(SearchableField.MIME_TYPE, "application/vnd.google-apps.folder")))))
                .build();

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
     * Builds a new sign in client.
     */
    public void buildGoogleSignInClient(Context context) {
        GoogleSignInOptions signInOptions =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestScopes(Drive.SCOPE_FILE)
                        .build();
        googleSignInClient = GoogleSignIn.getClient(context, signInOptions);
    }



    /**
     * Retrieves Drive clients if sign in task succeeds.
     * @param task
     * @param context
     */
    public void googleSignInAccountTask(Task<GoogleSignInAccount> task, final Context context, final Activity activity) {
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

                        // Load or save app data on sign in
                        try{
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
                                Log.e(TAG, "Sign in failed", e);
                            }
                        });
    }



    /**
     * Gets app folder and database file from Drive
     * and replaces local database file with the loaded file, if it exists.
     * If Drive has no new data to load, try saving instead.
     * @param activity
     */
    public void loadAppDataFromDrive(Activity activity){
        getRootFolderFromDrive(activity, false);
    }


    /**
     * Gets app folder and database file from Drive
     * and replaces the file in Drive with copy of local database.
     * @param activity
     */
    public void saveAppDataToDrive(Activity activity){
        if(unsavedData) {
            getRootFolderFromDrive(activity, true);
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
     * Creates an app folder to root and creates new database file into the folder.
     * @param activity
     */
    private void createAppFolder(final Activity activity) {
        getDriveResourceClient()
                .getRootFolder()
                .continueWithTask(new Continuation<DriveFolder, Task<DriveFolder>>() {
                    @Override
                    public Task<DriveFolder> then(@NonNull Task<DriveFolder> task)
                            throws Exception {
                        DriveFolder parentFolder = task.getResult();

                        MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                                .setTitle(APP_FOLDER_NAME)
                                .setMimeType(DriveFolder.MIME_TYPE)
                                .setStarred(false)
                                .setCustomProperty(appFolderPropertyKey, "true")
                                .build();
                        return getDriveResourceClient().createFolder(parentFolder, changeSet);
                    }
                })
                .addOnSuccessListener(activity, new OnSuccessListener<DriveFolder>() {
                    @Override
                    public void onSuccess(DriveFolder driveFolder) {
                        Log.d(TAG, "App folder created");
                        createDatabaseInAppFolder(activity, driveFolder);
                    }
                })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Unable to create app folder", e);
                    }
                });

    }

    /**
     * Creates a new database file to app folder.
     * @param activity
     */
    private void createDatabaseInAppFolder(final Activity activity, final DriveFolder appFolder) {
        final Task<DriveContents> createContentsTask = getDriveResourceClient().createContents();
        createContentsTask
                .continueWithTask(new Continuation<DriveContents, Task<DriveFile>>() {
                    @Override
                    public Task<DriveFile> then(@NonNull Task<DriveContents> task) throws Exception {
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
                                .setStarred(false)
                                .setCustomProperty(DBPropertyKey, "true")
                                .build();

                        return getDriveResourceClient().createFile(appFolder, changeSet, contents);
                    }
                })
                .addOnSuccessListener(activity,
                        new OnSuccessListener<DriveFile>() {
                            @Override
                            public void onSuccess(DriveFile driveFile) {
                                Log.d(TAG, "File created successfully");
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
                                Log.d(TAG, "Contents was successfully downloaded");
                            }
                        })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Unable to download contents", e);
                    }
                });
    }

    /**
     * Finds the root folder and uses it to search for app folder.
     * @param activity
     * @param savingFile
     */
    private void getRootFolderFromDrive(final Activity activity, final boolean savingFile){
        Task<DriveFolder> folderTask = driveResourceClient.getRootFolder();
        folderTask.addOnSuccessListener(activity, new OnSuccessListener<DriveFolder>() {
            @Override
            public void onSuccess(DriveFolder driveFolder) {
                Log.d(TAG, "Root folder retrieved");
                getAppFolderFromDrive(driveFolder, activity, savingFile);
            }
        });

        folderTask.addOnFailureListener(activity, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "Root folder retrieval failed", e);
            }
        });
    }

    /**
     * Searches for app folder from root, if the folder is found, it is used to search for db file,
     * if folder is not found, creates a new app folder to root.
     * @param root
     * @param activity
     * @param savingFile
     */
    private void getAppFolderFromDrive(final DriveFolder root, final Activity activity, final boolean savingFile){
        Task<MetadataBuffer> queryTask = driveResourceClient.queryChildren(root, appFolderQuery);

        // Search for app folder from root
        queryTask.addOnSuccessListener(activity, new OnSuccessListener<MetadataBuffer>() {
            @Override
            public void onSuccess(MetadataBuffer metadatas) {

                if(metadatas.getCount() > 1){
                    Log.w(TAG, "Found multiple app folders, can't determine which one to use, file count: " + metadatas.getCount());
                }

                // App folder found, search for the db file
                if(metadatas.getCount() > 0){
                    DriveFolder appFolder = metadatas.get(0).getDriveId().asDriveFolder();
                    Log.d(TAG, "App folder retrieved");
                    getDatabaseFileFromDrive(activity, appFolder, savingFile);
                }

                // Can't find app folder, create one instead
                else{
                    Log.d(TAG, "Could not find the app folder");
                    createAppFolder(activity);
                }
                metadatas.release();
            }
        });
    }


    private void getDatabaseFileFromDrive(final Activity activity, final DriveFolder appFolder, final boolean savingFile){
        Task<MetadataBuffer> queryTask = driveResourceClient.queryChildren(appFolder, databaseQuery);
        queryTask.addOnSuccessListener(activity, new OnSuccessListener<MetadataBuffer>() {
            @Override
            public void onSuccess(MetadataBuffer metadatas) {

                // If there are multiple files in the folder...
                if(metadatas.getCount() > 1){
                    Log.w(TAG, "Query returns multiple files, can't determine which is the database, file count: " + metadatas.getCount());
                }

                // There is at least one file in app folder, do save or load.
                if(metadatas.getCount() > 0){
                    SharedPreferences prefs = activity.getSharedPreferences(Cookvert.PREFS_NAME, 0);
                    long localEditDate = prefs.getLong(Cookvert.PREFS_DB_LAST_EDITED, 0L);
                    long driveEditDate = metadatas.get(0).getModifiedDate().getTime();

                    // data is being saved and local db was edited last
                    if(savingFile && localEditDate > driveEditDate){
                        DriveId databaseDriveId = metadatas.get(0).getDriveId();
                        Log.d(TAG, "Database file retrieved");
                        saveDatabaseToAppFolder(activity, databaseDriveId.asDriveFile());
                    }
                    // data is being loaded and Drive db was edited last
                    else if(!savingFile && localEditDate < driveEditDate){
                        DriveId databaseDriveId = metadatas.get(0).getDriveId();
                        Log.d(TAG, "Database file retrieved");
                        copyDatabaseFromDrive(activity, databaseDriveId.asDriveFile());
                    }
                }

                //No files in app folder, create a new file and write local database into it.
                else if(metadatas.getCount() == 0){
                    Log.d(TAG, " No database file found, creating a new one");
                    //createDatabaseInAppFolder(activity, appFolder);
                }
                metadatas.release();
            }
        });

        queryTask.addOnFailureListener(activity, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "Database file retrieval failed", e);
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
                                Log.d(TAG, "Database in Drive was updated successfully");
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
