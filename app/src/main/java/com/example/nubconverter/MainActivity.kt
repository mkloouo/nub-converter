package com.example.nubconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        fromCurrencySpinner.onItemSelectedListener = object: AdapterView.OnItemClickListener

        fromValueInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.println(Log.INFO, "MainActivity", "value in fromValueInput changed")
                if (!fromValueInput.text.isNullOrEmpty() && !toValueInput.text.isNullOrEmpty()) {
                    sumText.text =
                        (fromValueInput.text.toString().toInt() +
                                toValueInput.text.toString().toInt()).toString();
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        toValueInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.println(Log.INFO, "MainActivity", "value in toValueInput changed")
                if (!fromValueInput.text.isNullOrEmpty() && !toValueInput.text.isNullOrEmpty()) {
                    sumText.text =
                        (fromValueInput.text.toString().toInt() +
                                toValueInput.text.toString().toInt()).toString();
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
