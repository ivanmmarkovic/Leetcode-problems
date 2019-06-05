
class Main {
	
	public static void main(String args[]) {
		
		BinaryTree bt = new BinaryTree(10, null, null, null);
		bt.insertLeft(30);
		bt.insertRight(30);
		
		bt.getLeftChild().insertLeft(100);
		bt.getLeftChild().insertRight(100);
		
		bt.getRightChild().insertLeft(100);
		bt.getRightChild().insertRight(100);
		
		System.out.println(isSymmetric(bt));
		
	}
	
	public static boolean isSymmetric(BinaryTree bt) {
		if(bt.leftChild == null && bt.rightChild == null)
			return true;
		else if(bt.leftChild != null && bt.rightChild != null) {
			if(bt.leftChild.key  == bt.rightChild.key)
				return isSymmetric(bt.leftChild) && isSymmetric(bt.rightChild);
			else
				return false;
		}
		else
			return false;
	}
}
