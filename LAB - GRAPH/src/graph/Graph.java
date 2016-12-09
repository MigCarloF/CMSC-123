package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Miguel Carlo Fernandez
 * Janlle Elaiza Unabia
 * CMSC 123 B
 * FINAL OUTPUT FOR SURE
 */

// implement a graph using either an adjacency matrix or adjacency list, and add corresponding tests
public class Graph<E> {
	private ArrayList<MyNode<String>> heads;
	private int headsSize;

	public Graph() {
		heads = new ArrayList<MyNode<String>>();
		headsSize = 0;
	}

	public void addNode(String src) throws Exception {
		for (int i = 0; i < headsSize; i++) {
			if (heads.get(i).getData() == src) {
				throw new Exception("Data already exists");
			}
		}
		heads.add(new MyNode<String>(src));
		headsSize++;
	}

	public void addEdge(String src, String dst) throws Exception {
		if (contains(src) && contains(dst)) {
			getNodeWithData(src).add(getNodeWithData(dst));
			getNodeWithData(dst).add(getNodeWithData(src));
		} else {
			throw new Exception("src or dst don't exist");
		}
	}

	public void removeEdge(String src, String dst) throws Exception {
		if (contains(src)) {
			getNodeWithData(src).remove(getNodeWithData(dst));
		} else {
			throw new Exception("Edge does not exist");
		}
	}

	public boolean hasEdge(String src, String dst) {
		return checkEdge(src, dst);
	}

	public List<String> outEdges(String src) {
		List<String> edges = new LinkedList<String>();
		for (MyNode<String> node : getNodeWithData(src).getAdjacents()) {
			edges.add(node.getData());
		}
		return edges;
	}

	public List<String> inEdges(String src) {
		List<String> inwards = new LinkedList<String>();
		for (int i = 0; i < headsSize; i++) {
			if (heads.get(i).getData() != src) {
				if (heads.get(i).contains(getNodeWithData(src))) {
					inwards.add(heads.get(i).getData());
				}
			}
		}
		return inwards;
	}

	public List<String> bfs(String src, String dst) throws Exception {
		resetVisited();
		List<String> bfsList = new ArrayList<String>();
		Queue<MyNode<String>> queue = new LinkedList<MyNode<String>>();
		MyNode<String> firstNode = null;
		MyNode<String> activeNode;
		boolean found = false;
		if (contains(src) == false) {
			throw new Exception("src doesn't exist");
		}
		
		firstNode = getNodeWithData(src);
		
		if (firstNode == null) {
			throw new Exception("Graph is empty @ bfs exception");
		}

		queue.add(firstNode);
		firstNode.setVisited(true);
		bfsList.add(firstNode.getData());

		while (queue.isEmpty() == false && found == false) {
			activeNode = queue.remove();

			for (MyNode<String> node : activeNode.getAdjacents()) {
				if (node.isVisited() == false) {
					queue.add(node);
					node.setVisited(true);
					bfsList.add(node.getData());

					if (node.getData() == dst) {
						found = true;
						break;
					}
				}
			}
		}

		return bfsList;
	}
	
	public List<String> dfs(String src, String dst) throws Exception {
		List<String> list = new ArrayList<String>();
		dfs(src, dst, list);
		return list;
		
	}
	
	public void dfs(String src, String dst, List<String> list){
		resetVisited();
		if(getNodeWithData(src).getData() == dst){
			list.add(src);
		} else {
			for(MyNode<String> node : getNodeWithData(src).getAdjacents()){
				node.setVisited(true);
				dfs(node.getData(), dst, list);
			}
		}
	}

	public boolean contains(String src) { // checks if this graph contains the
											// node with src
		for (int i = 0; i < headsSize; i++) {
			if (heads.get(i).getData() == src) {
				return true;
			}
		}
		return false;
	}

	public boolean checkEdge(String src, String dst) {
		return getNodeWithData(src).contains(getNodeWithData(dst));
	}

	// helper functions
	public MyNode<String> getNodeWithData(String src) {
		for (int i = 0; i < headsSize; i++) {
			if (heads.get(i).getData() == src) {
				return heads.get(i);
			}
		}
		return null;
	}

	private void resetVisited() {
		for (MyNode<String> node : heads) {
			node.setVisited(false);
		}
	}

	// MyNode Class
	private class MyNode<String> {
		private String data;
		private LinkedList<MyNode<String>> adjacents;
		private boolean visited;

		public MyNode(String src) {
			this.data = src;
			adjacents = new LinkedList<MyNode<String>>();
			setVisited(false);
		}

		public void remove(MyNode<String> node) {
			adjacents.remove(node);
		}

		public void add(MyNode<String> node) {
			adjacents.add(node);
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public LinkedList<MyNode<String>> getAdjacents() {
			return adjacents;
		}

		public boolean contains(MyNode<String> node) {
			return adjacents.contains(node);
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
	}
}
