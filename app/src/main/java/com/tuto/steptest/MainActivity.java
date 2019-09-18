package com.tuto.steptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuto.steptest.step.StepActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMoveToStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnMoveToStep = findViewById(R.id.btn_move_to_step);
        btnMoveToStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStepActivity();
            }
        });
    }

    private void startStepActivity() {
        Intent intent = new Intent(getApplicationContext(), StepActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
