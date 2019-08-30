public class Main {

    public static void main(String[] args) {
        

    }
    
    public static BinaryTree commonAncestor(BinaryTree bt1, BinaryTree bt2) {
        BinaryTree tmp = bt2;
        boolean found = false;
        while(bt1 != null && !found) {
            while(tmp != null && !found) {
                if(bt1 == tmp)
                    found = true;
                else
                    tmp = tmp.parent;
            }
            if(!found) {
                bt1 = bt1.parent;
                tmp = bt2;
            }
        }
        if(found)
            return bt1; 
        else
            return null;
    }

}
