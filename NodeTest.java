import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    // Instance variables
    private Node node;
    private Node node2;
    private RBTree rb;

    @Before
    public void initialize() {
        node = new Node(3, 0);
        node.p = -1;
        node2 = new Node(7, 1);
        node2.p = 1;
    }

  /*  @Test
    public void testGetParent() {
        node.setParent(node2);
        assertEquals(7, node.getParent().getKey());
    }

    @Test
    public void testGetLeft() {
        node.setLeft(node2);
        assertEquals(7, node.getLeft().getKey());
    }

    @Test
    public void testGetRight() {
        node.setRight(node2);
        assertEquals(7, node.getRight().getKey());
    }
*/
    @Test
    public void testGetKey() {
        assertEquals(3, node.getKey());
    }

    @Test
    public void testGetP() {
        assertEquals(-1, node.getP());
        assertEquals(1, node2.getP());
    }

    @Test
    public void testGetVal() {
        node.setVal(rb);
        assertEquals(7, node.getVal());
    }

    @Test
    public void testGetMaxVal() {
        node.setMaxVal(rb);
        assertEquals(7, node.getMaxVal());
    }

    @Test
    public void testGetEndpoint() {
        Endpoint endpoint = new Endpoint(7);
        node = new Node(7, 2);
        assertEquals(endpoint, node.getEndPoint());
    }

    @Test
    public void testGetEmax() {
        Endpoint emax = new Endpoint(7);
        node.setEmax(rb);
        assertEquals(emax, node.getEmax());
    }

    @Test
    public void testGetColor() {
        node.setColor(0);
        assertEquals(0, node.getColor());
        node.setColor(1);
        assertEquals(1, node.getColor());
    }
}
