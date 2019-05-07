package Queue;

import LinkedList.LinkedList;
import Node.Node;

import java.util.ArrayList;

public class Queue<T> extends LinkedList<T> {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */

    /**
     * Storage Capacity of the Queue
     */
    protected int Capacity = 11;


    /* ---------- ---------- ---------- CONSTRUCTOR ---------- ---------- ---------- */

    /**
     * Create a new Queue with a Default Capacity of 11 Nodes.
     */
    public Queue() {
    }


    /**
     * Create a new Queue with a Custom Capacity.
     *
     * @param Capacity
     */
    public Queue(int Capacity) {
        this.Capacity = Capacity;
    }

    /* ---------- ---------- ---------- QUEUE METHODS ---------- ---------- ---------- */

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int Size() {
        return super.Size();
    }

    public void Enqueue(T data) {
        if (Size() == this.Capacity)
            return;

        AddTailNode(data);
    }

    public void Enqueue(T data, boolean increase) {
        if (increase)
            this.Capacity++;
        Enqueue(data);
    }

    public Node<T> Dequeue() {
        return DeleteHeadNode();
    }

    public Node<T> Peek() {
        return GetFirstNode();
    }

    public void Clear() {
        super.Clear();
    }

    public T[] ToArray() {
        return super.ToArray();
    }

    public ArrayList<T> ToList() {
        return super.ToList();
    }

    public static void main(String[] args) {
        Queue<Integer> Queue = new Queue<Integer>();

        Queue.Enqueue(0);
        Queue.Enqueue(1);
        Queue.Enqueue(2);
        Queue.Enqueue(3);
        Queue.Enqueue(4);

        System.out.println(Queue.Size());

        Queue.Display();

        System.out.println(Queue.Dequeue().toString());

        Queue.Display();
    }
}
