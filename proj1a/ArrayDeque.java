public class ArrayDeque<T> {
	private T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int maxSize;
	private static double ratio = 0.25;

	public ArrayDeque() {
		size = 0;
		// 强制类型转换，为了更好的使用范型
		items = (T[]) new Object[8];
		nextFirst = 0;
		nextLast = 1;
		maxSize = 8;
	}
	/** 完成这些基本功能后，要不要让ArrayDequq能够自动增长
	 * 这个函数有一些问题，并没有办法很好的增长*/
	private void expand() {
		int large = maxSize * 2;
		T[] bigger = (T[]) new Object[large];
		int p1 = add(nextFirst);
		int p2 = add(nextFirst); //找到存放的第一个位置
		int p = nextFirst;
		for (int i = 0; i < maxSize - 1; i++) {
			bigger[p1] = items[add(p)];
			p1 += 1;
			p = add(p);
		}
		maxSize = large;
		items = bigger;
		nextLast = p1; //nextFirst也需要更新
		nextFirst = minus(p2);

	}

	private void resize() {
		/** 希望能将数组长度自动缩小，
		 * 如果达到一定的比率自动调整*/
		if ((double) size / maxSize >= ratio) {
			return;
		}
		int size = maxSize / 4;
		T[] smaller = (T[]) new Object[size];
		int count = 0;
		while (count < size) {
			smaller[count] = items[add(nextFirst)];
			count += 1;
		}
		nextFirst = maxSize - 1;
		nextLast = size;
		maxSize = maxSize / 4;
		items = smaller;
	}

	public ArrayDeque(ArrayDeque other) {
		size = other.size;
		nextFirst = other.nextFirst;
		nextLast = other.nextLast;
		items = (T[]) new Object[other.maxSize];
		int first = nextFirst;
		while (first != nextLast) {
			items[add(first)] = (T) other.items[add(first)];
			first = add(first);
		}
	}



	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if ((nextFirst + 1) % maxSize == nextLast) {
			return true;
		}
		return false;
	}

	private boolean isFull() {
		if (nextLast == nextFirst && maxSize - 1 == size) {
			return true;
		}
		return false;
	}

	public void addFirst(T x) {
		//如果满了的话函数直接返回
		if (isFull()) {
			expand();
		}
		size += 1;
		items[nextFirst] = x;
		nextFirst = minus(nextFirst);
	}

	public void addLast(T x) {
		if (isFull()) {
			expand();
		}
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
		if (isEmpty()) {
			return;
		}
		int pt = add(nextFirst);
		while (pt != nextLast) {
			if (pt == minus(nextLast)) { //这部分写错了 应该用的first
				System.out.print(items[pt]);
				break;
			}
			System.out.print(items[pt] + " ");
			pt = add(pt);
		}
	}

	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		resize();
		size -= 1;
		T first = items[add(nextFirst)];
		items[add(nextFirst)] = null;
		nextFirst = add(nextFirst);
		return first;
	}

	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		resize();
		size -= 1;
		T last = items[minus(nextLast)];
		items[minus(nextLast)] = null;
		nextLast = minus(nextLast);
		return last;
	}

	public T get(int index) {
		if (index > maxSize - 1) {
			return null;
		}
		int count = 0;
		int pt = nextFirst;
		while (count < index + 1) {
			pt = add(pt);
			count += 1;
		}
		return items[pt];
	}

}
