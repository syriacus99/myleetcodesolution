import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94BinaryTreeInorderTraversal {
      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursiveApproach(root,list);
        return list;
    }

    public static void recursiveApproach(TreeNode root,List<Integer> list){
          if(root!=null){
              recursiveApproach(root.left,list);
              list.add(root.val);
              recursiveApproach(root.right,list);
          }
    }

    public static List<Integer> inorderTraversalStack(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (!stack.empty()||currentNode!=null){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
     }

     //Morris Traversal space complexity: O(n)
    public static List<Integer> inorderTraversalMorris(TreeNode root){
          List<Integer> res = new ArrayList<>();
          TreeNode currentNode = root;
          TreeNode pre;
          while(currentNode!=null){
              if(currentNode.left==null){
                  res.add(currentNode.val);
                  currentNode = currentNode.right;
              }
              else {
                  pre = currentNode.left;
                  while(pre.right!=null){
                      pre = pre.right;
                  }
                  pre.right = currentNode;
                  TreeNode tmp = currentNode;
                  currentNode = currentNode.left;
                  tmp.left = null;
              }
          }
          return res;
    }
}
