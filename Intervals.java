import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Team members:
 * @author Shivkarthi Sundar
 * @author Elizabeth Li
 * 
 * A wrapper class for RBTree
 */
public class Intervals 
{
	private int ID = 1; //If deletion is done, this could be used to keep track of edpoints
	//for the same interval.
	public RBTree rb;
	public int counter = 0;
	HashMap<Integer, Node[]> interval = new HashMap<>();
	/**
	 * Constructor with no parameters.
	 */
	public Intervals()
	{
		rb = new RBTree();
	}

	/**
	 * 
	 * Adds the interval with left endpoint a and right endpoint b 
	 * to the collection of intervals. Each newly inserted interval 
	 * must be assigned an ID. The IDs should be consecutive; that is, 
	 * the ID of the interval inserted on the ith call of this method should be i.
	 * For example if intervalInsert is called successively to insert intervals 
	 * [5,7],[4,9],[1,8], then the IDs of these intervals should be 1,2,3, respectively.These IDs are permanent
	 *  for the respective intervals. Keep track of the IDs, as multiple intervals that have the same endpoints
	 *   on both sides can be added. intervalInsertshould run in O(logn)time
	 * @param a
	 * @param b
	 */
	//Update everything as soon as you insert something
	void intervalInsert(int a, int b) 
	{
		Node[] interv = new Node[2];
		Node node1 = new Node(a, ID);
		Node node2 = new Node(b, ID);
		interv[0] = node1;
		interv[1] = node2;
		node1.p = 1;
		node2.p = -1;
		RBInsert(rb, node1);
		//rb.size += 1;
		RBInsert(rb, node2);
		//rb.size += 1;
		interval.put(ID, interv);
		ID++;
	}
	//Rotation helper variable
	private Node rotateRight(Node current)
	{
		Node y = current.left;
		current.left = y.right;
		if(y.right != RBTree.nil) {
			y.right.parent = current;
		}

		y.parent = current.parent;
		if(current.parent == RBTree.nil) {
			rb.root = y;
		}

		else if(current == current.parent.right) {
			current.parent.right = y;
		}

		else {
			current.parent.left = y;
		}

		y.right = current;
		current.parent = y;
		if (current.right != rb.nil) {
			current.right.setVal(rb);
			current.right.setMaxVal(rb);
			current.right.setEmax(rb);
		}

		else {
			current.setVal(rb);
			current.setMaxVal(rb);
			current.setEmax(rb);
		}
		return current;
	}
	private void rotateLeft(Node current) 
	{
		Node x = current.right;
		current.right = x.left;
		if(x.left != RBTree.nil)
		{
			x.left.parent = current;
		}
		x.parent = current.parent;
		if(current.parent == RBTree.nil)
		{
			rb.root = x;
		}
		else if (current == current.parent.left)
		{
			current.parent.left = x;
		}
		else
		{
			current.parent.right = x;
		}
		x.left = current;
		current.parent = x;

		if (current.left != rb.nil) {
			current.left.setVal(rb);
			current.left.setMaxVal(rb);
			current.left.setEmax(rb);
		}


		else {
			current.setVal(rb);
			current.setMaxVal(rb);
			current.setEmax(rb);
		}
	}

	//TODO Move this code into intervalInsert
	void RBInsert(RBTree rb, Node insert)
	{

		Node y = RBTree.nil;
		Node x = rb.root;

		while (x != RBTree.nil) 
		{
			y = x;
			if (insert.key < x.key)
			{
				x = x.left;
			}
			else
			{
				x = x.right;

			}
		}
		insert.parent = y;
		if (y == RBTree.nil)
		{
			rb.root = insert; 
		}
		else if( insert.key < y.key) 
		{
			y.left = insert;
		}
		else
		{
			y.right = insert; 
		}
		insert.left = RBTree.nil;
		insert.right = RBTree.nil;
		insert.color = 0;

		RBInsertFixup(rb, insert);
		insert.setVal(rb);
		insert.setMaxVal(rb);
		insert.setEmax(rb);
		rb.size += 1;
	}
	private int RBInsertFixup(RBTree rb, Node insert)
	{
		int i = 0;
		while (insert.parent.color == 0)
		{
			if (insert.parent == insert.parent.parent.left)
			{
				Node y = insert.parent.parent.right;
				if (y.color == 0)
				{
					insert.parent.color = 1; // Case 1
					y.color = 1; // Case 1
					insert.parent.parent.color = 0; // Case 1
					insert = insert.parent.parent; // Case 1
				}
				else
				{
					if (insert == insert.parent.right)
					{
						i = 3;
						insert = insert.parent; // Case 2
						rotateLeft(insert); // Case 2
					}

					else {
						i = 1;
					}

					insert.parent.color = 1; // Case 3
					insert.parent.parent.color = 0; // Case 3
					rotateRight(insert.parent.parent); // Case 3
				}
			}
			else
			{
				Node y = insert.parent.parent.left;
				if (y.color == 0)
				{
					insert.parent.color = 1; // Case 1
					y.color = 1; // Case 1
					insert.parent.parent.color = 0; // Case 1
					insert = insert.parent.parent; // Case 1
				}
				else
				{
					if (insert == insert.parent.left)
					{
						insert = insert.parent; // Case 2
						rotateRight(insert); // Case 2
						i = 4;
					}

					else {
						i = 2;						
					}
					insert.parent.color = 1; // Case 3
					insert.parent.parent.color = 0; // Case 3
					rotateLeft(insert.parent.parent); // Case 3
				}
			}
		}

		rb.root.color = 1;
		return i;
	}
	//TODO: Add an update method that updates everything whenever subtree changes. 
	//TODO: Create a data structure that keeps track of all of the Nodes

	/**
	 * To delete an interval from delete.
	 * 
	 * 
	 * Deletes the interval whose ID (generated byintervalInsert) isintervalID. Returnstrueif 
	 * deletion was successful. Thismethod should run inO(logn)time.Note.TheintervalDeletemethod 
	 * isoptional; that is, you are not requiredto implement it. However, your codemustprovide 
	 * anintervalDeletemethodeven if you choose not to implement interval deletion. If you do not
	 *  implementdeletion, theintervalDeletemethod should consist of just one line that returnsfalse.
	 * @param intervalID
	 * @return
	 */
	boolean intervalDelete(int intervalID) {
		//		Node[] x = interval.get(intervalID);
		for (Node z : interval.get(intervalID)) {
			Node y = z;
			Node x;
			//			Node min = z;
			int origCol = y.color;
			if (z.left == RBTree.nil) {
				x = z.right;
				RBTransplant(z, z.right);
			}

			else if(z.right == RBTree.nil) {
				x = z.left;
				RBTransplant(z, z.left);
			}

			else {
				Node min = z.right;
				while (min.left != RBTree.nil) {
					min = min.left;
				}

				y = min;
				origCol = y.color;
				x = y.right;
				if (y.parent == z) {
					x.parent = y;
				}

				else {
					RBTransplant(y, y.right);
					y.right = z.right;
					y.right.parent = y;
				}

				RBTransplant(z, y);
				y.left = z.left;
				y.left.parent = y;
				y.color = z.color;
			}

			if (origCol == 1) {
				RBDeleteFixup(x);
			}

			rb.size--;
		}

		//TODO: Complete it as needed (This is optional so you can leave it as it is)
		return false;
	}

	public void RBDeleteFixup(Node x) {
		Node w;
		while(x != rb.root && x.color == 1) {
			if (x == x.parent.left) {
				w = x.parent.right;
				if(w.color == 0) {
					w.color = 1;
					x.parent.color = 0;
					rotateLeft(x.parent);
					w = x.parent.right;
					w.setVal(rb);
					w.setMaxVal(rb);
					w.setEmax(rb);
				}

				if (w.left.color == 1 && w.right.color == 1) {
					w.color = 0;
					x = x.parent;
					x.setVal(rb);
					x.setMaxVal(rb);
					x.setEmax(rb);
				}

				else {
					if (w.right.color == 1) {
						w.left.color = 1;
						w.color = 0;
						rotateRight(w);
						w = x.parent.right;
						w.right.setVal(rb);
						w.right.setMaxVal(rb);
						w.right.setEmax(rb);
					}

					w.color = x.parent.color;
					x.parent.color = 1;
					w.right.color = 1;
					rotateLeft(x.parent);
					x.setVal(rb);
					x.setMaxVal(rb);
					x.setEmax(rb);
					x = rb.root;
				}
			}

			else {
				w = x.parent.left;
				if(w.color == 0) {
					w.color = 1;
					x.parent.color = 0;
					rotateRight(x.parent);
					w = x.parent.left;
					w.setVal(rb);
					w.setMaxVal(rb);
					w.setEmax(rb);
				}

				if (w.right.color == 1 && w.left.color == 1) {
					w.color = 0;
					x = x.parent;
					x.setVal(rb);
					x.setMaxVal(rb);
					x.setEmax(rb);
				}

				else {
					if (w.left.color == 1) {
						w.right.color = 1;
						w.color = 0;
						rotateLeft(w);
						w = x.parent.left;
						w.left.setVal(rb);
						w.left.setMaxVal(rb);
						w.left.setEmax(rb);
					}

					w.color = x.parent.color;
					x.parent.color = 1;
					w.left.color = 1;
					rotateRight(x.parent);
					x.setVal(rb);
					x.setMaxVal(rb);
					x.setEmax(rb);
					x = rb.root;
				}
			}
		}

		x.color = 1;
	}

	public void RBTransplant(Node u, Node v) {
		if (u.parent == RBTree.nil) {
			rb.root = v;
		}

		else if (u == u.parent.left) {
			u.parent.left = v;
		}

		else {
			u.parent.right = v;
		}

		v.parent = u.parent;
	}

	/**
	 * Finds the endpoint that has maximum overlap and returns its value. This method should run in constant time.
	 * @return
	 */
	int findPOM() {
		//TODO: Modify it accordingly.
		return rb.root.getEmax().getValue();
	}

	/**
	 * Returns the red-black tree used, which is an object of typeRBTree.
	 * @return
	 */
	public RBTree getRBTree()
	{
		return rb;
	}

	//Add more functions as  you see fit.


	/**
	 * This is a suggested way on how to add intervals and call POM()
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String base_path = "C:/Users/Shivkarthi/Downloads/res/";
		String[] arr = {"small", "medium", "large"};

		for (String filename : arr) {
			for (int i = 1; i < 6; i++) {
				String test_path = base_path + filename + "_" + i + ".txt";
				System.out.println("Test file: " + test_path);
				readFile(test_path);
			}
		}


	}

	private static void readFile(String path) {
		File file = new File(path);
		ArrayList<ArrayList<Integer>> returnArr = new ArrayList<>();

		try {
			Scanner sc = new Scanner(file);
			String sanswer = sc.nextLine();
			ArrayList<Integer> answers = getAnswers(sanswer);

			while (sc.hasNextLine()) {
				String str = sc.nextLine();
				String[] arr = str.split(" ", -1);
				ArrayList<Integer> irr = new ArrayList<>();
				for (String s : arr) {
					irr.add(Integer.parseInt(s));
				}
				returnArr.add(irr);
			}
			boolean result = test(answers, returnArr);
			System.out.println("Test result: " + result);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static ArrayList<Integer> getAnswers(String sanswer) {
		String[] arranswer = sanswer.split(" ", -1);
		ArrayList<Integer> answers = new ArrayList<>();
		for (String ans : arranswer) {
			answers.add(Integer.parseInt(ans));
		}
		return answers;
	}

	private static boolean test(ArrayList<Integer> answers, ArrayList<ArrayList<Integer>> inputs) {
		Intervals intervals = new Intervals();
		for (ArrayList<Integer> points : inputs) {
			intervals.intervalInsert(points.get(0), points.get(1));
		}

		for (int answer : answers) {
			System.out.println("Expected:" + answer);
			System.out.println("Actual:" + intervals.findPOM());
			if (answer == intervals.findPOM()) {
				return true;
			}
		}
		return false;
	}
}
