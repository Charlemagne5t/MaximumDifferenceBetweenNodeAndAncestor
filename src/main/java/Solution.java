import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int maxDif = 0;
    public int maxAncestorDiff(TreeNode root) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        dfs(root, max, min);
        return maxDif;
    }
    private void dfs(TreeNode root, PriorityQueue<Integer> max ,PriorityQueue<Integer> min){
        if(root == null){
            return;
        }
        max.offer(root.val);
        min.offer(root.val);
        maxDif = Math.max(maxDif, max.peek() - min.peek());
        if(root.left != null){
            dfs(root.left, max, min);
        }
        if(root.right != null){
            dfs(root.right, max, min);
        }
        max.remove(root.val);
        min.remove(root.val);
    }
}
