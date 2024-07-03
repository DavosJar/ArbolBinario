/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinario;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Alexis
 */
public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree arbol = new BinaryTree(897);
        
        System.out.println(arbol);
        arbol.addNode(578);
        arbol.addNode(900);
        arbol.addNode(901);
        arbol.addNode(902);
        arbol.addNode(450);
        arbol.addNode(430);
        arbol.addNode(455);
        arbol.addNode(300);
        arbol.addNode(992);
        arbol.addNode(982);
        System.out.println(arbol);
        arbol.printTreeByLevels();
        
        
        System.out.println("InOrder traversal:");
        arbol.traverseInOrder();

        System.out.println("PreOrder traversal:");
        arbol.traversePreOrder();

        System.out.println("PostOrder traversal:");
        arbol.traversePostOrder();
    }
    
    
}
