/**
 * A class that represents a DNA sequence.
 * <p>
 * Internally the class represents DNA as a string. You are responsible for implementing the longest
 * common subsequence method and a straightforward constructor.
 * <p>
 * The DNA class does not need to provide a setter for the sequence, meaning that it can be allowed
 * to not change after the instance is created. As a result, it should not provide an empty
 * constructor.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/5/">MP5 Documentation</a>
 */
public class DNA {

    /** Sequence of base pairs for this DNA instance. */
    private String sequence;

    /**
     * Gets the sequence of base pairs for this DNA instance.
     *
     * @return the sequence of base pairs for this DNA instance
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * Create a new DNA instance from the given sequence of base pairs.
     * <p>
     * The constructor should validate and normalize its inputs. All characters in the string should
     * be from the set A, T, C, and G (this in DNA, not RNA). You should accept lower-case inputs
     * but convert them to upper-case for the purposes of later comparison.
     *
     * @param setSequence the sequence of base pairs to initialize the instance with
     */
    public DNA(final String setSequence) {
        sequence = setSequence.toUpperCase();
    }

    /**
     * Return the longest common subsequence of the two provided DNA sequences.
     * You should complete a recursive implementation of this algorithm.
     * You may want to use a helper function so that you can recurse on strings,
     * which have helpful methods, rather than the DNA sequence object.
     * A recursive solution to this problem can get quite slow,
     * particularly as the length of the sequences to compare increases.
     * The testing timeouts provided should be sufficient and will be adjusted as needed.
     * However, feel free to investigate and consider faster approaches.
     *
     * @param firstSequence     the first DNA sequence to compare
     * @param secondSequence    the second DNA sequence to compare
     * @return          the longest common subsequence between the two provided DNA sequences
     */
    public static DNA getLongestCommonSubsequence(final DNA firstSequence,
                                                  final DNA secondSequence) {
        String first = firstSequence.toString();
        String second = secondSequence.toString();

        String output = getLongestCommonString(first, second);

        return new DNA(output);
    }

    /**
     *
     * @param first first string.
     * @param second second string.
     * @return the longest common subsequence of characters.
     */
    public static String getLongestCommonString(final String first, final String second) {
        if (first.equals("") || second.equals("")) {
            return "";
        } else if (first.equals(second)) {
            return first;
        }

        String lastOfFirst = first.substring(first.length() - 1, first.length());
        String restOfFirst = first.substring(0, first.length() - 1);

        String lastOfSecond = second.substring(second.length() - 1, second.length());
        String restOfSecond = second.substring(0, second.length() - 1);

        if (lastOfFirst.equals(lastOfSecond)) {
            return getLongestCommonString(restOfFirst, restOfSecond) + lastOfFirst;
        } else {
            String one = getLongestCommonString(first, restOfSecond);
            String two = getLongestCommonString(restOfFirst, second);

            if (one.length() < two.length()) {
                return two;
            } else {
                return one;
            }
        }
    }

    /**
     * Public toString method for DNA sequences.
     *
     * @return a DNA sequence in String form.
     */
    public String toString() {
        return this.sequence;
    }
}
