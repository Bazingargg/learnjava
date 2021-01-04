public class Palindrome {
    /** make "persiflage" to p-e-r-s-i-f-l-a-g-e */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> listOfWord = new LinkedListDeque<>();
        for (int pos = 0; pos < word.length(); pos += 1) {
            char c = word.charAt(pos);
            listOfWord.addLast(c);
        }
        return listOfWord;
    }

    /** 判断输入的word是否是回文体*/
    /** public boolean isPalindromeee(String word) {
        if (word == null || word.length() == 1) {
            return true;
        }
        Deque<Character> list = wordToDeque(word);
        while (list.size() > 1) {
            if (list.removeFirst() == list.removeLast()) {
                continue;
            }
            return false;
        }
        return true;
    } 这个方法有点是迭代的思想，Josh觉得递归的方式写起来更美*/

    /** 这一次用递归的方法来写 */
    public boolean isPalindrome(String word) {
        Deque<Character> list = wordToDeque(word);
        return isPalindromeHelper(list);
    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        if (word.isEmpty() || word.size() == 1) {
            return true;
        }
        if (word.removeLast() != word.removeFirst()) {
            return false;
        }
        return isPalindromeHelper(word);
    }

    public  boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> list = wordToDeque(word);
        return isPalindromeHelper(list, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> word, CharacterComparator cc) {
        if (word.isEmpty() || word.size() == 1) {
            return true;
        }
        if (cc.equalChars(word.removeFirst(), word.removeLast()) != true) {
            return false;
        }
        return isPalindromeHelper(word, cc);
    }

}