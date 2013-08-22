package org.psjava.ds.graph;


import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.EmptyIterable;
import org.psjava.javautil.MergedIterable;

public class MutableDirectedGraph<E extends DirectedEdge> implements DirectedGraph<E> {
	
	private static final MutableMapFactory MF = GoodMutableMapFactory.getInstance();

	private MutableSet<Object> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<E> edges = DynamicArray.create();
	private MutableMap<Object, MutableMap<Object, DynamicArray<E>>> data = MF.create();
	
	public void insertVertex(Object v) {
		vertices.insert(v);
		if (!data.containsKey(v))
			data.put(v, MF.<Object, DynamicArray<E>>create());
	}

	public void addEdge(E e) {
		MutableMap<Object, DynamicArray<E>> submap = data.get(e.from());
		DynamicArray<E> edges = submap.get(e.to(), null);
		if (edges == null) {
			edges = DynamicArray.create();
			submap.put(e.to(), edges);
		}
		edges.addToLast(e);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public Collection<Object> getVertices() {
		return vertices;
	}

	@Override
	public boolean hasEdge(Object from, Object to) {
		return data.get(from).containsKey(to);
	}
	
	@Override
	public Iterable<E> getOutEdges(Object from) {
		return MergedIterable.wrap(data.get(from).values());		
	}
	
	@Override
	public Iterable<E> getOutEdges(Object from, Object to) {
		DynamicArray<E> r = data.get(from).get(to, null);
		if (r == null)
			return EmptyIterable.create();
		return r;
	}

	@Override
	public Iterable<E> getEdges() {
		return edges;
	}
	
	@Override
	public String toString() {
		String r = "";
		for(E e : getEdges()) {
			if(r.length() != 0)
				r += ", ";
			r += e.toString();
		}
		return "Graph: " + r;
	}
}
