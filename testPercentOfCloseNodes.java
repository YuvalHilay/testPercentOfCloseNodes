package structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphTest {

    
    // checking functionality: percentOfCloseNodes() with graph having no nodes
    // input: Graph with no nodes and edges
    // expected result: 0
    @Test
    public void test_PercentOfCloseNodes_GraphWithNoNodes_DivisionbyZero_Failed() {
        // Create a graph
        Graph graph = new Graph();
        // Graph with no nodes and edges   
        
        int actualPercent = 0;

        try {
            actualPercent = graph.percentOfCloseNodes();
        } catch (Exception e) {
            // Handle any exceptions that occur during the test
            Assertions.fail("Exception occurred: " + e.getMessage());
        }

        // Verify that the percent of close nodes is 0 when there are no nodes in the graph
        Assertions.assertEquals(0, actualPercent);
    }
    // checking functionality: percentOfCloseNodes() with graph having a single node
    // input: Graph with a single node
    // expected result: 0
    @Test
    public void testPercentOfCloseNodes_WithSingleNode_ExpectZeroPercent() {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        graph.addNode(nodeA);

        int actualPercent = 0;

        try {
            actualPercent = graph.percentOfCloseNodes();
        } catch (Exception e) {
            // Handle any exceptions that occur during the test
            Assertions.fail("Exception occurred: " + e.getMessage());
        }
// expect 0 but actualprecent is -1
        // Verify that the percent of close nodes is 0 when there is only one node in the graph
        Assertions.assertEquals(0, actualPercent);
    }
    @Test
    // checking functionality: percentOfCloseNodes() with graph having multiple edges
    // input: Graph with multiple nodes and edges
    // expected result: 3
    public void testPercentOfCloseNodes_WithMultipleEdges() {
        try {
            Graph graph = new Graph();
            Node nodeA = new Node("A");
            Node nodeB = new Node("B");
            Node nodeC = new Node("C");
            nodeA.addDestination(nodeB, 10);
            nodeA.addDestination(nodeC, 15);
            nodeB.addDestination(nodeC, 5);
            nodeC.addDestination(nodeA, 8);
            graph.addNode(nodeA);
            graph.addNode(nodeB);
            graph.addNode(nodeC);

            int actualPercent = graph.percentOfCloseNodes();

            // Verify the expected percent of close nodes based on the graph structure
            Assertions.assertEquals(3, actualPercent);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    // checking functionality: percentOfCloseNodes() with graph having multiple nodes
    // input: Graph with multiple nodes but no edges
    // expected result: 0
    public void testPercentOfCloseNodes_WithMultipleNodes() {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        int actualPercent = 0;

        try {
            actualPercent = graph.percentOfCloseNodes();
        } catch (Exception e) {
            // Handle any exceptions that occur during the test
            Assertions.fail("Exception occurred: " + e.getMessage());
        }

        // Verify the expected percent of close nodes based on the graph structure
        Assertions.assertEquals(0, actualPercent);
    }
    @Test
    // checking functionality: percentOfCloseNodes() with graph having no edges
    // input: Graph with nodes but no edges
    // expected result: 0
    public void testPercentOfCloseNodes_NoEdgesGraph() {
        try {
            Graph graph = new Graph();
            Node nodeA = new Node("A");
            Node nodeB = new Node("B");
            Node nodeC = new Node("C");
            graph.addNode(nodeA);
            graph.addNode(nodeB);
            graph.addNode(nodeC);

            int actualPercent = graph.percentOfCloseNodes();

            // Verify that the percent of close nodes is 0 when there are no edges in the graph
            Assertions.assertEquals(0, actualPercent);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    // checking functionality: percentOfCloseNodes() with graph having self-loops
    // input: Graph with self-loops
    // expected result: 2
    public void testPercentOfCloseNodes_WithSelfLoops() {
        try {
            Graph graph = new Graph();
            Node nodeA = new Node("A");
            Node nodeB = new Node("B");
            Node nodeC = new Node("C");
            nodeA.addDestination(nodeA, 5); // Self-loop
            nodeA.addDestination(nodeB, 10);
            nodeB.addDestination(nodeC, 15);
            graph.addNode(nodeA);
            graph.addNode(nodeB);
            graph.addNode(nodeC);

            int actualPercent = graph.percentOfCloseNodes();

            // Verify the expected percent of close nodes based on the self-loops
            Assertions.assertEquals(2, actualPercent);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

}
