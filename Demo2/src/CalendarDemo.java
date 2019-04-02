import java.util.Calendar;
public class CalendarDemo {
    public static void main(String[] args){
        Calendar calendar=Calendar.getInstance();//获得一个日历对象
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);//月份是从0~11，所以需要加1
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        calendar.set(Calendar.YEAR,2020);
        System.out.println(calendar);
    }


}
