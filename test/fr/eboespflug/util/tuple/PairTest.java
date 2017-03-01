package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Pair}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/1/2017.
 */
public class PairTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        // Nothing to do.
    }

    @After
    public void tearDown() throws Exception {
        // Nothing to do.
    }

    @Test
    public void testEquals() throws Exception {
        Pair<String, Integer> p1 = new Pair<>("Hello", 28);
        Pair<String, Integer> p2 = new Pair<>("World", 32);

        assertNotEquals(p1, p2);
        p1.second = 32;
        p1.first = "World";
        assertEquals(p1, p2);
        assertNotEquals(p2, new Pair<>("Hellow", 32));
    }


    @Test
    public void testToString() throws Exception {
        Pair<String, Pair<String, Integer>> complexPair = new Pair<>("Hello", new Pair<>("World", 42));

        assertEquals("(Hello, (World, 42))", complexPair.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Pair<String, Double> p1 = Pair.create("Hello", 28.0);

        assertEquals(new Pair<>("Hello", 28.0), p1);
    }

    @Test
    public void testGet() throws Exception {

        Tuple pair = new Pair<>(1254L, 0.1f);
        assertEquals(pair.count(), 2);
        assertEquals(pair.get(0), 1254L);
        assertEquals(pair.get(1), 0.1f);

        exception.expect(IndexOutOfBoundsException.class);
        pair.get(28);
    }

    @Test
    public void testCount() throws Exception {
        Tuple p1 = new Pair<>(new Pair<>(1, 2), 3);
        assertEquals(2, p1.count());
        assertEquals(2, ((Pair)p1.get(0)).count());
    }
}