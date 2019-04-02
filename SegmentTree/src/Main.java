public class Main {

    public static void main(String[] args) {
	// write your code here
        int i,j;

        i=f(f(2));
        System.out.println(i);
    }
    public  static int f(int x){
        return ((x>2)? x*f(x-1):3);
    }
}
