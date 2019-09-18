package com.tuto.steptest.utils;

import android.animation.Animator;
import android.view.View;

public class AnimatorUtil {
    public static void fadeInUp(final View v, int duration, int delay, Animator.AnimatorListener listener) {
        v.setAlpha(0);
        v.setTranslationY(140);
        v.animate()
                .setListener(listener)
                .alpha(1).translationY(0)
                .setStartDelay(delay).setDuration(duration)
                .start();
    }

}
