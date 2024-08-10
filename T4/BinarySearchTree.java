import java.util.Scanner;

class BinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST ob = new BST();
        while (true) {
            System.out.println("==============================================");
            System.out.println("1.Insertion Of Element.");
            System.out.println("2.Traversal Of [InOrder, PreOrder, PostOrder].");
            System.out.println("3.Find Min Element(Recursion).");
            System.out.println("4.Find Min Element(Without Recursion).");
            System.out.println("5.Find Max Element(Recursion).");
            System.out.println("6.Find Max Element(Without Recursion).");
            System.out.println("==============================================");

            System.out.print("Enter Your Choice :- ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Number :- ");
                    int n = sc.nextInt();
                    ob.insert(n);
                    break;

                case 2:
                    System.out.print("Inorder :- ");
                    ob.inOrder(ob.root);
                    System.out.println();
                    System.out.print("Preorder :- ");
                    ob.preOrder(ob.root);
                    System.out.println();
                    System.out.print("Postorder :- ");
                    ob.postOrder(ob.root);
                    System.out.println();
                    break;

                case 3:
                    ob.findMinRec(ob.root);
                    break;

                case 4:
                    ob.findMin(ob.root);
                    break;

                case 5:
                    ob.findMaxRec(ob.root);
                    break;

                case 6:
                    ob.findMax(ob.root);
                    break;
                default:
                    System.out.println("Invalid Choice! Please Try Again Between <1-5>.");
                    break;
            }
        }
    }
}

class BST {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    Node root = null;

    void insert(int data) {
        root = insertRec(root, data);
        System.out.println("Data Is Inserted.- " + data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // recursion....
    void findMinRec(Node root) {
        if (root.left == null) {
            System.out.println("Minimum Element Is:- " + root.data);
        } else {
            findMinRec(root.left);
        }
    }

    void findMaxRec(Node root) {
        if (root.right == null) {
            System.out.println("Maximun Element Is:- " + root.data);
        } else {
            findMaxRec(root.right);
        }
    }

    // Without recursion...
    void findMin(Node root) {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        System.out.println("Minimum Element is :- " + cur.data);
    }

    void findMax(Node root) {
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        System.out.println("Maximum Element is :- " + cur.data);
    }
}