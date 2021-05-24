package com.example.moveactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnPindah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPindah = findViewById(R.id.move_activity)
        btnPindah.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.move_activity_data -> {

                val moveWithDataIntent = Intent(this@MainActivity, MoveActivityWithData::class.java)
                moveWithDataIntent.putExtra(MoveActivityWithData.EXTRA_NAMe, "DICODING INDONESIA")
                moveWithDataIntent.putExtra(MoveActivityWithData.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)

            }
        }
    }
}