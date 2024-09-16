package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void test1x1Board() {
        // Create a 1x1 grid with a BasicSquare
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        // Create the board with the grid
        Board board = new Board(grid);

        // Assert that the board has the correct width and height
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);

        // Assert that the square at (0, 0) is the BasicSquare we created
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
    }
}
