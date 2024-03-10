/**
 * The abstract LifeForm class represents living entities within the simulation
 * world. Subclasses such as Herbivore and Plant extend this class to define
 * specific behaviors.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
abstract class LifeForm {
    Cell cell;
    World world;
    int lastEaten = 5;
    int turnsTaken = 0;

    /**
     * Constructs a new LifeForm object with the specified world, number of turns taken, and cell.
     *
     * @param wrld         The world where the life form exists.
     * @param turns     The number of turns taken by the life form.
     * @param thisCell  The cell where the life form is located.
     */
    public LifeForm(World wrld, int turns, Cell thiscell) {
        cell = thiscell;
        world = wrld;
        turnsTaken = turns;
    }

    /**
     * Defines the action that the life form can perform.
     * Subclasses must override this method to implement specific behaviors.
     */
    public abstract void action();
    
    /**
     * Defines the behavior of the life form when it dies.
     * Subclasses may override this method to implement custom death behavior.
     */
    public abstract void die();

    /**
     * Defines the behavior of the life form when it reproduces.
     * Subclasses may override this method to implement custom reproduction behavior.
     */
    public abstract void reproduce(Cell cell);

    /**
     * Defines the behavior of the life form when it eats.
     * Subclasses may override this method to implement custom eating behavior.
     */
    public abstract void eat();
    
    /**
     * Retrieves the number of turns taken by the life form.
     *
     * @return The number of turns taken by the life form.
     */
    public int getTurnsTaken() {
        return turnsTaken;
    }

    /**
     * Updates the cell where the life form is located.
     *
     * @param newCell The new cell where the life form is located.
     */
    public void updateCell(Cell newCell) {
        cell = newCell;
    }

}