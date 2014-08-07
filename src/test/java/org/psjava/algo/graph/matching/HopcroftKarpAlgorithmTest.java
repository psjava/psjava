package org.psjava.algo.graph.matching;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.MutableBipartiteGraph;

public class HopcroftKarpAlgorithmTest extends MaximumBipartiteMatchingAlgorithmTestBase {

	@Override
	protected MaximumBipartiteMatching getInstance() {
		return HopcroftKarpAlgorithm.getInstance();
	}

}
