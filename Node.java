

/**
 * Team members:
 * @author Elizabeth Li
 * @author Shivkarthi Sundar
 * 
 * Node class for RBTree.
 */
public class Node 
{
	public Node left, right, parent;
	public int color, key, val, maxVal, p;
	public Endpoint endPoint, eMax;
	public int ID;

	public Node(int value, int ID) {
		this.ID = ID;
		endPoint = new Endpoint(value);
		parent = null;
		right = null;
		left = null;
		color = 1;
		key = endPoint.getValue();
	}
	//Setters
	
	public void setVal(RBTree rb) {
		if (this == rb.root) {
			val = this.left.val + p + this.right.val;
		}

		else {
			val = this.left.val + p + this.right.val;
			parent.setVal(rb);
		}
	}
	
	public void setMaxVal(RBTree rb) {
		if (this == rb.root) {
			maxVal = Math.max(left.maxVal, left.val + p);
			maxVal = Math.max(maxVal, left.val + p + right.maxVal);
		}

		else {
			maxVal = Math.max(left.maxVal, left.val + p);
			maxVal = Math.max(maxVal, left.val + p + right.maxVal);
			parent.setMaxVal(rb);
		}
	}
	public void setEndPoint(Endpoint endPoint) {
		this.endPoint = endPoint;
	}

	//TODO change this to be called when inserting new nodes
	//this will not have a parameter and will recalculate emax
	//TODO can this have a parameter?
	public void setEmax(RBTree rb) {
		if (this == rb.root) {

			if (left == RBTree.nil && right == RBTree.nil) {
				eMax = this.endPoint;
			}

			else if (left == RBTree.nil) {
				eMax = right.eMax;
			}

			else if (right == RBTree.nil) {
				eMax = left.eMax;
			}

			else {
				if (this.maxVal > Math.max(left.maxVal, right.maxVal)) {
					eMax = this.endPoint;
				}

				else if(Math.max(left.maxVal, right.maxVal) == right.maxVal) {
					eMax = right.eMax;
				}
				
				else {
					eMax = left.eMax;
				}
			}
		}

		else {
			if (left == RBTree.nil && right == RBTree.nil) {
				eMax = this.endPoint;
			}

			else if (left == RBTree.nil) {
				eMax = right.eMax;
			}

			else if (right == RBTree.nil) {
				eMax = left.eMax;
			}

			else {
				if (this.maxVal > Math.max(left.maxVal, right.maxVal)) {
					eMax = right.eMax;
				}

				else if(Math.max(left.maxVal, right.maxVal) == right.maxVal) {
					eMax = this.endPoint;
				}
				
				else {
					eMax = left.eMax;
				}
			}

			parent.setEmax(rb);
		}
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * Returns the parent of this node.
	 * @return
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Returns the left child.
	 * @return
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 * Returns the right child.
	 * @return
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Returns the endpoint value, which is an integer.
	 * @return
	 */

	public int getKey() {
		return endPoint.getValue();
	}

	/**
	 * Returns the value of the functionpbased on this endpoint.
	 * @return
	 */
	public int getP() {
		return p;
	}

	/**
	 * Returns the val of the node as described in this assignment.
	 * @return
	 */

	public int getVal() {
		return val;
	}

	/**
	 * Returns themaxvalof the node as described in this assignment.
	 * @return
	 */
	public int getMaxVal() {
		return maxVal;
	}

	/**
	 * Returns theEndpointobject that this node represents.
	 * @return
	 */
	public Endpoint getEndPoint() {
		return endPoint;
	}

	/**
	 * Returns anEndpointobject that represents emax. 
	 * Calling this method on the root node will give the End point object whose getValue() 
	 * provides a point of maximum overlap.
	 * @return
	 */

	public Endpoint getEmax() {
		return this.eMax;
	}
	/**
	 * Returns 1 if black 0 if red
	 * @return
	 */
	public int getColor() {
		return color;
	}

}
