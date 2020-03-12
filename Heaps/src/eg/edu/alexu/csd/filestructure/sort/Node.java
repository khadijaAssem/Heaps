package eg.edu.alexu.csd.filestructure.sort;

public class Node implements INode{
    Node[] arr;
    Comparable val;
    int index;
    public Node(Node[] arr,int index){
        this.arr = arr;
        this.index = index;
    }
    @Override
    public INode getLeftChild() {
        return arr[index*2];
    }

    @Override
    public INode getRightChild() {
        return arr[index*2+1];
    }

    @Override
    public INode getParent() {
        return arr[index/2];
    }

    @Override
    public Comparable getValue() {
        return val;
    }

    @Override
    public void setValue(Comparable value) {
        this.val = value;
    }
}
