package eg.edu.alexu.csd.filestructure.sort;

import java.util.Collection;

public class Heap implements IHeap {
    private int MAX = 20000000;
    int size =1;
    Node[] heap;
    Node last;
    public Heap(){
        heap = new Node[MAX];
    }

    @Override
    public INode getRoot() {
        return heap[1];
    }

    @Override
    public int size() {
        return size-1;
    }

    @Override
    public void heapify(INode node) {
        boolean flag = true;
        while(flag) {
            try {
                while (node.getValue().compareTo(node.getParent().getValue()) > 0) {
//            if (node.getValue().compareTo(node.getParent().getValue()) > 0) {
                    Comparable temp = node.getValue();
                    node.setValue(node.getParent().getValue());
                    node.getParent().setValue(temp);
                    node = node.getParent();
//                continue;
//            }
                }
            }
            catch (Exception e){}

            try {
//                System.out.println("HERE");
                if (size % 2 != 0 && node.getValue().compareTo(node.getParent().getLeftChild().getValue()) > 0) {
                    Comparable temp = node.getValue();
                    node.setValue(node.getParent().getLeftChild().getValue());
                    node.getParent().getLeftChild().setValue(temp);
                    continue;
                }
            }
            catch (Exception e){/*System.out.println("EXCEPTION");*/}
            flag =false;
        }
//       else if (size%2==0&&size!=2&&node.getValue().compareTo(node.getParent().getRightChild().getValue())<0){
//           Comparable temp = node.getValue();
//           node.setValue(node.getParent().getRightChild().getValue());
//           node.getParent().setValue(temp);
//       }
    }

    @Override
    public Comparable extract() {
        Comparable x = heap[size-1].getValue();
        heap[size-1].setValue(null);
        heap[size-1] = null;
        size--;
        return x;
    }

    @Override
    public void insert(Comparable element) {
        if (element==null) return;
        INode nNode = new Node(heap,size);
        nNode.setValue(element);
        if(size == 1){
            System.out.println("ROOT "+element);
            heap[size++] = (Node) nNode;
            return;
        }
        heap[size++] = (Node) nNode;
        heapify(nNode);
//        System.out.println("Size "+(size-1));
//        System.out.println("Element "+element);
//        for(int i=1;i<size;i++){
//            System.out.println(heap[i].getValue());
//        }
//        size++;
    }

    @Override
    public void build(Collection unordered) {

    }
}
