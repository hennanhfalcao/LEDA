package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
					new DoubleLinkedListNode<T>());

			if (this.isEmpty()) {
				this.setHead(aux);
				this.setLast(aux);
			} else {
				aux.setNext(this.getHead());
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(aux);
				this.setHead(aux);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());
			this.getLast().setNext(newLast);
			((DoubleLinkedListNode<T>) newLast.getNext()).setPrevious(newLast);

			if (this.getLast().isNIL()) {
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.next;
				}
				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T found = null;
		if (!this.isEmpty() && element != null) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();

			while (!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) && !auxHead.getData().equals(element)
					&& !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}

			if (auxHead.getData().equals(element)) {
				found = auxHead.getData();
			}

			if (auxLast.getData().equals(element)) {
				found = auxLast.getData();
			}
		}

		return found;

	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {

			if (this.getHead().getNext().isNIL()) {
				this.setHead(new DoubleLinkedListNode<T>());
				this.setLast(new DoubleLinkedListNode<T>());

			} else {
				this.setHead(this.getHead().getNext());
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getLast().getPrevious().isNIL()) {
				this.setHead(new DoubleLinkedListNode<T>());
				this.setLast(new DoubleLinkedListNode<T>());
			} else {
				this.setLast(this.getLast().getPrevious());
				this.getLast().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}