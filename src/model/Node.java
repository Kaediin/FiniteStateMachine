package model;

public class Node {

    // Node values
    private String name;
    private Node nodeA;
    private Node nodeB;

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

    public Node getNodeA() {
        return nodeA;
    }

    public Node getNodeB() {
        return nodeB;
    }

    // Setters

    //Not used but is a handy function to have regardless
    public void setName(String name) {
        this.name = name;
    }

    public void setNodes(Node nodeA, Node nodeB){
        setNodeA(nodeA);
        setNodeB(nodeB);
    }

    public void setNodeA(Node nodeA) {
        this.nodeA = nodeA;
    }

    public void setNodeB(Node nodeB) {
        this.nodeB = nodeB;
    }
}
