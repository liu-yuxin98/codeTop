public class ValidateBST {
    public boolean isValidBST(TreeNode root) {

        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }


    public boolean helper(TreeNode root, Long min, Long max){
    // make sure every node within root has value between (min,max)
    if(root==null){
        return true;
    }
    if(root.val<=min || root.val>=max){
        return false;
    }
    return (helper(root.left,min, Math.min(max,root.val)) && helper(root.right,Math.max(min,root.val),max));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        ValidateBST sol = new ValidateBST();
        sol.isValidBST(root);

    }

}
