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

package Node;

public class Node<T> {
    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */

    private T data;
    private Node next;

    /* ---------- ---------- ---------- CONSTRUCTOR ---------- ---------- ---------- */
    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ---------- */

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    /* ---------- ---------- ---------- TO STRING ---------- ---------- ---------- */
    public String toString() {
        return String.valueOf(this.data.toString());
    }
}
