import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A class that splits a string on character change boundaries.
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the tests in
 * <code>StringSplitterTest.java</code>.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/2/">MP2 Documentation</a>
 */
public class StringSplitter {

    /**
     * Given a string, split consecutive characters into elements of an array of Strings.
     *
     * @param input String to be split.
     * @return      Array of split character Strings.
     */
    public static String[] splitString(final String input) {
        if (input == null) {
            return null;
        }

        ArrayList<String> arr = new ArrayList<String>();

        String toSplit = new String(input);

        for (int i = 0; i < input.length();) {
            int j = i + 1;

            while (j < input.length() && input.charAt(i) == input.charAt(j)) {
                j++;
            }

            String plus = input.substring(i, j);
            arr.add(plus);
            i = j;
        }

        String[] output = new String[arr.size()];

        for (int x = 0; x < output.length; x++) {
            output[x] = arr.get(x);
        }

        return output;
    }

    /* ********************************************************************************************
     * You do not need to modify code below this comment.
     * ********************************************************************************************/

    /**
     * Solicit a string and split it whenever the character changes.
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a string to split: ");
        String input = lineScanner.nextLine();
        System.out.println("This splits into: ");
        System.out.println(Arrays.toString(splitString(input)));
    }
}
