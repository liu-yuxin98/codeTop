public class BSTmaxPathsum {

    public static int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath =  Integer.MIN_VALUE;
        maxGain(root);
        return maxPath;
    }

    public int maxGain(TreeNode root) {
        /* max gain we can get from root
         */
        if(root == null){
            return 0;
        }
        int maxGainLeft = Math.max(0,maxGain(root.left));
        int maxGainRight = Math.max(0,maxGain(root.right));
        // update maxPath, if we regard root as real root
        int currentMaxPath = root.val+maxGainLeft+maxGainRight;
        maxPath = Math.max(maxPath,currentMaxPath);
        return root.val + Math.max(maxGainLeft,maxGainRight);
    }

}
