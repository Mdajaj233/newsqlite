package com.example.newsqlite

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle





import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.content.DialogInterface
import android.content.Intent
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view=findViewById<AppCompatButton>(R.id.viewrecod)
        view.setOnClickListener {
            val intent= Intent(this, ShowData::class.java)
            startActivity(intent)
            finish()
        }


    }
    //method for saving records in database
    fun saveRecord(view: View){

                val u_id=findViewById<EditText>(R.id.u_id)
            val u_name=findViewById<EditText>(R.id.u_name)
        val u_email=findViewById<EditText>(R.id.u_email)

        val id = u_id.text.toString()
        val name = u_name.text.toString()
        val email = u_email.text.toString()
        val databaseHandler: DatabaseHandler= DatabaseHandler(this)
        if(id.trim()!="" && name.trim()!="" && email.trim()!=""){
            val status = databaseHandler.addEmployee(EmpModelClass(Integer.parseInt(id),name, email))
            if(status > -1){
                Toast.makeText(applicationContext,"record save",Toast.LENGTH_LONG).show()
                u_id.text.clear()
                u_name.text.clear()
                u_email.text.clear()
            }
        }else{
            Toast.makeText(applicationContext,"id or name or email cannot be blank",Toast.LENGTH_LONG).show()
        }

    }
    //method for read records from database in ListView

}