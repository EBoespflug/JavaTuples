package fr.eboespflug.util.tuple;

import java.util.Objects;

/**
 * A Quadruple is a Tuple composed by four elements.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/1/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Quadruple<_Type1, _Type2, _Type3, _Type4> implements Tuple {
    /**
     * The first element of the Quadruple.
     */
    public _Type1 first;
    /**
     * The second element of the Quadruple.
     */
    public _Type2 second;
    /**
     * The third element of the Quadruple.
     */
    public _Type3 third;
    /**
     * The fourth element of the Quadruple.
     */
    public _Type4 fourth;

    /**
     * Creates a new Quadruple with the specified values for the
     * elements.
     *
     * @param first  the first value of the Quadruple.
     * @param second the second value of the Quadruple.
     * @param third  the third value of the Quadruple.
     * @param fourth the third value of the Quadruple.
     */
    public Quadruple(_Type1 first, _Type2 second, _Type3 third, _Type4 fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    /**
     * Tests this Quadruple for equality with another Object.
     * <p>
     * Returns false if the Object to be tested is null or is not Quadruple.
     * <p>
     * Two quadruples are considered equal if and only if all element are
     * one by one equals.
     *
     * @param other the object which will be equality compared with the quadruple.
     * @return true if the Quadruple and the object are equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Quadruple))
            return false;
        Quadruple<?, ?, ?, ?> p = (Quadruple<?, ?, ?, ?>) other;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second) && Objects.equals(p.third, third) && Objects.equals(p.fourth, fourth);
    }

    /**
     * Generates a hash code for the Quadruple.
     * <p>
     * The generated hash code is calculated using the hashes of the
     * elements of the tuple.
     *
     * @return a hash for the Quadruple.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode())
                ^ (third == null ? 0 : third.hashCode() ^ (fourth == null ? 0 : fourth.hashCode()));
    }

    /**
     * Returns the String representation of the Quadruple.
     * <p>
     * The created string is composed of the string representation of
     * the underlying objects separated by a comma (',') and surrounded
     * by parenthesis ('(' and ')').
     *
     * @return the String representation of the Quadruple.
     */
    @Override
    public String toString() {
        return "(" + (first == null ? "null" : first.toString()) + ", " + (second == null ? "null" : second.toString()) + ", " +
                (third == null ? "null" : third.toString()) + ", " + (fourth == null ? "null" : fourth.toString()) + ")" ;
    }

    /**
     * Creates a new types parameterized quadruple with the specified
     * values.
     *
     * @param first     the first value in the quadruple.
     * @param second    the second value in the quadruple.
     * @param third     the third value in the quadruple.
     * @param fourth    the fourth value in the quadruple.
     * @param <_Type1>  the first type parameter of the method, used
     *                  as the first type of the quadruple.
     * @param <_Type2>  the second type parameter of the method, used
     *                  as the second type of the quadruple.
     * @param <_Type3>  the third type parameter of the method, used
     *                  as the third type of the quadruple.
     * @param <_Type4>  the fourth type parameter of the method, used
     *                  as the fourth type of the quadruple.
     * @return a Quadruple parameterized with it's elements.
     */
    public static <_Type1, _Type2, _Type3, _Type4> Quadruple<_Type1, _Type2, _Type3, _Type4> create(_Type1 first, _Type2 second, _Type3 third, _Type4 fourth) {
        return new Quadruple<>(first, second, third, fourth);
    }


    /**
     * Returns the element in the tuple at the specified
     * index.
     * <p>
     * If {@code elementIndex} doesn't refer to an existing
     * element in the tuple, throws IndexOutOfBoundsException.
     * <p>
     * For quadruples, {@code elementIndex} is in {0, 1, 2, 3}.
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
        if(elementIndex == 3)
            return fourth;
        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns 4 for quadruples.
     *
     * @return the number of element in the Tuple.
     */
    @Override
    public int count() {
        return 4;
    }
}
