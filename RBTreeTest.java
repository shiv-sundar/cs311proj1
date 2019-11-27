import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeTest {

    // Instance variables
    private RBTree tree;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;
    private Intervals interval;
    
    @Before
    public void initialize() {
        tree = new RBTree();
        node1 = new Node(1, 0);
        node2 = new Node(2, 1);
        node3 = new Node(3, 2);
        node4 = new Node(4, 3);
        node5 = new Node(5, 4);
        node6 = new Node(6, 5);
        interval = new Intervals();
    }

    @Test
    public void testGetRoot() {

        // Root should initially be NIL
        assertTrue(tree.getRoot() == RBTree.nil);

        // Insert node, which is new root
        interval.rb = tree;
        interval.RBInsert(tree, node1);
        assertFalse(tree.getRoot() == tree.nil);
        assertEquals(tree.getRoot().getKey(), 1);

        // New insert keeps the same root as before
        interval.RBInsert(tree, node2);
        assertEquals(tree.getRoot().getKey(), 1);

        // Rotation results in new root
        interval.RBInsert(tree, node3);
        assertEquals(tree.getRoot().getKey(), 2);
    }

    @Test
    public void testGetNILNode() {
        Node nilNode = tree.getNILNode();
        assertTrue(nilNode == RBTree.nil);
        assertEquals(nilNode.color, 1);
        interval.RBInsert(tree, node1);
        assertEquals(tree.getNILNode(), nilNode);   // NIL node shouldn't change after insert
    }

    @Test
    public void testGetSize() {
        assertEquals(tree.getSize(), 0);
        interval.RBInsert(tree, node1);
        assertEquals(tree.getSize(), 1);
        interval.RBInsert(tree, node2);
        assertEquals(tree.getSize(), 2);
        interval.RBInsert(tree, node3);
        assertEquals(tree.getSize(), 3);
    }

    @Test
    public void testGetHeight() {
        assertEquals(tree.getHeight(), 0);
        interval.RBInsert(tree, node3);
        assertEquals(tree.getHeight(), 1);
        interval.RBInsert(tree, node2);
        assertEquals(tree.getHeight(), 2);
        interval.RBInsert(tree, node4);
        assertEquals(tree.getHeight(), 2);
        interval.RBInsert(tree, node5);
        assertEquals(tree.getHeight(), 3);
        interval.RBInsert(tree, node6);
        assertEquals(tree.getHeight(), 3);  // Rotation keeps height at 3
    }
}
