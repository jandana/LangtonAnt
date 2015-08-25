package cl.jandana.langtonant.logic;

/**
 *
 * @author Javier
 */
public class Board {

    private int columnas, filas;
    private Node[][] NodeBoard;

    public Board(int columnas, int filas) {
        this.columnas = columnas;
        this.filas = filas;
        NodeBoard = new Node[columnas][filas];
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                NodeBoard[x][y] = new Node();
                NodeBoard[x][y].setX(x);
                NodeBoard[x][y].setY(y);

            }
        }
    }

    public void print() {
        for (int i = 0; i < NodeBoard.length; i++) {
            for (int j = 0; j < NodeBoard.length; j++) {
                System.out.print("Vector: " + NodeBoard[i][j].getVector().elementAt(0).toString());
                System.out.print(" Vector: " + NodeBoard[i][j].getVector().elementAt(1).toString());
                System.out.print(" Vector: " + NodeBoard[i][j].getVector().elementAt(2).toString());
                System.out.println("");
            }
            System.out.println("");
        }

    }

    public Node getNodo(int x, int y) {
        return NodeBoard[x][y];
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

    public Node[][] getNodeBoard() {
        return NodeBoard;
    }

    public void setNodeBoard(Node[][] NodeBoard) {
        this.NodeBoard = NodeBoard;
    }

}
