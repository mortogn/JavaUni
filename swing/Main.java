import javax.swing.*;

import ui.MainFrame;

public class Main {

    int count;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}