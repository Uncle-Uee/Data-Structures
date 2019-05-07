package PriorityQueue;

import Queue.Queue;

public class PriorityQueue<T> {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ----------  */

    /**
     * Priority of the Element.
     */
    private int _priority = -1;

    /**
     * Stack of Items with the Same Priority.
     */
    private Queue<T> _queue;

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */

    public PriorityQueue() {
        this._queue = new Queue<T>();
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ----------  */

    public int getPriority() {
        return _priority;
    }

    public void setPriority(int priority) {
        this._priority = priority;
    }

    public Queue<T> getQueue() {
        return _queue;
    }

    public void setQueue(Queue<T> stack) {
        this._queue = stack;
    }
}
