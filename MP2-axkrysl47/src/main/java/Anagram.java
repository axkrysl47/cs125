import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A class that tests whether two strings are anagrams.
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the tests in
 * <code>AnagramTest.java</code>.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/2/">MP2 Documentation</a>
 * @see <a href="https://www.vocabulary.com/dictionary/anagram">Definition of anagram</a>
 */
public class Anagram {

    /** ASCII character value for numeral 0.  **/
    public static final int MIN_INT = 48;

    /** ASCII character value for numeral 9.  **/
    public static final int MAX_INT = 57;

    /** ASCII character value for letter A.  **/
    public static final int MIN_CHAR = 65;

    /** ASCII character value for letter Z.  **/
    public static final int MAX_CHAR = 90;


    /**
     * Given two strings return true if they are anagrams of each other.
     * <p>
     * Two strings are anagrams if they contain the same letters but in a different order.
     * You should ignore case, punctuation, and whitespace. So only consider the letters A-Z,
     * a-z, and the numbers 0-9. And you should also require that the anagram use the same
     * letters the same number of times. (Some anagram definitions are more flexible.)
     *
     * <ul>
     *     <li>Example: "A decimal point" anagrams to "I’m a dot in place."</li>
     *     <li>Example: "rail safety" anagrams to "fairy tales".</li>
     * </ul>
     *
     * <p>
     * Either the first or second string may be null, in which case you should return false.
     * Empty strings require no special treatment.
     * <p>
     * Write this function.
     *
     * @param first the first string to use for the anagram comparison
     * @param second the second string to use for the anagram comparison
     * @return true if the two strings are anagrams ignoring case and punctuation
     * @see <a href="https://www.vocabulary.com/dictionary/anagram">Definition of anagram</a>
     */
    public static boolean areAnagrams(final String first, final String second) {
        ArrayList<String> list = new ArrayList<String>();

        if (first == null || second == null) {
            return false;
        }

        String input1 = first.toUpperCase();    //System.out.println(input1);
        String input2 = second.toUpperCase();   //System.out.println(input1);

        String word1 = "";
        String word2 = "";

        for (int i = 0; i < input1.length(); i++) {
            char c = input1.charAt(i);              //System.out.println("Word 1's Char " + c);
            int x = (int) c;                        //System.out.println("Int " + x);
            String s = input1.substring(i, i + 1);  //System.out.println("String " + s);

            if ((x >= MIN_INT && x <= MAX_INT) || (x >= MIN_CHAR && x <= MAX_CHAR)) {
                word1 += s;
            }
        }

        for (int i = 0; i < input2.length(); i++) {
            char c = input2.charAt(i);
            int x = (int) c;
            String s = input2.substring(i, i + 1);

            if ((x >= MIN_INT && x <= MAX_INT) || (x >= MIN_CHAR && x <= MAX_CHAR)) {
                word2 += s;
            }
        }

        //System.out.println("Word 1: " + word1);
        //System.out.println("Word 2: " + word2);

        if (word1.length() != word2.length()) {
            return false;
        }

        char[] arr1 = new char[word1.length()];
        char[] arr2 = new char[word2.length()];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = word1.charAt(i);
            arr2[i] = word2.charAt(i);
        }

        Arrays.sort(arr1);  //System.out.println(arr1);
        Arrays.sort(arr2);  //System.out.println(arr2);

        String ans1 = "";
        String ans2 = "";

        for (int i = 0; i < arr1.length; i++) {
            ans1 += arr1[i];
            ans2 += arr2[i];
        }

        //System.out.println(ans1 + " " + ans2);

        if (ans1.equals(ans2)) {
            return true;
        } else {
            return false;
        }
    }

    /* ********************************************************************************************
     * You do not need to modify code below this comment.
     * ********************************************************************************************/

    /**
     * Solicits two strings from the user and print if they are anagrams.
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String first = lineScanner.nextLine();
        System.out.println("Enter another string: ");
        String second = lineScanner.nextLine();
        if (areAnagrams(first, second)) {
            System.out.println("The two strings are anagrams");
        } else {
            System.out.println("The two strings are not anagrams");
        }
    }
}
