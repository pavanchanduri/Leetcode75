package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {

    public static void main(String[] args) {

        // Create a sample graph and call the cloneGraph method
        Node original = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        original.neighbors.add(node2); // 1 -- 2
        node2.neighbors.add(original);  // 2 -- 1
        original.neighbors.add(node4); // 1 -- 4
        node4.neighbors.add(original);  // 4 -- 1

        node2.neighbors.add(node3);     // 2 -- 3
        node3.neighbors.add(node2);     // 3 -- 2

        node3.neighbors.add(node4);     // 3 -- 4
        node4.neighbors.add(node3);     // 4 -- 3
        // The graph looks like:
        // 1 -- 2
        // |    |
        // 4 -- 3
        cloneGraph(original);
        System.out.println("Node " + original.val + ": neighbors " + 
            original.neighbors.stream().map(n -> n.val).toList());
        System.out.println("Node " + node2.val + ": neighbors " + 
            node2.neighbors.stream().map(n -> n.val).toList());
        System.out.println("Node " + node3.val + ": neighbors " + 
            node3.neighbors.stream().map(n -> n.val).toList());
        System.out.println("Node " + node4.val + ": neighbors " +   
            node4.neighbors.stream().map(n -> n.val).toList());
    }

    /**
     * This method clones an undirected graph using BFS.
     * The algorithm works as below:
     * 1. Use a map to keep track of cloned nodes.
     * 2. Use a queue to perform BFS traversal of the graph.
     * 3. For each node, clone it if it hasn't been cloned yet and add
     *   its neighbors to the queue.
     * 4. Link the cloned neighbors to the cloned node.
     * 5. Return the cloned node corresponding to the input node.
     *
     * @param node the starting node of the graph to be cloned
     * @return the cloned graph's starting node
     */
    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Clone the root node and put it in the map
        map.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone and add to map and queue
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Add the cloned neighbor to the current clone's neighbors
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
