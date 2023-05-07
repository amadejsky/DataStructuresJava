package lib;

public class TreeBST<E extends Comparable<E>> {
    private TreeBSTNode<E> root;

    public TreeBST() {
        root = null;
    }

    //wstawia nowy element do drzewa
    public boolean insert(E data){
        if( root != null ){
            return insert_aux(data);
        } else {
            root = new TreeBSTNode<>(data);
            return true;
        }
    }

    private boolean insert_aux(E data) {
        TreeBSTNode<E> visitingNode = root;
        while( visitingNode.getData().compareTo(data) != 0 ){
            if( visitingNode.getData().compareTo(data) < 0 ){
                //go to right
                if( visitingNode.getRight() == null ){
                    visitingNode.setRight( new TreeBSTNode<>(data) );
                    return true;
                } else {
                    visitingNode = visitingNode.getRight();
                }
            } else {
                //go to left
                if( visitingNode.getLeft() == null ){
                    visitingNode.setLeft( new TreeBSTNode<>(data) );
                    return true;
                } else {
                    visitingNode = visitingNode.getLeft();
                }
            }
        }
        return false;
    }

    //usuwa z drzewa element podany jako parametr
    public boolean delete(E data){
        if( root == null )
            return false;

        //1.
        TreeBSTNode<E> parentNode = root;
        TreeBSTNode<E> deletingNode = root;
        while ( deletingNode.getData().compareTo(data) != 0 ){
            parentNode = deletingNode;
            if( deletingNode.getData().compareTo(data) < 0 ){
                //go right
                if( deletingNode.getRight() == null )
                    return false;
                else
                    deletingNode = deletingNode.getRight();
            } else {
                //go left
                if( deletingNode.getLeft() == null )
                    return false;
                else
                    deletingNode = deletingNode.getLeft();
            }
        }

        //2.
        if( deletingNode.getLeft() == null && deletingNode.getRight() == null ){
            if( deletingNode == root ){
                root = null;
            } else {
                if( parentNode.getLeft() == deletingNode ){
                    parentNode.setLeft(null);
                } else {
                    parentNode.setRight(null);
                }
            }
        } else if ( deletingNode.getLeft() != null && deletingNode.getRight() == null ) {
            TreeBSTNode<E> child = deletingNode.getLeft();
            deletingNode.setData( child.getData() );
            deletingNode.setLeft( child.getLeft() );
            deletingNode.setRight( child.getRight() );
            child = null;
        } else if ( deletingNode.getLeft() == null && deletingNode.getRight() != null ) {
            TreeBSTNode<E> child = deletingNode.getRight();
            deletingNode.setData( child.getData() );
            deletingNode.setLeft( child.getLeft() );
            deletingNode.setRight( child.getRight() );
            child = null;
        } else {
            //oba poddrzewa:

            //znajdujemy węzeł z którego skopiujemy dane do deletingNode:
            parentNode = deletingNode;
            TreeBSTNode<E> descendantNode = deletingNode.getLeft();
            while( descendantNode.getRight() != null ){
                parentNode = descendantNode;
                descendantNode = descendantNode.getRight();
            }
            //kopiujemy daną data
            deletingNode.setData(descendantNode.getData());


            if( descendantNode.getLeft() == null && descendantNode.getRight() == null ){
                //węzeł jest liściem:
                if( parentNode.getLeft() == descendantNode ){
                    parentNode.setLeft(null);
                } else {
                    parentNode.setRight(null);
                }
            } else {
                //węzeł ma lewe poddrzewo
                TreeBSTNode<E> child = descendantNode.getLeft();
                descendantNode.setData(child.getData());
                descendantNode.setLeft(child.getLeft());
                descendantNode.setRight(child.getRight());
                child = null;
            }
        }
        return true;
    }

    public void preorder() {
        if( root != null )
            preorder_aux(root);
    }

    private void preorder_aux(TreeBSTNode<E> node) {
        System.out.println(node.getData());
        if( node.getLeft() != null )
            preorder_aux(node.getLeft());
        if( node.getRight() != null )
            preorder_aux(node.getRight());
    }

    //Zad1. a)
    public int checkHeight(){
        if( root == null )
            return -1;
        else
            return checkHeight_aux(root);
    }
    private int checkHeight_aux(TreeBSTNode<E> node){
        if( node.getLeft() == null && node.getRight() == null  ){
            return 0;
        } else if ( node.getLeft() != null && node.getRight() == null ) {
            return 1+checkHeight_aux(node.getLeft());
        } else if ( node.getLeft() == null && node.getRight() != null ) {
            return 1+checkHeight_aux(node.getRight());
        } else { // node.getLeft() != null && node.getRight() != null
            // gdzie jest dłuższa ścieżka? Czy po lewej czy po prawej?
            int heightOnLeft = checkHeight_aux(node.getLeft());
            int heightOnRight = checkHeight_aux(node.getRight());
            if( heightOnLeft > heightOnRight )
                return heightOnLeft + 1;
            else
                return heightOnRight + 1;
        }
    }

    //zad1.b)
    public int countSingleSubtree(){
        if( root == null )
            return 0;
        else
            return countSingleSubtree_aux(root);
    }
    private int countSingleSubtree_aux(TreeBSTNode<E> node){
        if( node.getLeft() == null && node.getRight() == null  ){
            return 0;
        } else if ( node.getLeft() != null && node.getRight() == null ) {
            return 1+countSingleSubtree_aux(node.getLeft());
        } else if ( node.getLeft() == null && node.getRight() != null ) {
            return 1+countSingleSubtree_aux(node.getRight());
        } else { // node.getLeft() != null && node.getRight() != null
            return countSingleSubtree_aux(node.getLeft())+countSingleSubtree_aux(node.getRight());
        }
    }
    //zad1 c)
    public int countLeaves(){
        if( root == null )
            return 0;
        else
            return countLeaves_aux(root);
    }
    private int countLeaves_aux(TreeBSTNode<E> node){
        if( node.getLeft() == null && node.getRight() == null  )
            return 1;
        int onLeft = node.getLeft() != null ? countLeaves_aux(node.getLeft()) : 0;
        int onRight = node.getRight() != null ? countLeaves_aux(node.getRight()) : 0;
        return onLeft + onRight;
    }
    //zad1 d)
    public int countSymetryHeightNodes(){
        if( root == null )
            return 0;
        else
            return countSymetryHeightNodes_aux(root);
    }
    private int countSymetryHeightNodes_aux(TreeBSTNode<E> node){
        int onLeft = node.getLeft() != null ? checkHeight_aux(node.getLeft()) : 0;
        int onRight = node.getRight() != null ? checkHeight_aux(node.getRight()) : 0;

        return (node.getLeft() != null ? countSymetryHeightNodes_aux(node.getLeft()) : 0) +
                (node.getRight() != null ? countSymetryHeightNodes_aux(node.getRight()) : 0) +
                 (onLeft == onRight ? 1 : 0 );
    }
    //zad1 e)
    public int countTreeElements(){
        if( root == null )
            return 0;
        else
            return countTreeElements_aux(root);
    }
    private int countTreeElements_aux(TreeBSTNode<E> node){
        if( node.getLeft() == null && node.getRight() == null  ){
            return 1;
        } else if ( node.getLeft() != null && node.getRight() == null ) {
            return 1+countTreeElements_aux(node.getLeft());
        } else if ( node.getLeft() == null && node.getRight() != null ) {
            return 1+countTreeElements_aux(node.getRight());
        } else { // node.getLeft() != null && node.getRight() != null
            return 1+countTreeElements_aux(node.getLeft())+countTreeElements_aux(node.getRight());
        }
    }

    //zad2. a) i b)
    public void inorder() {
        if( root != null )
            inorder_aux(root);
    }

    private void inorder_aux(TreeBSTNode<E> node) {
        if( node.getLeft() != null )
            inorder_aux(node.getLeft());
        System.out.println(node.getData());
        if( node.getRight() != null )
            inorder_aux(node.getRight());
    }

    public void postorder() {
        if( root != null )
            postorder_aux(root);
    }

    private void postorder_aux(TreeBSTNode<E> node) {
        if( node.getLeft() != null )
            postorder_aux(node.getLeft());
        if( node.getRight() != null )
            postorder_aux(node.getRight());
        System.out.println(node.getData());
    }
    //zad2 c)
    //wyszukuje element data w drzewie
    public boolean find(E data){
        if( root == null )
            return false;

        TreeBSTNode<E> visitingNode = root;
        while( visitingNode.getData().compareTo(data) != 0 ){
            if( visitingNode.getData().compareTo(data) < 0 ){
                //go right
                if( visitingNode.getRight() == null ){
                    return false;
                } else {
                    visitingNode = visitingNode.getRight();
                }
            } else {
                //go left
                if( visitingNode.getLeft() == null ){
                    return false;
                } else {
                    visitingNode = visitingNode.getLeft();
                }
            }
        }
        return true;
    }
    //zad3
    public TreeBSTNode<E> findReference(E data){
        if( root == null )
            return null;

        TreeBSTNode<E> visitingNode = root;
        while( visitingNode.getData().compareTo(data) != 0 ){
            if( visitingNode.getData().compareTo(data) < 0 ){
                //go right
                if( visitingNode.getRight() == null ){
                    return null;
                } else {
                    visitingNode = visitingNode.getRight();
                }
            } else {
                //go left
                if( visitingNode.getLeft() == null ){
                    return null;
                } else {
                    visitingNode = visitingNode.getLeft();
                }
            }
        }
        return visitingNode;
    }

    //zad4 b)
    public String printPath(TreeBSTNode<E> A){
        StringBuilder str = new StringBuilder();
        TreeBSTNode<E> visitingNode = root;
        while( visitingNode != null ){
            str.append(visitingNode.toString()).append(",");
            if( visitingNode.getData().compareTo(A.getData()) == 0 ){
                break;
            } else if ( visitingNode.getData().compareTo(A.getData()) < 0 ){
                //go right
                visitingNode = visitingNode.getRight();
            } else {
                //go left
                visitingNode = visitingNode.getLeft();
            }
        }
        if( visitingNode == null ){
            str.append("ERROR");
        }

        return str.toString();

    }

    //zad4.a)
    public static <E extends Comparable<E>> boolean checkPathExistence(TreeBSTNode<E> A,TreeBSTNode<E> B){
        final boolean flag = false;
        if( A == null || B == null )
            return false;
        if( A.getData().compareTo(B.getData()) == 0 ){
            return true;
        } else if ( A.getData().compareTo(B.getData()) < 0 ){
            TreeBSTNode<E> startingNode = B;
            while( startingNode != null ){
                if( startingNode.getData().compareTo(A.getData()) == 0 ){
                    return true;
                } else if (startingNode.getData().compareTo(A.getData()) < 0) {
                    startingNode = startingNode.getRight();
                } else {
                    startingNode = startingNode.getLeft();
                }
            }
        } else {
            TreeBSTNode<E> startingNode = A;
            while( startingNode != null ){
                if( startingNode.getData().compareTo(B.getData()) == 0 ){
                    return true;
                } else if (startingNode.getData().compareTo(B.getData()) < 0) {
                    startingNode = startingNode.getRight();
                } else {
                    startingNode = startingNode.getLeft();
                }
            }
        }
        return false;
    }

}
