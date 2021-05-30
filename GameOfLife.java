package life;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class GameOfLife extends JFrame implements Runnable {
    private InfoPanel infoReference;
    private BoardPanel cells;
    private JPanel main;
    private Color mainColor;
    private Color secondColor;

    public GameOfLife() {


        try {
            Main.main(null);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public GameOfLife(int size, long seed) {
        super("Game of  Life");

        mainColor = Color.darkGray.darker();
        secondColor = Color.white.darker();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setLocationRelativeTo(null);
        Dimension windowDimensions = new Dimension(size * 12 + 120, size * 12);
        setSize(windowDimensions);
        setResizable(false);
        setLayout(new BorderLayout( 0,50));

        main = new JPanel();
        main.setVisible(true);
        main.setBackground(mainColor);
        main.setLayout(new FlowLayout(FlowLayout.LEFT));

        infoReference = new InfoPanel(150, 30, seed, mainColor, secondColor);
        main.add(infoReference);

        cells = new BoardPanel(size, mainColor);
        main.add(cells);
        add(main);
    }

    public void switchTheme() {
        if (mainColor == Color.darkGray.darker()) {
            mainColor = Color.white.darker();
            secondColor = Color.darkGray.darker();

        }
        else {
            mainColor = Color.darkGray.darker();
            secondColor = Color.white.darker();
        }
        setBackground(mainColor);
        main.setBackground(mainColor);
        infoReference.switchTheme();
    }

    public InfoPanel getInfoReference() {
        return infoReference;
    }

    public BoardPanel getCells() {
        return cells;
    }

    @Override
    public void run() {}
}
