public class LinkedListDeque<T> {
    private class NodePoint {
        T item;
        NodePoint prev;
        NodePoint next;

        NodePoint(T x) {
            item = x;
            prev = null;
            next = null;
        }
    }

    private int size;    //需要全局维护的变量
    private NodePoint sentinel;  //只有一个哨兵就够了，然后利用循环的形式


    public LinkedListDeque() {
        size = 0;
        sentinel = new NodePoint(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /** 问题是如果建立的是一个空链，添加第一个元素的时候怎么操作*/
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
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }



    /** 为了遍历输出队列的值，感觉需要一个辅助函数
     * 仔细想想，好像不需要？*/
    public void printDeque() {
        NodePoint pt = sentinel;
        if (pt.next == sentinel) {
            return;
        }
        while (pt != sentinel) {
            if (pt.next == sentinel) {
                System.out.print(pt.item);
                return;
            }
            System.out.print(pt.item + " ");
            pt = pt.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size -= 1;
        NodePoint pt = sentinel;
        pt = pt.next;
        sentinel.next = pt.next;
        pt.next.prev = sentinel;
        return pt.item;
    }

    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size -= 1;
        NodePoint pt = sentinel;
        pt = pt.prev;
        pt.prev.next = sentinel;
        sentinel.prev = pt.prev;
        return pt.item;
    }

    public T get(int index) {
        NodePoint pt = sentinel;
        int count = 0;
        while (count <= index) {
            pt = pt.next;
            count += 1;
        }
        return pt.item;
    }

    /**其实不用这么死板，可以搞个辅助函数*/
    public T getRecursive(int index) {
        return getRecursive(index, sentinel);
    }

    private T getRecursive(int index, NodePoint point) {
        if (index == 0) {
            return point.next.item;
        }
        return getRecursive(index - 1, point.next);
    }

}
