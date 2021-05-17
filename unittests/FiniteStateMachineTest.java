import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FiniteStateMachineTest {

    FiniteStateMachine compute_path(String path) {
        // Create list with 4 new nodes. We can already set the names
        final int STARTER_NODES_LIMIT = 9;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < STARTER_NODES_LIMIT; i++) nodes.add(new Node(("s" + i)));

        // Set the node their node-navigations.
        // Nulls can be used as they get checked for in the FiniteStateMachine class
        nodes.get(0).setAccessibleNodes(Arrays.asList(nodes.get(1), nodes.get(6), nodes.get(0)));
        nodes.get(1).setAccessibleNodes(Arrays.asList(nodes.get(7), nodes.get(2), nodes.get(1)));
        nodes.get(2).setAccessibleNodes(Arrays.asList(nodes.get(8), nodes.get(3), nodes.get(2)));
        nodes.get(3).setAccessibleNodes(Arrays.asList(nodes.get(7), nodes.get(4), nodes.get(3)));
        nodes.get(4).setAccessibleNodes(Arrays.asList(nodes.get(5), null, nodes.get(4)));
        nodes.get(5).setAccessibleNodes(Arrays.asList(nodes.get(7), nodes.get(0), nodes.get(5)));
        nodes.get(6).setAccessibleNodes(Arrays.asList(nodes.get(5), nodes.get(7)));
        nodes.get(7).setAccessibleNodes(Arrays.asList(nodes.get(8), nodes.get(4)));
        nodes.get(8).setAccessibleNodes(Arrays.asList(nodes.get(3), nodes.get(6), nodes.get(1)));


        // Create a fsm instance and give the nodes, path and we want to compute immediately
        // You can disable that function if you expect to alter nodes and want to compute later
        // For this demonstration we compute now
        return new FiniteStateMachine(nodes, path, true);
    }

    @Test
    void compute_valid_path() {
        // Text that the FSM will read and compute with
        String path = "ABBBABBAAABBB";
        FiniteStateMachine fsm = compute_path(path);

        assertEquals("[s0, s1, s2, s3, s4, s5, s0, s6, s5, s7, s8, s6, s7, s4]", String.valueOf(fsm.getOutput()));
    }

    @Test
    void compute_invalid_path() {
        // Text that the FSM will read and compute with
        String path = "ABBBD";
        assertThrows(NullPointerException.class, () -> compute_path(path));
    }

    @Test
    void compute_random_path() {
        // Create FSM object with no path (as we are going to randomly traverse it)
        FiniteStateMachine fsm = compute_path("");
        // Set the amount of stept (excluding the first one)
        final int steps = 10;
        // Compute
        fsm.computeRandom(steps);
        // Check if the result length is the same as the amount of stept plus 1 (because of the first one)
        assertEquals(fsm.getOutput().size(), steps+1);
    }
}