/**
 * A class that implements a linked list storing integers.
 * <p>
 * You need to complete this class by adding methods to insert, remove, and swap values.
 * Note that our test suites walks this list internally, so you need to maintain the start
 * reference and the structure of the Node class for the tests to pass.
 * <p>
 * Like trees, linked lists are also <i>recursive data structure</i>, since each part of the list is
 * itself a list. However, linked lists can be manipulated easily using both recursive and
 * iterative algorithms. We leave the choice to you.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/5/">MP5 Documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Linked_list">Linked List</a>
 */
public class SingleLL {

    /**
     * Internal class storing a node in our SingleLL.
     */
    public final class Node {

        /** **/
        private int value;

        /**
         * Get this node's value.
         *
         * @return this node's value
         */
        public int getValue() {
            return value;
        }

        /**
         * Set this node's value.
         *
         * @param setValue new value for this node
         */
        void setValue(final int setValue) {
            value = setValue;
        }

        /** Reference to the next node in the list. */
        private Node next;

        /**
         * Get this node's next node.
         *
         * @return this node's next node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set this node's next node.
         *
         * @param setNext new next node for this node
         */
        void setNext(final Node setNext) {
            next = setNext;
        }

        /**
         * Full constructor for the Node class.
         *
         * @param setValue the int value this node will store
         * @param setNext the next node in the list, or null if this node is the end of the list
         */
        Node(final int setValue, final Node setNext) {
            this.setValue(setValue);
            this.setNext(setNext);
        }


        /**
         * toString method for Node objects.
         *
         * @return String format for node.
         */
        public String toString() {
            String output = "";
            output += this.value;
            return output;
        }
    }

    /** Start of this linked list. */
    private Node start;

    /**
     * Get a reference to the start of the list.
     * <p>
     * <strong>Do not remove or break this method.</strong> The testing suite uses it to do
     * its own testing.
     *
     * @return a reference to the start of the list
     */
    public Node getStart() {
        return start;
    }

    /**
     * Add a new value to the front of the list.
     * <p>
     * <strong>Do not remove or break this method.</strong> The testing suite uses it to do
     * its own testing.
     *
     * @param newValue the new int value to add to the front of the list
     */
    public void unshift(final int newValue) {
        start = new Node(newValue, start);
    }

    /**
     * Empty constructor.
     * <p>
     * <strong>Do not remove or break this method.</strong> The testing suite uses it to do
     * its own testing. You may want to add other constructors as needed.
     */
    SingleLL() { }


    /**
     * Insert a new value into the linked list.
     * Returns true if the insert succeeded,
     * and false if the position was either less than zero
     * or off the end of the list.
     *
     * @param newValue  the new value to insert
     * @param position  the position to insert the value at
     * @return          true if the insert succeeded, and false if the position was invalid
     */
    public boolean insert(final int newValue, final int position) {
        //System.out.println("insert " + newValue + " @ " + position);
        //this.printLL();

        if (position < 0) {
            return false;
        }

        if (this.getStart() == null && position != 0) {
            return false;
        } else if (this.getStart() == null && position == 0) {
            this.start = new Node(newValue, null);
            return true;
        } else if (this.getStart() != null && position == 0) {
            this.unshift(newValue);
            return true;
        }

        Node previous = this.getNode(position - 1);
        Node next = this.getNode(position);

        if (previous == null) {
            return false;
        }

        Node inserted = new Node(newValue, next);
        previous.setNext(inserted);

        //this.printLL();

        return true;
    }

    /**
     * Remove a value from the linked list.
     * Returns true if the removals succeeded,
     * and false if the position was either less than zero
     * or off the end of the list.
     *
     * @param position  the position to remove
     * @return          true if the removal succeeded, and false if the position was invalid
     */
    public boolean remove(final int position) {
        //System.out.println("remove " + position);
        //this.printLL();

        if (this.getStart() == null) {
            return false;
        } else if (this.getStart() != null && position == 0) {
            this.start = this.getStart().getNext();
            return true;
        }

        Node previous = this.getNode(position - 1);
        Node at = this.getNode(position);
        Node next = this.getNode(position + 1);

        if (at == null) {
            return false;
        }

        previous.setNext(next);

        //printLL();

        return true;
    }

    /**
     * Swap two values in the list.
     * Returns true if the swap succeeded,
     * and false if the either position was either less than zero
     * or off the end of the list.
     *
     * @param firstPosition     the first value to swap
     * @param secondPosition    the second value to swap
     * @return                  true if the swap succeeded, and false if either position was invalid
     */
    public boolean swap(final int firstPosition, final int secondPosition) {
        //System.out.println("swap " + firstPosition + " with " + secondPosition);

        //this.printLL();

        Node first = this.getNode(firstPosition);
        Node second = this.getNode(secondPosition);

        if (first == null || second == null) {
            return false;
        }

        int firstValue = first.getValue();
        int secondValue = second.getValue();

        if (!this.insert(firstValue, secondPosition) || !this.insert(secondValue, firstPosition)) {
            return false;
        } else {
            this.remove(firstPosition);
            this.remove(secondPosition);
        }

        if (firstPosition < secondPosition) {
            this.insert(secondValue, firstPosition);
            this.remove(firstPosition + 1);

            this.insert(firstValue, secondPosition);
            this.remove(secondPosition + 1);
        } else if (firstPosition > secondPosition) {
            this.insert(firstValue, secondPosition);
            this.remove(secondPosition + 1);

            this.insert(secondValue, firstPosition);
            this.remove(firstPosition + 1);
        }

        //this.printLL();

        return true;

        /**
        Node first = this.getNode(firstPosition);
        Node second = this.getNode(secondPosition);

        Node firstPrevious = this.getNode(firstPosition - 1);
        Node firstNext = this.getNode(firstPosition + 1);

        Node secondPrevious = this.getNode(secondPosition - 1);
        Node secondNext = this.getNode(secondPosition + 1);

        if (first == null || second == null) {
            return false;
        } else if (firstPosition == 0) {
            this.unshift(second.getValue());

            secondPrevious.setNext(first);
            first.setNext(secondNext);
            System.out.println(first + " goes to " + secondNext);

            this.printLL();

            return true;
        } else if (secondPosition == 0) {
            this.unshift(first.getValue());

            firstPrevious.setNext(second);
            second.setNext(firstNext);

            this.printLL();

            return true;
        }

        firstPrevious.setNext(second);
        second.setNext(firstNext);

        secondPrevious.setNext(first);
        first.setNext(secondNext);

        this.printLL();

        return true;
         **/
    }


    /**
     * Retrieves a node at a given position.
     * @param position  integer position of a node.
     * @return          node at given position.
     */
    private Node getNode(final int position) {
        if (position < 0 || this.getStart() == null) {
            return null;
        }

        Node output = this.getStart();

        for (int i = 0; i < position; i++) {
            if (output.getNext() == null) {
                return null;
            } else {
                output = output.getNext();
            }
        }

        return output;
    }

    /**
     * Prints the linked list.
     */
    private void printLL() {
        System.out.println();
        System.out.println("print LL ");

        Node check = this.getStart();
        int count = 0;

        System.out.print(count + " : ");

        if (check != null) {
            System.out.println(check.toString());
            count++;
            while (check.getNext() != null) {
                System.out.print(count + " : ");
                check = check.getNext();
                System.out.print(check.toString());
                count++;
                System.out.println();
            }
        }
        System.out.println();
    }
}
