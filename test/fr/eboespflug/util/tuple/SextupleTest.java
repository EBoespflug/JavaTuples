package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Sextuple}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/2/2017.
 */
public class SextupleTest {
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
        Sextuple<String, Integer, Double, String, Byte, Integer> t1 = new Sextuple<>("Hello", 28, 0.0, ";;;", (byte)1, 0);
        Sextuple<String, Integer, Double, String, Byte,Integer> t2 = new Sextuple<>("World", 32, 0.1, "$", (byte)0, 42);

        assertNotEquals(t1, t2);
        t1.second = 32;
        t1.first = "World";
        t1.third = 0.1;
        t1.fourth = "$";
        t1.fifth = (byte)0;
        t1.sixth = 42;
        assertEquals(t1, t2);
        assertNotEquals(t2, new Sextuple<>("Hello", 32, 0.1, "£", (byte)0, 42));
        assertNotEquals(new Sextuple<>(0, 0, 0, 0, 0, 0), new Sextuple<>(0, 0L, 0, 0, 0L, (byte)0));
    }


    @Test
    public void testToString() throws Exception {
        Sextuple<String, Pair<String, Integer>, String, Integer, Double, Byte> t =
                new Sextuple<>("Hello", new Pair<>("World", 42), null, 73, 0.1, (byte)0);

        assertEquals("(Hello, (World, 42), null, 73, 0.1, 0)", t.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Sextuple<String, Double, String, Integer, Byte, Float> t = Sextuple.create("Hello", 28.0, "World !", 0, (byte)25, 0f);

        assertEquals(new Sextuple<>("Hello", 28.0, "World !", 0, (byte)25, 0f), t);
    }

    @Test
    public void testGet() throws Exception {
        Tuple t = new Sextuple<>(1254L, 0.1f, 0, "Tuple", 0, 0.0);
        assertEquals(t.get(0), 1254L);
        assertEquals(t.get(1), 0.1f);
        assertEquals(t.get(2), 0);
        assertEquals(t.get(3), "Tuple");
        assertEquals(t.get(4), 0);
        assertEquals(t.get(5), 0.0);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(6);
    }

    // TODO() what for null element ?
    @Test
    public void testGetType() throws Exception {
        Tuple t = new Sextuple<>(1254L, 0.1f, 0, "Tuple", "Type", (byte)0);
        assertEquals(t.getType(0), Long.class);
        assertEquals(t.getType(1), Float.class);
        assertEquals(t.getType(2), Integer.class);
        assertEquals(t.getType(3), String.class);
        assertEquals(t.getType(4), String.class);
        assertEquals(t.getType(5), Byte.class);
        assertNotEquals(t.getType(5), Integer.class);
        assertEquals(new Sextuple<>("hello", "world", " !", "lol", (byte)0, 0).getType(5), Integer.class);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(6);
    }

    @Test
    public void testCount() throws Exception {
        Tuple t = new Sextuple<>(1, 2, 3, 4, 5, new Sextuple<>(1, 2, 3, 4, 5, 6));
        assertEquals(6, t.count());
        assertEquals(6, ((Sextuple)t.get(5)).count());
    }
}