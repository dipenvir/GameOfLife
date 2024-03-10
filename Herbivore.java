import java.util.ArrayList;

/**
 * The Herbivore class represents an animal that feeds primarily on plants in a
 * world simulation. It extends the Animal class and defines specific behaviors
 * and attributes of herbivores.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class Herbivore extends Animal {

    /**
     * Constructs a Herbivore object with the specified world, number of turns, and
     * initial cell.
     *
     * @param w     the world in which the herbivore exists
     * @param turns the number of turns the herbivore has taken
     * @param cell  the initial cell where the herbivore is located
     */
    public Herbivore(World w, int turns, Cell cell) {

        super(w, turns, cell);
    }

    /**
     * Performs the action of the herbivore during its turn. This method defines the
     * behavior of herbivores, including eating plants or moving.
     */
    public void action() {

        ArrayList<Cell> life = world.getPlantAndEmptyNeighbours(this.cell);

        if (life.size() == 0) {
            return;
        }
        int random = RandomGenerator.nextNumber(life.size());
        Cell food = life.get(random);

        if (lastEaten <= 0) {
            die();
        } else if (turnsTaken < world.currTurn) {
            turnsTaken++;
            if (food.getOccupant() instanceof HerbivoreFood) {
                eat(food);
            } else {
                move(food);
                lastEaten--;
            }
        }
    }

    /**
     * Handles the death of the herbivore. This method removes the herbivore from
     * its current cell.
     */
    public void die() {
        this.cell.setOccupant(null);
    }

    /**
     * Moves the herbivore to the specified new cell.
     *
     * @param newcell the new cell where the herbivore will move
     */
    public void move(Cell newcell) {
        this.cell.setOccupant(null);
        this.updateCell(newcell);
        this.cell.setOccupant(this);
    }

    /**
     * Handles the reproduction behavior of the herbivore. This method defines how
     * herbivores reproduce.
     */
    public void reproduce() {

    }

    /**
     * Handles the eating behavior of the herbivore. This method allows the
     * herbivore to consume plants.
     *
     * @param newcell the cell containing the plant to be eaten
     */
    public void eat(Cell newcell) {
        // kill
//      
        this.cell.setOccupant(null);

        newcell.setOccupant(new Herbivore(world, turnsTaken + 1, newcell));
        lastEaten = 5;
    }

    /**
     * Gets the number of turns taken by the herbivore.
     *
     * @return the number of turns taken by the herbivore
     */
    public int getTurnsTaken() {
        return turnsTaken;
    }

    /**
     * Updates the current cell of the herbivore.
     *
     * @param newCell the new cell where the herbivore will be moved
     */
    public void updateCell(Cell newCell) {
        cell = newCell;
    }

}