import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class BSTMap<K extends Comparable<K>,V>implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value){
            this.key=key;
            this.value= value;
            left=null;
            right=null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root=null;
        size=0;
    }
    @Override
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void add(K key,V value){
        root=add(root,key,value);
    }
    //向以node为根的二分搜索树中插入元素key,value，递归算法
    private Node add(Node node,K key,V value){
        if (node==null){
            size++;
            return new Node(key,value);//构建一个新的根节点
        }
        if (key.compareTo(node.key)<0){
            node.left=add(node.left, key,value);
        }
        else if (key.compareTo(node.key)>0){
            node.right=add(node.right, key,value);
        }
        return node;
    }
    //返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node,K key){
        if (node==null)
            return null;
        if (key.compareTo(node.key)==0)
            return node;
        else if (key.compareTo(node.key)<0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }

    @Override
    public boolean contains(K key){
        return getNode(root,key)!=null;
    }
    @Override
    public V get(K key){
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key,V newValue){
        Node node=getNode(root,key);
        if (node==null)
            throw new IllegalArgumentException(key+"bucunzai!");
        node.value=newValue;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if (node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }

        node.left=removeMin(node.left);
        return node;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if (node.left==null)
            return node;
        return minimum(node.left);
    }

    @Override
    public V remove(K key){
        Node node=getNode(root,key);
        if (node!=null){
            root=remove(root,key);
            return node.value;
        }
        return null;
    }

    //删除掉以node为根的二分搜索树中值为key的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    //删除以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node,K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {//key==node.key
            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;//先将节点的左孩子暂存进leftNode
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            //在removeMin函数中已经size--了，但实际上节点还没删除，这个节点被successor指着，所以要size++回来弥补一下
            successor.right = removeMin(node.right);//removeMin函数返回删除节点后新的二分搜索树的根节点
            size++;

            successor.left = node.left;
            node.left = node.right = null;
            size--;
            return successor;
        }
    }

}
