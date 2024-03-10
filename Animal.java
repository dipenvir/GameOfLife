/**
 * The Animal class represents a generic animal life form in a world simulation.
 * It extends the LifeForm class and defines behaviors and attributes common to
 * animals.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class Animal extends LifeForm {

    /**
     * Constructs an Animal object with the specified world, number of turns, and
     * initial cell.
     *
     * @param w     the world in which the animal exists
     * @param turns the number of turns the animal has taken
     * @param cell  the initial cell where the animal is located
     */
    public Animal(World w, int turns, Cell cell) {
        super(w, turns, cell);
    }

    /**
     * Performs the action of the animal during its turn. This method is meant to be
     * overridden by subclasses to define specific behaviors.
     */
    public void action() {

    }

    /**
     * Handles the death of the animal. This method can be overridden by subclasses
     * to define specific death behaviors.
     */
    public void die() {

    }

    /**
     * Reproduces, creating a new animal in the specified cell.
     *
     * @param cell the cell where the new animal will be placed
     */

    public void reproduce(Cell cell) {

    }

    /**
     * Handles the eating behavior of the animal. This method can be overridden by
     * subclasses to define specific eating behaviors.
     */
    public void eat() {

    }

    /**
     * Gets the number of turns taken by the animal.
     *
     * @return the number of turns taken by the animal
     */
    public int getTurnsTaken() {
        return turnsTaken;
    }

    /**
     * Updates the current cell of the animal.
     *
     * @param newCell the new cell where the animal will be moved
     */
    public void updateCell(Cell newCell) {
        cell = newCell;
    }

}