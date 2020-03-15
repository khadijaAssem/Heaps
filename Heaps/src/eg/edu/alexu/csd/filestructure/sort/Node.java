package eg.edu.alexu.csd.filestructure.sort;

import java.util.Collections;
import java.util.PriorityQueue;
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

    public static void main(String[] args) {
        IHeap heap = (IHeap)TestRunner.getImplementationInstanceForInterface(IHeap.class);

        try {
            PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
            Random r = new Random();
            Random pick = new Random();

            for(int i = 0; i < 10; ++i) {
                int numToPick = pick.nextInt(200);
                int val = r.nextInt(200);
                if (numToPick % 4 == 0) {
                    if (!pq.isEmpty()) {
                        System.out.println("O/P 1 "+pq.poll()+" "+heap.extract());
                    } else {
                        System.out.println("O/P 2 "+0L+" "+(long)heap.size());
                    }
                } else {
                    pq.add(val);
                    heap.insert(val);
                }
            }
        } catch (Throwable var8) {
            TestRunner.fail("Fail in heap", var8);
        }

    }
}
