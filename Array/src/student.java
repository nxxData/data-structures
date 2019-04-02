public class student {
    private String name;
    private int score;
    public student(String studentName,int studentScore){
        name = studentName;
        score=studentScore;
    }
    @Override
    public String toString(){
        return String.format("Student(name:%s,score:%d)",name,score);
    }
    public static void main(String[] args){
        Array<student> arr=new Array<>();
        arr.addLast(new student("alice",100));
        arr.addLast(new student("bob",66));
        arr.addLast(new student("charlie",88));
        System.out.println(arr);
    }
}
