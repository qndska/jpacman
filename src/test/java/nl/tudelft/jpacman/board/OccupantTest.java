package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square targetSquare = new BasicSquare();

        // Unit occupies the target square
        unit.occupy(targetSquare);

        // Verify that the unit is now on the target square
        assertThat(unit.getSquare()).isEqualTo(targetSquare);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square firstSquare = new BasicSquare();
        Square secondSquare = new BasicSquare();

        // Unit occupies the first square
        unit.occupy(firstSquare);

        // Unit reoccupies a second square
        unit.occupy(secondSquare);

        // Verify that the unit is now on the second square
        assertThat(unit.getSquare()).isEqualTo(secondSquare);

        // Optionally, verify that the unit is no longer on the first square
        assertThat(firstSquare.getOccupants()).doesNotContain(unit);
    }
}
