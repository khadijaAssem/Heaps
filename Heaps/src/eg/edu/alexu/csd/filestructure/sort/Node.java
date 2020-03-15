package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;

class Node<T extends Comparable<T>> implements INode {
	private Integer index;
	private ArrayList nodes;
	Comparable val;

	public Node( ArrayList nodes,Integer index) {
		this.index = index;
		this.nodes=nodes;
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public Node getLeftChild() {
		if((index * 2) + 1 >= nodes.size()) return null;
		Node<T> lChild = new Node<T>(nodes, (index * 2) + 1);
		return lChild;
	}

	@Override
	public Node getRightChild() {
		if((index * 2) + 2 >= nodes.size()) return null;
		Node<T> rChild = new Node<T>(nodes, (index * 2) + 2);
		return rChild;
	}

	@Override
	public Node getParent() {
		if(index == 0) return null;
		Node<T> parent = new Node<T>(nodes, (index - 1) / 2);
		return parent;
	}

	@Override
	public Comparable getValue() {
		if(index >= nodes.size()) {
			return null;
		}
		return (Comparable) nodes.get(index);
	}

	@Override
	public void setValue(Comparable value) {
		if(index >= nodes.size()) return;
		nodes.set(index, value);
	}



}