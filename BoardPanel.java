package life;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    static class CellPanel extends JPanel {
        public void setColor(Color cr) {
            setBackground(cr);
        }
    }

    private final CellPanel[][] cells;

    BoardPanel(int size, Color mainColor) {
        setSize(size * 12,size * 12);
        setLayout(new GridLayout(size, size));
        setVisible(true);

        cells = new CellPanel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new CellPanel();
                cells[i][j].setSize(12,12);
                cells[i][j].setVisible(true);
                cells[i][j].setBackground(mainColor);
                add(cells[i][j]);
            }
        }
    }

    public CellPanel[][] getCells() {
        return cells;
    }
}
