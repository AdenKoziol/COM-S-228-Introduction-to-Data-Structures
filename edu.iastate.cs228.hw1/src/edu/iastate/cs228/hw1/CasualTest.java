package edu.iastate.cs228.hw1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Aden Koziol
 */
public class CasualTest
{
    @Test
    void test()
    {
        Town town = new Town(2, 2);

        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Casual(town, 0, 1);
        town.grid[1][0] = new Casual(town, 1, 0);
        town.grid[1][1] = new Casual(town, 1, 1);

        assertEquals(State.RESELLER, town.grid[1][1].next(town).who());
    }
}
