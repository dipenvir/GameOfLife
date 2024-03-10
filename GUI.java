import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * The GUI class represents the graphical user interface for the simulation. It
 * provides a visual representation of the simulation world and handles user
 * interactions.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class GUI extends JFrame {

    Game game;
    private JPanel gridPanel;
    JPanel panel;

    /**
     * Constructs a new GUI object for the simulation.
     *
     * @param game The Game object representing the simulation game.
     */
    public GUI(Game game) {
        this.game = game;
        displayWorld(game.getWorld());
        addMouseListener(new CellMouseListener());
    }

    /**
     * Displays the world grid on the GUI.
     *
     * @param world The World object representing the simulation world.
     */
    public void displayWorld(World world) {
        new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The World");
        setSize(800, 500);
        gridPanel = new JPanel(new GridLayout(25, 25));

        Cell[][] layout = world.getLayout();

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                panel = new JPanel();

                if (layout[i][j].getOccupant() instanceof Animal) {
                    panel.setBackground(Color.yellow);
                } else if (layout[i][j].getOccupant() instanceof Plant) {
                    panel.setBackground(Color.green);
                } else {
                    panel.setBackground(Color.white);
                }

                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setPreferredSize(new Dimension(30, 30));
                gridPanel.add(panel);
            }
        }
        add(gridPanel);
        pack();
        setVisible(true);

    }

    /**
     * Updates the color of the cell in the GUI based on the occupant of the cell.
     *
     * @param cell The Cell object representing the cell to update.
     */
    public void setCellColor(Cell cell) {
        int row = cell.currentrow;
        int col = cell.currentcol;
        JPanel panel = (JPanel) gridPanel.getComponent(row * 25 + col);

        if (cell.getOccupant() instanceof Animal) {
            panel.setBackground(Color.YELLOW);
        } else if (cell.getOccupant() instanceof Plant) {
            panel.setBackground(Color.GREEN);
        } else {
            panel.setBackground(Color.WHITE);
        }
    }

    /**
     * Sets the game associated with the GUI.
     *
     * @param game The Game object representing the simulation game.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Inner class implementing the MouseListener interface to handle mouse events.
     */
    private class CellMouseListener implements MouseListener {

        /**
         * ActionListener to handle mouse clicks on the GUI. Triggers a turn in the game
         * world when the user clicks the window.
         * 
         * @param e as mouseEvent
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            game.turnWorld();
            updateGUI();

        }

        // Other methods of the MouseListener interface (not used in this context)
        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }

    /**
     * Updates the GUI to reflect the new state of the world after a turn.
     */
    public void updateGUI() {
        Cell[][] layout = game.getWorld().getLayout();
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                setCellColor(layout[i][j]);
            }
        }
    }
}
