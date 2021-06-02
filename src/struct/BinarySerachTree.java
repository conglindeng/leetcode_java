package struct;

import java.util.Comparator;

public class BinarySerachTree<T> {
    private TreeNode_T<T> root;
    private Comparator<? super T> compare;

    public BinarySerachTree() {
        this(null);
    }

    private int compare(T left, T right) {
        if (compare != null) {
            return compare.compare(left, right);
        } else {
            return ((Comparable) left).compareTo(right);
        }
    }

    public BinarySerachTree(Comparator<? super T> val) {
        root = null;
        compare = val;
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean contains(T x) {
        return contains(root, x);
    }

    public T findMax() {
        return findMax(root).val;
    }

    public T findMin() {
        return findMin(root).val;
    }

    public void insert(T x) {
        root = insert(root, x);
    }

    public void remove(T x) {
        remove(root, x);
    }

    private TreeNode_T<T> findMin(TreeNode_T<T> root) {
        TreeNode_T<T> cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    private TreeNode_T<T> findMax(TreeNode_T<T> root) {
        TreeNode_T<T> cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    private TreeNode_T<T> insert(TreeNode_T<T> root, T x) {
        if (root == null) {
            return new TreeNode_T<>(x, null, null);
        }
        int compare = compare(x, root.val);
        if (compare < 0) {
            root.left = insert(root.left, x);
        } else if (compare > 0) {
            root.right = insert(root.right, x);
        } else {

        }
        return root;
    }

    private TreeNode_T<T> remove(TreeNode_T<T> root, T x) {
        if (root == null) {
            return root;
        }
        int compare = compare(x, root.val);
        if (compare < 0) {
            root.left = remove(root.left, x);
        } else if (compare > 0) {
            root.right = remove(root.right, x);
        } else if (root.left != null && root.right != null) {
            root.val = findMin(root.left).val;
            root.right = remove(root.right, root.val);
        } else {
            return (root.left == null) ? root.right : root.left;
        }
        return root;
    }

    private boolean contains(TreeNode_T<T> root, T x) {
        TreeNode_T<T> cur = root;
        while (cur != null) {
            int compare = compare(x, cur.val);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }




    //ToDo:rotate
    private TreeNode_T<T> rotateChild(TreeNode_T<T> root){
        TreeNode_T<T> left = root.left;
        root.left=left.right;
        left.right=root;

        return left;
    }

}
