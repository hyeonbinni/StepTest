package com.tuto.steptest.step;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.tuto.steptest.R;
import com.tuto.steptest.utils.AnimatorUtil;
import com.tuto.steptest.utils.LayoutUtil;

import androidx.annotation.Nullable;

public class StepFinal extends LinearLayout implements IStep {
    public StepFinal(Context context) {
        super(context);

        init(context);
    }

    public StepFinal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutUtil.inflate(context, this, R.layout.step_final);
        AnimatorUtil.fadeInUp(this, 600, 200, null);
    }
}
