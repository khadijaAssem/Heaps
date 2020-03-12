package eg.edu.alexu.csd.filestructure.sort;

import java.util.Collection;

public class Heap implements IHeap {
    private int MAX = 5;
    INode root;
    int size =0;
    Node[] heap;
    public Heap(){
        heap = new Node[MAX];
        root = new Node(heap,0);
        size++;
    }

    @Override
    public INode getRoot() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void heapify(INode node) {

    }

    @Override
    public Comparable extract() {
        return null;
    }

    @Override
    public void insert(Comparable element) {

    }

    @Override
    public void build(Collection unordered) {

    }
}
