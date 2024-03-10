import java.util.ArrayList;

/**
 * The World class represents the environment where the simulation takes place.
 * It consists of a grid layout of cells, each of which may contain a life form
 * such as a plant or herbivore or an empty cell.
 * 
 * @author Dipenvir Kaur
 * @version 1.0
 */
public class World {

    int rows;
    int cols;
    Cell[][] layout;
    int currTurn = 0;
    /**
     * Constructs a new World object with default dimensions (25x25) and initializes
     * the grid with life forms.
     */
    public World() {
        layout = new Cell[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                LifeForm life;
                int random = RandomGenerator.nextNumber(100);

                if (random >= 85) {
                    life = new Herbivore(this, 0, null);
                } else if (random >= 65) {
                    life = new Plant(this, 0, null);
                } else {
                    life = null;
                }
                Cell cell = new Cell(life, i, j);

                if (life != null) {
                    life.updateCell(cell);
                }

                layout[i][j] = cell;
            }

        }
    }

    /**
     * Retrieves the neighbors of a given cell. Neighbors are cells adjacent to the
     * given cell, including diagonals.
     *
     * @param cell The cell whose neighbors are to be retrieved.
     * @return An ArrayList containing the neighboring cells.
     */
    public ArrayList<Cell> getNeighbours(Cell cell) {

        ArrayList<Cell> neighbours = new ArrayList<>();
        int row = cell.currentrow;
        int col = cell.currentcol;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                // Skip if it's the same cell
                if (i == row && j == col)
                    continue;
                if (i >= 0 && i < layout.length && j >= 0 && j < layout[i].length) {
                    Cell occupant = layout[i][j];
                    neighbours.add(occupant);

                }
            }
        }
        return neighbours;

    }

    /**
     * Retrieves the neighbors of a given cell that contain plants.
     *
     * @param cell The cell whose plant neighbors are to be retrieved.
     * @return An ArrayList containing the neighboring cells containing plants.
     */
    public ArrayList<Cell> getPlantNeighbours(Cell cell) {

        ArrayList<Cell> plantNeighbours = new ArrayList<>();
        for (Cell life : getNeighbours(cell)) {
            if (life.getOccupant() instanceof Plant) {
                plantNeighbours.add(life);
            }
        }
        return plantNeighbours;
    }

    /**
     * Retrieves the empty neighbors of a given cell.
     *
     * @param cell The cell whose empty neighbors are to be retrieved.
     * @return An ArrayList containing the neighboring cells that are empty.
     */
    public ArrayList<Cell> getEmptyNeighbours(Cell cell) {

        ArrayList<Cell> emptyNeighbours = new ArrayList<>();
        for (Cell life : getNeighbours(cell)) {
            if (life.getOccupant() == null) {
                emptyNeighbours.add(life);
            }
        }
        return emptyNeighbours;
    }

    /**
     * Retrieves the neighbors of a given cell that contain plants or are empty.
     *
     * @param cell The cell whose neighbors containing plants or empty are to be
     *             retrieved.
     * @return An ArrayList containing the neighboring cells containing plants or
     *         empty cells.
     */
    public ArrayList<Cell> getPlantAndEmptyNeighbours(Cell cell) {

        ArrayList<Cell> plantAndEmptyNeighbours = new ArrayList<>();
        ArrayList<Cell> neighbours = getNeighbours(cell);

        for (Cell life : neighbours) {
            if (life.getOccupant() instanceof Plant || life.getOccupant() == null) {
                plantAndEmptyNeighbours.add(life);
            }
        }

        return plantAndEmptyNeighbours;
    }

    /**
     * Retrieves the layout of the world, which is a grid of cells.
     *
     * @return The grid of cells representing the layout of the world.
     */
    public Cell[][] getLayout() {

        return layout;
    }
}