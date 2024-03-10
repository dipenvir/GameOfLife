/**
 * The Cell class represents a single cell in the world grid. Each cell can hold
 * a life form, such as a plant or an animal.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class Cell {
    int currentrow;
    int currentcol;
    LifeForm occupant;

    /**
     * Constructs a new Cell object with the specified life form, row, and column
     * indices.
     *
     * @param life The life form to be placed in the cell.
     * @param row  The row index of the cell.
     * @param col  The column index of the cell.
     */

    /**
     * Sets the life form occupying the cell.
     *
     * @param life The life form to be placed in the cell.
     */
    public Cell(LifeForm life, int row, int col) {
        occupant = life;
        currentcol = col;
        currentrow = row;
    }

    /**
     * Sets the life form occupying the cell.
     *
     * @param life The life form to be placed in the cell.
     */
    public void setOccupant(LifeForm life) {
        occupant = life;
    }

    /**
     * Retrieves the life form occupying the cell.
     *
     * @return The life form occupying the cell.
     */
    public LifeForm getOccupant() {
        return occupant;
    }

    /**
     * Retrieves the row index of the cell.
     *
     * @return The row index of the cell.
     */
    public int getRow() {
        return currentrow;
    }

    /**
     * Retrieves the column index of the cell.
     *
     * @return The column index of the cell.
     */
    public int getCol() {
        return currentcol;
    }

}
