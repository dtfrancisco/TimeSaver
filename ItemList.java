package com.example.timesaver;

import android.graphics.drawable.Drawable;
import android.widget.Button;

/**
 * Created by Imane on 4/7/18.
 */

public class ItemList {

    Drawable appIcon;
    String appName;
    String processName;
    // Button button;

    public ItemList(Drawable appIcon, String appName, String processName) {
        this.appIcon = appIcon;
        this.appName = appName;
        this.processName = processName;
        //   this.button = button;
    }


    public Drawable getAppIcon() {
        return appIcon;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


  /*  public Button getButton() {
        return button;
    }
    public void setButton(Button button) {
        this.button = button;
    } */
}