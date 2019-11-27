/**
 * Team members:
 * @author Elizabeth Li
 * @author Shivkarthi Sundar
 * 
 * RBTree class, maintains operations on RBTree.
 */

public class RBTree 
{
	public Node current, root;
	public static Node nil;
	public int size;
	public int height;
	
	/**
	 * RB Tree constructor. It initializes nil node as well.
	 */
	public RBTree() {
		nil = new Node(0, 0);
		nil.key = 0;
		nil.p = 0;
		nil.val = 0;
		nil.maxVal = 0;
		nil.eMax = nil.endPoint;
		nil.ID = -1;
		nil.key = -1;
		root = nil;				
		root.left = nil;
		root.right = nil;
		height = 0;
		size = 0;	
	}
	/**
	 * Returns the root of the tree.
	 * @return
	 */
	public Node getRoot() 
	{
		return root;
	}
	
	/**
	 * Returns reference for the nil node, for the rbTree.
	 * @return
	 */
	public Node getNILNode()
	{
		return nil;
	}
	/**
	 * Returns the number of internal nodes in the tree.
	 * @return
	 */
	public int getSize()
	{
		return size;
	}
	/**
	 * Returns the height of the tree.
	 * @return
	 */
	public int getHeight()
	{
		return height;
	}
	//Add more functions as you see fit.

	public void setRoot(Node root)
	{
		this.root = root;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
