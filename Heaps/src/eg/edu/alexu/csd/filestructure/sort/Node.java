package eg.edu.alexu.csd.filestructure.sort;

import javax.management.RuntimeErrorException;
import java.util.*;

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
            int i;
            for(i = 0; i < 10; ++i) {
                heap.insert("soso");
            }

            for(i = 0; i < 10; ++i) {
                heap.extract();
            }

            String s = (String)heap.extract();
            System.out.println(s);
        } catch (RuntimeErrorException var3) {
        } catch (Throwable var4) {
            TestRunner.fail("Fail to handle extracting after inserting and removing all elements", var4);
        }
    }
}
