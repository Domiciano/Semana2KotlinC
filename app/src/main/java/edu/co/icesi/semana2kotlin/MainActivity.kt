package edu.co.icesi.semana2kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var usernameET: EditText? = null
    var passwordET: EditText? = null
    var loginBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Registrar actividades
        val launcher = registerForActivityResult(StartActivityForResult(), ::onResult)

        usernameET = findViewById(R.id.usernameET)
        passwordET = findViewById(R.id.passwordET)
        loginBtn = findViewById(R.id.loginBtn)

        loginBtn?.setOnClickListener {
            val user = usernameET?.text.toString()
            val pass = passwordET?.text.toString()

            Toast.makeText(this, "${user}:${pass}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("username", user)
            }
            //startActivity(intent)
            launcher.launch(intent)
        }

    }

    private fun onResult(result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val username = data?.extras?.getString("username")!!
            usernameET?.setText(username)
        }

    }

}