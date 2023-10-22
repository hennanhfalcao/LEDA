package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else {
			if (tail == -1) {
				head = 0;
			}
			tail = (tail + 1)%elements;
			array[tail] = element;
			}
		}
	

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
			result = array[head];
			if (head == tail) {
				head = -1;
				tail = -1;
			}
			else {
				head = (head+1)%elements;
			}
			return result;
		}
	}

	@Override
	public T head() {
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		if (head == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (head == 0 && tail == array.length - 1) {
			return true;
		}
		if (head == tail + 1) {
			return true;
		}
		else {
			return false;
		}
	}
}

