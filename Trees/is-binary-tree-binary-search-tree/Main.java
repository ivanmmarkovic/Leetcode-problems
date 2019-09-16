
class Main {
	
	public static void main(String args[]) {
		
		
		
	}
	
	public static boolean isBST(BinaryTree bt) {
		return isBSTHelper(bt, null, null);
	}
	
	public static boolean isBSTHelper(BinaryTree bt, Integer min, Integer max) {
		if(bt == null)
			return true;
		if(min != null && bt.key <= min)
			return false;
		if(max != null && bt.key >= max)
			return false;
		if(!isBSTHelper(bt.leftChild, min, bt.key))
			return false;
		if(!isBSTHelper(bt.rightChild, bt.key, max))
			return false;
		return true;
	}
}
