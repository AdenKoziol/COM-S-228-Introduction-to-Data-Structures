package edu.iastate.cs228.hw1;

/**
 * @author Aden Koziol
 */
public class Casual extends TownCell {

    public Casual (Town p, int r, int c) {
        super(p,r,c);
    }
    @Override
    public State who() {
        return State.CASUAL;
    }

    @Override
    public TownCell next(Town tNew) {
        int nCensus1[] = new int[NUM_CELL_TYPE];
        census(nCensus1);
        nCensus1[CASUAL]--;

        if (nCensus1[EMPTY] + nCensus1[OUTAGE] <= 1)
            return new Reseller(tNew, row, col);
        else if (nCensus1[RESELLER] > 0)
            return new Outage(tNew, row, col);
        else if (nCensus1[STREAMER] > 0)
            return new Streamer(tNew, row, col);
        else if (nCensus1[CASUAL] >= 5)
            return new Streamer(tNew, row, col);
        else
            return new Casual(tNew, row, col);
    }

}