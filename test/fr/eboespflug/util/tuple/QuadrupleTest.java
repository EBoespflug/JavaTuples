package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Quadruple}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/1/2017.
 */
public class QuadrupleTest {
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
        Quadruple<String, Integer, Double, String> t1 = new Quadruple<>("Hello", 28, 0.0, ";;;");
        Quadruple<String, Integer, Double, String> t2 = new Quadruple<>("World", 32, 0.1, "$");

        assertNotEquals(t1, t2);
        t1.second = 32;
        t1.first = "World";
        t1.third = 0.1;
        t1.fourth = "$";
        assertEquals(t1, t2);
        assertNotEquals(t2, new Quadruple<>("Hello", 32, 0.1, "£"));
        assertNotEquals(new Quadruple<>(0, 0, 0, 0), new Quadruple<>(0, 0L, 0, 0));
    }


    @Test
    public void testToString() throws Exception {
        Quadruple<String, Pair<String, Integer>, String, Integer> t = new Quadruple<>("Hello", new Pair<>("World", 42), null, 73);

        assertEquals("(Hello, (World, 42), null, 73)", t.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Quadruple<String, Double, String, Integer> t = Quadruple.create("Hello", 28.0, "World !", 0);

        assertEquals(new Quadruple<>("Hello", 28.0, "World !", 0), t);
    }

    @Test
    public void testGet() throws Exception {
        Tuple t = new Quadruple<>(1254L, 0.1f, 0, "Tuple");
        assertEquals(t.get(0), 1254L);
        assertEquals(t.get(1), 0.1f);
        assertEquals(t.get(2), 0);
        assertEquals(t.get(3), "Tuple");

        exception.expect(IndexOutOfBoundsException.class);
        t.get(4);
    }

    // TODO() what for null element ?
    @Test
    public void testGetType() throws Exception {
        Tuple t = new Quadruple<>(1254L, 0.1f, 0, "Tuple");
        assertEquals(t.getType(0), Long.class);
        assertEquals(t.getType(1), Float.class);
        assertEquals(t.getType(2), Integer.class);
        assertEquals(t.getType(3), String.class);
        assertEquals(new Quadruple<>("hello", "world", " !", "lol").getType(0), String.class);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(4);
    }

    @Test
    public void testCount() throws Exception {
        Tuple t = new Quadruple<>(new Quadruple<>(1, 2, 3, 4), 5, 6, 7);
        assertEquals(4, t.count());
        assertEquals(4, ((Quadruple)t.get(0)).count());
    }
}