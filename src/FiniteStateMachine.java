import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FiniteStateMachine {

    private List<Node> nodes;
    private Node starterNode;
    private String path;
    private List<String> output = new ArrayList<>();

    /**
     * Constructor with the attributes needed to make a FiniteStateMachine
     *
     * @param nodes:     all the nodes used
     * @param path:               The text which is used to compute. Example: 'BAAB'
     * @param computeImmediately: If user wants to compute immediately the function will be called. Else not
     */
    public FiniteStateMachine(List<Node> nodes, String path, boolean computeImmediately) {
        this.nodes = nodes;
        this.path = path;
        this.starterNode = this.nodes.get(0);

        if (computeImmediately) this.compute();
    }


        /**
         * function to compute results
         * For each letter in string we check:
         * is it an A or B:
         * then we get the node accordingly
         * <p>
         * after we get the name of new node and append it to the output var
         */
    public void compute() {
        this.output = new ArrayList<>();
        Node currentNode = this.starterNode;
        this.output.add(currentNode.getName());
        String ALPHABET = "ABCDEFHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < path.length(); i++) {
            int newNodeIndex = ALPHABET.indexOf(this.path.charAt(i));
            if (currentNode.getAccessibleNodes().size()-1 >= newNodeIndex) {
                currentNode = currentNode.getAccessibleNodes().get(newNodeIndex);
                if (currentNode != null) {
                    output.add(currentNode.getName());
                    continue;
                }
            }
            throw new NullPointerException("Node is null! Index van letter "+this.path.charAt(i)+" komt niet voor in de lijst!");
        }
    }

    /**
     *
     * @param distance amount of steps.
     * This algorithm will traverse the nodes and append the names to the output var
     */
    public void computeRandom(int distance){
        this.output = new ArrayList<>();
        Random random = new Random();
        Node currentNode = this.starterNode;
        this.output.add(currentNode.getName());
        for (int i =0; i < distance;i++){
            currentNode = currentNode.getAccessibleNodes().get(random.nextInt(currentNode.getAccessibleNodes().size()));
            if (currentNode != null) {
                output.add(currentNode.getName());
                continue;
            }
            throw new NullPointerException("Node is null!");
        }
    }


    // Getters
    public List<String> getOutput() {
        return this.output;
    }

    // Setters - Not all are used, but they are good to have!
    public void setPath(String path) {
        this.path = path;
    }

    private void setStarterNode(Node node) {
        this.starterNode = node;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
        setStarterNode(this.nodes.get(0));
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
