package fr.eboespflug.util.tuple;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Tuples}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/5/2017.
 */
public class TuplesTest {
    @Test
    public void createTest_1() {
        Tuple t = Tuples.create(0L);
        assertEquals(t, Single.create(0L));
    }

    @Test
    public void createTest_2() {
        Tuple t = Tuples.create(0L, "1");
        assertEquals(t, Pair.create(0L, "1"));
    }

    @Test
    public void createTest_3() {
        Tuple t = Tuples.create(0L, "1", (byte)0);
        assertEquals(t, Triplet.create(0L, "1", (byte)0));
    }

    @Test
    public void createTest_4() {
        Tuple t = Tuples.create(0L, "1", (byte)0, 0.0);
        assertEquals(t, Quadruple.create(0L, "1", (byte)0, 0.0));
    }

    @Test
    public void createTest_5() {
        Tuple t = Tuples.create(0L, "1", (byte)0, 0.0, "a");
        assertEquals(t, Quintuple.create(0L, "1", (byte)0, 0.0, "a"));
    }

    @Test
    public void createTest_6() {
        Tuple t = Tuples.create(0L, "1", (byte)0, 0.0, "a", 0f);
        assertEquals(t, Sextuple.create(0L, "1", (byte)0, 0.0, "a", 0f));
    }

}