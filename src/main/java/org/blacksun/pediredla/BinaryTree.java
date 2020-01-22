package org.blacksun.pediredla;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pediredla on 11/24/16.
 */

public class BinaryTree {
    private BinaryTree.Node root;

    BinaryTree(int value) {
        this.root = new BinaryTree.Node(value);
    }

    public void addChild(int value) {
        BinaryTree.Node newNode = new BinaryTree.Node(value);
        if (this.root == null) {
            newNode = this.root;
        } else {
            BinaryTree.Node focusNode = this.root;

            BinaryTree.Node parent;
            label21:
            do {
                do {
                    parent = focusNode;
                    if (focusNode.value < value) {
                        focusNode = focusNode.rightChild;
                        continue label21;
                    }

                    focusNode = focusNode.leftChild;
                } while (focusNode != null);

                parent.leftChild = newNode;
                return;
            } while (focusNode != null);

            parent.rightChild = newNode;
        }
    }

    public void inOrderTraversal(BinaryTree.Node focusNode) {
        if (focusNode != null) {
            this.inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode.value);
            this.inOrderTraversal(focusNode.rightChild);
        }

    }

    public void preOrderTraversal(BinaryTree.Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.value);
            this.inOrderTraversal(focusNode.leftChild);
            this.inOrderTraversal(focusNode.rightChild);
        }

    }

    public void postOrderTraversal(BinaryTree.Node focusNode) {
        if (focusNode != null) {
            this.inOrderTraversal(focusNode.leftChild);
            this.inOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode.value);
        }

    }

    public BinaryTree.Node findNode(int key) {
        BinaryTree.Node focusNode = this.root;

        while (focusNode != null) {
            if (focusNode.value == key) {
                return focusNode;
            }

            if (key < focusNode.value) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
        }

        return null;
    }

    public boolean isValidBST(BinaryTree.Node root) {
        if (root != null) {
            boolean right = root.rightChild != null ? (root.rightChild.value > root.value ? this.isValidBST(root.rightChild) : false) : true;
            boolean left = root.leftChild != null ? (root.leftChild.value < root.value ? this.isValidBST(root.leftChild) : false) : true;
            return left && right;
        } else {
            return true;
        }
    }

    public List<List<Integer>> findLeaves(BinaryTree.Node root) {
        ArrayList ans = new ArrayList();
        if (root == null) {
            return ans;
        } else {
            this.dfs(ans, root, 0);
            return ans;
        }
    }

    private void dfs(List<List<Integer>> ans, BinaryTree.Node root, int level) {
        if (root != null) {
            if (root.leftChild == null && root.rightChild == null) {
                if (ans.size() <= level) {
                    ArrayList first = new ArrayList();
                    first.add(Integer.valueOf(root.value));
                    ans.add(first);
                } else {
                    ((List) ans.get(level)).add(Integer.valueOf(root.value));
                }

                ++level;
            }

            this.dfs(ans, root.leftChild, level);
            this.dfs(ans, root.rightChild, level);
            root.leftChild = null;
            root.rightChild = null;
        }
    }

    class Node {
        int value;
        BinaryTree.Node leftChild;
        BinaryTree.Node rightChild;

        Node(int value) {
            this.value = value;
        }
    }
}

