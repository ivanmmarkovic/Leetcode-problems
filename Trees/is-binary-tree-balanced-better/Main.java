
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


    public static int getHeight(BinaryTree bt) {
		int left = 0, right = 0;
		if(bt.leftChild != null)
			left += getHeight(bt.leftChild);
		if(bt.rightChild != null)
			right += getHeight(bt.rightChild);
		return Math.max(left, right) + 1;
	}


	public static boolean isBalanced(BinaryTree bt) {
		if(bt == null)
			return true;
		int left = bt.leftChild != null ? getHeight(bt.leftChild) : 0;
		int right = bt.rightChild != null ? getHeight(bt.rightChild) : 0;
		if(Math.abs(left - right) <= 1) {
			return isBalanced(bt.leftChild) && isBalanced(bt.rightChild);
		}
		else {
			return false;
		}
	}
	

}