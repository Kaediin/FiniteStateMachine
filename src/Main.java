import model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Main function that runs the application
     * @param args default parameter
     */
    public static void main(String[] args) {
        // Text that the FSM will read and compute with
        String text = "BAAB";

        // Create a fsm instance and give the nodes, text and we want to compute immediately
        // You can disable that function if you expect to alter nodes and want to compute later
        // For this demonstration we compute now
        FiniteStateMachine fsm = new FiniteStateMachine(getAllNodes(), text, true);

        // Since we have already computed we can get the ouput. If you dont compute immediately -
        // you need to call 'fsm.compute()'
        System.out.println(fsm.getOutput());
    }

    /**
     * Gets all the nodes we use for this demonstration
     * @return list with nodes
     * We can create a list and add to it immediately with Arrays.asList();
     */
    private static List<Node> getAllNodes(){
        // Create list with 4 new nodes. We can already set the names
        List<Node> nodes = new ArrayList<>(Arrays.asList(new Node("s0"), new Node("s1"), new Node("s2"), new Node("s3")));

        // Set the node their A and B node-navigations.
        // Nulls can be used as they get checked for in the FiniteStateMachine class
        nodes.get(0).setNodes(nodes.get(2), nodes.get(1));
        nodes.get(1).setNodes(nodes.get(1), nodes.get(2));
        nodes.get(2).setNodes(null, nodes.get(3));
        nodes.get(3).setNodes(nodes.get(3), nodes.get(0));
        return nodes;
    }
}
