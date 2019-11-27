import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Deletion test cases gotten from
 *  https://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/
 */
/*public class DeletionTest {

    // Instance variables
    private RBTree tree;
    private Intervals intervals;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;

    @Before
    public void initialize() {
        tree = new RBTree();
        node1 = new Node(1,0);
        node2 = new Node(2,1);
        node3 = new Node(3,2);
        node4 = new Node(4,3);
        node5 = new Node(5,4);
        node6 = new Node(6,5);
        intervals = new Intervals();
        RBTree tree = intervals.getRBTree();
    }

    @Test
    public void simpleDelete() {

        // Create simple tree
    	
    	intervals.rb = tree;
    	//node3
    	intervals.intervalInsert();
    	//node 2
        intervals.intervalInsert();
        //node 4
        intervals.intervalInsert();
        //node1
        intervals.intervalInsert();
        

        // Delete root.left
       intervals.intervalDelete(1);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(1, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());

        // Test tree parents
      //  assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
      /*  assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());
       */
        // Test tree colors

/*
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(3, tree.getSize());
    }

    @Test
    public void doubleBlackLeftLeftTest() {

        // Create tree
        tree.insert(node5);
        tree.insert(node3);
        tree.insert(node6);
        tree.insert(node2);
        tree.insert(node4);

        // Delete root.right
        tree.delete(node6);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(2, tree.getRoot().getLeft().getKey());
        assertEquals(5, tree.getRoot().getRight().getKey());
        assertEquals(4, tree.getRoot().getRight().getLeft().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());
        assertEquals(5, tree.getRoot().getRight().getLeft().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getLeft().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getRight().getColorInEnum());
        assertEquals(Color.RED, tree.getRoot().getRight().getLeft().getColorInEnum());

        // Test size
        assertEquals(4, tree.getSize());
    }

    @Test
    public void doubleBlackRightRightTest() {

        // Create tree
        tree.insert(node3);
        tree.insert(node2);
        tree.insert(node5);
        tree.insert(node4);
        tree.insert(node6);

        // Delete root.left
        tree.delete(node2);

        // Test tree keys
        assertEquals(5, tree.getRoot().getKey());
        assertEquals(3, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getLeft().getRight().getKey());
        assertEquals(6, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(5, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(5, tree.getRoot().getRight().getParent().getKey());
        assertEquals(3, tree.getRoot().getLeft().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getLeft().getColorInEnum());
        assertEquals(Color.RED, tree.getRoot().getLeft().getRight().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getRight().getColorInEnum());

        // Test size
        assertEquals(4, tree.getSize());
    }

    @Test
    public void doubleBlackLeftRightTest() {

        // Create tree
        tree.insert(node4);
        tree.insert(node2);
        tree.insert(node5);
        tree.insert(node3);

        // Delete root.right
        tree.delete(node5);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(2, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getLeft().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getRight().getColorInEnum());

        // Test size
        assertEquals(3, tree.getSize());
    }

    @Test
    public void doubleBlackRightLeftTest() {

        // Create tree
        tree.insert(node3);
        tree.insert(node2);
        tree.insert(node5);
        tree.insert(node4);

        // Delete root.left
        tree.delete(node2);

        // Test tree keys
        assertEquals(4, tree.getRoot().getKey());
        assertEquals(3, tree.getRoot().getLeft().getKey());
        assertEquals(5, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(4, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(4, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getLeft().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getRight().getColorInEnum());

        // Test size
        assertEquals(3, tree.getSize());
    }

    @Test
    public void siblingAndBothChildrenBlackTest() {

        // Create tree
        tree.insert(node2);
        tree.insert(node1);
        tree.insert(node3);
        tree.getRoot().getLeft().setColor(Color.BLACK);
        tree.getRoot().getRight().setColor(Color.BLACK);

        // Delete root.left
        tree.delete(node1);

        // Test tree keys
        assertEquals(2, tree.getRoot().getKey());
        assertEquals(3, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(2, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.RED, tree.getRoot().getRight().getColorInEnum());

        // Test size
        assertEquals(2, tree.getSize());
    }

    @Test
    public void siblingRedLeftTest() {

        // Create tree
        tree.insert(node4);
        tree.insert(node2);
        tree.insert(node5);
        tree.insert(node1);
        tree.insert(node3);
        tree.getRoot().getLeft().setColor(Color.RED);
        tree.getRoot().getLeft().getLeft().setColor(Color.BLACK);
        tree.getRoot().getLeft().getRight().setColor(Color.BLACK);

        // Delete root.right
        tree.delete(node5);

        // Test tree keys
        assertEquals(2, tree.getRoot().getKey());
        assertEquals(1, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());
        assertEquals(3, tree.getRoot().getRight().getLeft().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(2, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(2, tree.getRoot().getRight().getParent().getKey());
        assertEquals(4, tree.getRoot().getRight().getLeft().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getLeft().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getRight().getColorInEnum());
        assertEquals(Color.RED, tree.getRoot().getRight().getLeft().getColorInEnum());

        // Test size
        assertEquals(4, tree.getSize());
    }

    @Test
    public void siblingRedRightTest() {

        // Create tree
        tree.insert(node2);
        tree.insert(node1);
        tree.insert(node4);
        tree.insert(node3);
        tree.insert(node5);
        tree.getRoot().getRight().setColor(Color.RED);
        tree.getRoot().getRight().getLeft().setColor(Color.BLACK);
        tree.getRoot().getRight().getRight().setColor(Color.BLACK);

        // Delete root.left
        tree.delete(node1);

        // Test tree keys
        assertEquals(4, tree.getRoot().getKey());
        assertEquals(2, tree.getRoot().getLeft().getKey());
        assertEquals(3, tree.getRoot().getLeft().getRight().getKey());
        assertEquals(5, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(4, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(4, tree.getRoot().getRight().getParent().getKey());
        assertEquals(2, tree.getRoot().getLeft().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().isNil());

        // Test tree colors
        assertEquals(Color.BLACK, tree.getRoot().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getLeft().getColorInEnum());
        assertEquals(Color.RED, tree.getRoot().getLeft().getRight().getColorInEnum());
        assertEquals(Color.BLACK, tree.getRoot().getRight().getColorInEnum());

        // Test size
        assertEquals(4, tree.getSize());
    }
}*/
