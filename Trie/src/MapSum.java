import java.util.TreeMap;
public class MapSum {
    private class Node{

        public int value;//value初始值为0，isWord可以省略，有了value值就代表了它是一个单词，对sum值无影响
        public TreeMap<Character,Node> next;

        public Node(int value){
            this.value=value;
            next=new TreeMap<>();
        }
        public Node(){
            this(0);
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    public void insert(String key, int val) {
        Node cur=root;
        for (int i=0;i<key.length();i++){
            char c=key.charAt(i);
            if (cur.next.get(c)==null)
                cur.next.put(c,new Node());
            cur=cur.next.get(c);
        }
        cur.value=val;
    }

    public int sum(String prefix) {
        Node cur=root;
        for (int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if (cur.next.get(c)==null)
                return 0;
            cur=cur.next.get(c);
        }
        return sum(cur);
    }
    private int sum(Node node){

        int res=node.value;
        for (char c:node.next.keySet())//遍历node.next指向的所有节点集合
            res+=sum(node.next.get(c));
        return res;
    }
}
