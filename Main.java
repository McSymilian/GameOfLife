package life;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        int size = 100;
        Universe universe = new Universe(size);
        GameOfLife life = new GameOfLife(size, universe.getSeed());

        SwingUtilities.invokeAndWait(life);
        Algorithms.liveFor(universe, life);

    }
}
