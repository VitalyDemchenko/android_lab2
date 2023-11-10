package com.example.pr2_p3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pr2_p3.databinding.ActivityMainBinding
import com.example.pr2_p3.databinding.FragmentMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding : FragmentMainBinding
    private lateinit var binding2 : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding2 = ActivityMainBinding.inflate(layoutInflater)
        binding = FragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            //setContentView(binding2.root)
        //val binding = ActivityMainBinding.inflate(layoutInflater)
       // setContentView(binding.root)
        binding.recView1.layoutManager = LinearLayoutManager(this)

        val recipes = listOf(
                Pair("potato", "https://rud.ua/uploads/under_recipe/reciept-600x300-salty-strudel_61dea31d4418d.jpg"),
                Pair("d", "https://rud.ua/uploads/under_recipe/Potato-casserole-with-meat-600x300_6066cb594e6f2.jpg")

                )
        val adapter = recAdapter(recipes)
        {
            position ->  Toast.makeText(this, recipes[position].first, Toast.LENGTH_SHORT).show()
        }
        binding.recView1.adapter = adapter

       // supportFragmentManager.beginTransaction()
        //    .replace(binding.fragment.id, fragment_main())
         //   .addToBackStack(null)
          //  .commit()
    }
}