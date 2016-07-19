package org.psjava.algo.graph.bfs;

import org.psjava.util.VisitorStopper;

public class SimpleStopper implements VisitorStopper {
    private boolean stopped;

    @Override
    public void stop() {
        stopped = true;
    }

    public boolean isStopped() {
        return stopped;
    }
}