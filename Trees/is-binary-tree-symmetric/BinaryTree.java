
class BinaryTree {
    int key;
    BinaryTree parent, leftChild, rightChild;

    BinaryTree(int key, BinaryTree parent, BinaryTree leftChild, BinaryTree rightChild){
        this.key = key;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    BinaryTree(int key){
        this.key = key;
    }
    
    public boolean isRoot() {
    	return this.parent == null;
    }
    public void insertLeft(int key){
        this.leftChild = new BinaryTree(key, this, this.leftChild, null);
    }

    public void insertRight(int key){
        this.rightChild = new BinaryTree(key, this, null, this.rightChild);
    }

    public BinaryTree getLeftChild(){
        return this.leftChild;
    }

    public BinaryTree getRightChild(){
        return this.rightChild;
    }
    
}
