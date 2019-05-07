/*
  Created By : Uee
  Modified By :

  <p>
  This Source Code is released under the terms of the
  GNU license. See https://www.gnu.org/licenses/#GPL
  for more information.
  <p>
  Usage:   Do what you want, modify like you want.
  <p>
 */

package LinkedList;

import Node.*;

import java.util.ArrayList;

public class LinkedList<T> {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */
    /**
     * Reference to the Linked List itself as well as the HEAD Node/First Node.
     */
    protected Node<T> HEAD;

    /**
     * Reference to the Linked List itself as well as the TAIL Node/Last Node.
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
     * Size helps Determine how many Nodes are in your Linked List.
     */
    private int SIZE = 0;

    /* ---------- ---------- ---------- CONSTRUCTOR ---------- ---------- ---------- */
    public LinkedList() {
    }

    public LinkedList(Node<T> HEAD) {
        this.HEAD = HEAD;
        this.TAIL = HEAD;
    }

    /* ---------- ---------- ---------- LINKED LIST METHODS ---------- ---------- ---------- */

    /**
     * Determine Whether or not the Linked List Contains any Nodes.
     *
     * @return True if there are Nodes in the Linked List otherwise False.
     */
    public boolean isEmpty() {
        return this.HEAD == null && this.TAIL == null;
    }


    /**
     * Tells you how many Nodes are in the Linked List.
     *
     * @return the Total Number of Nodes in the Linked List.
     */
    public int Size() {
        return isEmpty() ? 0 : this.SIZE;
    }


    /**
     * Return the First Node of the LinkedList.
     *
     * @return
     */
    public Node<T> GetFirstNode() {
        return this.HEAD;
    }


    /**
     * Return the Last Node of the LinkedList.
     *
     * @return
     */
    public Node<T> GetLastNode() {
        return this.TAIL;
    }

    /**
     * Clear the LinkedList of all Existing Nodes.
     */
    public void Clear() {
        this.HEAD = null;
        this.TAIL = null;
    }


    /**
     * Add a new Node to the Head/Start of the Linked List.
     *
     * @param data The data of the New Node.
     */
    public void AddHeadNode(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            this.HEAD = this.TAIL = node;
        } else {
            node.setNext(this.HEAD);
            this.HEAD = node;
        }
        this.SIZE++;
    }


    /**
     * Delete/Remove the Head/First Node from the Linked List Completely.
     *
     * @return the Deleted/Removed Head Node.
     */
    public Node<T> DeleteHeadNode() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        this.CURRENT = this.HEAD;
        if (Size() == 1)
            this.HEAD = this.TAIL = null;
        else {
            this.HEAD = this.CURRENT.getNext();
        }
        this.SIZE--;
        return this.CURRENT;
    }


    /**
     * Add a new Tail/Last Node to the Linked List.
     *
     * @param data The data of the New Node.
     */
    public void AddTailNode(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            this.TAIL = this.HEAD = node;
        } else {
            this.TAIL.setNext(node);
            this.TAIL = node;
        }
        this.SIZE++;
    }


    /**
     * Delete/Remove the Tail/Last node from the Linked List Completely.
     *
     * @return the Deleted/Removed Tail/Last node.
     */
    public Node<T> DeleteTailNode() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");

        this.CURRENT = this.TAIL;
        if (Size() == 1)
            this.HEAD = this.TAIL = null;
        else {
            RESET();
            while (this.CURRENT != this.TAIL) {
                INCREMENT();
            }
            this.PREVIOUS.setNext(null);
            this.TAIL = this.PREVIOUS;
        }
        this.SIZE--;
        return this.CURRENT;
    }


    /**
     * Add a New Node with the T data to the Linked List at the given Index.
     *
     * @param index The Index position Where the New Node Will be Attached to the Linked List.
     * @param data  The data of the New Node.
     */
    public void AddNodeAt(int index, T data) {
        if (isEmpty() || index < 0 || index == Size())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        if (index == 0)
            AddHeadNode(data);
        else if (index == Size() - 1)
            AddTailNode(data);

        else {
            RESET();
            int count = 0;
            Node<T> node = new Node<>(data);

            while (this.CURRENT != null) {
                if (count == index) {
                    node.setNext(this.CURRENT);
                    this.PREVIOUS.setNext(node);
                }
                count++;
                INCREMENT();
            }
        }
    }


    /**
     * Add a New Node Before the Index.
     *
     * @param index The Index position of the Node to Insert Before.
     * @param data  The data of the New Node.
     */
    public void AddNodeBefore(int index, T data) {
        if (isEmpty() || index < 0 || index == Size())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        if (index == 0)
            AddHeadNode(data);
        else
            AddNodeAt(index - 1, data);
    }

    /**
     * Add a New Node After the Index.
     *
     * @param index The Index position of the Node to Insert After.
     * @param data  The data of the New Node.
     */
    public void AddNodeAfter(int index, T data) {
        if (isEmpty() || index < 0 || index == Size())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        if (index == Size() - 1)
            AddTailNode(data);
        else
            AddNodeAt(index + 1, data);
    }


    /**
     * Delete/Remove the Node at the given Index, if it Exists.
     * <p>
     * The Indexes of the Linked List follow the Same Pattern as an Array and List.
     * The First node is at Index 0.
     * The Second node is at Index 1 etc
     *
     * @param index The Index position of the Node to Delete/Remove.
     * @return the Delete/Removed Node.
     */
    public Node<T> DeleteNodeAt(int index) {
        if (isEmpty() || index < 0 || index == Size())
            throw new RuntimeException("Empty Linked List or Index out of Bounds.");

        if (index == 0)
            return DeleteHeadNode();

        else if (index == Size() - 1)
            return DeleteTailNode();

        int count = 0;
        RESET();
        while (this.CURRENT != null) {
            if (count == index) {
                return DELETED();
            }
            count++;
            INCREMENT();
        }
        return null;
    }


    /**
     * Count how many Nodes Contains the Same Object Data.
     *
     * @param data The data to find.
     * @return the Total Number of Nodes that contain Similar Data.
     */
    public int CountDuplicateNodes(Object data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");

        if (Size() == 1 && this.HEAD.getData() == data)
            return 1;

        int count = 0;
        RESET();
        while (this.CURRENT != null) {
            if (this.CURRENT.getData() == data)
                count++;
            INCREMENT();
        }
        return count;
    }


    /**
     * Find the Index of the First Node that Contains the Specified Data.
     *
     * @param data The data to Find.
     * @return the Index of the Node.
     */
    public int IndexOf(Object data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");

        if (this.HEAD.getData().equals(data))
            return 0;
        else if (this.TAIL.getData().equals(data))
            return Size() - 1;
        else {
            RESET();
            for (int index = 0; this.CURRENT != null; this.CURRENT = this.CURRENT.getNext(), index++) {
                if (this.CURRENT.getData().equals(data))
                    return index;
            }
        }
        return -1;
    }


    /**
     * Delete/Remove the First Occurrence of the Node that Contains the data.
     *
     * @param data The Data of the Node to Match.
     * @return the Deleted/Removed Node.
     */
    public Node<T> DeleteFirstOccurrence(Object data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");

        if (this.HEAD.getData().equals(data))
            return DeleteHeadNode();

        RESET();
        while (this.CURRENT != null) {
            if (this.CURRENT.getData().equals(data))
                return DELETED();
            INCREMENT();
        }
        return null;
    }


    /**
     * Delete/Remove the Last Occurrence of the Node that Contains the  data.
     *
     * @param data The data of the Node to Match.
     * @return the Deleted/Removed Node.
     */
    public Node<T> DeleteLastOccurrence(Object data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");

        if (Size() == 1 && this.HEAD.getData() == data)
            return DeleteHeadNode();

        int count = CountDuplicateNodes(data);
        if (count > 0) {
            RESET();
            while (this.CURRENT != null) {
                if (this.CURRENT.getData() == data) {
                    count--;
                }
                if (count == 0) {
                    return DELETED();
                }
                INCREMENT();
            }
        }
        return null;
    }


    /**
     * Deletes all the Nodes that Contains the Given data.
     *
     * @param data The data to find in each Node.
     */
    public void DeleteAllOccurrences(Object data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");

        RESET();
        while (this.CURRENT != null) {
            if (this.CURRENT == this.HEAD && this.CURRENT.getData().equals(data)) {
                DeleteHeadNode();
                RESET();
            } else if (this.CURRENT.getData().equals(data)) {
                this.PREVIOUS.setNext(this.CURRENT.getNext());
                this.CURRENT = this.PREVIOUS.getNext();
                this.SIZE--;
            } else {
                INCREMENT();
            }
        }
    }


    /**
     * Replace a Specific Node at a given Index with a Newly Created Node.
     * <p>
     * The Indexes of the Linked List follow the Same Pattern as an Array and List.
     * The First node is at Index 0.
     * The Second node is at Index 1 etc
     *
     * @param index The Index Position of the node to Replace.
     * @param data  The data of the Newly Created Node.
     */
    public void ReplaceNodeAt(int index, T data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        if (index == 0) {
            DeleteHeadNode();
            AddHeadNode(data);
        } else if (index == this.

                Size() - 1) {
            DeleteTailNode();
            AddTailNode(data);
        } else {
            int count = 0;
            RESET();
            while (this.CURRENT != null) {
                if (count == index) {
                    DELETED();
                    Node<T> node = new Node<>(data);
                    node.setNext(this.PREVIOUS.getNext());
                    this.PREVIOUS.setNext(node);
                    this.SIZE++;
                }
                count++;
                INCREMENT();
            }
        }

    }


    /**
     * Overwrite the Data of a Node at the Specified Index.
     * <p>
     * The Indexes of the Linked List follow the Same Pattern as an Array and List.
     * The First node is at Index 0.
     * The Second node is at Index 1 etc
     *
     * @param index The Index position of the Node whose Data will be Overwritten.
     * @param data  The Data that will Replace old Data of the Node found at the index.
     */
    public void OverwriteNodeData(int index, T data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        if (index == 0) {
            this.HEAD.setData(data);
        } else if (index == Size() - 1) {
            this.TAIL.setData(data);
        } else {
            int count = 0;
            RESET();
            while (this.CURRENT != null) {
                if (count == index) {
                    this.CURRENT.setData(data);
                }
                count++;
                INCREMENT();
            }
        }
    }


    /**
     * Return an Array Containing all the Elements of the LinkedList.
     *
     * @return
     */
    public T[] ToArray() {
        if (isEmpty())
            return null;

        T[] array = (T[]) new Object[Size()];
        if (Size() == 1) {
            array[0] = this.HEAD.getData();
            return array;
        }

        this.CURRENT = this.HEAD;
        int index = 0;
        while (this.CURRENT != null) {
            array[index] = this.CURRENT.getData();
            this.CURRENT = this.CURRENT.getNext();
            index++;
        }

        return array;
    }

    /**
     * Return a List Containing all the Elements of the LinkedList.
     *
     * @return
     */
    public ArrayList<T> ToList() {
        if (isEmpty())
            return null;

        ArrayList<T> list = new ArrayList<>();
        if (Size() == 1) {
            list.add(this.HEAD.getData());
            return list;
        }

        this.CURRENT = this.HEAD;
        while (this.CURRENT != null) {
            list.add(this.CURRENT.getData());
            this.CURRENT = this.CURRENT.getNext();
        }

        return list;
    }


    /**
     * Display the Data of the Nodes in the Linked List.
     */
    public void Display() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        else if (Size() == 1)
            System.out.println(this.HEAD.toString());

        else {
            StringBuilder list = new StringBuilder();
            this.CURRENT = this.HEAD;

            while (this.CURRENT != null) {
                list.append(this.CURRENT).append(" -> ");
                this.CURRENT = this.CURRENT.getNext();
            }

            System.out.println(list.length() > 0 ? list.substring(0, list.length() - 4) : "Empty Linked " +
                    "List");
        }
    }


    /**
     * Display the Data of the Nodes in the Linked List in Reverse Order, from the Last Node to the First
     * Node.
     */
    public void DisplayReverseOrder() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List or Index out of bounds.");

        else if (Size() == 1)
            System.out.println(this.HEAD.toString());

        else {
            StringBuilder list = new StringBuilder();
            for (int i = Size() - 1; i >= 0; i--) {
                this.CURRENT = this.HEAD;
                for (int j = 0; j < i && this.CURRENT.getNext() != null; j++) {
                    this.CURRENT = this.CURRENT.getNext();
                }
                list.append(this.CURRENT).append(" -> ");
            }
            System.out.println(list.length() > 0 ? list.substring(0, list.length() - 4) : "Empty Linked " +
                    "List");
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
     * Deletes/Removes the Current Node Reference from the Linked List and Return it.
     *
     * @return the Deleted/Removed Node.
     */
    protected Node<T> DELETED() {
        this.PREVIOUS.setNext(this.CURRENT.getNext());
        this.CURRENT.setNext(null);
        this.SIZE--;
        return this.CURRENT;
    }
}
