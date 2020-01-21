package com.example.singhkshitiz.letschat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class TestWtihKotlineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_wtih_kotline)

        Toast.makeText(applicationContext,"welcome kotlin",Toast.LENGTH_LONG).show()
    }
}
