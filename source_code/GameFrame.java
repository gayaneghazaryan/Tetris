package Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    private ImageIcon icon;

    private Board board;
    public static EastPanel eastPanel;
    private static GameEngine engine;

    public GameFrame() {
        icon = new ImageIcon(".//Resources//tetris.png");
        board = GameEngine.board;
        eastPanel = new EastPanel();
        engine = new GameEngine();
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tetris");
        this.setSize(515, 640);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);
        this.add(GameEngine.board, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //LEFT
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            engine.moveLeft();
            System.out.println("left \n");
            repaint();
        }

        //RIGHT
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            engine.moveRight();
            System.out.println("right \n");
            repaint();
        }

        //CLOCKWISE
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            engine.rotateClockwise();
            System.out.println("Clockwise \n");
            repaint();
        }

        //HardDrop
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            engine.hardDrop();
            System.out.println("HardDrop\n");
            repaint();
        }

        //SlowDrop
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (engine.NoBottomCollision()) {
                GameEngine.board.currentTetromino.setCurrShapeY(board.currentTetromino.getCurrShapeY() + 1);
                System.out.println("Down \n ");
                repaint();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_Z) {
            engine.holdShape();
            eastPanel.updateEastPanel();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //Nothing comes here
    }

    public void keyTyped(KeyEvent e) {
        //Nothing comes here
    }

}
