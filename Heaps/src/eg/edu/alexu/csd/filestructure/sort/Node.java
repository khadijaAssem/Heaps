package eg.edu.alexu.csd.filestructure.sort;

import java.util.Random;

public class Node implements INode {
    Node[] arr;
    Comparable val;
    int index;

    public Node(Node[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public INode getLeftChild() {
//        System.out.println("Left Child "+index*2);
        return arr[index * 2];
    }

    @Override
    public INode getRightChild() {
        return arr[index * 2 + 1];
    }

    @Override
    public INode getParent() {
//        if(index==1)
//            return
        return arr[index / 2];
    }

    @Override
    public Comparable getValue() {
        return val;
    }

    @Override
    public void setValue(Comparable value) {
        this.val = value;
    }

//    public static void main(String[] args) {
//        IHeap<Integer> heap = (IHeap) TestRunner.getImplementationInstanceForInterface(IHeap.class);
//        INode root = null;
//        Integer max = 0;
//
//        for (int i = 0; i < 10; ++i) {
//            Random r = new Random();
//            int val = r.nextInt(200);
//            heap.insert(val);
//            max = Math.max(max, val);
//        }
//
//        root = heap.getRoot();
//        System.out.println(max + " " + root.getValue());
//    }
}
