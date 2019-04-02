public class EnumDemo {
    public static void main(String[] args){
        System.out.println(Color.YELLOW);
        Color[] colors=Color.values();
        for (Color color:colors){
            System.out.println(color);
        }
    }
}
//当jvm去加载使用枚举类时，会预先创建多个枚举类型的对象供外界使用
//public static final Color RED=new Color();
//public static final Color YELLOW=new Color();
//public static final Color BLUE=new Color();
enum Color{
    RED,YELLOW,BLUE;
    private Color(){
        System.out.println("gouzao");
    }
}
