
/*

404. Sum of Left Leaves
Easy

https://leetcode.com/problems/sum-of-left-leaves

Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
Memory Usage: 39.5 MB, less than 5.02% of Java online submissions for Sum of Left Leaves.

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

Accepted
178,019
Submissions
350,267

*/

class  SumOfLeftLeaves  {
    public  class  TreeNode  {
        int  val;
        TreeNode  left;
        TreeNode  right;
        TreeNode()  {}
        TreeNode(int  val)  {  this.val  =  val;  }
        TreeNode(int  val,  TreeNode  left,  TreeNode  right)  {
            this.val  =  val;
            this.left  =  left;
            this.right  =  right;
        }
    }

    public  int  sumOfLeftLeaves(TreeNode  root)  {
        return  helper(root,  false);
    }
  
    private  int  helper(TreeNode  node,  boolean  isLeft){
        if(node  ==  null)
            return  0;
        if(node.left  ==  null  &&  node.right  ==  null  &&  isLeft)
            return  node.val;
        int  sum  =  0;
        sum  +=  helper(node.left,  true);
        sum  +=  helper(node.right,  false);
        return  sum;
    }
}