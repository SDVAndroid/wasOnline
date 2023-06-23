fun main(args: Array<String>) {
    val result = agoToText(60 * 21)
    println("был(а) в сети $result")
}

fun agoToText(time: Int) = when (time) {
    in 0..60 -> "только что"
    in 61..60 * 60 -> conversionToMinutes(time).toString()
    in 60 * 60 + 1..24 * 60 * 60 -> conversionToHours(time).toString()
    in 24 * 60 * 60 + 1..48 * 60 * 60 -> "вчера"
    in 48 * 60 * 60 + 1..72 * 60 * 60 -> "позавчера"
    else -> "давно"
}

fun conversionToMinutes(time: Int): String {
    val minutes = (time / 60).toInt()
    val correctMinutes = when {
        minutes % 10 == 1 && minutes != 11 -> "$minutes минуту назад"
        minutes % 10 in 2..4 && minutes !in 12..14 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
    return correctMinutes
}

fun conversionToHours(time: Int): String {
    val hours = (time / (60 * 60)).toInt()
    val correctHours = when {
        hours % 10 == 1 && hours != 11 -> "$hours час назад"
        hours % 10 in 2..4 && hours !in 12..14 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
    return correctHours
}