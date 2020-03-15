package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;

public class Heap<T extends Comparable<T>> implements IHeap {
	//  private int MAX = 20000000;
	int size =1;
	//  Node[] heap;
//  int j;
	ArrayList<Comparable<T>> nodes ;
	public Heap(){
		nodes= new ArrayList<Comparable<T>>() ;
	}

	@Override
	public INode getRoot() {
		INode root = new Node(nodes, 0);
		if (nodes.size()==0)
			return null;
		return root;
	}

	@Override
	public int size() {
		return nodes.size();
	}

	@Override
	public void heapify(INode node) {
		if (node == null) return;
		INode left = node.getLeftChild();
		INode right = node.getRightChild();
		INode max = node;
		if (left != null && left.getValue().compareTo(node.getValue()) > 0) {
			max = left;
		}
		if (right != null && right.getValue().compareTo(max.getValue()) > 0) {
			max = right;
		}
		if (!max.equals(node)) {
			Comparable temp = max.getValue();
			max.setValue(node.getValue());
			node.setValue(temp);
			heapify(max);
		}
	}

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
	//mn hna

//      if(j*2<size && j*2+1<size && node!=null) {
//          Comparable l = node.getLeftChild().getValue();
//          Comparable n = node.getValue();
//          Comparable r = node.getRightChild().getValue();
//          if (l.compareTo(r) > 0 && l.compareTo(n) > 0) {
//              node.setValue(l);
//              node.getLeftChild().setValue(n);
//              j=j*2;
//              heapify(node.getLeftChild());
//          } else if (r.compareTo(l) > 0 && r.compareTo(n) > 0) {
//              node.setValue(r);
//              node.getRightChild().setValue(n);
//              j=j*2+1;
//              heapify(node.getRightChild());
//          }
//      }
//      else if(j*2<size&&node!=null){
//          Comparable l = node.getLeftChild().getValue();
//          Comparable n = node.getValue();
//          if (l.compareTo(n) > 0) {
//              node.setValue(l);
//              node.getLeftChild().setValue(n);
//              j=j*2;
//              heapify(node.getLeftChild());
//          }
//      }
	//l7d hna
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


	@Override
	public Comparable extract() {
		Comparable x ;
		try {
			x = getRoot().getValue();
		}
		catch (Exception e) {return null;}
		nodes.set(0, nodes.get(nodes.size() - 1));

		heapify(getRoot());
//        heap[size-1].setValue(null);
		nodes.remove(nodes.size() - 1);

//        System.out.println("After extract");
//        for(int i=1;i<size;i++)
//            System.out.print(heap[i].getValue()+" ");
//        System.out.println();
		return x;
////        System.out.println("Before extraction");
////        for(int i=1;i<size;i++)
////            System.out.print(heap[i].getValue()+" ");
////        System.out.println();
//      Comparable <T> x ;
//      try {
//          x = getRoot().getValue();
//      }
//      catch (Exception e) {return null;}
//      nodes.set(0, nodes.get(nodes.size() - 1));
////        j = 1;
//      nodes.remove(nodes.size()-1);
//      heapify(getRoot());
////        heap[size-1].setValue(null);
//
////        size--;
////        System.out.println("After extract");
////        for(int i=1;i<size;i++)
////            System.out.print(heap[i].getValue()+" ");
////        System.out.println();
//      return x;
	}

	@Override
	public void insert(Comparable element) {
		if (element == null) return;
		nodes.add(element);
		Node<T> added = new Node<T>(nodes, nodes.size() - 1);
		while (added.getParent() != null &&((Node) added.getParent()).getIndex() >= 0) {
			INode parent =  added.getParent();
			if (added.getValue().compareTo(parent.getValue()) > 0) {
				Comparable temp = parent.getValue();
				nodes.set(((Node)parent).getIndex(), added.getValue());
				nodes.set(added.getIndex(), temp);
				added = (Node)parent;
			} else {
				break;
			}
		}
	}
//        heapify(nNode);
//        for(int k=1;k<size;k++)
//            System.out.print(heap[k].getValue()+" ");
//        System.out.println();
//	        if (element==null) return;
//        nodes.add(element);
//	INode nNode = new Node(nodes,nodes.size()-1);
//        nNode.setValue(element);
//	//        if(size == 1){
//////            System.out.println("ROOT "+element);
////            heap[size++] = (Node) nNode;
////            return;
////        }
////      heap[size++] = (Node) nNode;
////        System.out.println("Size "+(size-1));
////        for(int i=1;i<size;i++)
////            System.out.print(heap[i].getValue()+" ");
////        System.out.println();
//	int i=size-1;
//        while (i!=1) {
//		Comparable p = nNode.getParent().getValue();
//		Comparable n = nNode.getValue();
////            i++;
//		if (p.compareTo(n) < 0) {
//			Comparable temp = p;
//			nodes.set(((Node) nNode.getParent()).getIndex(), nNode.getValue());
//			nodes.set(((Node)nNode).getIndex(), temp);
//			nNode = nNode.getParent();
////              nNode.setValue(p);
////              nNode.getParent().setValue(n);
////              nNode = nNode.getParent();
////                System.out.println(i);
//		}
//		i/=2;


		@Override
	public void build(Collection unordered) {
		if (unordered == null) {
			return;
		}
		nodes = new ArrayList<Comparable<T>>(unordered);
		int i = nodes.size() / 2;
		while (i >= 0) {
			Node<T> node = new Node<T>(nodes, i);
			heapify(node);
			i--;
		}
	}


	private void heapify(INode node, int size) {
		if (node == null) return;
		Node<T> leftChild = (Node<T>) node.getLeftChild();
		Node<T> rightChild = (Node<T>) node.getRightChild();
		Node<T> largest;
		if (leftChild != null && leftChild.getIndex() < size && leftChild.getValue().compareTo(node.getValue()) > 0) {
			largest = leftChild;
		} else {
			largest = (Node<T>) node;
		}
		if (rightChild != null && rightChild.getIndex() < size && rightChild.getValue().compareTo(largest.getValue()) > 0) {
			largest = rightChild;
		}
		if (((Node<T>) node).getIndex() == largest.getIndex()) return;
		Comparable<T> temp = node.getValue();
		nodes.set(((Node<T>) node).getIndex(), largest.getValue());
		nodes.set(largest.getIndex(), temp);
		heapify(largest, size);
	}
	private void buildArrayList(ArrayList unordered) {
		if (unordered == null) {
			return;
		}
		nodes = unordered;
		int i = nodes.size() / 2;
		while (i >= 0) {
			Node<T> node = new Node<T>(nodes, i);
			heapify(node);
			i--;
		}
	}

	public void heapSort(ArrayList unordered) {
		buildArrayList(unordered);
		int i = nodes.size() - 1;
		while (i >= 0) {
			Comparable<T> top = nodes.get(0);
			nodes.set(0, nodes.get(i));
			nodes.set(i, top);
			heapify(getRoot(), i);
			i--;
		}
	}
}