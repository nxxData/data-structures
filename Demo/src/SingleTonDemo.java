public class SingleTonDemo {

    public static void main(String[] args){
        SingleTon ton1=SingleTon.getSingleTon();
    }
}
class SingleTon{
    private static SingleTon singleTon=null;
    private SingleTon(){
        System.out.println("SingleTon");
    }
    public static SingleTon getSingleTon(){
        if (singleTon==null)
            singleTon=new SingleTon();
        return singleTon;
    }
}
