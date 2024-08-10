import java.util.Scanner;
import java.sql.*;
import java.io.*;

class DS1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        int ch;
        do {
            System.out.println("enter 1 for insert");
            System.out.println("enter 2 for inorder");
            System.out.println("enter 3 for preorder");
            System.out.println("enter 4 for postorder");
            System.out.println("enter 5 for minimum");
            System.out.println("enter 6 for maximum");
            System.out.println("enter 7 for search");
            System.out.println("enter 8 for exit");
            System.out.println("enter choices");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter the number to be inserted");
                    int data = sc.nextInt();
                    bst.insert(data);
                    break;
                case 2:
                    bst.inorder(bst.root);
                    break;
                case 3:
                    bst.preorder(bst.root);
                    break;
                case 4:
                    bst.postorder(bst.root);
                    break;
                case 5:
                    bst.minimum(bst.root);
                    break;
                case 6:
                    bst.maximum(bst.root);
                    break;
                case 7:
                    System.out.println("Enter Number To Search");
                    int s = sc.nextInt();
                    BST.Node x = bst.search(bst.root, s);
                    if (x != null) {
                        System.out.println("Value Found " + x.data);
                    } else {
                        System.out.println("Not Found " + s);
                    }
                    break;
                case 8:
                    System.out.println("Enter Number To Delete With Successor");
                    int ds = sc.nextInt();
                    bst.deleteSUC(ds);
                    bst.inorder(bst.root);
                    break;
                case 9:
                    System.out.println("Enter Number To Delete With Successor");
                    int dp = sc.nextInt();
                    bst.deletePRE(dp);
                    bst.inorder(bst.root);
                    break;
                case 10:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("enter valid choice");
                    break;
            }
        } while (ch != 8);
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
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            System.out.println(root.data + " is inserted");
            return root;
        }
        if (root.data > data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data + " ");
        }
    }

    void minimum(Node root) {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        System.out.println("Minimum = " + cur.data);
    }

    void maximum(Node root) {
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        System.out.println("Minimum = " + cur.data);
    }

    Node search(Node root, int d) {
        while (root != null && root.data != d) {
            if (d < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    // RIGHT SUB TREE
    void deleteSUC(int d) {
        root = deleterecSUC(root, d);
    }

    Node deleterecSUC(Node root, int d) {
        if (root == null) {
            return root;
        } else if (d < root.data) {
            root.left = deleterecSUC(root.left, d);
        } else if (d > root.data) {
            root.right = deleterecSUC(root.right, d);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minvalue(root.right);
            root.right = deleterecSUC(root.right, root.data);
        }
        return root;
    }

    int minvalue(Node root) {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }

    // RIGHT SUB TREE
    void deletePRE(int d) {
        root = deleterecPRE(root, d);
    }

    Node deleterecPRE(Node root, int d) {
        if (root == null) {
            return root;
        } else if (d < root.data) {
            root.left = deleterecPRE(root.left, d);
        } else if (d > root.data) {
            root.right = deleterecPRE(root.right, d);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = maxvalue(root.right);
            root.right = deleterecPRE(root.right, root.data);
        }
        return root;
    }

    int maxvalue(Node root) {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }
    /*
     * USING RECURSION MINIMUM MAXIMUM
     * void min(Node root){
     * if(root.left==null){
     * System.out.println(root.data);
     * }else{
     * min(root.left);
     * }
     * }
     * void max(Node root){
     * if(root.right==null){
     * System.out.println(root.data);
     * }else{
     * max(root.right);
     * }
     * }
     */
}