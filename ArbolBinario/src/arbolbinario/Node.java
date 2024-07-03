/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinario;

/**
 *
 * @author Alexis
 */
public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }
    
    public void addNode(int value) {
        if (value < this.value) {
            if (this.leftChild == null) {
                this.leftChild = new Node(value);
            } else {
                this.leftChild.addNode(value);
            }
        } else if (value > this.value) {
            if (this.rightChild == null) {
                this.rightChild = new Node(value);
            } else {
                this.rightChild.addNode(value);
            }
        }
        // Si el valor es igual, no se hace nada, se ignora el nodo duplicado.
    }
    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
    @Override
    public String toString() {
        return "Nodo{" + "Valor = " + value + '}';
    }
    
    
}
