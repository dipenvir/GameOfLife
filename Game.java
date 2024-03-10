/**
 * The Game class represents the main control unit for the simulation of The
 * Game Of Life. It manages the game state, including the number of turns, the
 * graphical user interface (GUI), and the world where the simulation takes
 * place.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class Game {
    int numTurns;
    GUI gui;
    World world;

    /**
     * Constructs a new Game object. Initializes the simulation world and the
     * graphical user interface (GUI).
     */
    public Game() {
        world = new World();
        gui = new GUI(this);
        gui.setGame(this);
    }

    /**
     * Advances the simulation by one turn. Increments the number of turns and
     * triggers actions for each life form in the world. Life forms such as
     * herbivores and plants perform their actions according to their behavior
     * rules.
     */
    public void turnWorld() {
        numTurns++;
        
        Cell[][] layout = world.getLayout();
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {

                LifeForm life = layout[i][j].getOccupant();
                if (life instanceof Herbivore) {
                    life.action();
                } else if (life instanceof Plant) {
                    life.action();
                }
            }
        }
        world.currTurn = numTurns;
    }
    /**
     * Retrieves the world object where the simulation takes place.
     *
     * @return The World object representing the simulation world.
     */
    public World getWorld() {
        return world;
    }
}