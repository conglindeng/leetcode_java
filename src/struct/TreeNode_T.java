package struct;

public class TreeNode_T<T> {
    public T val;
    public TreeNode_T<T> left;
    public TreeNode_T<T> right;

    public TreeNode_T(T val) {
        this.val = val;
    }

    public TreeNode_T(T val, TreeNode_T<T> left, TreeNode_T<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
