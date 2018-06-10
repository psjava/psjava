package org.psjava.ds.deque;

import java.util.Iterator;

import org.psjava.ds.PSCollection;
import org.psjava.util.IterableToString;
import org.psjava.util.ReadOnlyIterator;

public class DoubleLinkedList<T> implements PSDeque<T>, PSCollection<T> {

    public static <T> DoubleLinkedList<T> create() {
        return new DoubleLinkedList<T>();
    }

    private class Node {
        public T v;
        public Node n;
        public Node p;

        public Node(T v, Node p, Node n) {
            this.v = v;
            this.p = p;
            this.n = n;
        }
    }

    private final Node head;
    private final Node tail;

    public DoubleLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);
        head.n = tail;
        tail.p = head;
    }

    @Override
    public void addToLast(T e) {
        add(tail, e);
    }

    @Override
    public void clear() {
        head.n = tail;
        tail.p = head;
    }

    @Override
    public boolean isEmpty() {
        return head.n == tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReadOnlyIterator<T>() {
            Node next = head.n;

            @Override
            public boolean hasNext() {
                return next != tail;
            }

            @Override
            public T next() {
                T r = next.v;
                next = next.n;
                return r;
            }
        };
    }

    @Override
    public int size() {
        int r = 0;
        Node node = head;
        while (node.n != tail) {
            r++;
            node = node.n;
        }
        return r;
    }

    @Override
    public void addToFirst(T v) {
        add(head.n, v);
    }

    @Override
    public T getFirst() {
        return head.n.v;
    }

    @Override
    public T getLast() {
        return tail.p.v;
    }

    @Override
    public T removeFirst() {
        return remove(head.n);
    }

    @Override
    public T removeLast() {
        return remove(tail.p);
    }

    private T remove(Node node) {
        node.p.n = node.n;
        node.n.p = node.p;
        return node.v;
    }

    private void add(Node node, T v) {
        Node newNode = new Node(v, node.p, node);
        newNode.p.n = newNode;
        newNode.n.p = newNode;
    }

    @Override
    public String toString() {
        return IterableToString.toString(this);
    }

}
