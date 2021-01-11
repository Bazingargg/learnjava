import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    private static final int nCall = 1000;
    private static String message = "";

    private void randomAdd(double random, Integer i, StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> right) {
        if (random < 0.5) {
            sad.addFirst(i);
            right.addFirst(i);
            message += "\naddFirst(" + i + ")";
        } else {
            sad.addLast(i);
            right.addLast(i);
            message += "\naddLast(" + i + ")";
        }
    }

    private void randomRemove(double random, Integer i, StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> right) {
        Integer expected;
        Integer actual;
        if (random < 0.5) {
            expected = right.removeFirst();
            actual = sad.removeFirst();
            message += "\nremoveFirst()";
        } else {
            expected = right.removeLast();
            actual = sad.removeLast();
            message += "\nremoveLast()";
        }
        assertEquals(message, expected, actual);
    }

    @Test
    public void testWhat() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> right = new ArrayDequeSolution<>();

        for (Integer i = 0; i < nCall; i += 1) {
            if (sad.isEmpty()) {
                double random = StdRandom.uniform();
                randomAdd(random, i, sad, right);
            } else {
                double random1 = StdRandom.uniform();
                double random2 = StdRandom.uniform();
                if (random1 < 0.5) {
                    randomAdd(random2, i, sad, right);
                } else {
                    randomRemove(random2, i, sad, right);
                }
            }
        }
    }

}
