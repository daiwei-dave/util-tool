package coreJava.Chapter14.bounceThread;

import coreJava.Chapter14.bounce.Ball;
import coreJava.Chapter14.bounce.BallComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Shows animated bouncing balls.
 * Created by daiwei on 2018/3/10.
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setTitle("BounceThread");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}

/**
 * 30 * A runnable that animates a bouncing ball.
 * 31
 */


class BallRunnable implements Runnable {
    private Ball ball;
    private Component component;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    /**
     * Constructs the runnable.
     *
     * @param aBall      the ball to bounce
     * @param aComponent the component in which the ball bounces3
     */
    public BallRunnable(Ball aBall, Component aComponent) {
        ball = aBall;
        component = aComponent;
    }

    public void run() {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
        }
    }

}

/**
 * 68 * The frame with panel and buttons.
 * 69
 */
class BounceFrame extends JFrame {
    private BallComponent comp;

    /**
     * 75 * Constructs the frame with the component for showing the
     * bouncing ball and Start and Close
     * 76 * buttons
     * 77
     */
    public BounceFrame() {
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addBall();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * 103 * Adds a button to a container.
     * 104 * @param c the container
     * 105 * @param title the button title
     * 106 * @param listener the action listener for the button
     * 107
     */
    public void addButton(Container c, String title, ActionListener
            listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * 116 * Adds a bouncing ball to the canvas and starts a thread to
     * make it bounce
     * 117
     */
    public void addBall() {
        Ball b = new Ball();
        comp.add(b);
        Runnable r = new BallRunnable(b, comp);
        Thread t = new Thread(r);
        t.start();
    }
}