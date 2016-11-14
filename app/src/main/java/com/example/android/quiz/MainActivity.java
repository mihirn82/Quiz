package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.x;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calls evaluateQuiz and displayMessage methods.
     *
     */
    public void submitAnswers(View view) {
        String message = "";

        int score = evaluateQuiz();
        Log.v("MainActivity.java","score: " + score);
        if (score < 0) {
            message = "Please answer all questions";
        }
        else
        {
            message = score + " of 5";
            Toast.makeText(this, "Scored " + message, Toast.LENGTH_SHORT).show();
        }
        displayMessage(message);
    }

    /**
     * This method is used to evaluate whether all questions have been answered
     * @return grade returns the final score based on correctness of answers
     */
    private int evaluateQuiz(){
        int grade = 0;

        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();

        RadioButton apk1 = (RadioButton) findViewById(R.id.apk_1);
        RadioButton apk2 = (RadioButton) findViewById(R.id.apk_2);
        RadioButton apk3 = (RadioButton) findViewById(R.id.apk_3);
        RadioButton apk4 = (RadioButton) findViewById(R.id.apk_4);

        RadioButton view1 = (RadioButton) findViewById(R.id.view_1);
        RadioButton view2 = (RadioButton) findViewById(R.id.view_2);
        RadioButton view3 = (RadioButton) findViewById(R.id.view_3);
        RadioButton view4 = (RadioButton) findViewById(R.id.view_4);

        CheckBox viewGroup1 = (CheckBox) findViewById(R.id.view_group_1);
        CheckBox viewGroup2 = (CheckBox) findViewById(R.id.view_group_2);
        CheckBox viewGroup3 = (CheckBox) findViewById(R.id.view_group_3);
        CheckBox viewGroup4 = (CheckBox) findViewById(R.id.view_group_4);

        RadioButton xml1 = (RadioButton) findViewById(R.id.xml_1);
        RadioButton xml2 = (RadioButton) findViewById(R.id.xml_2);
        RadioButton xml3 = (RadioButton) findViewById(R.id.xml_3);
        RadioButton xml4 = (RadioButton) findViewById(R.id.xml_4);

        if (name.equals("")){
            grade = -1;
        }
        else if (!apk1.isChecked() && !apk2.isChecked() && !apk3.isChecked() && !apk4.isChecked()) {
            grade = -1;
        }
        else if (!view1.isChecked() && !view2.isChecked() && !view3.isChecked() && !view4.isChecked()) {
            grade = -1;
        }
        else if (!viewGroup1.isChecked() && !viewGroup2.isChecked() && !viewGroup3.isChecked() && !viewGroup4.isChecked()) {
            grade = -1;
        }
        else if (!xml1.isChecked() && !xml2.isChecked() && !xml3.isChecked() && !xml4.isChecked()) {
            grade = -1;
        }

        if (grade == 0) {
            if (name.equals("Google")) {
                grade = grade + 1;
            }
            if (apk1.isChecked()) {
                grade = grade + 1;
            }
            if (view4.isChecked()) {
                grade = grade + 1;
            }
            if (viewGroup1.isChecked() && viewGroup3.isChecked()) {
                grade = grade + 1;
            }
            if (xml2.isChecked()) {
                grade = grade + 1;
            }
        }
        return grade;
    }


    /**
     * This method displays the given text on the screen.
     * @param message is used to pass the String to be displayed.
     */
    private void displayMessage(String message) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }
}
