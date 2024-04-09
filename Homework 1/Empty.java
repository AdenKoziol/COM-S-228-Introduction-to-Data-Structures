package edu.iastate.cs228.hw1;

/**
 * @author Aden Koziol
 */
public class Empty extends TownCell {

    public Empty (Town p, int r, int c) {
        super(p,r,c);
    }
    @Override
    public State who() {

        return State.EMPTY;
    }

    @Override
    public TownCell next(Town tNew)
    {
        int nCensus1[] = new int[NUM_CELL_TYPE];
        census(nCensus1);
        nCensus1[EMPTY]--;
        if (nCensus1[EMPTY] +
                nCensus1[OUTAGE] <= 1)
            return new Reseller(tNew, row, col);
        else
            return new Casual(tNew, row, col);
    }

}
