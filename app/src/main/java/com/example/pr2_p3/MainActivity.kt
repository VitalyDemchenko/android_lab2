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
                Triple("ШТРУДЕЛЬ ІЗ КУРЯТИНОЮ, ГРИБАМИ ТА СИРОМ", "https://rud.ua/uploads/under_recipe/reciept-600x300-salty-strudel_61dea31d4418d.jpg", "Запашний штрудель із курятиною та грибами — ситна версія популярної страви, яку подарували світу австрійці. "),
                Triple("АРОМАТНА ЗАПІКАНКА З КАРТОПЛІ, ЯЛОВИЧОГО ФАРШУ ТА ГРИБІВ", "https://rud.ua/uploads/under_recipe/Potato-casserole-with-meat-600x300_6066cb594e6f2.jpg", "Прості інгредієнти, знайомий рецепт, година вільного часу — і на вашому столі апетитна картопляна запіканка."),
            Triple("ПИРІГ ІЗ ЛИСТКОВОГО ТІСТА З КИСЛОМОЛОЧНИМ СИРОМ І ВАРЕННЯМ", "https://rud.ua/uploads/under_recipe/lystkovyi-purig-600x300-min_608bea5fa2239.jpg", "Франція славиться круасанами, Австрія — штруделями, а Україна — пирогами! "),
            Triple("ЯБЛУЧНИЙ КРАМБЛ: КЛАСИЧНИЙ РЕЦЕПТ", "https://rud.ua/uploads/under_recipe/Recept_yabluchnij_krambl_600%D1%85300_6156f564dc80c.jpg", "Яблучний крамбл — запашний англійський десерт із соковитою фруктовою начинкою і хрустким розсипчастим тістом."),
            Triple("ЦВІТНА КАПУСТА, ЗАПЕЧЕНА ІЗ СОУСОМ БЕШАМЕЛЬ ТА СИРОМ", "https://rud.ua/uploads/under_recipe/tsvitna-kapusta-beshamel-600x300_6038ae8e503fc.jpg", "Цвітна капуста, запечена в соусі бешамель, чудово підходить для дієтичного та дитячого харчування — страва поживна."),
            Triple("ПРОСТИЙ РЕЦЕПТ БАНАНОВОГО ПУДИНГУ З МОРОЗИВОМ", "https://rud.ua/uploads/under_recipe/600%D1%85300-bananovyy-pudynh_60423ee9232dd.jpg", "Шматочки бананів і печива, вкриті ніжним заварним кремом та прикрашені збитими вершками чи кулькою морозива, — це знаменитий банановий пудинг."),
            Triple("РУМ'ЯНО-ЗЕЛЕНІ ПАНКЕЙКИ ЗІ ШПИНАТОМ", "https://rud.ua/uploads/under_recipe/600%D1%85300-blinchiki-shpinat_604b7eddb5275.jpg", "Розпочати день із пухких яскраво-зелених панкейків зі шпинатом означає отримати заряд енергії та настрою на цілий день."),
                )
        val adapter = recAdapter(recipes)
        {
               // position ->  Toast.makeText(this, recipes[position].first, Toast.LENGTH_SHORT).show()
                position ->
            // Обробка кліку на елемент списку
            val selectedRecipe = recipes[position]

            // Створення екземпляру фрагменту для передачі даних
            val fragment = fragment_2.newInstance(
                selectedRecipe.first,
                selectedRecipe.second,
                //selectedRecipe.third
            )

            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_2, fragment) // R.id.fragmentContainer - ваш контейнер для фрагментів
                    .addToBackStack(null)
                    .commit()
        }
        binding.recView1.adapter = adapter

       // supportFragmentManager.beginTransaction()
        //    .replace(binding.fragment.id, fragment_main())
         //   .addToBackStack(null)
          //  .commit()
    }
}