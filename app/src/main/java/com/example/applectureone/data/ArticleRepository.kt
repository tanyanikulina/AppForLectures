package com.example.applectureone.data

import android.content.Context
import com.example.applectureone.data.local.SharedPrefs
import com.example.applectureone.data.local.model.ArticleEntity
import kotlinx.coroutines.delay

class ArticleRepository(private val context: Context) {

    private val sPref = SharedPrefs(context)

    suspend fun getArticles(): List<ArticleEntity> {
        delay(1000)
        return createDefaultData()
    }

    private fun createDefaultData(): List<ArticleEntity> {

        val list = ArrayList<ArticleEntity>()
        list.add(
            ArticleEntity(
                1L,
                "What is Lorem Ipsum?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            )
        )
        list.add(
            ArticleEntity(
                2L,
                "Why do we use it?",
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
            )
        )
        list.add(
            ArticleEntity(
                3L,
                "Where does it come from?",
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old."
            )
        )
        list.add(
            ArticleEntity(
                4L,
                "Where can I get some?",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
            )
        )
        return list
    }

    fun getUserName(): String? = sPref.getUserName()

    fun setUserName(name: String) {
        sPref.setUserName(name)
    }

}