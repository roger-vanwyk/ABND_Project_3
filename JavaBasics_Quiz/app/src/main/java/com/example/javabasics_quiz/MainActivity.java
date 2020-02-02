/*
Copyright (c) 2019 Roger van Wyk
This code is written specifically for ABND + AAL grant Project 3 of 6.
African App Launchpad in partnership with Google.
*/

package com.example.android.javabasics_quiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuestionOneAnswers(){
        CheckBox questionOneJava = (CheckBox) findViewById(R.id.checkboxQuest1AnswerJava);
        CheckBox questionOneVariables = (CheckBox) findViewById(R.id.checkboxQuest1AnswerVariables);
        CheckBox questionOneAndroid = (CheckBox) findViewById(R.id.checkboxQuest1AnswerAndroid);
        boolean isQuestionOneJavaChecked = questionOneJava.isChecked();
        boolean isQuestionOneVariablesChecked = questionOneVariables.isChecked();
        boolean isQuestionOneAndroidChecked = questionOneAndroid.isChecked();

        if (isQuestionOneJavaChecked && isQuestionOneVariablesChecked && !isQuestionOneAndroidChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        RadioButton radioButtonClasses = (RadioButton) findViewById(R.id.radio_Classes);
        boolean isQuestionTwoClassesChecked = radioButtonClasses.isChecked();
        if (isQuestionTwoClassesChecked){
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        EditText userInputPrefixArray = (EditText) findViewById(R.id.answerInputUserPrefixArray);
        String name = userInputPrefixArray.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("string")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers(){
        RadioButton radioButtonValues = (RadioButton) findViewById(R.id.radio_values);
        boolean isQuestionTwoValuesChecked = radioButtonValues.isChecked();
        if (isQuestionTwoValuesChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveParameters = (CheckBox) findViewById(R.id.checkboxQuest5Parameters);
        CheckBox questionFiveFunctions = (CheckBox) findViewById(R.id.checkboxQuestFunctions);
        CheckBox questionFiveIntegers = (CheckBox) findViewById(R.id.checkboxQuest5Integers);
        boolean isQuestionFiveParametersChecked = questionFiveParameters.isChecked();
        boolean isQuestionFiveFunctionsChecked = questionFiveFunctions.isChecked();
        boolean isQuestionFiveIntegersChecked = questionFiveIntegers.isChecked();

        if (isQuestionFiveParametersChecked && !isQuestionFiveFunctionsChecked && isQuestionFiveIntegersChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}
