// Construct a binary tree from preorder and in order traversal
import java.io.*;
import java.util.*;
    //TreeNode class
    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode()
        {}
        TreeNode(int val)
        {
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }    
class bt1
{
    
    private static int preindex;
    private static HashMap<Integer, Integer> map;
    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int left=0,right=inorder.length-1;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);
        preindex=0;
        return build(preorder,left,right);
    }

    private static TreeNode build(int[] preorder,int left,int right)
    {
        if(left>right)
        return null;
        TreeNode root=new TreeNode();
        root.val=preorder[preindex++];
        int index=map.get(root.val);
        root.left=build(preorder, left, index-1);
        root.right=build(preorder,index+1,right);
        return root;
    }
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int[] preorder=new int[n];
        int[] inorder= new int[n];
        for(int i=0;i<n;i++)
        {
            preorder[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            inorder[i]=sc.nextInt();
        }
        TreeNode root=buildTree(preorder,inorder);
        Queue<TreeNode> queue=new LinkedList<>();
        List<String> list=new ArrayList<>();
        if(root==null)
        {
            System.out.println(list);
            return;
        }

        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode current=queue.poll();
            if(current==null)
            {
                list.add("null");
                continue;
            }
            list.add(String.valueOf(current.val));
            if(current.left!= null)
            queue.add(current.left);
            if(current.right!= null)
            queue.add(current.right);
        }
        System.out.println(list);
    }
}