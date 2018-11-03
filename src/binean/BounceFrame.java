package binean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallComponent comp;
    private static final int STEPS = 1000;
    private static final int DELAY = 5;

    public BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel,BorderLayout.SOUTH);
        pack();

    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);

    }

    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r =new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= STEPS; i++) {
                        ball.move(comp.getBounds());
                        comp.paint(comp.getGraphics());
                        Thread.sleep(DELAY);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t =new Thread(r);
        t.start();
    }
}
