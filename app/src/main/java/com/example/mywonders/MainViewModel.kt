package com.example.mywonders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywonders.database.Wonders
import com.example.mywonders.database.WondersDatabase
import kotlinx.coroutines.launch
import kotlin.Exception

class MainViewModel: ViewModel() {

    lateinit var database: WondersDatabase

    fun putData(){
        viewModelScope.launch {
            try {
                var wonder:Wonders?=null
                for(i in 0..6){
                    when(i){
                        1->{
                            wonder=(Wonders("https://cdn.britannica.com/36/162636-050-932C5D49/Colosseum-Rome-Italy.jpg?w=600&q=60","The Colloseum"))
                        }
                        2->{
                            wonder=(Wonders("https://cdn.britannica.com/30/94530-050-99493FEA/Machu-Picchu.jpg?w=600&q=60","Machu Picchu"))
                        }
                        3->{
                            wonder=(Wonders("https://cdn.britannica.com/25/153525-050-FC43840D/Khaznah-Petra-Jordan.jpg?w=600&q=60","Petra"))
                        }
                        4->{
                            wonder=(Wonders("https://cdn.britannica.com/86/170586-050-AB7FEFAE/Taj-Mahal-Agra-India.jpg?w=600&q=60","Taj Mahal"))
                        }
                        5->{
                            wonder=(Wonders("https://cdn.britannica.com/54/150754-050-5B93A950/statue-Christ-the-Redeemer-Rio-de-Janeiro.jpg?w=600&q=60","Cristo Redentor"))
                        }
                        6->{
                            wonder=(Wonders("https://cdn.britannica.com/82/94382-050-20CF23DB/Great-Wall-of-China-Beijing.jpg?w=600&q=60","Great Wall Of China"))
                        }
                        0->{
                            wonder=(Wonders("https://cdn.britannica.com/49/61349-050-9FFBEB28/El-Castillo-pyramid-plaza-Toltec-state-Yucatan.jpg?w=600&q=60","Chichen Itza"))
                        }
                    }

                    if (wonder != null) {
                        insertIntoDB(wonder)
                    }
                }

            }catch (ex:Exception){

            }
        }


    }


    fun deleteAll(){
        viewModelScope.launch {
            database.contactDAO().deleteAll()
        }
    }

    private fun insertIntoDB(wonder: Wonders){
        viewModelScope.launch {
            try {
                database.contactDAO().insert(wonder)
            }catch (ex:Exception){
            }
        }
    }
}