//import javafx.scene.Parent;

/**
 * A class that implements a basic binary tree storing integers.
 * You need to complete this class by adding methods to insert values,
 * compute the minimum and maximum, search for a value,
 * and compute a value's depth in the tree and number of descendants.
 * You will also need to complete several constructors used during tree creation
 * and value insertion.
 *
 * Our binary tree is an example of a recursive data structure,
 * since each tree instance refers to several other tree instances to complete the entire structure.
 * As you might expect, recursive algorithms are particularly useful on recursive data structures.
 */
public class Tree {

    /** **/
    private int value = -1;

    /** **/
    private Tree left;

    /** **/
    private Tree right;

    /** **/
    private Tree parent;

    /**
     * Initialize a new binary tree.
     *
     * @param setValue  value for the root of the tree.
     */
    public Tree(final int setValue) {
        this.value = setValue;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    /**
     * Initialize a new binary tree node for an existing tree.
     *
     * @param setValue  value for the root of the tree.
     * @param setParent the parent of this node.
     */
    public Tree(final int setValue, final Tree setParent) {
        this.value = setValue;
        this.left = null;
        this.right = null;
        this.parent = setParent;
        if (setValue < setParent.value) {
            setParent.left = this;
        } else {
            setParent.right = this;
        }
    }

    /**
     * Insert a new value into the binary tree.
     * Insertion should follow the algorithm described in the MP5 writeup.
     * Do not re-balance the tree or otherwise modify it between insertions.
     * Otherwise the depth and descendants tests will fail.
     * Insertion should fail and return false if the value already exists in the tree.
     *
     *
     * @param newValue  the new value to insert.
     * @return          true if the value does not already exist
     *                  and is successfully inserted, false otherwise.
     */
    public boolean insert(final int newValue) {
        if (this.value == newValue) {
            return false;
        } else if (this.value < newValue) {
            if (this.right != null) {
                return this.right.insert(newValue);
            } else {
                this.right = new Tree(newValue, this);
                return true;
            }
        } else if (this.value > newValue) {
            if (this.left != null) {
                return this.left.insert(newValue);
            } else {
                this.left = new Tree(newValue, this);
                return true;
            }
        }

        return false;
    }

    /**
     * Return the minimum value stored in this binary tree.
     * This function can assume it is called on the root node.
     *
     * @return  the minimum value stored in the tree.
     */
    public int minimum() {
        if (this.left != null) {
            return this.left.minimum();
        } else {
            return this.value;
        }
    }

    /**
     * Return the maximum value stored in this binary tree.
     * This function can assume it is called on the root node.
     *
     * @return  the maximum value stored in the tree.
     */
    public int maximum() {
        if (this.right != null) {
            return this.right.maximum();
        } else {
            return this.value;
        }
    }

    /**
     * Search the binary tree for a specific value.
     *
     * @param searchValue   the value to search for.
     * @return              the node containing the specified value,
     *                      or null if the value is not present in the tree.
     */
    public Tree search(final int searchValue) {
        if (this.value == searchValue) {
            return this;
        } else if (this.value < searchValue) {
            if (this.right != null) {
                return this.right.search(searchValue);
            } else {
                return null;
            }
        } else if (this.value > searchValue) {
            if (this.left != null) {
                return this.left.search(searchValue);
            } else {
                return null;
            }
        }

        return null;

        /**
        if (this.left == null && this.right == null
            && this.value != searchValue) {
            return null;
        } else if (this.value == searchValue) {
            return this;
        } else {

            if (this.left != null && this.right != null) {
                this.left.search(searchValue);
                this.right.search(searchValue);
            } else if (this.left == null && this.right != null) {
                this.right.search(searchValue);
            } else if (this.left != null && this.right == null) {
                this.left.search(searchValue);
            }
        }
        return null;
         **/
    }

    /**
     * Return the depth of this node from the root of the tree.
     *
     * @return  the depth of this node relative to the root
     */
    public int depth() {


        int count = 0;
        Tree current = this;

        while (current.parent != null) {
            count++;
            current = current.parent;
        }

        return count;
    }

    /**
     * Return the number of nodes below this node in the tree.
     *
     * @return  the number of nodes below this node in the tree
     */
    public int descendants() {
        int count = 0;

        if (this.left != null) {
            count++;
            count += this.left.descendants();
        }

        if (this.right != null) {
            count++;
            count += this.right.descendants();
        }

        return count;
    }


    /**
     * Finds the root of a given tree.
     *
     * @return the root of this tree.
     */
    private Tree findRoot() {
        Tree output = this;
        while (this.parent != null) {
            output = this.parent;
        }
        return output;
    }
}
