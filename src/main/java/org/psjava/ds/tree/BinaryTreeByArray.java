package org.psjava.ds.tree;

import org.psjava.ds.array.DynamicArray;
import org.psjava.util.Assertion;
import org.psjava.util.BooleanIterable;

public class BinaryTreeByArray<T> {

    /**
     * This is a rooted binary tree implementation which is specialized for speed.
     */

    private DynamicArray<T> array = DynamicArray.create();

    public int createRoot(T value) {
        array.clear();
        array.addToLast(value);
        return 0;
    }

    public boolean hasRoot() {
        return hasNode(0);
    }

    public int getRootPointer() {
        assertHasNode(0);
        return 0;
    }

    public T getValue(int pointer) {
        assertHasNode(pointer);
        return array.get(pointer);
    }

    public void setValue(int pointer, T value) {
        assertHasNode(pointer);
        array.set(pointer, value);
    }

    public boolean hasChild(int pointer, boolean edge) {
        assertHasNode(pointer);
        return hasNode(calcChildPointer(pointer, edge));
    }

    public int getLeft(int node) {
        return getChild(node, false);
    }

    public int getRight(int node) {
        return getChild(node, true);
    }

    private int getChild(int node, boolean edge) {
        assertHasNode(node);
        int c = calcChildPointer(node, edge);
        assertHasNode(c);
        return c;
    }

    public int putChild(int pointer, boolean edge, T value) {
        assertHasNode(pointer);
        int childIndex = calcChildPointer(pointer, edge);
        while (array.size() <= childIndex)
            array.addToLast(null);
        array.set(childIndex, value);
        return childIndex;
    }

    public void remove(int pointer) {
        assertHasNode(pointer);
        for (boolean v : BooleanIterable.getInstance())
            if (hasChild(pointer, v))
                remove(getChild(pointer, v));
        array.set(pointer, null);
    }

    private void assertHasNode(int pointer) {
        Assertion.ensure(hasNode(pointer));
    }

    private boolean hasNode(int pointer) {
        return pointer < array.size() && array.get(pointer) != null;
    }

    private static int calcChildPointer(int index, boolean edge) {
        return index * 2 + (edge ? 2 : 1);
    }

    @Override
    public String toString() {
        if (this.hasRoot())
            return BinaryTreeByArray.toString(this, this.getRootPointer());
        else
            return "empty";
    }

    private static <T> String toString(BinaryTreeByArray<T> tree, int pointer) {
        String r = "";
        for (boolean b : BooleanIterable.getInstance()) {
            if (tree.hasChild(pointer, b)) {
                if (r.length() == 0)
                    r += "(";
                else
                    r += ",";
                r += (b ? 1 : 0) + ":" + toString(tree, tree.getChild(pointer, b));
            }
        }
        if (r.length() > 0)
            r += ")";
        return tree.getValue(pointer) + r;
    }

}
