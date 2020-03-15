package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

class Node<T extends Comparable<T>> implements INode {
	private Integer index;
	private int [] array;


	@Override
	public INode getLeftChild() {
		return null;
	}

	@Override
	public INode getRightChild() {
		return null;
	}

	@Override
	public INode getParent() {
		return null;
	}

	@Override
	public Comparable getValue() {
		return null;
	}

	@Override
	public void setValue(Comparable value) {

	}
}
