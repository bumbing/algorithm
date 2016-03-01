package algorithm;

import junit.framework.TestCase;

/**
 * Created by maliu2 on 12/9/15.
 */
public class PerfectSquareTest extends TestCase {

    public void testNumSquares() throws Exception {
        int result = new PerfectSquare().numSquares(12);
        assertEquals(3, result);
    }
}