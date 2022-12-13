package programs;


import java.util.ArrayList;
import java.util.List;

/**

 10
 /  \
 5    20
 /\    /\
 1  6  15 30
 \
 40
 \
 7
 Key 1 and 7 -> lowest common ancestor is 5
 Key 15 and 30 -> 20
 Key 15 and 20 -> 20
 Key 15 and 40 -> 20

 **/

/*
Follow the steps below to solve the problem:

Find a path from the root to n1 and store it in a vector or array.
Find a path from the root to n2 and store it in another vector or array.
Traverse both paths till the values in arrays are the same. Return the common element just before the mismatch.
 */

class FindAncestor{

    static Integer ancestorValue=null;
    static Integer k1Value=null;

    static Node root;
    private static List<Integer> path1 = new ArrayList<>();
    private static List<Integer> path2 = new ArrayList<>();

    static class Node{
        Integer value;
        Node right;
        Node left;

        Node(Integer value){
            this.value=value;
            right=null;
            left=null;
        }

    }

    public static void main(String[] arg){

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5) = "
                + findLCA(4, 5));
        System.out.println("LCA(4, 6) = "
                + findLCA(4, 6));
        System.out.println("LCA(3, 4) = "
                + findLCA(3, 4));
        System.out.println("LCA(2, 4) = "
                + findLCA(2, 4));
    }

    private static int  findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();

        return findLCAInternal(root, n1, n2);
    }

    private static int  findLCAInternal(Node root, int n1, int n2) {

        if(!findPath(root,n1,path1) || !findPath(root,n2,path2)){
            System.out.println((path1.size() > 0)
                    ? "n1 is present"
                    : "n1 is missing");
            System.out.println((path2.size() > 0)
                    ? "n2 is present"
                    : "n2 is missing");
            return -1;
        }

        int i;
        for(i=0;i<path1.size() && i < path2.size();i++){
            if(!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    private static boolean findPath(Node root, int n, List<Integer> path) {
       if(root==null)
           return false;
       path.add(root.value);

       if(root.value==n)
           return true;
       if(root.left!=null && findPath(root.left,n,path)){
           return true;
       }
        if(root.right!=null && findPath(root.right,n,path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    /**

     10
     /  \
     5    20
     /\    /\
     1  6  15 30
     \
     40
     \
     7
     Key 1 and 7 -> lowest common ancestor is 5
     Key 15 and 30 -> 20
     Key 15 and 20 -> 20
     Key 15 and 40 -> 20

     **/

//if k1 is present node then check for k2 = Ancestor=present
//if k1 < present and k2 > present = Ancestor=present
//if k1 < present then repeat step 1
//if k1> present then check for K1 in right and repeat step1
    public void printAncestor(Node node,int k1,int k2){
        if(node==null){
            System.out.println("nothing to check");
            return;
        }
        if(k1Value!=null){
            if(node.value == k2){
                return;
            }
        }
        if(node.value == k1){
            ancestorValue= node.value;
            k1Value= node.value;
            printAncestor(node.right,k1,k2);
        }

        if(node.value<k1 && node.value>k2 ){
            ancestorValue= node.value;
            return;
        }else if(node.value>k1){
            printAncestor(node.left,k1,k2);
        }else if(node.value<k1){
            printAncestor(node.right,k1,k2);
        }


    }

    public Integer findKey(Node node,int key){

        return null;
    }

}