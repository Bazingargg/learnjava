public class ArrayDeque<T> {
	public T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int maxSize;

	public ArrayDeque() {
		size = 0;
		T[] items = new items[8];
		nextFirst = 0;
		nextLast = 1;
		maxSize = 8;
	}

	public ArrayDeque(ArrayDeque other) {
		size = other.size;
		nextFirst = other.nextFirst;
		nextLast = other.nextLast;
		T[] items = new T[other.maxSize];
		
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if ((nextFirst + 1) % maxSize == nextLast) return true;
		return false;
	}

	public boolean isFull() {
		if (nextLast == nextFirst) return true;
		return false;
	}

	public void addFirst(T x) {
		//如果满了的话函数直接返回
		if (isFull()) return;
		size += 1;
		items[nextFirst] = x;
		nextFirst = minus(nextFirst);
	}

	public void addLast(T x) {
		if (isFull()) return;
		size += 1;
		items[nextLast] = x;
		nextLast = add(nextLast);
	}

	private int minus(int x) {
		return (x - 1 + maxSize) % maxSize;
	}

	private int add(int x) {
		return (x + 1 + maxSize) % maxSize;
	}

	public void printDeque() {
		if (isEmpty()) return;
		int pt = nextFirst;
		while (pt !=nextLast) {
			if (pt = minus(nextlast)) {
				System.out.print(items[pt]);
			}
			System.out.print(items[pt] + ' ');
			pt = add(pt);
		}
	}

	public T removeFirst() {
		if (isEmpty()) return;
		size -= 1;
		T first = items[add(nextFirst)];
		items[add(nextFirst)] = null;
		nextFirst = add(nextFirst);
		return first;
	}

	public T removeLast() {
		if (isEmpty()) renturn;
		size -= 1;
		T last = items[minus(nextLast)];
		items[minus(nextLast)] = null;
		nextLast = minus(nextLast);
		return last;
	}

	public T get(int index) {
		if (index > size - 1) return null;
		int count = 0;
		int pt = nextFirst;
		while (count < index + 1) {
			pt = add(pt);
			count += 1;
		}
		return items[pt];
	}

}