package fr.eboespflug.util.tuple;

import java.util.Objects;

// TODO() implements Map.Entry<_Type1, _Type2> ?
// TODO() implements Comparable<Pair<_Type1, _Type2>> ?
// TODO() implements Serializable ?

// TODO() extends a Tuple abstract class providing common tuple interface ?

/**
 * A Pair is a Tuple composed by two elements.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 2/12/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Pair<_Type1, _Type2> {
    /**
     * The first element of the Pair.
     */
    public final _Type1 first;
    /**
     * The second element of the Pair.
     */
    public final _Type2 second;

    /**
     * Creates a new Pair with the specified values for the
     * elements.
     *
     * @param first  the first value of the Pair.
     * @param second the second value of the Pair.
     */
    public Pair(_Type1 first, _Type2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Tests this Pair for equality with another Object.
     * <p>
     * Returns false if the Object to be tested is null or is not Pair.
     * <p>
     * Two pairs are considered equal if and only if both first and
     * second are equals.
     *
     * @param other the object which will be equality compared with the pair.
     * @return true if the Pair and the object are equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pair))
            return false;
        Pair<?, ?> p = (Pair<?, ?>) other;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    /**
     * Generates a hash code for the Pair.
     * <p>
     * The generated hash code is calculated using the hashes of the
     * two objects.
     *
     * @return a hash for the Pair.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    /**
     * Returns the String representation of the Pair.
     * <p>
     * The created string is composed of the string representation of
     * the underlying objects separated by a comma (',') and surrounded
     * by parenthesis ('(' and ')').
     *
     * @return the String representation of the Pair.
     */
    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    /**
     * Creates a new types parameterized pair with the specified
     * values.
     *
     * @param first    the first value in the pair.
     * @param second   the second value in the pair.
     * @param <_Type1> the first type parameter of the method, used
     *                 as the first type of the pair.
     * @param <_Type2> the second type parameter of the method, used
     *                 as the second type of the pair.
     * @return a Pair parameterized with the types of first and second.
     */
    public static <_Type1, _Type2> Pair<_Type1, _Type2> create(_Type1 first, _Type2 second) {
        return new Pair<>(first, second);
    }
}
