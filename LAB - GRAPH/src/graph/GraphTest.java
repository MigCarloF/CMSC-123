package graph;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GraphTest {
	private Graph g = new Graph();

	public void setGraphs() throws Exception {
		g.addNode("A");
		g.addNode("B");
		g.addNode("S");
		g.addNode("C");
		
		//
		g.addNode("G");
		g.addNode("F");
		g.addNode("D");
		g.addNode("E");
		g.addNode("H");
		//
		
		//
		g.addEdge("A", "B");
		g.addEdge("A", "S");
		g.addEdge("S", "C");
		//
		
		g.addEdge("S", "G");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		g.addEdge("E", "H");
		g.addEdge("F", "G");
		g.addEdge("G", "H");
		g.addEdge("C", "F");
	}

	@Test
	public void addNode() throws Exception {
		g.addNode("Mitsuha");
		g.addNode("Taki");
		assertTrue(g.contains("Mitsuha"));
		assertTrue(g.contains("Taki"));
		g.addNode("Nido");
		assertTrue(g.contains("Nido"));
	}

	@Test
	public void addEdge() throws Exception {
		g.addNode("Mitsuha");
		g.addNode("Taki");
		g.addEdge("Mitsuha", "Taki");
		assertTrue(g.checkEdge("Mitsuha", "Taki"));
	}

	@Test
	public void removeEdge() throws Exception {
		g.addNode("Red");
		g.addNode("Green");
		g.addNode("Blue");
		g.addEdge("Green", "Blue");
		g.removeEdge("Green", "Blue");
		assertFalse(g.checkEdge("Green", "Blue"));
	}

	@Test
	public void hasEdge() throws Exception {
		g.addNode("Mitsuha");
		g.addNode("Taki");
		g.addEdge("Mitsuha", "Taki");
		assertTrue(g.hasEdge("Mitsuha", "Taki"));
	}

	@Test
	public void outEdges() throws Exception {
		setGraphs();

		List<String> list = new LinkedList<String>();

		list.add("B");
		list.add("S");
		assertEquals(list, g.outEdges("A"));
	}

	@Test
	public void inEdges() throws Exception {
		setGraphs();

		List<String> list = new LinkedList<String>();

		list.add("B");
		list.add("S");
		assertEquals(list, g.inEdges("A"));
	}

	@Test
	public void bfs() throws Exception {
		setGraphs();

		List<String> list = new LinkedList<String>();

		list.add("A");
		list.add("B");
		list.add("S");
		list.add("C");
		assertEquals(list, g.bfs("A", "C"));

		List<String> list2 = new LinkedList<String>();

		list2.add("A");
		list2.add("B");
		list2.add("S");
		list2.add("C");
		list2.add("G");
		list2.add("D");
		list2.add("E");
		list2.add("F");
		list2.add("H");
		assertEquals(list2, g.bfs("A", "H"));
	}

	@Test
	public void dfs() throws Exception {
		setGraphs();

		List<String> list = new LinkedList<String>();

		list.add("A");
		list.add("B");
		list.add("S");
		list.add("C");
		assertEquals(list, g.bfs("A", "C"));

		List<String> list2 = new LinkedList<String>();

		list2.add("A");
		list2.add("B");
		list2.add("S");
		list2.add("C");
		list2.add("G");
		list2.add("D");
		list2.add("E");
		list2.add("F");
		list2.add("H");
		assertEquals(list2, g.bfs("A", "H"));
	}

}
