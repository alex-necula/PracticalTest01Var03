package lab03.eim.systems.cs.pub.ro.practicaltest01var03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {
    public static final String FIRST_NUMBER_EDIT_TEXT = "firstNumberEditText";
    public static final String SECOND_NUMBER_EDIT_TEXT = "secondNumberEditText";
    public static final String RESULT_TEXT_VIEW = "resultTextView";
    private EditText firstNumberEditText, secondNumberEditText;
    private Button additionButton, subtractionButton, navigateButton;
    private TextView resultTextView;
    private String firstNumber, secondNumber, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03);

        firstNumberEditText = findViewById(R.id.firstNumberEditText);
        secondNumberEditText = findViewById(R.id.secondNumberEditText);
        additionButton = findViewById(R.id.additionButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        resultTextView = findViewById(R.id.resultTextView);
        navigateButton = findViewById(R.id.navigateButton);

        additionButton.setOnClickListener(view -> {
            if (!firstNumberEditText.getText().toString().isEmpty() && !secondNumberEditText.getText().toString().isEmpty()) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                int result = firstNumber + secondNumber;
                resultTextView.setText(firstNumber + " + " + secondNumber + " = " + result);
            } else {
                Toast.makeText(PracticalTest01Var03MainActivity.this, "Both numbers should be set.", Toast.LENGTH_SHORT).show();
            }
        });

        subtractionButton.setOnClickListener(view -> {
            if (!firstNumberEditText.getText().toString().isEmpty() && !secondNumberEditText.getText().toString().isEmpty()) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                int result = firstNumber - secondNumber;
                resultTextView.setText(firstNumber + " - " + secondNumber + " = " + result);
            } else {
                Toast.makeText(PracticalTest01Var03MainActivity.this, "Both numbers should be set.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FIRST_NUMBER_EDIT_TEXT, firstNumberEditText.getText().toString());
        outState.putString(SECOND_NUMBER_EDIT_TEXT, secondNumberEditText.getText().toString());
        outState.putString(RESULT_TEXT_VIEW, resultTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstNumber = savedInstanceState.getString(FIRST_NUMBER_EDIT_TEXT);
        secondNumber = savedInstanceState.getString(SECOND_NUMBER_EDIT_TEXT);
        result = savedInstanceState.getString(RESULT_TEXT_VIEW);

        firstNumberEditText.setText(firstNumber);
        secondNumberEditText.setText(secondNumber);
        resultTextView.setText(result);
        Toast.makeText(this, "First number: " + firstNumber + ", second number: " + secondNumber + ", result: " + result, Toast.LENGTH_SHORT).show();
    }
}