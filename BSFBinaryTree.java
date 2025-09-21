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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result= new ArrayList<>();
        if(root==null)
        return result;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                root=queue.peek();
                if(root.left!=null) 
                queue.offer(root.left);
                if(root.right!=null) 
                queue.offer(root.right);
                list.add(queue.poll().val);
            }
            result.add(list);
        }
        return result;
    }
}