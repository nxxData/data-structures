public class Array<E> {
    private E[] data;
    private int size;
    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data =(E[]) new Object[capacity];//强制转换
        size=0;
    }
    //无参数构造函数，默认capacity=10
    public Array(){
        this(10);
    }
    //获取数组中的元素个数

    public int getSize() {
        return size;
    }
    //获取数组的容量

    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    //向所有元素后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }
    //向所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }
    //向中间添加一个新元素
    public void add(int index,E e){

        if(index<0||index>size)
            throw new IllegalArgumentException("ADD FAILED.index<0||index>size");
        if (size==data.length)
            resize(2*data.length);
        for (int i=size-1;i>=index;i--)
            data[i+1]=data[i];

        data[index]=e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData=(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++)
            newData[i]=data[i];
        data=newData;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){

        if(index<0||index>size)
            throw new IllegalArgumentException("ADD FAILED.index<0||index>size");

        E ret=data[index];
        for (int i=index+1;i<size;i++)
            data[i-1]=data[i];
        size--;
        data[size]=null;//闲逛的程序回收

        if (size==data.length/4&&data.length/2!=0)
            resize(data.length/2);
        return ret;
    }
    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    //从数组中删除元素e
    public void removeElement(E e){
        int index=findIndex(e);
        if (index!=-1)
            remove(index);
    }
    //获取索引位置的元素
    public E get(int index){
        if (index<0||index>size)
            throw new IllegalArgumentException("get FAILED.index IS illegal.");
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    //修改索引位置的元素为e
    void set(int index,E e){
        if (index<0||index>size)
            throw new IllegalArgumentException("get FAILED.index IS illegal.");
        data[index]=e;
    }
    //查找数组中是否有e
    public boolean contains(E e){
        for (int i=0;i<size ;i++){
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

//查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int  findIndex(E e){
        for (int i=0;i<size ;i++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //输出数组
    @Override//覆盖父类的声明
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if (i!=size-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}
