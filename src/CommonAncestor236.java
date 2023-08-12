public class CommonAncestor236 {


    public boolean containsNode(TreeNode root, TreeNode child){
        //check if root contains child
        if(root==null){
            return false;
        }
        if(root==child){
            return true;
        }
        return (containsNode(root.left,child) || containsNode(root.right,child));
    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(containsNode(root.left,p) && containsNode(root.left,q)){
//            return lowestCommonAncestor(root.left,p,q);
//        } else if(containsNode(root.right,p) && containsNode(root.right,q)){
//            return lowestCommonAncestor(root.right,p,q);
//        }else{
//            return root;
//        }
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null ){
            return root;
        }else if(right==null){
            return left;
        }else{
            return right;
        }
    }
}
