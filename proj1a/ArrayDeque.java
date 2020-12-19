public class ArrayDeque<T> {
	public T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int maxSize;

	public ArrayDeque() {
		size = 0;
		// 强制类型转换，为了更好的使用范型
		items = (T[]) new Object[8];
		nextFirst = 0;
		nextLast = 1;
		maxSize = 8;
	}
	/** 完成这些基本功能后，要不要让ArrayDequq能够自动增长*/

	public ArrayDeque(ArrayDeque other) {
		size = other.size;
		nextFirst = other.nextFirst;
		nextLast = other.nextLast;
		items = (T[]) new Object[other.maxSize];
		int first = nextFirst;
		while(first != nextLast) {
			items[add(first)] = (T) other.items[add(first)];
			first = add(first);
		}
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
		int pt = add(nextFirst);
		while (pt !=nextLast) {
			if (pt == minus(nextLast)) {
				System.out.print(items[pt]);
				break;
			}
			System.out.print(items[pt] + " ");
			pt = add(pt);
		}
	}

	public T removeFirst() {
		if (isEmpty()) return null;
		size -= 1;
		T first = items[add(nextFirst)];
		items[add(nextFirst)] = null;
		nextFirst = add(nextFirst);
		return first;
	}

	public T removeLast() {
		if (isEmpty()) return null;
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

	public static void main(String[] args) {
		ArrayDeque<String> test = new ArrayDeque<>();
		test.addFirst("you ");
		test.addLast("are ");
		if (!test.isEmpty()) {
			System.out.println("it is not null!");
		}
		System.out.println("the size of test is: " + test.size());
		test.addLast("good!");
		test.printDeque();
		test.removeFirst();
		test.removeLast();
		System.out.println();
		test.printDeque();
		System.out.println();
		System.out.println(test.get(0));

	}

}