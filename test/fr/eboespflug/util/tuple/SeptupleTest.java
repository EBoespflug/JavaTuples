package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Septuple}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/6/2017.
 */
public class SeptupleTest {
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
        Septuple<String, Integer, Double, String, Byte, Integer, Object> t1 = new Septuple<>("Hello", 28, 0.0, ";;;", (byte)1, 0, new Object());
        Septuple<String, Integer, Double, String, Byte,Integer, Object> t2 = new Septuple<>("World", 32, 0.1, "$", (byte)0, 42, null);

        assertNotEquals(t1, t2);
        t1.second = 32;
        t1.first = "World";
        t1.third = 0.1;
        t1.fourth = "$";
        t1.fifth = (byte)0;
        t1.sixth = 42;
        t1.seventh = null;
        assertEquals(t1, t2);
        assertNotEquals(t2, new Septuple<>("Hello", 32, 0.1, "£", (byte)0, 42, null));
        assertNotEquals(new Septuple<>(0, 0, 0, 0, 0, 0, 0), new Septuple<>(0, 0L, 0, 0, 0L, (byte)0, 0L));
    }


    @Test
    public void testToString() throws Exception {
        Septuple<String, Integer, String, Integer, Double, Byte, Pair<String, Integer>> t =
                new Septuple<>("Hello", 42, null, 73, 0.1, (byte)0, new Pair<>("World", 42));

        assertEquals("(Hello, 42, null, 73, 0.1, 0, (World, 42))", t.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Septuple<String, Double, String, Integer, Byte, Float, Object> t = Septuple.create("Hello", 28.0, "World !", 0, (byte)25, 0f, null);

        assertEquals(new Septuple<>("Hello", 28.0, "World !", 0, (byte)25, 0f, null), t);
    }

    @Test
    public void testGet() throws Exception {
        Tuple t = new Septuple<>(1254L, 0.1f, 0, "Tuple", 0, 0.0, "123");
        assertEquals(t.get(0), 1254L);
        assertEquals(t.get(1), 0.1f);
        assertEquals(t.get(2), 0);
        assertEquals(t.get(3), "Tuple");
        assertEquals(t.get(4), 0);
        assertEquals(t.get(5), 0.0);
        assertEquals(t.get(6), "123");

        exception.expect(IndexOutOfBoundsException.class);
        t.get(7);
    }

    // TODO() what for null element ?
    @Test
    public void testGetType() throws Exception {
        Tuple t = new Septuple<>(1254L, 0.1f, 0, "Tuple", "Type", (byte)0, 100);
        assertEquals(t.getType(0), Long.class);
        assertEquals(t.getType(1), Float.class);
        assertEquals(t.getType(2), Integer.class);
        assertEquals(t.getType(3), String.class);
        assertEquals(t.getType(4), String.class);
        assertEquals(t.getType(5), Byte.class);
        assertEquals(t.getType(6), Integer.class);
        assertNotEquals(t.getType(6), Byte.class);
        assertEquals(new Septuple<>("hello", "world", " !", "lol", (byte)0, 0, 0.0).getType(6), Double.class);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(7);
    }

    @Test
    public void testCount() throws Exception {
        Tuple t = new Septuple<>(1, 2, 3, 4, 5, 6, new Septuple<>(1, 2, 3, 4, 5, 6, 7));
        assertEquals(7, t.count());
        assertEquals(7, ((Septuple)t.get(6)).count());
    }
}