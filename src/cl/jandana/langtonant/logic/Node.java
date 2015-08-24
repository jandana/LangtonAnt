package cl.jandana.langtonant.logic;

import java.util.Vector;

/**
 *
 * @author Javier
 */
public class Node {

    private Vector vector;

    public Node() {
        vector = new Vector();
        for (int i = 0; i < 3; i++) {
            vector.addElement((double) 0);
        }
    }
 public Node(Vector v) {
        vector =v;
        
    }
    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }
    
   

    
}
