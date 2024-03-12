package org.sel.au_garry

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rv = findViewById<RecyclerView>(R.id.revi)
        val retrofit = RetrofitClass().getRetrofit()
        val api = retrofit.create(RetrofitInterface::class.java)
        val ret_call: Call<MutableList<chardata>> = api.pers()
        ret_call.enqueue(object:retrofit2.Callback<MutableList<chardata>>
        {
            override fun onResponse(
                call: Call<MutableList<chardata>>,
                response: Response<MutableList<chardata>>
            ) {
                if (response.isSuccessful)
                { rv.adapter = adaptergarry(applicationContext, response.body() as MutableList<chardata>)
                    Toast.makeText(this@MainActivity, "мы молодец!", Toast.LENGTH_SHORT).show()
                }
                else
                    Toast.makeText(this@MainActivity, "что-то не так", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<MutableList<chardata>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ДА БОЖЕ", Toast.LENGTH_SHORT).show()
            }

        }
        )

    }
}