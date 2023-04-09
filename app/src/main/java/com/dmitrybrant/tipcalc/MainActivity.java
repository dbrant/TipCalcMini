package com.dmitrybrant.tipcalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements TextWatcher {
    private TextView textPercent15;
    private TextView textPercent18;
    private TextView textPercent20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText amountText = findViewById(R.id.percentEditText);
        textPercent15 = findViewById(R.id.percentView15);
        textPercent18 = findViewById(R.id.percentView18);
        textPercent20 = findViewById(R.id.percentView20);

        amountText.addTextChangedListener(this);
        amountText.requestFocus();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(Editable s) {
        float amount = 0f;
        try {
            amount = Float.parseFloat(s.toString());
        } catch (Exception e) {
            // ignore
            e.printStackTrace();
        }
        textPercent15.setText(getString(R.string.percent_text, 15, amount * 0.15f));
        textPercent18.setText(getString(R.string.percent_text, 18, amount * 0.18f));
        textPercent20.setText(getString(R.string.percent_text, 20, amount * 0.2f));
    }
}
