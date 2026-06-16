package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class Button extends JButton {

    private Color normalColor = new Color(0, 0, 0);
    private Color hoverColor = new Color(33, 33, 33);
    private Color foreground = new Color(255, 255, 255);

    private Color currentColor = normalColor;
    private int borderRadius = 15;

    public Button(String text) {
        this(text, 150, 40);
    }

    public Button(String text, int width, int height) {
        super(text);

        setUI(new javax.swing.plaf.basic.BasicButtonUI());
        setForeground(foreground);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setMargin(new Insets(0, 0, 0, 0));
        setPreferredSize(new Dimension(width, height));

        setFont(new Font("Arial", Font.BOLD, 14));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                currentColor = hoverColor;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentColor = normalColor;
                repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(currentColor);
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), borderRadius, borderRadius));

        super.paintComponent(g2d);
        g2d.dispose();
    }

}
