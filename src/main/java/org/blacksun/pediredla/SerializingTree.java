package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializingTree {
    private static final String spliter = ",";
    private static final String NN = "X";

    public SerializingTree() {
    }

    public String serialize(SerializingTree.TreeNode root) {
        StringBuilder sb = new StringBuilder();
        this.buildString(root, sb);
        return sb.toString();
    }

    private void buildString(SerializingTree.TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X").append(",");
        } else {
            sb.append(node.val).append(",");
            this.buildString(node.left, sb);
            this.buildString(node.right, sb);
        }

    }

    public SerializingTree.TreeNode deserialize(String data) {
        LinkedList nodes = new LinkedList();
        nodes.addAll(Arrays.asList(data.split(",")));
        return this.buildTree(nodes);
    }

    private SerializingTree.TreeNode buildTree(Deque<String> nodes) {
        String val = (String) nodes.remove();
        if (val.equals("X")) {
            return null;
        } else {
            SerializingTree.TreeNode node = new SerializingTree.TreeNode(Integer.valueOf(val).intValue());
            node.left = this.buildTree(nodes);
            node.right = this.buildTree(nodes);
            return node;
        }
    }

    private class TreeNode {
        int val;
        SerializingTree.TreeNode left;
        SerializingTree.TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}

