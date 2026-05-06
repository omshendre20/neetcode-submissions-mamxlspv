/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean getPath(TreeNode A, ArrayList<TreeNode> arr, TreeNode B){
        if(A==null){
            return false;
        }
        arr.add(A);
        if(A.val==B.val){
            return true;
        }
        if(getPath(A.left, arr, B) || getPath(A.right, arr, B)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> arr1 = new ArrayList<>();
        ArrayList<TreeNode> arr2 = new ArrayList<>();

        getPath(root, arr1, p);
        getPath(root, arr2, q);
        for(int i = 0;i<arr1.size();i++){
            System.out.print(arr1.get(i).val+" ");
        }
        System.out.println();
        for(int i = 0;i<arr2.size();i++){
            System.out.print(arr2.get(i).val+" ");
        }

        int size = Math.min(arr1.size(), arr2.size());
        System.out.println();
        TreeNode ans = null;
        for(int i = 0;i<size;i++){
            System.out.print(arr1.get(i).val+" "+arr2.get(i).val);
            if(arr1.get(i).val==arr2.get(i).val){
                ans = arr1.get(i);
            }
            System.out.println();
        }
        return ans;
    }
}