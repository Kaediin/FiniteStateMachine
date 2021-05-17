import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    /**
     * Main function that runs the application
     * @param args default parameter
     */
    public static void main(String[] args) {
        // Text that the FSM will read and compute with
        String path = "ABBBABBAAA";

        // Create list with 4 new nodes. We can already set the names
        final int STARTER_NODES_LIMIT = 9;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < STARTER_NODES_LIMIT; i++) nodes.add(new Node(("s"+i)));

        // Set the node their node-navigations.
        // Nulls can be used as they get checked for in the FiniteStateMachine class
        nodes.get(0).setAccessibleNodes(Arrays.asList(nodes.get(1), nodes.get(6), nodes.get(0)));
        nodes.get(1).setAccessibleNodes(Arrays.asList(nodes.get(7), nodes.get(2), nodes.get(1)));
        nodes.get(2).setAccessibleNodes(Arrays.asList(nodes.get(8), nodes.get(3), nodes.get(2)));
        nodes.get(3).setAccessibleNodes(Arrays.asList(nodes.get(7), nodes.get(4), nodes.get(3)));
        nodes.get(4).setAccessibleNodes(Arrays.asList(nodes.get(5), nodes.get(4)));
        nodes.get(5).setAccessibleNodes(Arrays.asList(nodes.get(7), nodes.get(0), nodes.get(5)));
        nodes.get(6).setAccessibleNodes(Arrays.asList(nodes.get(5), nodes.get(7)));
        nodes.get(7).setAccessibleNodes(Arrays.asList(nodes.get(8), nodes.get(4)));
        nodes.get(8).setAccessibleNodes(Arrays.asList(nodes.get(3), nodes.get(6), nodes.get(1)));


        // Create a fsm instance and give the nodes, path and we want to compute immediately
        // You can disable that function if you expect to alter nodes and want to compute later
        // For this demonstration we compute now
        FiniteStateMachine fsm = new FiniteStateMachine(nodes, path, true);

        // Since we have already computed we can get the output. If you dont compute immediately -
        // you need to call 'fsm.compute()'
        System.out.println(fsm.getOutput());
        fsm.computeRandom(10);
        System.out.println(fsm.getOutput());

    }
}
