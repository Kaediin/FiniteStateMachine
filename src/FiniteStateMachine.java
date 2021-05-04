import model.Node;

import java.util.ArrayList;
import java.util.List;

public class FiniteStateMachine {

    private List<Node> nodes;
    private Node starterNode;
    private String text;
    private final List<String> output = new ArrayList<>();

    /**
     * Constructor with the attributes needed to make a FiniteStateMachine
     * @param nodes: all the nodes used
     * @param text: The text which is used to compute. Example: 'BAAB'
     * @param computeImmediately: If user wants to compute immediately the function will be called. Else not
     */
    public FiniteStateMachine(List<Node> nodes, String text, boolean computeImmediately) {
        this.nodes = nodes;
        this.text = text;
        this.starterNode = this.nodes.get(0);

        if (computeImmediately) this.compute();
    }

    /**
     * function to compute results
     * For each letter in string we check:
     *      is it an A or B:
     *          then we get the node accordingly
     *
     *      after we get the name of new node and append it to the output var
     */
    public void compute() {
        Node currentNode = this.starterNode;
        this.output.add(currentNode.getName());

        for (int i = 0; i < text.length(); i++) {
            switch (String.valueOf(text.charAt(i))) {
                case "A":
                    if (currentNode.getNodeA() == null) continue;
                    currentNode = currentNode.getNodeA();
                    break;
                case "B":
                    if (currentNode.getNodeB() == null) continue;
                    currentNode = currentNode.getNodeB();
                    break;
            }
            output.add(currentNode.getName());
        }
    }


    // Getters
    public List<String> getOutput() {
        return this.output;
    }

    // Setters - Not all are used, but they are good to have!
    public void setText(String text) {
        this.text = text;
    }

    private void setStarterNode(Node node) {
        this.starterNode = node;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
        setStarterNode(this.nodes.get(0));
    }
}
