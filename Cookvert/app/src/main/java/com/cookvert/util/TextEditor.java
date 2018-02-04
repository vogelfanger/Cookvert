package com.cookvert.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

public class TextEditor {

    private static final TextEditor instance = new TextEditor();

    public static TextEditor getInstance() {
        return instance;
    }

    private TextEditor() {
    }

    /**
     * Combines two strings into one, where one of the strings is made bold.
     * @return spannable, which consists of parameter strings where one of them is bold
     * @param after text after the bold part
     * @param bold bold part of the text
     */
    public static SpannableString addBoldSection(String bold, String after){
        String returnString = bold + " " + after;
        SpannableString sp = new SpannableString(returnString);
        sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), returnString.indexOf(bold),
                bold.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }
}
