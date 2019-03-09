package DoubleLinkedList;

import Node.*;

public class DoubleLinkedList<T> {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */
    /**
     * Reference to the Double Linked List itself as well as the HEAD Node/First Node.
     */
    protected Node<T> HEAD;

    /**
     * Reference to the Double Linked List itself as well as the TAIL Node/Last Node.
     */
    protected Node<T> TAIL;

    /**
     * Pointer Node.
     */
    protected Node<T> PREVIOUS;

    /**
     * Pointer Node
     */
    protected Node<T> CURRENT;

    /**
     * Size helps Determine how many Nodes are in your Double Linked List.
     */
    private int SIZE = 0;

    /* ---------- ---------- ---------- CONSTRUCTOR ---------- ---------- ---------- */
    public DoubleLinkedList() {
    }

    public DoubleLinkedList(Node<T> HEAD) {
        this.HEAD = HEAD;
        this.TAIL = HEAD;
    }

    /* ---------- ---------- ---------- DOUBLE LINKED LIST METHODS ---------- ---------- ---------- */

    /**
     * Determine Whether or not the Double Linked List Contains any Nodes.
     *
     * @return True if there are Nodes in the Double Linked List otherwise False.
     */
    public boolean isEmpty() {
        return this.HEAD == null && this.TAIL == null;
    }


    /**
     * Return Number of Nodes in the Double Linked List.
     *
     * @return the Total Number of Nodes in the Double Linked List.
     */
    public int Size() {
        return isEmpty() ? 0 : this.SIZE;
    }


    /**
     * Display the Data of the Nodes in the Double Linked List.
     *
     * @param reverse Set to True to Display the List in Reverse Order.
     */
    public void Display(boolean reverse) {
        if (isEmpty()) throw new RuntimeException("Empty Linked List or Index out of bounds.");

        else if (Size() == 1)
            System.out.println(this.HEAD.toString());

        else {
            StringBuilder list = new StringBuilder();
            this.CURRENT = !reverse ? this.HEAD : this.TAIL;

            while (this.CURRENT != null) {
                list.append(this.CURRENT).append(" -> ");
                this.CURRENT = !reverse ? this.CURRENT.getNext() : this.CURRENT.getPrevious();
            }

            System.out.println(list.length() > 0 ? list.substring(0, list.length() - 4) : "Empty Linked List");
        }
    }

    /* ---------- ---------- ---------- HELPERS ---------- ---------- ----------  */

    /**
     * Reset the PREVIOUS and CURRENT Nodes to the HEAD node.
     */
    protected void RESET() {
        this.PREVIOUS = this.HEAD;
        this.CURRENT = this.HEAD;
    }


    /**
     * Increment the PREVIOUS and CURRENT Nodes.
     */
    protected void INCREMENT() {
        this.PREVIOUS = this.CURRENT;
        this.CURRENT = this.CURRENT.getNext();
    }


    /**
     * Deletes/Removes the Current Node Reference from the Double Linked List and Return it.
     *
     * @return the Deleted/Removed Node.
     */
    protected Node<T> DELETED() {
        this.PREVIOUS.setNext(this.CURRENT.getNext());
        this.CURRENT.getNext().setPrevious(this.PREVIOUS);
        this.SIZE--;
        return this.CURRENT;
    }
}
