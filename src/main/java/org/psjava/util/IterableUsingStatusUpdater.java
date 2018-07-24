package org.psjava.util;

import java.util.Iterator;

public class IterableUsingStatusUpdater {

    public static <T> Iterable<T> create(final T initialStatus, final Updater<T> updater) {
        return IterableUsingIteratorFactory.create(new IteratorFactory<T>() {
            @Override
            public Iterator<T> create() {
                return new ReadOnlyIterator<T>() {
                    T nextStatusOrNull = initialStatus;

                    @Override
                    public boolean hasNext() {
                        return nextStatusOrNull != null;
                    }

                    @Override
                    public T next() {
                        T current = nextStatusOrNull;
                        Assertion.ensureNotNull(current);
                        nextStatusOrNull = updater.getUpdatedOrNull(current);
                        return current;
                    }
                };
            }
        });
    }

}
