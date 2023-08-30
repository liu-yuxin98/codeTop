import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String path = "";
        Helper(root, res, path);
        return res;
    }


    public static void Helper(TreeNode root, List<String> res, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path += String.valueOf(root.val);
            res.add(path);
            return;
        }
        path += root.val + "->";
        Helper(root.left, res, path);
        Helper(root.right, res, path);

    }


}
