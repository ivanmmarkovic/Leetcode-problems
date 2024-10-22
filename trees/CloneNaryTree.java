

class CloneNaryTree {

  // Definition for a Node.
    class Node {
        public int val; // Variable to store the node's value.
        public List<Node> children; // List to store the node's children.
    
        // Constructor to initialize the node with no children.
        public Node() {
            children = new ArrayList<Node>();
        }
    
        // Constructor to initialize the node with a value and no children.
        public Node(int val) {
            this.val = val;
            children = new ArrayList<Node>();
        }
    
        // Constructor to initialize the node with a value and a list of children.
        public Node(int val, ArrayList<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
    
    public Node cloneTree(Node root) {
        if(root == null)
            return null;
        
        ArrayList<Node> children = new ArrayList<>();
        for(Node child: root.children){
            children.add(cloneTree(child));
        }
        
        return new Node(root.val, children);
        
    }
  
}
