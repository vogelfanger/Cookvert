package com.cookvert.navigation;

/**
 *
 */

public class NavigationItem {

    private String text; // text title of navigation item
    int iconRes; // resource id of item's icon

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public NavigationItem(String text, int iconRes) {
        this.text = text;
        this.iconRes = iconRes;
    }
}
