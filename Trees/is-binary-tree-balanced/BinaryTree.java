
class BinaryTree {

    int key;
    BinaryTree leftChild, rightChild;

    BinaryTree(int key, BinaryTree leftChild, BinaryTree rightChild){
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void insertLeft(int key){
        this.leftChild = new BinaryTree(key, this.leftChild, null);
    }

    public void insertRight(int key){
        this.rightChild = new BinaryTree(key, null, this.rightChild);
    }

    public BinaryTree getLeftChild(){
        return this.leftChild;
    }

    public BinaryTree getRightChild(){
        return this.rightChild;
    }

    public int subtreeHeight(){
        int leftHeight = 0, rightHeight = 0;
        if(this.leftChild != null)
            leftHeight += this.leftChild.subtreeHeight();
        if(this.rightChild != null)
            rightHeight += this.rightChild.subtreeHeight();
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(){
        if(Math.abs((this.leftChild != null ? this.leftChild.subtreeHeight() : 0) - (this.rightChild != null ? this.rightChild.subtreeHeight() : 0)) <= 1){
            return (this.leftChild != null ? this.leftChild.isBalanced() : true) && (this.rightChild != null ? this.rightChild.isBalanced() : true);
        }
        else {
            return false;
        }
    }
}