package trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/clone-n-ary-tree/description/

public class CloneNaryTree {
	
	class Node {
        public int val; 
        public List<Node> children; 
    
       
        public Node() {
            children = new ArrayList<Node>();
        }
    
       
        public Node(int val) {
            this.val = val;
            children = new ArrayList<Node>();
        }
    
      
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
