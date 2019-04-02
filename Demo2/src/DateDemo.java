import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDemo {
    public static void main(String[] args){
        Date date=new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        DateFormat df1=null;
        df1=DateFormat.getDateInstance(DateFormat.FULL,new Locale("zh","CN"));
        System.out.println(df1.format(date));
    }
}
