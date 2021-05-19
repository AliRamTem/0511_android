package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerListActivity extends AppCompatActivity {
    private TextView answers;
    private boolean[] answerArray;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_list);

        answers = findViewById(R.id.textViewYourAnswers);
        start = findViewById(R.id.buttonStartNew);
        answerArray = getIntent().getBooleanArrayExtra("answers");
        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i])
                answers.append((i + 1) + ") Правильно \n" );
            else
                answers.append((i + 1) + ") Не правильно \n");
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnswerListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}