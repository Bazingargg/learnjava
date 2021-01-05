public interface Deque<Ti> {
    public void addFirst(Ti item);
    public void addLast(Ti item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Ti removeFirst();
    public Ti removeLast();
    public Ti get(int index);
}
