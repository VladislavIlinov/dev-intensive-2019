package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
    val id:String,
    val form:User?,
    val chat:Chat,
    val isIncoming : Boolean = false,
    val date: Date = Date()
){
    abstract fun formatMessage():String
    companion object AbstractFactory{
        var lastId = -1;
        fun makeMessage(form:User?,chat:Chat,date:Date = Date(), type:String = "text", payload:Any?):BaseMessage{
            lastId++
            return when(type){
                "image"-> ImageMessage("$lastId", form, chat, date=date, image = payload as String)
                else -> TextMessage("$lastId", form, chat, date=date, text = payload as String)
            }

        }
    }
}