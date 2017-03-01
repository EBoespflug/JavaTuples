package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Triplet}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/1/2017.
 */
public class TripletTest {
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
        Triplet<String, Integer, Double> t1 = new Triplet<>("Hello", 28, 0.0);
        Triplet<String, Integer, Double> t2 = new Triplet<>("World", 32, 0.1);

        assertNotEquals(t1, t2);
        t1.second = 32;
        t1.first = "World";
        t1.third = 0.1;
        assertEquals(t1, t2);
        assertNotEquals(t2, new Triplet<>("Hellow", 32, 0.1));
        assertNotEquals(new Triplet<>(0, 0, 0), new Triplet<>(0, 0L, 0));
    }


    @Test
    public void testToString() throws Exception {
        Triplet<String, Pair<String, Integer>, String> complexTriple = new Triplet<>("Hello", new Pair<>("World", 42), null);

        assertEquals("(Hello, (World, 42), null)", complexTriple.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Triplet<String, Double, String> t1 = Triplet.create("Hello", 28.0, "World !");

        assertEquals(new Triplet<>("Hello", 28.0, "World !"), t1);
    }

    @Test
    public void testGet() throws Exception {
        Tuple t = new Triplet<>(1254L, 0.1f, "Tuple");
        assertEquals(t.get(0), 1254L);
        assertEquals(t.get(1), 0.1f);
        assertEquals(t.get(2), "Tuple");

        exception.expect(IndexOutOfBoundsException.class);
        t.get(3);
    }

    // TODO() what for null element ?
    @Test
    public void testGetType() throws Exception {
        Tuple t = new Triplet<>(1254L, 0.1f, 0);
        assertEquals(t.getType(0), Long.class);
        assertEquals(t.getType(1), Float.class);
        assertEquals(t.getType(2), Integer.class);
        assertEquals(new Triplet<>("hello", "world", " !").getType(0), String.class);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(3);
    }

    @Test
    public void testCount() throws Exception {
        Tuple p1 = new Triplet<>(new Triplet<>(1, 2, 3), 4, "Test");
        assertEquals(3, p1.count());
        assertEquals(3, ((Triplet)p1.get(0)).count());
    }
}