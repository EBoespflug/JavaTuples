package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Quintuple}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/2/2017.
 */
public class QuintupleTest {
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
        Quintuple<String, Integer, Double, String, Byte> t1 = new Quintuple<>("Hello", 28, 0.0, ";;;", (byte)1);
        Quintuple<String, Integer, Double, String, Byte> t2 = new Quintuple<>("World", 32, 0.1, "$", (byte)0);

        assertNotEquals(t1, t2);
        t1.second = 32;
        t1.first = "World";
        t1.third = 0.1;
        t1.fourth = "$";
        t1.fifth = (byte)0;
        assertEquals(t1, t2);
        assertNotEquals(t2, new Quintuple<>("Hello", 32, 0.1, "£", (byte)0));
        assertNotEquals(new Quintuple<>(0, 0, 0, 0, 0), new Quintuple<>(0, 0L, 0, 0, 0L));
    }


    @Test
    public void testToString() throws Exception {
        Quintuple<String, Pair<String, Integer>, String, Integer, Double> t = new Quintuple<>("Hello", new Pair<>("World", 42), null, 73, 0.1);

        assertEquals("(Hello, (World, 42), null, 73, 0.1)", t.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Quintuple<String, Double, String, Integer, Byte> t = Quintuple.create("Hello", 28.0, "World !", 0, (byte)25);

        assertEquals(new Quintuple<>("Hello", 28.0, "World !", 0, (byte)25), t);
    }

    @Test
    public void testGet() throws Exception {
        Tuple t = new Quintuple<>(1254L, 0.1f, 0, "Tuple", 0);
        assertEquals(t.get(0), 1254L);
        assertEquals(t.get(1), 0.1f);
        assertEquals(t.get(2), 0);
        assertEquals(t.get(3), "Tuple");
        assertEquals(t.get(4), 0);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(5);
    }

    // TODO() what for null element ?
    @Test
    public void testGetType() throws Exception {
        Tuple t = new Quintuple<>(1254L, 0.1f, 0, "Tuple", (byte)0);
        assertEquals(t.getType(0), Long.class);
        assertEquals(t.getType(1), Float.class);
        assertEquals(t.getType(2), Integer.class);
        assertEquals(t.getType(3), String.class);
        assertEquals(t.getType(4), Byte.class);
        assertNotEquals(t.getType(4), Integer.class);
        assertEquals(new Quintuple<>("hello", "world", " !", "lol", (byte)0).getType(3), String.class);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(5);
    }

    @Test
    public void testCount() throws Exception {
        Tuple t = new Quintuple<>(new Quintuple<>(1, 2, 3, 4, 5), 5, 6, 7, 8);
        assertEquals(5, t.count());
        assertEquals(5, ((Quintuple)t.get(0)).count());
    }

}