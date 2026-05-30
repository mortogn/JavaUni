package util;

public class GridBagUtil {

    int gridy = 0;

    public java.awt.GridBagConstraints gbc(int gridx, int gridy, java.awt.Insets insets) {
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = insets;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

        return gbc;
    }

    public java.awt.GridBagConstraints gbc(int top, int left, int bottom, int right) {
        java.awt.Insets insets = new java.awt.Insets(top, left, bottom, right);
        java.awt.GridBagConstraints gbc = this.gbc(0, gridy, insets);
        this.gridy++;
        return gbc;
    }
}
