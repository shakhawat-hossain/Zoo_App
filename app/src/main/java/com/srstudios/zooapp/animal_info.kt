package com.srstudios.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*
import kotlinx.android.synthetic.main.animal_killer.*
import kotlinx.android.synthetic.main.animal_list.*
import kotlinx.android.synthetic.main.animal_list.baboon_des
import kotlinx.android.synthetic.main.animal_list.baboon_img
import kotlinx.android.synthetic.main.animal_list.baboon_name

class animal_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle:Bundle= intent.extras!!

//        val bundle: Bundle? =intent.extras
        val name= bundle.getString("name")
        val des= bundle.getString("des")
        val image= bundle.getInt("image")
        animal_info_img.setImageResource(image)
        animal_info_name.text=name
        animal_info_des.text=des



    }
}
