package sort;

/**
 * How would you convert a sorted integer array to height balanced Binary
 * Search Tree? How would you calculate depth of a binary tree?
 *
 */
public class SortedArrayToBST {
    static class Node {
        Node left;
        Node right;
        int data;
    }
    Node sortedArrayToBST(int arr[], int n) {
        return sortedArrayToBST(arr, 0, n - 1);
    }

    Node sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2; // same as (start+end)/2, but it avoids overflow.
        Node node = new Node();
        node.data = arr[mid];
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }
    public static int height(Node node){
        if(node == null){
            return 0;
        }
        int hLeft = height(node.left);
        int hRight = height(node.right);
        int height = 1+Math.max(hLeft, hRight);
        return height;
    }
    static int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
    public static void main(String[] args) {
        int[] sortedArray = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        SortedArrayToBST test = new SortedArrayToBST();
        Node node = test.sortedArrayToBST(sortedArray, 11);
        //printTree(node);
        System.out.println(height(node));
        System.out.println("factorial of node height :" + factorial(height(node)));
    }
}
