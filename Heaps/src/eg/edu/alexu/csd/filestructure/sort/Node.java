package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class Node implements INode {
    ArrayList<Node> arr;
    Comparable val;
    int index;

    public Node(ArrayList<Node> arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public INode getLeftChild() {
        if((index * 2) > (arr.size()-1)) return null;
//        System.out.println("Left Child "+index*2);
        return arr.get(index * 2);
    }

    @Override
    public INode getRightChild() {
        if((index * 2) + 1 > (arr.size()-1)) return null;
        return arr.get(index * 2 + 1);
    }

    @Override
    public INode getParent() {
//        if(index==1)
//            return
        return arr.get(index / 2);
    }

    @Override
    public Comparable getValue() {
        return val;
    }

    @Override
    public void setValue(Comparable value) {
        this.val = value;
    }

    public static void main(String[] args) {
       IHeap heap = (IHeap)TestRunner.getImplementationInstanceForInterface(IHeap.class);

        try {
            ArrayList<Integer> arr = new ArrayList();
            Random r = new Random();
            PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

            int i;
            for(i = 0; i < 25; ++i) {
                int val = r.nextInt(1000);
                arr.add(val);
                pq.add(val);
            }

            heap.build(arr);

            for(i = 0; i < 25; ++i) {
               System.out.println("o/p "+(long)(Integer)pq.poll()+ " "+ (long)(Integer)heap.extract());
            }
        } catch (Throwable var7) {
            TestRunner.fail("Fail to build heap", var7);
        }

    }
}
