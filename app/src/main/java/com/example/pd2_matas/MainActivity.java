package com.example.pd2_matas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pd2_matas.utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    private EditText edUserInput;
    private TextView tvResult;
    private Spinner spCountOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);

        this.spCountOptions = findViewById(R.id.spCountOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.counting_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        processInput();
    }

    private void processInput() {
        String userInput = this.edUserInput.getText().toString().trim();
        if (userInput.isEmpty()) {
            Toast.makeText(this, R.string.input_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        String[] countingOptions = getResources().getStringArray(R.array.counting_options);
        String selectedOption = this.spCountOptions.getSelectedItem().toString();

        if (selectedOption.equals(countingOptions[0])) {
            int result = TextCounter.getCharsCount(userInput);
            this.tvResult.setText(String.valueOf(result));
        }
        else if (selectedOption.equals(countingOptions[1])) {
            int result = TextCounter.getWordsCount(userInput);
            this.tvResult.setText(String.valueOf(result));
        }
        else {
            this.tvResult.setText(R.string.message_not_implemented);
        }
    }
}
