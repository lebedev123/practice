public class RevertNode {
    public static void main(String[] args) {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        first.setNext(second);
        second.setNext(third);
        Node reverted = revertNodes(first);
        while (reverted != null) {
            System.out.println(reverted);
            reverted = reverted.next;
        }

    }

    private static Node revertNodes(Node node) {
        Node next = null;
        Node result = null;
        while (node != null) {
            result = new Node(node.value);
            result.setNext(next);
            next = result;
            node = node.next;
        }
        return result;
    }

    private static Node revertNodeRecuirsive(Node node){
        Node result = node;
        if(node != null){
            result.setNext(revertNodes(node.next));
        }else{
            return null;
        }
        return result;

    }
}

class Node {
    String value;
    Node next;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value;
    }
}
