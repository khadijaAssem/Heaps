package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;

public class Heap implements IHeap {
    private int MAX = 20000000;
    int size =1;
//    Node[] heap;
    ArrayList<Node> heap;
    int j;
    public Heap(){
        heap = new ArrayList<>();
        heap.add(0,null);
    }

    @Override
    public INode getRoot() {
        if(size-1==0)
            return null;
        return heap.get(1);
    }

    @Override
    public int size() {
        return size-1;
    }

    @Override
    public void heapify(INode node) {
//        boolean flag = true;
//        while(flag) {
//            try {
//                while (node.getValue().compareTo(node.getParent().getValue()) > 0) {
////            if (node.getValue().compareTo(node.getParent().getValue()) > 0) {
//                    Comparable temp = node.getValue();
//                    node.setValue(node.getParent().getValue());
//                    node.getParent().setValue(temp);
//                    node = node.getParent();
////                continue;
////            }
//                }
//            }
//            catch (Exception e){}
//
//            try {
////                System.out.println("HERE");
//                if (size % 2 != 0 && node.getValue().compareTo(node.getParent().getLeftChild().getValue()) > 0) {
//                    Comparable temp = node.getValue();
//                    node.setValue(node.getParent().getLeftChild().getValue());
//                    node.getParent().getLeftChild().setValue(temp);
//                    continue;
//                }
//            }
//            catch (Exception e){/*System.out.println("EXCEPTION");*/}
//            flag =false;
//        }
//       else if (size%2==0&&size!=2&&node.getValue().compareTo(node.getParent().getRightChild().getValue())<0){
//           Comparable temp = node.getValue();
//           node.setValue(node.getParent().getRightChild().getValue());
//           node.getParent().setValue(temp);
//       }

//        }catch(Exception e){
//        if (size%2==0) {
//            try {
//                System.out.println("SETTING VALUE TO IT'SLEFT "+node.getLeftChild().getValue());
//                node.setValue(node.getLeftChild().getValue());
//            } catch (Exception E) {
//            }
//        }
//        else{
//            try{
//                System.out.println("SETTING VALUE TO RIGHT "+node.getParent().getRightChild().getValue());
//                node.setValue(node.getParent().getRightChild().getValue());
//            }catch (Exception E){}
//        }
//            try{
//                node.setValue(node.getRightChild().getValue());
//            }catch (Exception E){}
//        }
//        if((j*2)+1>=(size)||(j*2)>=size) {
//            if ((j*2)+1<size){
//                Comparable temp = node.getValue();
//                node.setValue(node.getRightChild().getValue());
//                node.getRightChild().setValue(temp);
//            }
//            if (j*2 < size){
//                Comparable temp = node.getValue();
//                node.setValue(node.getLeftChild().getValue());
//                node.getLeftChild().setValue(temp);
//            }
//            return;
//        }
        if(j*2<size && j*2+1<size && node!=null) {
//            System.out.println(j+ " will check both");
            Comparable l = node.getLeftChild().getValue();
            Comparable n = node.getValue();
            Comparable r = node.getRightChild().getValue();
            if (l.compareTo(r) >= 0 && l.compareTo(n) > 0) {
//                System.out.println("IF1");
                node.setValue(l);
                node.getLeftChild().setValue(n);
                j=j*2;
                heapify(node.getLeftChild());
            } else if (r.compareTo(l) >= 0 && r.compareTo(n) > 0) {
//                System.out.println("IF2");
                node.setValue(r);
                node.getRightChild().setValue(n);
                j=j*2+1;
                heapify(node.getRightChild());
            }
        }
        else if(j*2<size&&node!=null){
//            System.out.println("Check 1");
            Comparable l = node.getLeftChild().getValue();
            Comparable n = node.getValue();
            if (l.compareTo(n) > 0) {
//                System.out.println("IF3");
                node.setValue(l);
                node.getLeftChild().setValue(n);
                j=j*2;
                heapify(node.getLeftChild());
            }
        }
//
//            System.out.println(l+" vs "+n);
//            if (l.compareTo(n)>0){
//                System.out.println("IF1");
//                node.setValue(l);
//                node.getLeftChild().setValue(n);
//                heapify(node.getLeftChild());
//            }
//
//        }
//        if (j*2+1<size){
//            j = j*2+1;
//            Comparable r = node.getRightChild().getValue();
//            Comparable n = node.getValue();
//            System.out.println(r +" vs "+n);
//            if (r.compareTo(n)>0){
//                System.out.println("IF2");
//                node.setValue(r);
//                node.getRightChild().setValue(n);
//                heapify(node.getRightChild());
//            }
//        }

//        try {
      /*  System.out.println("j "+j + " size "+(size-1));
            if (j*2<size && node.getLeftChild().getValue().compareTo(node.getValue()) > 0) {
                System.out.println("IF1");
                Comparable temp = node.getValue();
                node.setValue(node.getLeftChild().getValue());
                node.getLeftChild().setValue(temp);
                j=j*2;
                heapify(node.getLeftChild());
            }
//        }catch (Exception e){}
//        try {
            if ((j*2+1)<size && node.getRightChild().getValue().compareTo(node.getValue()) > 0 ) {
                System.out.println("IF2");
                Comparable temp = node.getValue();
                node.setValue(node.getRightChild().getValue());
                node.getRightChild().setValue(temp);
                j=j*2+1;
                heapify(node.getRightChild());
            }*/
//        }catch (Exception e){}
    }

    @Override
    public Comparable extract() {
//        System.out.println("Before extraction");
//        for(int i=1;i<size;i++)
//            System.out.print(heap.get(i).getValue()+" ");
//        System.out.println();
        Comparable x ;
        try {
            x = heap.get(1).getValue();
        }
        catch (Exception e) {return null;}
        heap.get(1).setValue(heap.get(size-1).getValue());
        j = 1;
        heapify(heap.get(1));
//        heap[size-1].setValue(null);
        heap.set(size-1,null);
        size--;
//        System.out.println("After extract");
//        for(int i=1;i<size;i++)
//            System.out.print(heap.get(i).getValue()+" ");
//        System.out.println();
        return x;
    }

    @Override
    public void insert(Comparable element) {
        if (element==null) return;
        INode nNode = new Node(heap,size);
        nNode.setValue(element);
//        if(size == 1){
////            System.out.println("ROOT "+element);
//            heap[size++] = (Node) nNode;
//            return;
//        }
        heap.add(size++,(Node) nNode);
//        System.out.println("Size "+(size-1));
//        for(int i=1;i<size;i++)
//            System.out.print(heap.get(i).getValue()+" ");
//        System.out.println();
        int i=size-1;
        while (i!=1) {
            Comparable p = nNode.getParent().getValue();
            Comparable n = nNode.getValue();
//            i++;
            if (p.compareTo(n) < 0) {
                nNode.setValue(p);
                nNode.getParent().setValue(n);
                nNode = nNode.getParent();
//                System.out.println(i);
            }
            i/=2;
        }
//        heapify(nNode);
//        for(int k=1;k<size;k++)
//            System.out.print(heap.get(k).getValue()+" ");
//        System.out.println();
    }
    @Override
    public void build(Collection unordered) {
        size = 1;
        if(unordered==null) return;
        int x = unordered.size();
        ArrayList<Comparable> values = new ArrayList<Comparable>(unordered);
//        System.out.println(size);
        for(int i=0;i<x;i++){
            insert(values.get(i));
//            Node nNode = new Node(heap,size);
//            heap.add(size,nNode);
//            heap.get(size++).setValue(values.get(i));
//            System.out.print(values.get(i)+ " ");
        }
//        j = (size-1) / 2;
//        while (j > 0) {
//            heapify(heap.get(j));
//            j--;
//        }
//        for(int k=1;k<size;k++){
//            System.out.print(heap.get(k).getValue()+" ");
//        }
//        System.out.println();
    }
}
