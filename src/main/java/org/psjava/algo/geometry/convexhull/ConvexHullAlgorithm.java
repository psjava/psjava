package org.psjava.algo.geometry.convexhull;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

import java.util.Set;


public interface ConvexHullAlgorithm {
    <T> Polygon2D<T> calc(Set<Point2D<T>> points, MultipliableNumberSystem<T> ns);
}