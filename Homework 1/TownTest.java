package edu.iastate.cs228.hw1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

/**
 * @author Aden Koziol
 */
public class TownTest
{
    @Test
    void test()
    {
        Town town = new Town(2,1);
        assertEquals(2, town.getLength());
    }
    @Test
    void test1()
    {
        Town town = new Town(2,1);
        assertEquals(1, town.getWidth());
    }
    @Test
    void test2() throws FileNotFoundException {
        Town town = new Town("C:\\Users\\Aden\\Downloads\\COM S 228\\edu.iastate.cs228.hw1\\src\\edu\\iastate\\cs228\\hw1\\Test.txt");
        assertEquals(State.CASUAL, town.grid[0][0].who());
    }
}
