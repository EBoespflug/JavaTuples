package fr.eboespflug.util.tuple;

import java.util.Objects;

/**
 * A Triplet is a Tuple composed by three elements.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 2/21/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Triplet<_Type1, _Type2, _Type3> implements Tuple{
    /**
     * The first element of the Triplet.
     */
    public _Type1 first;
    /**
     * The second element of the Triplet.
     */
    public _Type2 second;
    /**
     * The third element of the Triplet.
     */
    public _Type3 third;

    /**
     * Creates a new Triplet with the specified values for the
     * elements.
     *
     * @param first  the first value of the Triplet.
     * @param second the second value of the Triplet.
     * @param third  the third value of the Triplet.
     */
    public Triplet(_Type1 first, _Type2 second, _Type3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Tests this Triplet for equality with another Object.
     * <p>
     * Returns false if the Object to be tested is null or is not Triplet.
     * <p>
     * Two triplets are considered equal if and only if all element are
     * one by one equals.
     *
     * @param other the object which will be equality compared with the triplet.
     * @return true if the Triplet and the object are equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Triplet))
            return false;
        Triplet<?, ?, ?> p = (Triplet<?, ?, ?>) other;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second) && Objects.equals(p.third, third);
    }

    /**
     * Generates a hash code for the Triplet.
     * <p>
     * The generated hash code is calculated using the hashes of the
     * elements of the tuple.
     *
     * @return a hash for the Triplet.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode())
                ^ (third == null ? 0 : third.hashCode());
    }

    /**
     * Returns the String representation of the Triplet.
     * <p>
     * The created string is composed of the string representation of
     * the underlying objects separated by a comma (',') and surrounded
     * by parenthesis ('(' and ')').
     *
     * @return the String representation of the Triplet.
     */
    @Override
    public String toString() {
        return "(" + (first == null ? "null" : first.toString()) + ", " + (second == null ? "null" : second.toString()) + ", " +
                (third == null ? "null" : third.toString()) + ")";
    }

    /**
     * Creates a new types parameterized triplet with the specified
     * values.
     *
     * @param first     the first value in the triplet.
     * @param second    the second value in the triplet.
     * @param third     the third value in the triplet.
     * @param <_Type1>  the first type parameter of the method, used
     *                  as the first type of the triplet.
     * @param <_Type2>  the second type parameter of the method, used
     *                  as the second type of the triplet.
     * @param <_Type3>  the third type parameter of the method, used
     *                  as the third type of the triplet.
     * @return a Triplet parameterized with it's elements.
     */
    public static <_Type1, _Type2, _Type3> Triplet<_Type1, _Type2, _Type3> create(_Type1 first, _Type2 second, _Type3 third) {
        return new Triplet<>(first, second, third);
    }


    /**
     * Returns the element in the tuple at the specified
     * index.
     * <p>
     * If {@code elementIndex} doesn't refer to an existing
     * element in the tuple, throws IndexOutOfBoundsException.
     * <p>
     * For triplets, {@code elementIndex} is in {0, 1, 2}.
     *
     * @param elementIndex the index of the element in the tuple.
     * @return the element as the specified index as an Object.
     */
    @Override
    public Object get(int elementIndex) {
        if(elementIndex == 0)
            return first;
        if(elementIndex == 1)
            return second;
        if(elementIndex == 2)
            return third;
        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns 3 for triplets.
     *
     * @return the number of element in the Tuple.
     */
    @Override
    public int count() {
        return 3;
    }
}
