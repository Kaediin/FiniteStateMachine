import java.util.List;

public class Node {

    // Node values
    private String name;
    private List<Node> accessibleNodes;

    /**
     * Constructor with name attribute
     * @param name of the node. For example: 's0'
     * We dont add the nodes yet as we need to initialize them which happens all at once
     */
    public Node(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }


    // Setters

    //Not used but is a handy function to have regardless
    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getAccessibleNodes() {
        return accessibleNodes;
    }

    public void setAccessibleNodes(List<Node> accessibleNodes) {
        this.accessibleNodes = accessibleNodes;
    }
}
