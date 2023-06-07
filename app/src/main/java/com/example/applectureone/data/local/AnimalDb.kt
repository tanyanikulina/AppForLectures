package com.example.applectureone.data.local

import com.example.applectureone.data.local.model.Animal

class AnimalDb {

    fun getStubAnimalList(): List<Animal> {
        return listOf(
            Animal("Dog"),
            Animal("Dog"),
            Animal("Dog"),
        )


    }

}