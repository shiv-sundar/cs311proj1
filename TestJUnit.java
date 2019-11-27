import static org.junit.jupiter.api.Assertions.
*;

import org.junit.jupiter.api.Test;


import org.junit.Before;

import static org.junit.Assert.*;	

public class TestJUnit {

	// Instance variables
	RBTree rt1;
	Intervals i1;
	public static Node nil;
	@Before
	public void before() {
		i1 = new Intervals();

	}

	@Test
	//Change to RBINSERT?
	public void testInsert() {
		// initial
	
		//assertEquals(rt1.nil, rt1.root);
		i1 = new Intervals();
		// first insertion
		i1.intervalInsert(0, 4); 
		rt1 = i1.getRBTree();
		assertEquals(0, rt1.root.key);
		assertEquals(4, rt1.root.right.key);

		// second insertion
		i1.intervalInsert(1, 6); 
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.key);
		assertEquals(0, rt1.root.left.key);
		assertEquals(4, rt1.root.right.key);
		assertEquals(6, rt1.root.right.right.key);

		// third insertion
		i1.intervalInsert(3, 9);
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.key);
		assertEquals(0, rt1.root.left.key);
		assertEquals(4, rt1.root.right.key);
		assertEquals(6, rt1.root.right.right.key);
		assertEquals(3, rt1.root.right.left.key);
		assertEquals(9, rt1.root.right.right.right.key);

		// fourth insertion
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(4, rt1.root.key);
		assertEquals(1, rt1.root.left.key);
		assertEquals(0, rt1.root.left.left.key);
		assertEquals(3, rt1.root.left.right.key);
		assertEquals(7, rt1.root.right.key);
		assertEquals(6, rt1.root.right.left.key);
		assertEquals(9, rt1.root.right.right.key);
		assertEquals(11, rt1.root.right.right.right.key); 	
	}

	@Test
	public void testColor() {
		// initial
		before();
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.color);

		// first insertion
		i1.intervalInsert(0, 4); 
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.color);
		assertEquals(0, rt1.root.right.color);

		// second insertion
		i1.intervalInsert(1, 6); 
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.color);
		assertEquals(1, rt1.root.left.color);
		assertEquals(1, rt1.root.right.color);
		assertEquals(0, rt1.root.right.right.color);

		// third insertion
		i1.intervalInsert(3, 9);
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.color);
		assertEquals(1, rt1.root.left.color);
		assertEquals(0, rt1.root.right.color);
		assertEquals(1, rt1.root.right.right.color);
		assertEquals(1, rt1.root.right.left.color);
		assertEquals(0, rt1.root.right.right.right.color);

		// fourth insertion
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(1, rt1.root.color);
		assertEquals(0, rt1.root.left.color);
		assertEquals(1, rt1.root.left.left.color);
		assertEquals(1, rt1.root.left.right.color);
		assertEquals(0, rt1.root.right.color);
		assertEquals(1, rt1.root.right.left.color);
		assertEquals(1, rt1.root.right.right.color);
		assertEquals(0, rt1.root.right.right.right.color);

	}

	@Test
	public void testSize() {
		// initial 
		rt1 = i1.getRBTree();
		assertEquals(0, rt1.getSize());

		// first insertion
		i1.intervalInsert(0, 4); 
		rt1 = i1.getRBTree();
		assertEquals(2, rt1.getSize());

		// second insertion
		i1.intervalInsert(1, 6); 
		rt1 = i1.getRBTree();
		assertEquals(4, rt1.getSize());

		// third insertion
		i1.intervalInsert(3, 9);
		rt1 = i1.getRBTree();
		assertEquals(6, rt1.getSize());

		// fourth insertion
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(8, rt1.getSize());
	}

	@Test
	public void testHeight() {
		//initial
		rt1 = i1.getRBTree();
		assertEquals(0, rt1.getHeight());

		// first insertion
		i1.intervalInsert(0, 4); 
		rt1 = i1.getRBTree();
		assertEquals(2, rt1.getHeight());

		// second insertion
		i1.intervalInsert(1, 6); 
		rt1 = i1.getRBTree();
		assertEquals(3, rt1.getHeight());

		// third insertion
		i1.intervalInsert(3, 9);
		rt1 = i1.getRBTree();
		assertEquals(4, rt1.getHeight());

		// fourth insertion
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(4, rt1.getHeight());

	}


	@Test
	public void testP() {
		i1.intervalInsert(0, 4); 
		i1.intervalInsert(1, 6); 
		i1.intervalInsert(3, 9);
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(-1, rt1.root.p);
		assertEquals(1, rt1.root.left.p);
		assertEquals(1, rt1.root.left.left.p);
		assertEquals(1, rt1.root.left.right.p);
		assertEquals(1, rt1.root.right.p);
		assertEquals(-1, rt1.root.right.left.p);
		assertEquals(-1, rt1.root.right.right.p);
		assertEquals(-1, rt1.root.right.right.right.p); 
	}

	@Test
	public void testVal() {
		i1.intervalInsert(0, 4); 
		i1.intervalInsert(1, 6); 
		i1.intervalInsert(3, 9);
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(0, rt1.root.getVal());
		assertEquals(3, rt1.root.left.getVal());
		assertEquals(1, rt1.root.left.left.getVal());
		assertEquals(1, rt1.root.left.right.getVal());
		assertEquals(-2, rt1.root.right.getVal());
		assertEquals(-1, rt1.root.right.left.getVal());
		assertEquals(-2, rt1.root.right.right.getVal());
		assertEquals(-1, rt1.root.right.right.right.getVal());
	}

	@Test
	public void testMaxVal() {
		i1.intervalInsert(0, 4); 
		i1.intervalInsert(1, 6); 
		i1.intervalInsert(3, 9);
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(3, rt1.root.getMaxVal());
		assertEquals(3, rt1.root.left.getMaxVal());
		assertEquals(1, rt1.root.left.left.getMaxVal());
		assertEquals(1, rt1.root.left.right.getMaxVal());
		assertEquals(0, rt1.root.right.getMaxVal());
		assertEquals(0, rt1.root.right.left.getMaxVal());
		assertEquals(0, rt1.root.right.right.getMaxVal());
		assertEquals(0, rt1.root.right.right.right.getMaxVal());
	}

	@Test
	public void testEmax() {
		i1.intervalInsert(0, 4); 
		i1.intervalInsert(1, 6); 
		i1.intervalInsert(3, 9);
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(3, rt1.root.getEmax().getValue());
		assertEquals(3, rt1.root.left.getEmax().getValue());
		assertEquals(0, rt1.root.left.left.getEmax().getValue());
		assertEquals(3, rt1.root.left.right.getEmax().getValue()); 
		assertEquals(RBTree.nil.key, rt1.root.right.getEmax().getValue()); 
		assertEquals(RBTree.nil.key, rt1.root.right.left.getEmax().getValue()); 
		assertEquals(RBTree.nil.key, rt1.root.right.right.getEmax().getValue()); 
		assertEquals(RBTree.nil.key, rt1.root.right.right.right.getEmax().getValue()); 	

	}


	@Test
	public void testPOM() {
		i1.intervalInsert(0, 4); 
		i1.intervalInsert(1, 6); 
		i1.intervalInsert(3, 9);
		i1.intervalInsert(7, 11);
		rt1 = i1.getRBTree();
		assertEquals(3, i1.findPOM());

	}
	
	@Test
	public void testID() {
		/*
		assertEquals(1, i1.ID);
		i1.intervalInsert(0, 4); 
		assertEquals(2, i1.ID);
		i1.intervalInsert(1, 6); 
		assertEquals(3, i1.ID);
		i1.intervalInsert(3, 9);
		assertEquals(4, i1.ID);
		i1.intervalInsert(7, 11);
		assertEquals(5, i1.ID);
		*/
	}
}


