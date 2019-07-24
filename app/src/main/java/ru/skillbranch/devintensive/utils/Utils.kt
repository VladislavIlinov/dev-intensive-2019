package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {
     fun parseFullName(fullName:String?):Pair<String?, String?>{
         val parts : List<String>? = fullName?.split(" ")

         val firstName = parts?.getOrNull(0)
         val lastName = parts?.getOrNull(1)
         return when{
             (firstName !=null) && (lastName !=null)&&(firstName.trimStart() != "") && (lastName.trimEnd() != "") && (firstName.trimStart() != " ")&&( lastName.trimEnd() !=" ") -> firstName to lastName
             (firstName != null && firstName.trimStart() != " " && firstName.trimStart() != "") && (lastName == null || lastName.trimEnd() == "" || lastName.trimEnd() == " ") -> firstName to null
             (lastName != null && lastName != " " && lastName != "") && (firstName == null || firstName == "" || firstName == " ") -> lastName.trim() to null
             else -> null to null
         }
     }

    fun transliteration(payloade: String, divider:String = " "): String {
        var payload1 = payloade
         var str :String = ""
         var j: Int = 0
         for(i in payloade){
            when(payload1[j].toString()) {
                //"б"->  str = str.replace(str[j].toString(),"b")
                "а"->  str +="a"

                "б"->  str +="b"

                "в" -> str += "v"

                "г" -> str += "g"

                "д" -> str += "d"

                "е" -> str += "e"

                "ё" -> str += "e"

                "ж" -> str += "zh"

                "з" -> str += "z"

                "и" -> str += "i"

                "й" -> str += "i"

                "к" -> str += "k"

                "л" -> str += "l"

                "м" -> str += "m"

                "н" -> str += "n"

                "о" -> str += "o"

                "п" -> str += "p"

                "р" -> str += "r"

                "с" -> str += "s"

                "т" -> str += "t"

                "у" -> str += "u"

                "ф" -> str += "f"

                "х" -> str += "h"

                "ц" -> str += "c"

                "ч" -> str += "ch"

                "ш" -> str += "sh"

                "щ" -> str += "sh'"

                "ъ" -> str += ""

                "ы" -> str += "i"

                "ь" -> str += ""

                "э" -> str += "e"

                "ю" -> str += "yu"

                "я" -> str += "ya"

                "А" -> str += "A"

                "Б" -> str += "B"

                "В" -> str += "V"

                "Г" -> str += "G"

                "Д" -> str += "D"

                "Е" -> str += "E"

                "Ё" -> str += "E"

                "Ж" -> str += "Zh"

                "З" -> str += "Z"

                "И" -> str += "I"

                "Й" -> str += "I"

                "К" -> str += "K"

                "Л" -> str += "L"

                "М" -> str += "M"

                "Н" -> str += "N"

                "О" -> str += "O"

                "П" -> str += "P"

                "Р" -> str += "R"

                "С" -> str += "S"

                "Т" -> str += "T"

                "У" -> str += "U"

                "Ф" -> str += "F"

                "Х" -> str += "H"

                "Ц" -> str += "C"

                "Ч" -> str += "Ch"

                "Ш" -> str += "Sh"

                "Щ" -> str += "Sh'"

                "Ь" -> str += ""

                "Ы" -> str += "I"

                "Ъ" -> str += ""

                "Э" -> str += "E"

                "Ю" -> str += "Yu"

                "Я" -> str += "Ya"
                " " -> str+= divider
                else -> str+= payload1[j].toString()
            }
             j++
        }
        return str
    }

fun toInitials(firstName: String?, lastName: String?): String? {
    return when {
        (firstName != null) && (lastName != null) && (firstName != " ") && (firstName != "") && (lastName != " ") && (lastName != "") -> "${firstName.trim()[0].toUpperCase()}${lastName.trim()[0].toUpperCase()}"
        (firstName != null && firstName != " " && firstName.trim() != "") && (lastName == null || lastName == "" || lastName == " ") -> "${firstName.trim()[0].toUpperCase()}"
        (lastName != null && lastName != " " && lastName != "") && (firstName == null || firstName == "" || firstName == " ") -> "${lastName.trim()[0].toUpperCase()}"
        else -> null
    }


}
}

