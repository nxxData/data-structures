package niubenben;

import java.lang.reflect.Array;

public class ReflectionArrayDemo {
    public static void main(String[] args) {
        // write your code here
        Class<?> classType= null;
        try {
            classType = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object array= Array.newInstance(classType,5);
    }
}
