package fr.eboespflug.util.tuple;

import java.util.Objects;

/**
 * A Single is a Tuple composed by one elements.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/5/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Single <_Type1> implements Tuple {

    /**
     * The first and only element of the Single.
     */
    public _Type1 first;

    /**
     * Creates a new Single with the specified values for its
     * element.
     *
     * @param first  the first and only value of the Single.
     */
    public Single(_Type1 first) {
        this.first = first;
    }

    /**
     * Tests this Single for equality with another Object.
     * <p>
     * Returns false if the Object to be tested is null or is not
     * a Single.
     * <p>
     * Two singles are considered equal if and only if their elements
     * are equals.
     *
     * @param other the object which will be equality compared with the single.
     * @return true if the Single and the object are equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Single))
            return false;
        Single<?> p = (Single<?>) other;
        return Objects.equals(p.first, first);
    }

    /**
     * Generates a hash code for the Single.
     * <p>
     * The generated hash code is calculated using the hash of the
     * two element.
     *
     * @return a hash for the Single.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode());
    }

    /**
     * Returns the String representation of the Single.
     * <p>
     * The created string is composed of the string representation of
     * the underlying objects separated by a comma (',') and surrounded
     * by parenthesis ('(' and ')').
     *
     * @return the String representation of the Single.
     */
    @Override
    public String toString() {
        return "(" + (first == null ? "null" : first.toString()) + ")";
    }

    /**
     * Creates a new types parameterized single with the specified
     * value.
     *
     * @param first    the first and only value in the single.
     * @param <_Type1> the first and only type parameter of the method, used
     *                 as the first type of the single.
     * @return a Single parameterized with the types of first and second.
     */
    public static <_Type1> Single<_Type1> create(_Type1 first) {
        return new Single<>(first);
    }

    /**
     * Returns the element in the tuple at the specified
     * index.
     * <p>
     * If {@code elementIndex} doesn't refer to an existing
     * element in the tuple, throws IndexOutOfBoundsException.
     * <p>
     * For pairs, {@code elementIndex} is in {0}.
     *
     * @param elementIndex the index of the element in the tuple.
     * @return the element as the specified index as an Object.
     */
    @Override
    public Object get(int elementIndex) {
        if(elementIndex == 0)
            return first;
        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns 1 for singles.
     *
     * @return the number of element in the Single.
     */
    @Override
    public int count() {
        return 1;
    }
}
