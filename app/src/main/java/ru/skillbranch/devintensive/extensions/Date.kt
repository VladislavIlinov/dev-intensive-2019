package ru.skillbranch.devintensive.extensions

import kotlin.math.abs
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time

    time +=when(units){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    //var time = this.time
    var difference = this.time - date.time
    var minute = (abs(difference)/ MINUTE).toInt()
    var hour = (abs(difference)/ HOUR).toInt()
    var day = (abs(difference)/ DAY).toInt()
    if (difference <= 0) {
        return when (abs(difference)) {
            in 0..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "несколько секунд назад"
            in 45 * SECOND..75 * SECOND -> "минуту назад"
            in 75 * SECOND..45 * MINUTE -> "${TimeUnits.MINUTE.plural(minute)} назад"
            in 45 * MINUTE..75 * MINUTE -> "час назад"
            in 75 * MINUTE..22 * HOUR -> "${TimeUnits.HOUR.plural(hour)} назад"
            in 22 * HOUR..26 * HOUR -> "день назад"
            in 26 * HOUR..360 * DAY -> "${TimeUnits.DAY.plural(day)} назад"
            else -> "более года назад"

        }
    } else {
        return when (abs(difference)) {
            in 0..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "через несколько секунд"
            in 45 * SECOND..75 * SECOND -> "через минуту"
            in 75 * SECOND..45 * MINUTE -> "через ${TimeUnits.MINUTE.plural(minute)}"
            in 45 * MINUTE..75 * MINUTE -> "через час"
            in 75 * MINUTE..22 * HOUR -> "через ${TimeUnits.HOUR.plural(hour)}"
            in 22 * HOUR..26 * HOUR -> "через день"
            in 26 * HOUR..360 * DAY -> "через ${TimeUnits.DAY.plural(day)}"
            else -> "более чем через год"
        }
    }
}





enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;
        fun plural(value: Int): String {
            return when {
                this == SECOND -> return when {
                    value in 11..14 -> "$value секунд"
                    (value % 100) in 11..14 -> "$value секунд"
                    (value % 10) == 1 -> "$value секунду"
                    (value % 10) in 2..4 -> "$value секунды"
                    (value % 10) in 5..9 -> "$value секунд"
                    else -> "$value секунд"
                }
                this == MINUTE -> return when {
                    value in 11..14 -> "$value минут"
                    (value % 100) in 11..14 -> "$value минут"
                    (value % 10) == 1 -> "$value минуту"
                    (value % 10) in 2..4 -> "$value минуты"
                    (value % 10) in 5..9 -> "$value минут"
                    else -> "$value минут"

                }
                this == HOUR -> return when {
                    value in 11..14 -> "$value часов"
                    (value % 100) in 11..14 -> "$value часов"
                    (value % 10) == 1 -> "$value час"
                    (value % 10) in 2..4 -> "$value часа"
                    (value % 10) in 5..9 -> "$value часов"
                    else -> "$value часов"
                }
                this == DAY -> return when {
                    value in 11..14 -> "$value дней"
                    (value % 100) in 11..14 -> "$value дней"
                    (value % 10) == 1 -> "$value день"
                    (value % 10) in 2..4 -> "$value дня"
                    (value % 10) in 5..9 -> "$value дней"
                    else -> "$value дней"
                }
                else -> ""
            }
        }
}
