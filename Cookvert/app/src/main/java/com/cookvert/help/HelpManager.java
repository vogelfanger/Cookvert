package com.cookvert.help;

import com.cookvert.R;
import com.cookvert.util.Cookvert;

import java.util.ArrayList;

/**
 * Control object that manages data for adapters in HelpActivity
 */

public class HelpManager {

    public final static String ARG_HELP_CONTENT = "helpContent";

    private static HelpManager manager = new HelpManager();

    // titles of the help texts, also displayed as items in help item list
    private ArrayList<String> helpTopics;
    private int focusPosition;

    private HelpManager(){
        helpTopics = new ArrayList<>();
        createHelpTopics();
        focusPosition = 0;

    }

    public static HelpManager getInstance(){
        return manager;
    }

    public ArrayList<String> getHelpTopics() {
        return helpTopics;
    }

    public void setHelpTopics(ArrayList<String> helpTopics) {
        this.helpTopics = helpTopics;
    }

    public int getFocusPosition() {
        return focusPosition;
    }

    public void setFocusPosition(int focusPosition) {
        this.focusPosition = focusPosition;
    }

    /**
     * Fills manager lists with resource strings.
     * TODO add all help topics and texts here when finished
     */
    private void createHelpTopics(){
        helpTopics.add(Cookvert.getAppContext().getResources().getString(
                R.string.title_help_how_to_convert));
        helpTopics.add(Cookvert.getAppContext().getResources().getString(
                R.string.title_help_how_to_convert_saved_recipe));
        helpTopics.add(Cookvert.getAppContext().getResources().getString(
                R.string.title_help_how_to_convert_temperature));
        helpTopics.add(Cookvert.getAppContext().getResources().getString(
                R.string.title_help_how_to_save_recipes));
        helpTopics.add(Cookvert.getAppContext().getResources().getString(
                R.string.title_help_how_to_scale_recipe));
        helpTopics.add(Cookvert.getAppContext().getResources().getString(
                R.string.title_help_which_units_to_use));
    }

    public String getFocusedHelpTopic(){
        return helpTopics.get(focusPosition);
    }
}
