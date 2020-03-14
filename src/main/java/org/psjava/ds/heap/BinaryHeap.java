package org.psjava.ds.heap;

import java.util.Comparator;

import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.DynamicArray;
import org.psjava.util.Assertion;

//  TODO contains bug.
//  TODO left should be  (i << 1) + 1, right should be (i << 1) + 2, parent should be (i-1) >> 1
@Deprecated
public class BinaryHeap<T> implements Heap<T> {

    private final DynamicArray<Node> array = DynamicArray.create();
    private final Comparator<T> comparator;

    public BinaryHeap(Iterable<T> initialItems, Comparator<T> comparator) {
        this.comparator = comparator;
        for (T v : initialItems)
            array.addToLast(new Node(array.size(), v));
        for (int i = array.size() / 2 - 1; i >= 0; i--)
            heapify(i);
    }

    @Override
    public HeapNode<T> insert(T v) {
        Node node = new Node(array.size(), v);
        array.addToLast(node);
        decreaseKey(node.pos);
        return node;
    }

    @Override
    public T getMinimum() {
        Assertion.ensure(!isEmpty(), "empty");
        return array.get(0).key;
    }

    @Override
    public T extractMinimum() {
        Assertion.ensure(!isEmpty(), "heap is empty");
        swapNode(0, array.size() - 1);
        Node r = array.removeLast();
        heapify(0);
        r.pos = -1;
        return r.key;
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    private void swapNode(int i, int j) {
        ArraySwapper.swap(array, i, j);
        array.get(i).pos = i;
        array.get(j).pos = j;
    }

    private void heapify(int i) {
        int left, right, smallest;
        while (true) {
            left = i << 1;
            right = (i << 1) + 1;
            smallest = i;
            if (left < array.size() && compare(array.get(left), array.get(smallest)) < 0)
                smallest = left;
            if (right < array.size() && compare(array.get(right), array.get(smallest)) < 0)
                smallest = right;
            if (smallest == i)
                break;
            swapNode(smallest, i);
            i = smallest;
        }
    }

    private void decreaseKey(int pos) {
        while (pos > 0 && compare(array.get(pos), array.get(pos >> 1)) < 0) {
            swapNode(pos >> 1, pos);
            pos >>= 1;
        }
    }

    private void delete(int pos) {
        forceToRoot(pos);
        extractMinimum();
    }

    private void forceToRoot(int pos) {
        while (pos > 0) {
            swapNode(pos >> 1, pos);
            pos >>= 1;
        }
    }

    private int compare(Node v1, Node v2) {
        return comparator.compare(v1.getKey(), v2.getKey());
    }

    private class Node implements HeapNode<T> {
        int pos; // -1 if not in heap
        T key;

        Node(int pos, T key) {
            this.pos = pos;
            this.key = key;
        }

        @Override
        public T getKey() {
            assertNotDeleted();
            return key;
        }

        @Override
        public boolean isInHeap() {
            return pos != -1;
        }

        @Override
        public void decreaseKey(T key) {
            assertNotDeleted();
            this.key = key;
            BinaryHeap.this.decreaseKey(pos);
        }

        @Override
        public void delete() {
            assertNotDeleted();
            BinaryHeap.this.delete(pos);
        }

        private void assertNotDeleted() {
            Assertion.ensure(pos != -1, "Node is not in heap (deleted)");
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }

    @Override
    public String toString() {
        return array.toString();
    }

}
