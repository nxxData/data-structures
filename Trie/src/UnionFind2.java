import com.sun.glass.ui.Size;

public class UnionFind2 implements UF {

    private int[] parent;
    public UnionFind2(int size){
        parent=new int[size];
        for (int i=0;i<parent.length;i++)
            parent[i]=i;//初始化为了保证每个不相连
    }
    @Override
    public int getSize(){
        return parent.length;
    }

    //查找过程，查找元素p对应的集合编号
    //O(h)复杂度，h为树的高度
    private int find(int p){

        while (p!=parent[p])
            p=parent[p];
        return p;
    }
    //查看元素p和元素q是否所属一个集合
    @Override
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }


    @Override
    public void unionElements(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot)
            return;
        parent[pRoot]=qRoot;
    }
}
