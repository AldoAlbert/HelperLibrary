package cs.com.toolslibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatParser {

    private Locale locale;
    private TimeZone timeZone;

    public DateFormatParser(Locale locale, TimeZone timeZone) {
        this.locale = locale;
        this.timeZone = timeZone;
    }

    public Date datetimeToDate24(String datetime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        return format.parse(datetime);
    }

    public Date datetimeToDate(String datetime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
        return format.parse(datetime);
    }

    public Date dateToDate(String datetime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", locale);
        return format.parse(datetime);
    }

    public String toDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a", locale);
        String newFormat = formatter.format(date);
        return Character.toUpperCase(newFormat.charAt(0)) + newFormat.substring(1);
    }

    public String toDate_ddMMMMyy(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yy", locale);
        String newFormat = formatter.format(date);
        return Character.toUpperCase(newFormat.charAt(0)) + newFormat.substring(1);
    }

    public String toServerFormatDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", locale);
        return formatter.format(date);
    }

    public String formatMDY(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yy HH:mm", locale);
        String newFormat = formatter.format(date);
        return Character.toUpperCase(newFormat.charAt(0)) + newFormat.substring(1);
    }

    public String formatMDYWOhhmmss(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yy", locale);
        String newFormat = formatter.format(date);
        return Character.toUpperCase(newFormat.charAt(0)) + newFormat.substring(1);
    }

    public String toFechaWOhhmmss(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", locale);
        String newFormat = formatter.format(date);
        return Character.toUpperCase(newFormat.charAt(0)) + newFormat.substring(1);
    }

    public String nowString(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return  new SimpleDateFormat(pattern, locale).format(now());
    }

    public String nowDate(){
        String pattern = "yyyy-MM-dd";
        return  new SimpleDateFormat(pattern, locale).format(now());
    }

    /**
     * @param separator Char used as date separator
     * @param date Date to parse
     * @return The date with format dd mm yyyy with the selected separator
     */
    public String toDMY(String separator, Date date){
        String pattern = "dd" + separator + "MM" + separator + "yyyy";
        return  new SimpleDateFormat(pattern, locale).format(date);

    }

    private Calendar nowCalendar(){
        return Calendar.getInstance(timeZone, locale);
    }

    private Date now(){
        return nowCalendar().getTime();
    }
}
