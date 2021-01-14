package com.srstudios.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_list.view.*
import java.util.zip.Inflater

//vid_no:2 time: 6.00 mins



class MainActivity : AppCompatActivity() {
    var list_of_animals= ArrayList<Animal>()
    var adapter:AnimalAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        list_of_animals.add(Animal("Babbon","Baboon lives in jungle",R.drawable.baboon,false))
        list_of_animals.add(Animal("Bulldog","Bulldogs are very dangerous",R.drawable.bulldog,true))
        list_of_animals.add(Animal("Panda","Pandas are found only in china",R.drawable.panda,true))
        list_of_animals.add(Animal("Swallow Bird","Swallow Bird is a special type of bird",R.drawable.swallow_bird,false))
        list_of_animals.add(Animal("White Tiger","White Tiger is an extremely rare animal",R.drawable.white_tiger,true))
        list_of_animals.add(Animal("Zebra","Zebras are mostly found in Australia",R.drawable.zebra,false))
        adapter= AnimalAdapter(this,list_of_animals)
        animals_list.adapter=adapter



    }
    class AnimalAdapter: BaseAdapter{
        var list_of_animals= ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context, list_of_animals: ArrayList<Animal>):super(){
            this.list_of_animals=list_of_animals
            this.context=context

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
           val animal = list_of_animals[position]
            if(animal.iskiller==true) {

                var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myview= inflator.inflate(R.layout.animal_killer,null)
                myview.baboon_name.text=animal.name!!
                myview.baboon_des.text=animal.des!!
                myview.baboon_img.setImageResource(animal.image!!)
                myview.baboon_img.setOnClickListener {
                    val intent=Intent(context,animal_info::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }

                return myview

            }
            else{

                var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myview= inflator.inflate(R.layout.animal_list,null)
                myview.baboon_name.text=animal.name!!
                myview.baboon_des.text=animal.des!!
                myview.baboon_img.setImageResource(animal.image!!)
                myview.baboon_img.setOnClickListener {
                    val intent=Intent(context,animal_info::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }
                return myview



            }




        }

        override fun getItem(position: Int): Any {
            return list_of_animals[0]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return list_of_animals.size
        }

    }
}
