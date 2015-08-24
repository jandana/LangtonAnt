
package cl.jandana.langtonant.logic;

/**
 *
 * @author Javier
 */
public class Board {

    private int columnas, filas;
    private Node[][] matrizNodo;

    public Board(int columnas, int filas) {
        this.columnas = columnas;
        this.filas = filas;
        matrizNodo = new Node[columnas][filas];
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                matrizNodo[x][y] = new Node();
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrizNodo.length; i++) {
            for (int j = 0; j < matrizNodo.length; j++) {
                System.out.print("Vector: " + matrizNodo[i][j].getVector().elementAt(0).toString());
                System.out.print(" Vector: " + matrizNodo[i][j].getVector().elementAt(1).toString());
                System.out.print(" Vector: " + matrizNodo[i][j].getVector().elementAt(2).toString());
                System.out.println("");
            }
            System.out.println("");
        }

    }

    public Node getNodo(int x, int y) {
        return matrizNodo[x][y];
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public Node[][] getMatriz() {
        return matrizNodo;
    }

    public void setMatriz(Node[][] matriz) {
        this.matrizNodo = matriz;
    }
}
