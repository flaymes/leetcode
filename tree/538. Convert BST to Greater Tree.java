/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        
        inOrder(root);
        order2(root,0);
        return root;
        
    }
    
    public void inOrder(TreeNode root){
        if(root==null) return;
        
        inOrder(root.right);
        root.val=root.val+sum;
        sum=root.val;
        inOrder(root.left);
        
    }

    public int order2(TreeNode root, int val){
        if(root==null) return val;

        int right=order2(root.right, val);
        int left=order2(root.left, root.val+right);
        root.val=root.val+right;
        return left;
    }
}