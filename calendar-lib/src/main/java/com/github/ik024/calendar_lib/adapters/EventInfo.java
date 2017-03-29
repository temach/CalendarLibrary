package com.github.ik024.calendar_lib.adapters;

import android.graphics.Color;

/**
 * Created by artem on 3/29/17.
 */

public class EventInfo {
    private int bgColor;
    private int textColor;

    public EventInfo(int backgroundColor, int textColor) {
        this.bgColor = backgroundColor;
        this.textColor = textColor;
    }

    public int getEventBackgroundColor() {
        return bgColor;
    }

    public int getEventTextColor() {
        return textColor;
    }
}
