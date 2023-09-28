package edu.iastate.cs228.hw1;

/**
 * @author Aden Koziol
 */
public class Streamer extends TownCell {

    public Streamer (Town p, int r, int c) {
        super(p,r,c);
    }
    @Override
    public State who() {
        return State.STREAMER;
    }

    @Override
    public TownCell next(Town tNew) {
        int nCensus1[] = new int[NUM_CELL_TYPE];
        census(nCensus1);
        nCensus1[STREAMER]--;

        if (nCensus1[EMPTY] + nCensus1[OUTAGE] <= 1)
            return new Reseller(tNew, row, col);
        else if (nCensus1[RESELLER] > 0)
            return new Outage(tNew, row, col);
        else if (nCensus1[OUTAGE] > 0)
            return new Empty(tNew, row, col);
        else if (nCensus1[CASUAL] >= 5)
            return new Streamer(tNew, row, col);
        else
            return new Streamer(tNew, row, col);
    }
}