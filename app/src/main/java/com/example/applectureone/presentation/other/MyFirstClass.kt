package com.example.applectureone.presentation.other

abstract class MyFirstClass(private var myVal: String?, myBool: Boolean, myInt: Int = 1) {

    init {
        //ghjkl
        myVal = null
        myBool

        when (myInt) {

            2 -> {

            }
            3 -> myFun()
            else -> {

            }

        }


    }

    abstract fun myFun()

    fun letDouble(myInt: Int?): Int? {
        return myInt!! * myInt

    }


}

class MyClass3(private val myVal2: String, myBool2: Boolean, myInt2: Int = 1) :
    MyFirstClass(myVal2, myBool2, myInt2) {
    override fun myFun() {

        letDouble(5)?.let { v ->


        }
        // hjkl;

    }
}


class MyCass2() : myInterface {

    init {
        val v = MyClass3("ghjkl", false)
        MyObject.myFun()
        val s = "ghjkl"
        s.printHelloWorld()

    }

    override fun fun1() {
        TODO("Not yet implemented")
    }

    override fun fun2() {
        TODO("Not yet implemented")
    }


}

object MyObject {

    fun myFun() {
        // hjkl;

    }

}

fun String.printHelloWorld(): Int {
    // fghjkl
    return 5
}


interface myInterface {

    fun fun1()

    fun fun2()

}
