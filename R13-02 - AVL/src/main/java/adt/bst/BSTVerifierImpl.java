package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return this.bst.isEmpty() || isBST(this.bst.getRoot());
	}

	private boolean isBST(BSTNode<T> currentNode) {
		boolean result = true;
		if (!currentNode.isEmpty()) {
			if (isValidNodeLeft(currentNode) && isValidNodeRight(currentNode)) {
				result = isBST((BSTNode<T>) currentNode.getLeft()) && isBST((BSTNode<T>) currentNode.getRight());
			} else {
				result = false;
			}
		}
		return result;
	}

	private boolean isValidNodeRight(BSTNode<T> currentNode) {
		return isValidNodeRight((BSTNode<T>) currentNode.getRight(), currentNode);
	}

	private boolean isValidNodeRight(BSTNode<T> right, BSTNode<T> currentNode) {
		boolean result = true;
		if (!right.isEmpty()) {
			if (right.getData().compareTo(currentNode.getData()) > 0) {
				result = isValidNodeRight((BSTNode<T>) right.getLeft(), currentNode)
						&& isValidNodeRight((BSTNode<T>) right.getRight(), currentNode);
			} else {
				result = false;
			}
		}
		return result;
	}

	private boolean isValidNodeLeft(BSTNode<T> currentNode) {
		return isValidNodeLeft((BSTNode<T>) currentNode.getLeft(), currentNode);
	}

	private boolean isValidNodeLeft(BSTNode<T> left, BSTNode<T> currentNode) {
		boolean result = true;
		if (!left.isEmpty()) {
			if (left.getData().compareTo(currentNode.getData()) < 0) {
				result = isValidNodeLeft((BSTNode<T>) left.getLeft(), currentNode)
						&& isValidNodeLeft((BSTNode<T>) left.getRight(), currentNode);
			} else {
				result = false;
			}
		}
		return result;
	}
}
