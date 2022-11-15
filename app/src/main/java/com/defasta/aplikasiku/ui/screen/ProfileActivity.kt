package com.defasta.aplikasiku.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.defasta.aplikasiku.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bundle: Bundle? = intent.extras

        bundle.apply {
            val dataFromMainActivity : String? = intent.getStringExtra("key1")
            tvProfile.text = dataFromMainActivity
        }

    }
}