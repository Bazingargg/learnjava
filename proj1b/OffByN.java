public class OffByN implements CharacterComparator {

    private int n;
    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char a, char b) {
        if (a - b == n || b - a == n) {
            return true;
        }
        return false;
    }
}

