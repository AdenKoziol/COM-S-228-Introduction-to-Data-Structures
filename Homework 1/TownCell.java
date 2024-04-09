package edu.iastate.cs228.hw1;

/**
 *
 * @author Aden Koziol
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;


	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	public static final int NUM_CELL_TYPE = 5;

	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}


	/**
	 * Censuses all cell types in the 3 X 3 neighborhood
	 * Use who() method to get who is present in the
	 *
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0;
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0;
		nCensus[OUTAGE] = 0;
		nCensus[STREAMER] = 0;
		int top = Math.max(0, row - 1);
		int bottom = Math.min(plain.grid.length - 1, row + 1);
		int left = Math.max(0, col - 1);
		int right = Math.min(plain.grid.length - 1, col + 1);

		for (int i = top; i <= bottom; i++)
		{
			for (int j = left; j <= right; j++)
			{
				if (plain.grid[i][j].who() == State.RESELLER)
					nCensus[RESELLER]++;
				if (plain.grid[i][j].who() == State.EMPTY)
					nCensus[EMPTY]++;
				if (plain.grid[i][j].who() == State.CASUAL)
					nCensus[CASUAL]++;
				if (plain.grid[i][j].who() == State.OUTAGE)
					nCensus[OUTAGE]++;
				if (plain.grid[i][j].who() == State.STREAMER)
					nCensus[STREAMER]++;
			}
		}
	}

	/**
	 * Gets the identity of the cell.
	 *
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 *
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}