package org.psjava.ds.tree.binary;

import java.util.Iterator;

import org.psjava.ds.tree.binary.bst.MinimumFinder;
import org.psjava.ds.tree.binary.bst.SuccessorFinder;
import org.psjava.util.Assertion;
import org.psjava.util.ReadOnlyIterator;

public class InOrderIterator {

    public static <D2, D1 extends D2> Iterator<D2> create(final BinaryTreeNodeWithParent<D1> rootOrNull) {
        return new ReadOnlyIterator<D2>() {

            BinaryTreeNodeWithParent<D1> nextOrNull = (rootOrNull == null) ? null : MinimumFinder.find(rootOrNull);

            @Override
            public boolean hasNext() {
                return nextOrNull != null;
            }

            @Override
            public D2 next() {
                Assertion.ensure(nextOrNull != null);
                BinaryTreeNodeWithParent<D1> r = nextOrNull;
                nextOrNull = SuccessorFinder.findOrNull(r);
                return r.getData();
            }
        };
    }

    private InOrderIterator() {
    }

}
