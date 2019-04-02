public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;//sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size){
        parent=new int[size];
        sz=new int[size];
        for (int i=0;i<parent.length;i++){
            parent[i]=i;//初始化为了保证每个不相连
            sz[i]=1;
        }
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

        //把元素少的集合合并到元素更多的集合，保持h较低
        if (sz[pRoot]<sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }
        else {
            parent[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        }
    }
}
