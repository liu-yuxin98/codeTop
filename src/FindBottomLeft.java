import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeft {
    public int findBottomLeftValue(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(true) {
            TreeNode r = queue.removeFirst();
            if (r.left == null && r.right == null && queue.isEmpty()) {
                return r.val;
            }
            if (r.right != null) {
                queue.add(r.right);
            }
            if (r.left != null) {
                queue.add(r.left);
            }
        }

    }



}
