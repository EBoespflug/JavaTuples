package fr.eboespflug.util.tuple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * JUnit4 Test class for {@link fr.eboespflug.util.tuple.Single}.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/5/2017.
 */
public class SingleTest {
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
        Single<String> s1 = new Single<>("Hello");
        Single<String> s2 = new Single<>("World");

        assertNotEquals(s1, s2);
        s1.first = "World";
        assertEquals(s1, s2);
        assertNotEquals(s2, new Single<>("Hell"));
        assertNotEquals(new Single<>(0), new Single<>(0L));
    }


    @Test
    public void testToString() throws Exception {
        Single<Single<String>> complexSingle = new Single<>(new Single<>("^_^"));

        assertEquals("((^_^))", complexSingle.toString());
    }

    @Test
    public void testCreate() throws Exception {
        Single<String> s1 = Single.create("Hello");

        assertEquals(new Single<>("Hello"), s1);
    }

    @Test
    public void testGet() throws Exception {
        Tuple t = new Single<>(1254L);
        assertEquals(t.get(0), 1254L);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(1);
    }

    // TODO() what for null element ?
    @Test
    public void testGetType() throws Exception {
        Tuple t = new Single<>(1254L);
        assertEquals(t.getType(0), Long.class);
        assertEquals(new Single<>("hello").getType(0), String.class);

        exception.expect(IndexOutOfBoundsException.class);
        t.get(1);
    }

    @Test
    public void testCount() throws Exception {
        Tuple t = new Single<>(new Single<>(1));
        assertEquals(1, t.count());
        assertEquals(1, ((Single)t.get(0)).count());
    }
}