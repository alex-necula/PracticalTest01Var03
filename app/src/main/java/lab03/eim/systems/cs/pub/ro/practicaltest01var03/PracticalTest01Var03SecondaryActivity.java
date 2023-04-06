package lab03.eim.systems.cs.pub.ro.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    public static final String OPERATION_RESULT = "operationResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        TextView operationResultTextView = findViewById(R.id.operationResultTextView);
        Button correctButton = findViewById(R.id.correctButton);
        Button incorrectButton = findViewById(R.id.incorrectButton);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(OPERATION_RESULT)) {
            String operationResult = intent.getStringExtra(OPERATION_RESULT);
            operationResultTextView.setText(operationResult);
        }

        correctButton.setOnClickListener(view -> {
            setResult(RESULT_OK, null);
            finish();
        });

        incorrectButton.setOnClickListener(view -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });
    }
}

