import java.util.TreeSet;//基于红黑树实现的,不会出现最坏情况，所以是平衡二叉树

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set=new TreeSet<>();
        for (String word:words){

            StringBuilder res=new StringBuilder();
            for (int i=0;i<word.length();i++){
                res.append(codes[word.charAt(i)-'a']);
            }
            set.add(res.toString());
        }

        return set.size();
    }
}
