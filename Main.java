/**
 * The main class that serves as the entry point for the simulation program.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class Main {

    /**
     * The entry point for the simulation program. Initializes the game
     * 
     * The program creates an instance of the Game class, which sets up the
     * simulation world. The user triggers a turn by clicking on the window
     * displaying the simulation world. Each turn causes herbivores to move and
     * potentially graze on nearby plants, and plants to disperse seeds.
     * 
     * The program continues to run until the user exits or closes the application
     * window.
     *
     * @param args The command-line arguments passed to the program (not used in
     *             this implementation).
     */

    public static void main(String[] args) {
        new Game();
    }
}
