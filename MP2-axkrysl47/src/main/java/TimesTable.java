import java.util.Scanner;
import java.util.Arrays;

/**
 * A class that creates a Times Table.
 */
public class TimesTable {

    /**
     * Creates a square 2D array times table of consecutive numbers given a starting number and ending number.
     *
     * @param start number for starting row and column.
     * @param end   number for ending row and column.
     * @return      A 2D array times table.
     */
    public static int[][] createTimesTable(final int start, final int end) {
        if (start < 1 || end < 1 || start >= end) {
            return null;
        }

        int length = end - start + 2;
        int[][] output = new int[length][length];
        output[0][0] = 0;

        int set = start;
        for (int i = 1; i < length; i++) {
            output[i][0] = set;
            output[0][i] = set;
            set++;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                output[i][j] = output[0][j] * output[i][0];
            }
        }

        return output;
    }

    /**
     * Main class method.
     * <p></p>
     * Solicits to integers from the user and prints a times table.
     * @param unused unused input arguments.
     */
    public static void main(final String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter an integer to begin the times table: ");
        int first = lineScanner.nextInt();
        System.out.println("Enter another integer to end the times table: ");
        int second = lineScanner.nextInt();

        int[][] table = TimesTable.createTimesTable(first, second);

        System.out.println();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
