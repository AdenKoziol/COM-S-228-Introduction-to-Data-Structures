package edu.iastate.cs228.hw1;

/**
 * @author Aden Koziol
 */
public class Reseller extends TownCell {

    public Reseller (Town p, int r, int c) {
        super(p,r,c);
    }
    @Override
    public State who() {
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town tNew)
    {
        int nCensus1[] = new int[NUM_CELL_TYPE];
        census(nCensus1);
        nCensus1[RESELLER]--;

        if (nCensus1[CASUAL] <= 3 || nCensus1[EMPTY] >= 3)
            return new Empty(tNew, row, col);
        else
            return new Reseller(tNew, row, col);
    }

}