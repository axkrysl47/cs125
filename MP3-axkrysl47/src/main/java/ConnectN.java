import java.util.Objects;

/**
 * A class that implements a Connect4-like game.
 * ConnectN is a tile-based game played on a grid.
 * Like Connect4, players try to get a run of tiles of a given length (N).
 * However, unlike Connect4 ConnectN does not check diagonal runs,
 * although you can add this feature if you like.
 *
 * This ConnectN class is also not responsible for tracking players turns.
 * That could be done by a separate class, allowing for game variations in
 * which players can sometimes take more than one
 * turn in a row. Other variations allow more than two players. In any case,
 * the ConnectN class only monitors game play
 * to determine when the game has ended and returns the winning player.
 *
 */
public class ConnectN  extends java.lang.Object {

    /** Public game title. Could be used by toString(). **/
    public String title = "";

    /** Number of consecutive units needed to win the game. **/
    private int n;

    /** Width of game board. **/
    private int width;

    /** Height of game board. **/
    private int height;

    /** Minimum board width. **/
    public static final int MIN_WIDTH = 6;

    /** Maximum board width. **/
    public static final int MAX_WIDTH = 16;

    /** Minimum board height. **/
    public static final int MIN_HEIGHT = 6;

    /** Maximum board height. **/
    public static final int MAX_HEIGHT = 16;

    /** Minimum board N value. **/
    public static final int MIN_N = 4;


    /** number to represent. **/
    public int gameID;

    /** **/
    private static int totalGames = 0;

    /** **/
    private Player[][] game;

    /** **/
    public boolean hasBegun = false;

    /** **/
    public boolean hasEnded = false;

    /** **/
    public static final int GAME_HAS_NOT_STARTED = -1;

    /**
     * Creates a new ConnectN board with a given width, height, and N value.
     *
     * @param inputWidth    the width for the new ConnectN board.
     * @param inputHeight   the height for the new ConnectN board.
     * @param inputN        the N value for the new ConnectN board.
     */
    public ConnectN(final int inputWidth, final int inputHeight, final int inputN) {
        this.hasBegun = false;
        this.hasEnded = false;

        this.setWidth(inputWidth);
        this.setHeight(inputHeight);
        this.setN(inputN);

        this.gameID = totalGames;
        totalGames++;

        this.game = new Player[this.width][this.height];
    }

    /**
     *  Create a new ConnectN board with uninitialized width, heigh, and N value.
     */
    public ConnectN() {
        this(0, 0, 0);
    }

    /**
     * Create a new ConnectN board with given width and height and uninitialized N value.
     *
     * @param setWidth  the width for the new ConnectN board.
     * @param setHeight the height for the new ConnectN board.
     */
    public ConnectN(final int setWidth, final int setHeight) {
        this(setWidth, setHeight, 0);
    }

    /**
     *  Create a new ConnectN board with dimensions and N value copied from another board.
     *
     * @param otherBoard    the ConnectN board to copy width, height, and N from
     */
    public ConnectN(final ConnectN otherBoard) {
        this(otherBoard.getWidth(), otherBoard.getHeight(), otherBoard.getN());
    }

    /**
     * Class method to create a new ConnectN board.
     *
     * @param inputWidth    the width of the new ConnectN instance to create
     * @param inputHeight   the height of the new ConnectN instance to create
     * @param inputN        the n value of the new ConnectN instance to create
     * @return              the new ConnectN instance, or null if the parameters are invalid
     */
    public static ConnectN create(final int inputWidth, final int inputHeight, final int inputN) {
        ConnectN output = new ConnectN(0, 0, 0);

        if (output.setWidth(inputWidth) && output.setHeight(inputHeight) && output.setN(inputN)) {
            output.setWidth(inputWidth);
            output.setHeight(inputHeight);
            output.setN(inputN);
            return output;
        } else {
            return null;
        }
    }

    /**
     * Creates multiple new ConnectN instances.
     *
     * @param number    the number of new ConnectN instances to create
     * @param width     the width of the new ConnectN instance to create
     * @param height    the height of the new ConnectN instance to create
     * @param n         the n value of the new ConnectN instance to create
     * @return          the new ConnectN instance, or null if the parameters are invalid
     */
    public static ConnectN[] createMany(final int number, final int width, final int height,
                                        final int n) {
        ConnectN[] array = new ConnectN[number];
        for (int i = 0; i < number; i++) {
            ConnectN board = new ConnectN(width, height, n);
            array[i] = board;
        }
        return array;
    }

    /**
     *  Attempt to set the board width.
     *
     * @param input input to set width of board.
     * @return      width of board.
     */
    public boolean setWidth(final int input) {
        if (input >= MIN_WIDTH && input <= MAX_WIDTH && !hasBegun) {
            this.width = input;
            if (this.n >= this.getWidth() && this.n >= this.getHeight()) {
                this.n = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Get the current board width.
     *
     * @return  the current board width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     *  Attempt to set the board height.
     *
     * @param input the new height to set
     * @return      true if the height was set successfully, false on error
     */
    public boolean setHeight(final int input) {
        if (input >= MIN_HEIGHT && input <= MAX_HEIGHT && !hasBegun) {
            this.height = input;
            if (this.n >= this.getWidth() && this.n >= this.getHeight()) {
                this.n = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Get the current board height.
     *
     * @return  Get the current board height.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     *  Attempt to set the current board N value.
     *
     * @param input the new N
     * @return      true, if successful
     */
    public boolean setN(final int input) {
        if (!this.hasBegun && input >= MIN_N
            && this.getWidth() != 0 && this.getHeight() != 0
            && (input < this.getWidth() || input < this.getHeight())) {
            this.n = input;
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Get the current board N value.
     *
     * @return  the current board N value
     */
    public int getN() {
        return this.n;
    }

    /**
     * Return a copy of the board.
     *
     * @return   a copy of the current board
     */
    public Player[][] getBoard() {
        if (this.getWidth() == 0 || this.getHeight() == 0) {
            return null;
        } else {
            Player[][] output = new Player[this.getWidth()][this.getHeight()];

            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    if (this.getBoardAt(i, j) == null) {
                        output[i][j] = null;
                    } else {
                        Player player = new Player(this.getBoardAt(i, j));
                        output[i][j] = player;
                    }
                }
            }
            return output;
        }
    }

    /**
     * Get the player at a specific board position.
     *
     * @param getX  the X coordinate to get the player at
     * @param getY  the Y coordinate to get the player at
     * @return      the player whose tile is at that position,
     * or null or error or if nobody has played at that position
     */
    public Player getBoardAt(final int getX, final int getY) {
        if (hasBegun
            && getX >= 0 && getX < this.getWidth()
            && getY >= 0 && getY < this.getHeight()) {

            return this.game[getX][getY];
        } else {
            return null;
        }
    }

    /**
     *
     * @param player    the player attempting the move
     * @param setX      the X coordinate for the stack that they are trying to drop a tile in
     * @return          true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX) {
        boolean success = false;
        for (int y = this.getHeight(); y >= 0; y--) {
            if (setBoardAt(player, setX, y)) {
                setBoardAt(player, setX, y);
                success = true;
                break;
            } else {
                continue;
            }
        }
        return success;
    }

    /**
     * Set the board at a specific position.
     *
     * @param player    the player attempting the move
     * @param setX      the X coordinate that they are trying to place a tile at
     * @param setY      the Y coordinate that they are trying to place a tile at
     * @return          true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        if (hasEnded || player == null || setX < 0 || setY < 0
            || this.getWidth() == 0 || this.getHeight() == 0 || this.getN() == 0
            || this.getWidth() <= setX || this.getHeight() <= setY || this.getN() == 0) {
            return false;
        }

        if (getBoardAt(setX, setY) == null) {
            if (setY == 0 || getBoardAt(setX, setY - 1) != null) {
                this.game[setX][setY] = player;

                if (this.hasBegun != true) {
                    this.hasBegun = true;
                }
                //this.getWinner();

                return true;
            }
        }
        return false;
    }

    /**
     * Get the current board's id.
     *
     * @return  the current board's id
     */
    public int getID() {
        return this.gameID;
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     *
     * @return  the winner of the game, or null if the game has not ended
     */
    public Player getWinner() {
        if (hasBegun == false || hasEnded == true
            || this.getWidth() == 0 || this.getHeight() == 0 || this.getN() == 0) {
            return null;
        }

        Player[][] board = this.getBoard();
        Player[] count = new Player[this.getN()];

        for (int x = 0; x < this.getWidth() - this.getN(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                for (int i = 0; i < this.getN(); i++) {
                    count[i] = board[x + i][y];
                }

                boolean found = true;
                for (int i = 0; i < count.length - 1; i++) {
                    if (count[i] == null || !count[i].equals(count[i + 1])) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    this.hasEnded = true;
                    this.getBoardAt(x, y).addScore();
                    return count[0];
                }
            }
        }

        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight() - this.getN(); y++) {
                for (int i = 0; i < this.getN(); i++) {
                    count[i] = board[x][y + i];
                }

                boolean found = true;
                for (int i = 0; i < count.length - 1; i++) {
                    if (count[i] == null || !count[i].equals(count[i + 1])) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    this.hasEnded = true;
                    this.getBoardAt(x, y).addScore();
                    return count[0];
                }
            }
        }
        return null;
    }

    /**
     * Return the total number of games that have been created.
     *
     * @return  the total number of games that have been created.
     */
    public static int getTotalGames() {
        return totalGames;
    }


    /**
     * Compare two ConnectN boards.
     *
     * @param firstBoard    the first ConnectN board to compare
     * @param secondBoard   the second ConnectN board to compare
     * @return              true if the boards are the same, false otherwise
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        if (firstBoard == null && secondBoard == null) {
            return true;
        } else if (firstBoard == null || secondBoard == null) {
            return false;
        }

        if (firstBoard.getWidth() != secondBoard.getWidth()
                || firstBoard.getHeight() != secondBoard.getHeight()
                || firstBoard.getN() != secondBoard.getN()) {
            return false;
        }

        for (int x = 0; x < firstBoard.getWidth(); x++) {
            for (int y = 0; y < firstBoard.getHeight(); y++) {
                Player first = firstBoard.getBoardAt(x, y);
                Player second = secondBoard.getBoardAt(x, y);
                if ((first == null && second == null) || first.equals(second)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Compare any number of ConnectN boards.
     *
     * @param boards    the array of ConnectN boards to compare
     * @return          true if all passed boards are the same, false otherwise
     */
    public static boolean compareBoards(final ConnectN... boards) {
        for (int i = 0; i < boards.length - 1; i++) {
            if (!compareBoards(boards[i], boards[i + 1])) {
                return false;
            }
        }
        return true;
    }

    @Override
    /**
     * Define equality for the ConnectN class.
     * This method should only use the id field of the instance.
     * Note that IntelliJ can auto-generate this and hashCode().
     *
     * @param obj
     */
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConnectN connectN = (ConnectN) obj;
        return gameID == connectN.gameID;
    }

    @Override
    /**
     * Define the hash code for the ConnectN class.
     * This method should only use the id field of the instance.
     * Note that IntelliJ can auto-generate this and equals.
     */
    public int hashCode() {
        return Objects.hash(gameID);
    }

    /**
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {
        ConnectN otherTest = new ConnectN(0, 0, 0);
        ConnectN test = new ConnectN(0, 0, 0);

        System.out.println(test.getWidth());
        System.out.println(test.getHeight());
        System.out.println(test.getN());
        System.out.println(otherTest.getWidth());
        System.out.println(otherTest.getHeight());
        System.out.println(otherTest.getN());

        System.out.println(compareBoards(test, otherTest));
    }
}
