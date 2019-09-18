package com.tuto.steptest.step;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuto.steptest.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StepActivity extends AppCompatActivity implements View.OnClickListener {
    private final int STEP_ONE = 0;
    private final int STEP_TWO = 1;
    private final int STEP_THREE = 2;
    private final int STEP_FINAL = 3;

    private ImageView imgBackBtn;
    private ImageView imgIcon;

    private TextView tvPrevBtn;
    private TextView tvTopTitle;
    private TextView tvNextBtn;
    private TextView tvStepTitle;
    private TextView tvStepDesc;

    private LinearLayout layoutContainer;

    private IStep currentStep;

    private int stepNum = STEP_ONE;

    private String[] stepTitles;
    private String[] stepDescs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step);

        initStepTitles();
        initStepDescs();

        imgBackBtn = findViewById(R.id.img_back_btn);
        imgBackBtn.setOnClickListener(this);

        imgIcon = findViewById(R.id.img_icon);
        imgIcon.setImageResource(R.drawable.step_icon);

        tvPrevBtn = findViewById(R.id.tv_prev_btn);
        tvPrevBtn.setText("PREV");
        tvPrevBtn.setOnClickListener(this);

        tvNextBtn = findViewById(R.id.tv_next_btn);
        tvNextBtn.setText("NEXT");
        tvNextBtn.setOnClickListener(this);

        tvTopTitle = findViewById(R.id.tv_top_title);
        tvStepTitle = findViewById(R.id.tv_step_title);
        tvStepDesc = findViewById(R.id.tv_step_desc);

        layoutContainer = findViewById(R.id.layout_container);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        updateUI();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back_btn:
            case R.id.tv_prev_btn:
                onBackPressed();
                break;
            case R.id.tv_next_btn:
                moveNextStep();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(stepNum > STEP_ONE) {
            stepNum --;
            updateUI();
        } else {
            finish();
        }
    }

    private void initStepTitles() {
        stepTitles = new String[]{"Step 1", "Step 2", "Step 3", "Final Step"};
    }

    private void initStepDescs() {
        stepDescs = new String[]{"Description for Step 1", "Description for Step 2", "Description for Step 3", "Description for Final step"};
    }

    private void moveNextStep() {
        if(stepNum == STEP_FINAL) {
            finish();
        } else {
            stepNum++;
            updateUI();
        }
    }

    private void updateUI() {
        tvStepTitle.setText(stepTitles[stepNum]);
        tvStepDesc.setText(stepDescs[stepNum]);

        layoutContainer.removeAllViews();

        if(stepNum == STEP_FINAL) {
            tvTopTitle.setText("Final Step");
            tvNextBtn.setText("FINISH");
        } else {
            tvTopTitle.setText("STEP " + (stepNum + 1));
            tvNextBtn.setText("NEXT");
        }

        if(stepNum == STEP_ONE) {
            imgBackBtn.setVisibility(View.VISIBLE);
            tvPrevBtn.setVisibility(View.GONE);
        } else {
            imgBackBtn.setVisibility(View.GONE);
            tvPrevBtn.setVisibility(View.VISIBLE);
        }

        switch (stepNum) {
            case STEP_ONE:
                StepOne stepOne = new StepOne(this);
                layoutContainer.addView(stepOne);
                currentStep = stepOne;
                break;
            case STEP_TWO:
                StepTwo stepTwo = new StepTwo(this);
                layoutContainer.addView(stepTwo);
                currentStep = stepTwo;
                break;
            case STEP_THREE:
                StepThree stepThree = new StepThree(this);
                layoutContainer.addView(stepThree);
                currentStep = stepThree;
                break;
            case STEP_FINAL:
                StepFinal stepFinal = new StepFinal(this);
                layoutContainer.addView(stepFinal);
                currentStep = stepFinal;
                break;
            default:
                break;
        }
    }
}
