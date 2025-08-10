package com.xiaoli.base.oop


data class User(val id : Int , val username:String ,val password:String){}
fun main() : Unit{
    val user1 = User(1 , "username1" , "password1")
    val user2 = User(1 , "username1" , "password1")
    println(user1)
    println("user1.hashCode = " + user1.hashCode())
    println("user2.hashCode = " + user2.hashCode())
}

interface OOPMain1Interface2{
    fun show2()
}
interface OOPMain1Interface1{
    fun show1()
    fun method(){
        println("====")
    }
}

open class OOPMain1Father1{}

class OOPMain1(var id : Int , val username : String) : OOPMain1Father1()  ,  OOPMain1Interface1 , OOPMain1Interface2{
    override fun show1() {
        TODO("Not yet implemented")
    }

    override fun show2() {
        TODO("Not yet implemented")
    }

}

