package com.tuto.steptest.step;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.tuto.steptest.R;
import com.tuto.steptest.utils.AnimatorUtil;
import com.tuto.steptest.utils.LayoutUtil;

import androidx.annotation.Nullable;

public class StepThree extends LinearLayout implements IStep {
    public StepThree(Context context) {
        super(context);

        init(context);
    }

    public StepThree(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutUtil.inflate(context, this, R.layout.step_three);
        AnimatorUtil.fadeInUp(this, 600, 200, null);
    }
}
