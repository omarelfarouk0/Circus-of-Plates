package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.print.attribute.standard.Media;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Board extends javax.swing.JFrame {

    private BoardView gameBoard;
    private Timer timer;
    private boolean pressedNewGame = true;
    private boolean pressedExit = true;
    private int timerCounter;
    
    public Board() {
        
       
            

        
        initComponents();
        gameBoard = new BoardView();
        setLocationRelativeTo(null);
        setExtendedState(Board.MAXIMIZED_BOTH);
//        setVisible(true);
        jFrame2.setVisible(true);
        jFrame2.setExtendedState(Board.MAXIMIZED_BOTH);
        jFrame1.setUndecorated(true);
        jFrame1.setExtendedState(Board.MAXIMIZED_BOTH);
        jFrame1.add(gameBoard);
        gameBoard.addKeyListener(
                new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    setVisible(true);
                }
            }
        });
        Dimension dim = (Toolkit.getDefaultToolkit()).getScreenSize();
        timerCounter = 0;
        gameBoard.setSize(dim);
        menu.setSize(dim);
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new StartUp(), 100, 10);
    }
    
    
    public void check(){
        this.setVisible(true);
        jFrame2.dispose();
    }

    class StartUp extends TimerTask {

        @Override
        public void run() {
            timerCounter++;
            if ( timerCounter == 200 ){
                check();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel()
        {
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(new javax.swing.ImageIcon(getClass().getResource("moustache-and-circus_Photo-Booth-and-Moustaches.png")).getImage(), 0, 0, 1370, 760, this);
            }
        }
        ;
        menu = new javax.swing.JPanel()
        {
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                BasicStroke s;
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(new javax.swing.ImageIcon(getClass().getResource("carnival_b.jpg")).getImage(), 0, 0, 1367, 850, this);

                String text = "New Game";
                int x = 520;
                int y = 420;
                Font font1 = new Font("Georgia", Font.ITALIC, 70);
                g2d.setPaint(new Color(150, 150, 150));
                TextLayout textLayout = new TextLayout(text, font1, g2d.getFontRenderContext());
                textLayout.draw(g2d, x + 4, y + 4);
                g2d.draw3DRect(x-20, y-70, 390, 100, pressedNewGame);

                g2d.setPaint(Color.PINK);
                textLayout.draw(g2d, x, y);

                text = "Exit";
                x = 520;
                y = 550;
                g2d.setPaint(new Color(150, 150, 150));
                font1 = new Font("Georgia", Font.ITALIC, 70);
                textLayout = new TextLayout(text, font1, g2d.getFontRenderContext());
                textLayout.draw(g2d, x+100 + 4, y + 4);

                g2d.draw3DRect(x-20, y-70, 390, 100, pressedExit);
                g2d.setPaint(Color.PINK);
                textLayout.draw(g2d, x+100, y);

            }
        }
        ;

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jFrame2.setUndecorated(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(null);

        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuMousePressed(evt);
            }
        });
        menu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menuMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        getContentPane().add(menu);
        menu.setBounds(0, 0, 350, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        if (evt.getX() >= 499 && evt.getY() >= 250 && evt.getX() <= 889 && evt.getY() <= 450) {
            jFrame1.show();
            gameBoard.setRuned(true);
        } else if (evt.getX() >= 500 && evt.getY() >= 479 && evt.getX() <= 890 && evt.getY() <= 580) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuMouseClicked

    private void menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMousePressed
        if (evt.getX() >= 499 && evt.getY() >= 250 && evt.getX() <= 889 && evt.getY() <= 450) {
            pressedNewGame = false;
        } else if (evt.getX() >= 500 && evt.getY() >= 479 && evt.getX() <= 890 && evt.getY() <= 580) {
            pressedExit = false;
        }
        repaint();
    }//GEN-LAST:event_menuMousePressed

    private void menuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseReleased
        pressedNewGame = true;
        pressedExit = true;
        repaint();
    }//GEN-LAST:event_menuMouseReleased

    private void menuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseMoved
    }//GEN-LAST:event_menuMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 Board board = new Board();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
