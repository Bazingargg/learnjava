public class LinkedListDeque<T> {
    private class<T> NodePoint {
        T item;
        NodePoint prev;
        NodePoint next;

        public NodePoint(T x) {
            item = x;
            prev = null;
            next = null;
        }
    }

    private int size;    //需要全局维护的变量
    private NodePoint sentinel;  //只有一个哨兵就够了，然后利用循环的形式

    public LinkedListDeque(T x) {
        size = 0;
        sentinel = new NodePoint(x);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = null;
    }


    public void addFirst(T item) {
        size += 1;
        NodePoint point = new NodePoint(item);
        point.next = sentinel.next;
        point.prev = sentinel;
        sentinel.next.prev = point;
        sentinel.next = point;
    }

    public void addLast(T item) {
        size += 1;
        NodePoint point = new NodePoint(item);
        point.prev = sentinel.prev;
        point.next = sentinel;
        sentinel.prev.next = point;
        sentinel.prev = point;
    }

    public boolean isEmpty() {
        if (sentinel == null) return true;
        return false;
    }

    public int size() {
        return size;
    }

    /** 为了遍历输出队列的值，感觉需要一个辅助函数*/
    public void printDeque() {
        for (T )
    }

    public T removeFirst() {
        ...
    }

    public T removeLast() {
        ...
    }

    public T get(int index) {

    }

    public T getRecursive(int index) {

    }
}