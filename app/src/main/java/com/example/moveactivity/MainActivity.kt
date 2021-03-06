package com.example.moveactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    companion object{
        private const val REQUEST_CODE = 100
    }

    private lateinit var btnPindah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveForResult:Button = findViewById(R.id.move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.hasil)

        btnPindah = findViewById(R.id.move_activity)
        btnPindah.setOnClickListener(this)

        val btnDialPhone:Button = findViewById(R.id.dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject:Button = findViewById(R.id.move_activity_data_parcelable)
        btnMoveWithObject.setOnClickListener(this)

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

            R.id.move_activity_data_parcelable -> {
                val person = Person(
                    "Dicoding Indonesia",
                    5,
                    "academydicoding@gmail.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.dial_number->{
                val phoneNumber = "082217456798"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }

    }

}