
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

    public boolean isBST(){
        boolean left = this.leftChild != null ? (this.leftChild.key < this.key ? this.leftChild.isBST() : false) : true;
        boolean right = this.rightChild != null ? (this.rightChild.key > this.key ? this.rightChild.isBST() : false) : true;
        return left && right;
    }
}