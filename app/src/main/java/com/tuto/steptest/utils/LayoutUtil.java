package com.tuto.steptest.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LayoutUtil {
    public static View inflate(Context context , ViewGroup root, final int id){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(id, root, true);
    }
}
