import java.util.ArrayList;

/**
 * The Plant class represents a plant life form in a world simulation.
 * It extends the LifeForm class and serves as a source of food for herbivores.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class Plant extends LifeForm implements HerbivoreFood {

    /**
     * Constructs a Plant object with the specified world, number of turns, and initial cell.
     *
     * @param world the world in which the plant exists
     * @param turns the number of turns the plant has taken
     * @param cell  the initial cell where the plant is located
     */
    public Plant(World world, int turns, Cell cell) {
        super(world, turns, cell);
    }

    /**
     * Performs the action of the plant during its turn.
     * This method defines the behavior of plants, including reproduction under certain conditions.
     */
    public void action() {       

        ArrayList<Cell> life = world.getPlantNeighbours(this.cell);
        ArrayList<Cell> emptylife = world.getEmptyNeighbours(this.cell);
        if(life.size() == 0) {
            return;
        }
        if(life.size() >= 4 && emptylife.size() >= 3) {
            int random = RandomGenerator.nextNumber(emptylife.size());
            reproduce(emptylife.get(random));
        }
    }

    /**
     * Handles the death of the plant.
     * This method is not implemented as plants do not die in this simulation.
     */
    public void die() {
        //plants don't die
    }

    /**
     * Reproduces, creating a new plant in the specified cell.
     *
     * @param newPlant the cell where the new plant will be placed
     */
    public void reproduce(Cell newPlant) {
        newPlant.setOccupant(new Plant(this.world, this.turnsTaken, newPlant));
    }

    /**
     * Plants cannot eat, so this method does nothing.
     */
    public void eat() {
        //plants can't eat
    }

    /**
     * Gets the number of turns taken by the plant.
     *
     * @return the number of turns taken by the plant
     */
    public int getTurnsTaken() {
        return turnsTaken;
    }

    /**
     * Updates the current cell of the plant.
     *
     * @param newCell the new cell where the plant will be moved
     */
    public void updateCell(Cell newCell) {
        cell = newCell;
    }
}
