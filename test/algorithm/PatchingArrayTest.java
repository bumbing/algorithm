package algorithm;

import junit.framework.TestCase;

/**
 * Created by maliu2 on 2/16/16.
 */
public class PatchingArrayTest extends TestCase {

    public void testMinPatches() throws Exception {
        int result = new PatchingArray().minPatches(new int[] {1, 2, 31, 33}, 2147483647);
        assertEquals(result, 28);
    }
}