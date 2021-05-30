package life;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class InfoPanel extends JPanel {
    private final Color mainColor;
    private final Color secondColor;

    private final JLabel generationLabel;
    private final JLabel aliveLabel;
    private final JLabel seedLabel;

    private final Buttons buttons;



    class Buttons extends JPanel {
        private final JToggleButton stop;
        private final JButton reset;
        private final JButton theme;


        Buttons(Font font) {
           // setSize(width, height);
            setBackground(mainColor);
            setVisible(true);
            setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));


            ImageIcon iconPause = new ImageIcon("D:\\IntelliJ Projects\\Game of Life\\Game of Life\\task\\src\\life\\images\\icon-pause.png");
            Image scalePause = iconPause.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);

            stop = new JToggleButton(new ImageIcon(scalePause));
            stop.setName("PlayToggleButton");
            stop.setFont(font);
            stop.setBackground(secondColor);
            stop.setBorderPainted(false);
            stop.setOpaque(true);
            add(stop);

            ImageIcon iconRestart = new ImageIcon("D:\\IntelliJ Projects\\Game of Life\\Game of Life\\task\\src\\life\\images\\icon-reset.png");
            Image scaleRestart = iconRestart.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);

            reset = new JButton(new ImageIcon(scaleRestart));
            reset.setName("ResetButton");
            reset.setFont(font);
            reset.setBackground(secondColor);
            reset.setBorderPainted(false);
            reset.setOpaque(true);
            add(reset);

            ImageIcon iconTheme = new ImageIcon("D:\\IntelliJ Projects\\Game of Life\\Game of Life\\task\\src\\life\\images\\icon-theme.png");
            Image scaleTheme = iconTheme.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);

            theme = new JButton(new ImageIcon(scaleTheme));
            theme.setFont(font);
            theme.setBackground(secondColor);
            theme.setBorderPainted(false);
            theme.setOpaque(true);
            add(theme);
        }
        public JButton getTheme() {return theme; }

        public JToggleButton getStop() {
            return stop;
        }

        public JButton getReset() {
            return reset;
        }

    }

    InfoPanel(int width, int height, long seed, Color mainColor, Color secondColor) {
        this.mainColor = mainColor;
        this.secondColor = secondColor;
        setSize(width,height);
        setBackground(mainColor);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        setVisible(true);

        Font font = new Font("SansSerif", Font.PLAIN,15);

        buttons = new Buttons(font);
        add(buttons);
        add(Box.createRigidArea(new Dimension(0,5)));

        generationLabel = new JLabel("Generation #0");
        generationLabel.setSize(width,15);
        generationLabel.setFont(font);
        generationLabel.setName("GenerationLabel");
        generationLabel.setForeground(secondColor);
        add(generationLabel);

        aliveLabel = new JLabel("Alive: 0");
        aliveLabel.setSize(width,15);
        aliveLabel.setFont(font);
        aliveLabel.setName("AliveLabel");
        aliveLabel.setForeground(secondColor);
        add(aliveLabel);

        seedLabel = new JLabel("Seed: " + seed);
        seedLabel.setSize(width, 15);
        seedLabel.setFont(font);
        seedLabel.setForeground(secondColor);
        add(seedLabel);


    }
    public void switchTheme() {
        setBackground(mainColor);
        generationLabel.setBackground(mainColor);
        aliveLabel.setBackground(mainColor);
        seedLabel.setBackground(mainColor);
    }

    public void nextGen(int gen, int alive) {
        generationLabel.setText("Generation #" + gen);
        aliveLabel.setText("Alive: " + alive);
    }

    public void newSeed(long newSeed) {
        seedLabel.setText("Seed: " + newSeed);
    }

    public Buttons getButtons() {
        return buttons;
    }


}
