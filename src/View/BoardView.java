package View;

import Controller.EnvironmentController;
import Controller.PlayerController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.awt.Image;
import javax.swing.JPanel;
import java.util.Timer;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BoardView extends JPanel { //implements ActionListener {

    private Timer timer;
    private int y = 100;
    private PlayerController playerOne;
    private PlayerController playerTwo;
    private Image PlayerOneImage;
    private Image PlayerTwoImage;
    private boolean runed;
    int Y;
    EnvironmentController environment;

    public void setRuned(boolean runed) {
        this.runed = runed;
    }

    public BoardView() {

//        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
//        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
//                cursorImg, new Point(0, 0), "blank cursor");
//        setCursor(blankCursor);


        InputStream in;
        try {
            in = new FileInputStream(new File("C:\\Circus of Plates OOP Lab5\\Circus of Plates\\Sound\\circusoriginal.wav"));
            AudioStream audios = new AudioStream(in);

            AudioPlayer.player.start(audios);
        } catch (Exception e) {
        }




        setFocusable(true);
        setBackground(Color.WHITE);
        playerOne = new PlayerController("one");
        playerTwo = new PlayerController("two");
        environment = new EnvironmentController();
        PlayerOneImage = new javax.swing.ImageIcon(getClass().getResource("PlayerOne.png")).getImage();
        PlayerTwoImage = new javax.swing.ImageIcon(getClass().getResource("PlayerOne.png")).getImage();
        playerOne.setImage(PlayerOneImage);
        playerTwo.setImage(PlayerTwoImage);
        setDoubleBuffered(true);
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new GameLoop(), 100, 1);
        runed = false;
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                playerTwo.mouseMove(evt.getX());
                Y = evt.getY();
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                playerOne.keyPressed(e.getKeyCode());
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                playerOne.stop();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(new javax.swing.ImageIcon(getClass().getResource("BackGround.jpg")).getImage(), 0, 0, 1370, 800, this);
        g2d.drawRect(100, 100, y, y);
        g2d.drawImage(playerOne.getImage(), playerOne.getxPosition(), 450, 200, 300, this);
        g2d.drawImage(playerTwo.getImage(), playerTwo.getxPosition(), 450, 200, 300, this);
        Font font = new Font("Serif", Font.ROMAN_BASELINE, 50);
        g2d.setFont(font);
        g2d.setColor(Color.red);
        g2d.drawString("playerOne.getxPosition()=" + playerOne.getxPosition(), 50, 50);
        g2d.drawString("Y=" + Y, 50, 100);
        g2d.setColor(Color.BLACK);
        Toolkit.getDefaultToolkit().sync();
        
        g2d.fill(environment.nextLUH().getShape());
        g2d.fill(environment.nextLUV().getShape());
        g2d.fill(environment.nextRUH().getShape());
        g2d.fill(environment.nextRUV().getShape());
        g2d.fill(environment.nextLDH().getShape());
        g2d.fill(environment.nextLDV().getShape());
        g2d.fill(environment.nextRDH().getShape());
        g2d.fill(environment.nextRDV().getShape());
        g.dispose();
    }

    class GameLoop extends TimerTask {

        long beforeTime, timeDiff, sleep;

        @Override
        public void run() {
            if (runed) {
                y++;
            }
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 10 - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}