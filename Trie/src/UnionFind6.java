public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;//rank[i]表示以i为根的集合高度

    public UnionFind6(int size){
        parent=new int[size];
        rank=new int[size];
        for (int i=0;i<parent.length;i++){
            parent[i]=i;//初始化为了保证每个不相连
            rank[i]=1;
        }
    }
    @Override
    public int getSize(){
        return parent.length;
    }

    //查找过程，查找元素p对应的集合编号
    //O(h)复杂度，h为树的高度
    private int find(int p){

        if (p!=parent[p]){
            parent[p]=find(parent[p]);
        }
        return parent[p];
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

        //把rank少的集合合并到rank更多的集合，保持h较低
        if (rank[pRoot]<rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if (rank[qRoot]<rank[pRoot])
            parent[qRoot]=pRoot;
        else {//rank[pRoot]=rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot]+=1;
        }
    }
}

