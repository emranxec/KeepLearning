package master;

public class NodeTree {

    public static void main(String[] args) throws Exception {

        BinaryTree binaryTree=new BinaryTree();
        binaryTree.insert(9);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(20);
        binaryTree.insert(170);
        binaryTree.insert(180);
        binaryTree.insert(10);
        binaryTree.insert(17);
        binaryTree.insert(15);
        BinaryNode found=binaryTree.find(15);
        binaryTree.remove(1);

        System.out.println(binaryTree);
        System.out.println(found);
    }


}

class BinaryNode {

    BinaryNode Parent;
    Integer userObject;
    BinaryNode left;
    BinaryNode right;

    BinaryNode(Integer value){
        userObject=value;
        left=null;
        right=null;
        Parent=null;
    }

    public BinaryNode getParent() {
        return Parent;
    }

    public void setParent(BinaryNode parent) {
        Parent = parent;
    }

    @Override
    public String toString() {
        return "node{" +
                "userObject=" + userObject +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinaryTree {
    BinaryNode root;
    BinaryTree(){
        root=null;
    }

    BinaryTree insert(Integer value){
        BinaryNode newBinaryNode=null;
        if(root==null){
            root = new BinaryNode(value);
        }
        else{
             newBinaryNode =new BinaryNode(value);
             insertChild(newBinaryNode, root,newBinaryNode.userObject>root.userObject);
        }

        return this;
    }

    private void insertChild(BinaryNode newBinaryNode, BinaryNode tempRoot, Boolean isbig) {
            if (isbig) {
                if(tempRoot.right!=null) {
                    insertChild(newBinaryNode, tempRoot.right, newBinaryNode.userObject>tempRoot.right.userObject);
                }else{
                    tempRoot.right= newBinaryNode;
                }
            }
            else {
                if(tempRoot.left!=null) {
                    insertChild(newBinaryNode, tempRoot.left, newBinaryNode.userObject>tempRoot.left.userObject);
                }else{
                    tempRoot.left= newBinaryNode;
                }
            }
        }


    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public BinaryNode find(int i) {
        if(root==null){
            return null;
        }
        if(root.userObject==i){
            return root;
        }
        return findBinaryNode(root,i);
    }

    public void remove(int i) throws Exception {
        BinaryNode notToRemove=findBinaryNode(root,i);
        if(notToRemove==null){
            throw new Exception("Item not notToRemove in the tree");
        }
      /*  if(notToRemove.left==null && notToRemove.right==null ){
            if(notToRemove.)
        }*/
        // if node is a leaf
        //if not has two children
        //if not has one child

    }

    private BinaryNode findBinaryNode(BinaryNode tempRoot,int i) {
        if(i > tempRoot.userObject) {
            if (tempRoot.right == null) {
                return null;
            }
            if (i == tempRoot.right.userObject) {
                return tempRoot.right;
            } else {
                return findBinaryNode(tempRoot.right, i);
            }
        }
        if(i < tempRoot.userObject) {
            if (tempRoot.left == null) {
                return null;
            }
            if (i == tempRoot.left.userObject) {
                return tempRoot.left;
            } else {
                return findBinaryNode(tempRoot.left, i);
            }
        }
        return null;
    }
}
