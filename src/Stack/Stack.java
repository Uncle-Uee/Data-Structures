package Stack;

import LinkedList.LinkedList;
import Node.Node;

import java.util.ArrayList;

public class Stack<T> extends LinkedList<T> {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */

    /* ---------- ---------- ---------- CONSTRUCTOR ---------- ---------- ---------- */

    /**
     * Create a new Stack with a Default Capacity of 11 Nodes.
     */
    public Stack() {
    }

    /* ---------- ---------- ---------- QUEUE METHODS ---------- ---------- ---------- */

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int Size() {
        return super.Size();
    }

    public void Push(T data) {
        AddHeadNode(data);
    }

    public Node<T> Pop() {
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
        Stack<Integer> Stack = new Stack<Integer>();

        Stack.Push(0);
        Stack.Push(1);
        Stack.Push(2);
        Stack.Push(3);
        Stack.Push(4);

        System.out.println(Stack.Size());

        Stack.Display();
        System.out.println(Stack.Pop().toString());

        Stack.Display();
    }

}
