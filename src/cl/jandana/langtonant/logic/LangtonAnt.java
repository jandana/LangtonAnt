/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.jandana.langtonant.logic;

import cl.jandana.langtonant.util.DynamicPanel;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class LangtonAnt implements Runnable {

    private boolean running;
    private final DynamicPanel panel;
    private final Board board;
    private Thread runner;
    private int x;
    private int y;
    private int direction;

    public LangtonAnt(Board board, DynamicPanel panel) {
        this.board = board;
        this.panel = panel;
        x = board.getFilas() / 2;
        y = board.getColumnas() / 2;
        direction = 0;
    }

    public void start() {
        if (board != null) {
            runner = new Thread(this);
            runner.setPriority(Thread.MIN_PRIORITY);
            running = true;
            runner.start();
        }
    }

    @Override
    public void run() {

        while (running) {
            int x = this.x;
            int y = this.y;
            updatePosition();
            panel.render(board, x, y);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(LangtonAnt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void stop() {
        if (runner != null) {
            running = false;
            while (runner.isAlive()) {
            }
        }
    }

    private void updatePosition() {
        Vector vWhite = new Vector();
        vWhite.addElement((double) 1);
        vWhite.addElement((double) 1);
        vWhite.addElement((double) 1);
        Vector vBlack = new Vector();
        vBlack.addElement((double) 0);
        vBlack.addElement((double) 0);
        vBlack.addElement((double) 0);
        // Si esta en un cuadrado blanco
        if (board.getNodo(x, y).getVector().equals(vWhite)) {
            // Cambia  a negro
            board.getNodeBoard()[x][y] = new Node(vBlack);
            // Gira 90 grados a la derecha
            turnRight();
            // Avanza un cuadrado
            Forward();
        }
        // Si esta en un cuadrado negro
        if (board.getNodo(x, y).getVector().equals(vBlack)) {
            // Cambia  a blanco
            board.getNodeBoard()[x][y] = new Node(vWhite);

            // Gira 90 grados a la derecha
            turnLeft();
            // Avanza un cuadrado
            Forward();
        }
    }

    private void turnRight() {
        if (direction == 3) {
            direction = 0;
        } else {
            direction += 1;
        }
    }

    private void turnLeft() {
        if (direction == 0) {
            direction = 3;
        } else {
            direction -= 1;
        }
    }

    private void Forward() {
        if (direction == 0 && y > 0) {
            y--;
        }
        if (direction == 1 && x < board.getFilas()) {
            x++;
        }
        if (direction == 2 && y < board.getFilas()) {
            y++;
        }
        if (direction == 3 && x > 0) {
            x--;
        }
        if(x==0||y==0||x==board.getFilas()||y==board.getColumnas()){
            running=false;
        }
        
    }
}
