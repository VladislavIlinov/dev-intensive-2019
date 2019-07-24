package ru.skillbranch.devintensive.extensions

 fun String.truncate(value : Int = 16): String{
     var str = this
     when {
         str.trimEnd().length > value -> {
             str = this.trim().substring(0,value)
             str = str.trim() + "..."
         }
         str.trimEnd().length == value -> str = str.trim()
         str.trimEnd().length < value -> str  =  str.trim()
     }

     return str
 }

fun String.stripHtml(): String{
    var str = this
    var regex = Regex(pattern = "<.*?>")
    str = str.replace(regex , "")
    regex = Regex(pattern = "&.[^а-я]\\S*?;")
    str = str.replace(regex , "")
    regex = Regex(pattern = "\\s+")
    str = str.replace(regex , " ")
    return str
}

