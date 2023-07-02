package HashAssignment;
class BST {
    int key;
    BST left, right;

    public BST(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    BST root;

    BinarySearchTree() {
        root = null;
    }
    BST insert(BST node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            node = new BST(key);
            return node;
        }

        // Otherwise, recur down the tree
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        return node;
    }
    BST search(BST root, int key) {
        if (root == null || root.key == key)
            return root;

        if (root.key < key)
            return search(root.right, key);


        return search(root.left, key);
    }
    int size(){
        return size(root);
    }
    int size(BST node){
        if(node==null)
            return 0;
        else
            return (size(node.left)+1+size(node.right));
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 56);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 22);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 95);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 65);
        tree.insert(tree.root, 67);
        tree.insert(tree.root, 63);
        tree.insert(tree.root, 11);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 16);

        System.out.println("The size of tree is "+tree.size());

       int key = 63;

        // Searching in a BST
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
    }
}
