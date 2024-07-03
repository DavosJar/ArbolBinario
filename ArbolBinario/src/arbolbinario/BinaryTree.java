/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinario;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alexis
 */
public class BinaryTree {
        private Node root;
    private int height;
    
    public BinaryTree(int value) {
        this.root = new Node(value);
        this.height = 1;
    }

    public void addNode(int value) {
        if (root != null) {
            root.addNode(value);
            height = calculateHeight(root);
        }
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.getLeftChild());
        int rightHeight = calculateHeight(node.getRightChild());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getHeight() {
        return height;
    }


    public void printTreeByLevels() {
        if (root == null) {
            return;
        }
        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Node currentNode = currentLevel.poll();
            System.out.print(currentNode.getValue() + " ");

            if (currentNode.getLeftChild() != null) {
                nextLevel.add(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                nextLevel.add(currentNode.getRightChild());
            }

            if (currentLevel.isEmpty()) {
                System.out.println();
                Queue<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
    public void traverseInOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRightChild());
        }
    }

    public void traversePreOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void traversePostOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }
    @Override
    public String toString() {
        return "BinaryTree{" + "root=" + root + ", height=" + height + '}';
    }
}
