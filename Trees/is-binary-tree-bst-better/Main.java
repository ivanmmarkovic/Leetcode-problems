
class Main {


    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree(20, null, null);
        bt.insertLeft(10);
        bt.getLeftChild().insertRight(17);
        bt.getLeftChild().insertRight(15);

        bt.insertRight(35);
        bt.getRightChild().insertLeft(40);
        bt.insertRight(130);


        System.out.println(isBST(bt));


    }


    public static boolean isBst(BinaryTree bt) {
        boolean left = false, right = false;
        
        if(bt.leftChild == null)
            left = true;
        if(bt.leftChild != null) {
            if(bt.leftChild.key < bt.key)
                left = isBst(bt.leftChild);
            else
                left = false;
        }
        
        if(bt.rightChild == null)
            right = true;
        if(bt.rightChild != null) {
            if(bt.rightChild.key > bt.key)
                right = isBst(bt.rightChild);
            else
                right = false;
        }
        
        return left && right;
    }
    

}