package org.psjava.ds.graph;

public class FlowStatus<T> {
    public final T capacity;
    public T flow;

    public FlowStatus(T capacity, T flow) {
        this.capacity = capacity;
        this.flow = flow;
    }

    @Override
    public String toString() {
        return flow + "/" + capacity;
    }
}
