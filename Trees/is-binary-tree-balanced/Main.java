
class Main {


    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree(20, null, null);
        bt.insertLeft(10);
        bt.getLeftChild().insertRight(17);
        bt.getLeftChild().insertRight(15);

        bt.insertRight(40);
        bt.insertRight(30);


        System.out.println(bt.isBalanced());


    }

}