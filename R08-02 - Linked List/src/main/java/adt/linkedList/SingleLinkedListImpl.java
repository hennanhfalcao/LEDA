package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	public void rotate(SingleLinkedListNode<T> node, int k) {
		SingleLinkedListNode<T> last = head;
		SingleLinkedListNode<T> temp = head;

		if (head.equals(null) || k == 0) {
			return;
		}
		//fazemos o last apontar para o último nó
		while (!last.getNext().isNIL()) {
			last = last.getNext();
		}

		while (k != 0) {
			head = head.getNext();
			temp.setNext(new SingleLinkedListNode<T>());
			last.setNext(temp);
			last = temp;
			temp = head;
			k--;
		}
	}


	@Override
	public boolean isEmpty() {
		if (head.isNIL()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;

	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		while (!auxHead.isNIL() && auxHead.getData() != element) {
			auxHead = auxHead.getNext();
		}
		return (T) auxHead.getData();
	}

	@Override
	public void insert(T element) {
        
        if (element != null) {

            SingleLinkedListNode<T> aux = head;
            while (!aux.isNIL()) {                
                aux = aux.getNext();
            }

            aux.setData(element);
            aux.setNext(new SingleLinkedListNode<>());
        
        }
    }

	@Override
	public void remove(T element) {
		if (head.getData().equals(element)) {
			head = head.getNext();
		}
		else {
			SingleLinkedListNode<T> aux = head;
			while (!aux.isNIL() && aux.getData() != element) {
				aux = aux.getNext();
			}
			if (!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
        T[] array = (T[]) new Object[this.size()];
        
        int lastIndex = 0;
        SingleLinkedListNode<T> aux = head;
        while (!aux.isNIL()) {
            array[lastIndex++] = aux.getData();
            aux = aux.getNext();
        }
        
        return array;
    }

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
