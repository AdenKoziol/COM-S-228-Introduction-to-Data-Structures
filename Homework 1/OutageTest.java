package edu.iastate.cs228.hw1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Aden Koziol
 */
public class OutageTest
{
    @Test
    void test()
    {
        Town town = new Town(2,2);

        town.grid[0][0] = new Outage(town, 0,0);
        town.grid[0][1] = new Outage(town, 0,1);
        town.grid[1][0] = new Outage(town, 1,0);
        town.grid[1][1] = new Outage(town, 1,1);

        assertEquals(State.EMPTY, town.grid[0][0].next(town).who());
    }
}
