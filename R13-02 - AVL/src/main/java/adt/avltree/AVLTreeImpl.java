package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	@Override
	public void insert(T element) {
		if (element != null) {
			recursiveInsert(this.root, element);
		}
	}

	private void recursiveInsert(BSTNode<T> current, T element) {
		if (current.isEmpty()) {
			current.setData(element);
			current.setLeft(new BSTNode.Builder<T>().parent(current).build());
			current.setRight(new BSTNode.Builder<T>().parent(current).build());
		} else {
			if (element.compareTo(current.getData()) < 0) {
				recursiveInsert((BSTNode<T>) current.getLeft(), element);
			} else {
				recursiveInsert((BSTNode<T>) current.getRight(), element);
			}
			rebalance(current);
		}
	}

	public void remove(T element) {
		BSTNode<T> node = super.search(element);
		super.remove(element);
		this.rebalanceUp(node);
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;

		if (node!=null && !node.isEmpty()) {
			result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}

		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		BSTNode<T> aux = null;
		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					aux = Util.rightRotation(node);
				} else {
					Util.leftRotation((BSTNode<T>) node.getLeft());
					aux = Util.rightRotation(node);
				}
			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					aux = Util.leftRotation(node);
				} else {
					Util.rightRotation((BSTNode<T>) node.getRight());
					aux = Util.leftRotation(node);
				}
			}
			if (this.getRoot().equals(node) && aux != null) {
				this.root = aux;
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
}
