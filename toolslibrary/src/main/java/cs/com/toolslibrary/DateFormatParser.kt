package cs.com.toolslibrary

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class DateFormatParser(private val locale: Locale, private val timeZone: TimeZone) {

    /**
     * @param datetime String to parse
     * @return Date with format yyyy-MM-dd HH:mm:ss (24h)
     */
    @Throws(ParseException::class)
    fun datetimeToDate24(datetime: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale)
        return format.parse(datetime)
    }

    /**
     * @param datetime String to parse
     * @return Date with format yyyy-MM-dd hh:mm:ss (12h)
     */
    @Throws(ParseException::class)
    fun datetimeToDate(datetime: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale)
        return format.parse(datetime)
    }

    /**
     * @param datetime String to parse
     * @return Date with format yyyy-MM-dd
     */
    @Throws(ParseException::class)
    fun dateToDate(datetime: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd", locale)
        return format.parse(datetime)
    }

    /**
     * @param date Date to parse
     * @return The param date with format MMMM dd, yyyy hh:mm a
     */
    fun toDate(date: Date): String {
        val formatter = SimpleDateFormat("MMMM dd, yyyy hh:mm a", locale)
        val newFormat = formatter.format(date)
        return Character.toUpperCase(newFormat[0]) + newFormat.substring(1)
    }

    /**
     * @param date Date to parse
     * @return The param date with format dd MMMM yy
     */
    fun toDate_ddMMMMyy(date: Date): String {
        val formatter = SimpleDateFormat("dd MMMM yy", locale)
        val newFormat = formatter.format(date)
        return Character.toUpperCase(newFormat[0]) + newFormat.substring(1)
    }

    /**
     * @param date Date to parse
     * @return The param date with format yyyy-MM-dd
     */
    fun toServerFormatDate(date: Date): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", locale)
        return formatter.format(date)
    }

    /**
     * @param date Date to parse
     * @return The param date with format M/dd/yy HH:mm
     */
    fun formatMDY(date: Date): String {
        val formatter = SimpleDateFormat("M/dd/yy HH:mm", locale)
        val newFormat = formatter.format(date)
        return Character.toUpperCase(newFormat[0]) + newFormat.substring(1)
    }

    /**
     * @param date Date to parse
     * @return The param date with format M/dd/yy
     */
    fun formatMDYWOhhmmss(date: Date): String {
        val formatter = SimpleDateFormat("M/dd/yy", locale)
        val newFormat = formatter.format(date)
        return Character.toUpperCase(newFormat[0]) + newFormat.substring(1)
    }

    /**
     * @param date Date to parse
     * @return The param date with format MMMM dd, yyyy
     */
    fun toFechaWOhhmmss(date: Date): String {
        val formatter = SimpleDateFormat("MMMM dd, yyyy", locale)
        val newFormat = formatter.format(date)
        return Character.toUpperCase(newFormat[0]) + newFormat.substring(1)
    }

    /**
     * @return Now() datetime with format yyyy-MM-dd HH:mm:ss
     */
    fun nowString(): String {
        val pattern = "yyyy-MM-dd HH:mm:ss"
        return SimpleDateFormat(pattern, locale).format(now())
    }

    /**
     * @return Now() date with format yyyy-MM-dd
     */
    fun nowDate(): String {
        val pattern = "yyyy-MM-dd"
        return SimpleDateFormat(pattern, locale).format(now())
    }

    /**
     * @param separator Char used as date separator
     * @param date Date to parse
     * @return The date with format dd mm yyyy with the selected separator
     */
    fun toDMY(separator: String, date: Date): String {
        val pattern = "dd" + separator + "MM" + separator + "yyyy"
        return SimpleDateFormat(pattern, locale).format(date)

    }

    private fun nowCalendar(): Calendar {
        return Calendar.getInstance(timeZone, locale)
    }

    private fun now(): Date {
        return nowCalendar().time
    }
}
