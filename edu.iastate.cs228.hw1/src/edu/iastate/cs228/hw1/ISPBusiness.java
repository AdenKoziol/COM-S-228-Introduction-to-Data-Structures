package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Aden Koziol
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int i = 0; i < tOld.getWidth(); i++)
		{
			for (int j = 0; j < tOld.getWidth(); j++)
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
		}
		return tNew;
	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int profit = 0;
		for (int i = 0; i < town.getLength(); i++)
		{
			for (int j = 0; j < town.getWidth(); j++)
			{
				if(town.grid[i][j].who().equals(State.CASUAL))
					profit++;
			}
		}
		return profit;
	}


	/**
	 * Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should only print the integer part (Just print the
	 *  integer value. Example if profit is 35.56%, your output should be just: 35).
	 *
	 * Note that this method does not throws any exception, thus you need to handle all the exceptions
	 * in it.
	 *
	 * @param args
	 *
	 */
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
		int input = scan.nextInt();
		int length, width, seed;
		Town town;
		if (input == 1)
		{
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Please enter file path: ");
			String file = scan1.nextLine();
			try {
				town = new Town(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				scan1.close();
				return;
			}
		}
		else if(input == 2)
		{
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Provide rows, cols and seed integer separated by spaces: ");
			length = scan2.nextInt();
			width = scan2.nextInt();
			seed = scan2.nextInt();
			town = new Town(length, width);
			town.randomInit(seed);
			scan2.close();
		}
		else
			return;

		int profit = 0;
		for(int i = 0; i < 12; i++)
		{
			if(i == 0)
				System.out.print("Start: ");
			else
				System.out.print("After itr: " + i);
			System.out.print(town.toString());
			System.out.println();
			profit += getProfit(town);
			System.out.println("Profit: " + getProfit(town));
			System.out.println();
			town =  updatePlain(town);
		}
		double percentProfit = (profit * 100.0) / (town.getLength() * town.getWidth() * 12.0);
		System.out.printf("%.2f%%", percentProfit);
	}
}