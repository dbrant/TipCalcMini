package com.dmitrybrant.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.dmitrybrant.tipcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.percentEditText.doAfterTextChanged {
            var quantity = 0f
            try {
                quantity = it.toString().toFloat()
            } catch (e: Exception) {
            }
            binding.percentView15.text = getString(R.string.percent_text, 15, quantity * 0.15f)
            binding.percentView18.text = getString(R.string.percent_text, 18, quantity * 0.18f)
            binding.percentView20.text = getString(R.string.percent_text, 20, quantity * 0.2f)
        }

        binding.percentEditText.requestFocus()
    }
}
