public class ConvertBSTtoGreater {
    public TreeNode convertBST(TreeNode root) {
        dfs(root,0);
        return root;
    }

    public int dfs(TreeNode root, int val){
        // root.right -> root->root.left
        if(root ==null){
            return 0;
        }
        if(root.right!=null){
            val = dfs(root.right,val);
        }
        val += root.val;
        root.val = val;
        if(root.left!=null){
            val = dfs(root.left,val);
        }
        return val;
    }


}
