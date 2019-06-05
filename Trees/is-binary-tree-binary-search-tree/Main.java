
class Main {
	
	public static void main(String args[]) {
		
		
		
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
