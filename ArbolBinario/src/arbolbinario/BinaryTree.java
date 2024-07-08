



package arbolbinario;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree {
    private Node root;
    private int height;

    public BinaryTree(int value) {
        this.root = new Node(value);
        this.height = 1;
    }

    public boolean contains(int value) {
        return containsValue(root, value);
    }

    private boolean containsValue(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        return containsValue(node.getLeftChild(), value) || containsValue(node.getRightChild(), value);
    }

    public Node getPadre(int valor) {
        return encontrarPadre(root, valor);
    }

    private Node encontrarPadre(Node current, int valor) {
        if (current == null) {
            return null;
        }

        if ((current.getLeftChild() != null && current.getLeftChild().getValue() == valor) ||
            (current.getRightChild() != null && current.getRightChild().getValue() == valor)) {
            return current;
        }

        Node padre = encontrarPadre(current.getLeftChild(), valor);
        if (padre == null) {
            padre = encontrarPadre(current.getRightChild(), valor);
        }

        return padre;
    }

    public void addNode(int value) {
        if (root != null) {
            root.addNode(value);
            height = calculateHeight(root);
        }
    }

    public void deleteNode(int value) {
        root = delete(root, value);
        if (root != null) {
            height = calculateHeight(root);
        } else {
            height = 0; // El árbol está vacío
        }
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.setLeftChild(delete(node.getLeftChild(), value));
        } else if (value > node.getValue()) {
            node.setRightChild(delete(node.getRightChild(), value));
        } else {
            // Caso 1 y Caso 2: Nodo con 0 o 1 hijo
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            // Caso 3: Nodo con 2 hijos
            node.setValue(findMin(node.getRightChild()).getValue());
            node.setRightChild(delete(node.getRightChild(), node.getValue()));
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    public Node getRoot() {
        return root;
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

    private void delay() {
        try {
            Thread.sleep(300); // Delay fijo de 300ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void traverseInOrder(Consumer<Node> action) {
        inOrder(root, action);
    }

    private void inOrder(Node node, Consumer<Node> action) {
        if (node != null) {
            inOrder(node.getLeftChild(), action);
            action.accept(node);
            delay(); // Delay de 300ms entre cada acción
            inOrder(node.getRightChild(), action);
        }
    }

    public void traversePreOrder(Consumer<Node> action) {
        preOrder(root, action);
    }

    private void preOrder(Node node, Consumer<Node> action) {
        if (node != null) {
            action.accept(node);
            delay(); // Delay de 300ms entre cada acción
            preOrder(node.getLeftChild(), action);
            preOrder(node.getRightChild(), action);
        }
    }

    public void traversePostOrder(Consumer<Node> action) {
        postOrder(root, action);
    }

    private void postOrder(Node node, Consumer<Node> action) {
        if (node != null) {
            postOrder(node.getLeftChild(), action);
            postOrder(node.getRightChild(), action);
            action.accept(node);
            delay(); // Delay de 300ms entre cada acción
        }
    }

    // Métodos adicionales para devolver cadenas de los recorridos

    public String traverseInOrderString() {
        StringBuilder sb = new StringBuilder();
        traverseInOrder(node -> {
            sb.append(node.getValue()).append(" ");
        });
        return sb.toString().trim();
    }

    public String traversePreOrderString() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(node -> {
            sb.append(node.getValue()).append(" ");
        });
        return sb.toString().trim();
    }

    public String traversePostOrderString() {
        StringBuilder sb = new StringBuilder();
        traversePostOrder(node -> {
            sb.append(node.getValue()).append(" ");
        });
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                ", height=" + height +
                '}';
    }
}