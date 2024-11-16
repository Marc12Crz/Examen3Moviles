package com.marcelo.cristhian.laboratoriocalificado03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.cristhian.laboratoriocalificado03.adapter.TeacherAdapter
import com.marcelo.cristhian.laboratoriocalificado03.databinding.ActivityMainBinding
import com.marcelo.cristhian.laboratoriocalificado03.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import androidx.appcompat.widget.Toolbar



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar RecyclerView (ejemplo previo)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.api.getTeachers()
                val teachers = response.teachers
                withContext(Dispatchers.Main) {
                    binding.recyclerView.adapter = TeacherAdapter(teachers,
                        onItemClick = { teacher ->
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phone}"))
                            startActivity(intent)
                        },
                        onItemLongClick = { teacher ->
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:${teacher.email}")
                            }
                            startActivity(intent)
                        }
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

