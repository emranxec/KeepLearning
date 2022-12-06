package programs;


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


class FindAncestor{

    static Integer ancestorValue=null;
    static Integer k1Value=null;

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