package fr.eboespflug.util.tuple;

import java.util.Objects;

/**
 * A Sextuple is a Tuple composed by six elements.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/3/2017.
 */
public class Sextuple <_Type1, _Type2, _Type3, _Type4, _Type5, _Type6> implements Tuple {
    /**
     * The first element of the Sextuple.
     */
    public _Type1 first;
    /**
     * The second element of the Sextuple.
     */
    public _Type2 second;
    /**
     * The third element of the Sextuple.
     */
    public _Type3 third;
    /**
     * The fourth element of the Sextuple.
     */
    public _Type4 fourth;
    /**
     * The fifth element of the Sextuple.
     */
    public _Type5 fifth;
    /**
     * The fifth element of the Sextuple.
     */
    public _Type6 sixth;

    /**
     * Creates a new Sextuple with the specified values for the
     * elements.
     *
     * @param first     the first value of the Sextuple.
     * @param second    the second value of the Sextuple.
     * @param third     the third value of the Sextuple.
     * @param fourth    the fourth value of the Sextuple.
     * @param fifth     the fifth value of the Sextuple.
     * @param sixth     the sixth value of the Sextuple.
     */
    public Sextuple(_Type1 first, _Type2 second, _Type3 third, _Type4 fourth, _Type5 fifth, _Type6 sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    /**
     * Tests this Sextuple for equality with another Object.
     * <p>
     * Returns false if the Object to be tested is null or is not Sextuple.
     * <p>
     * Two sextuples are considered equal if and only if all element are
     * one by one equals.
     *
     * @param other the object which will be equality compared with the sextuple.
     * @return true if the Sextuple and the object are equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Sextuple))
            return false;
        Sextuple<?, ?, ?, ?, ?, ?> p = (Sextuple<?, ?, ?, ?, ?, ?>) other;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second) && Objects.equals(p.third, third) && Objects.equals(p.fourth, fourth)
                && Objects.equals(p.fifth, fifth) && Objects.equals(p.sixth, sixth);
    }

    /**
     * Generates a hash code for the Sextuple.
     * <p>
     * The generated hash code is calculated using the hashes of the
     * elements of the tuple.
     *
     * @return a hash for the Sextuple.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode())
                ^ (third == null ? 0 : third.hashCode()) ^ (fourth == null ? 0 : fourth.hashCode())
                ^ (fifth == null ? 0 : fifth.hashCode()) ^ (sixth == null ? 0 : sixth.hashCode());
    }

    /**
     * Returns the String representation of the Sextuple.
     * <p>
     * The created string is composed of the string representation of
     * the underlying objects separated by a comma (',') and surrounded
     * by parenthesis ('(' and ')').
     *
     * @return the String representation of the Sextuple.
     */
    @Override
    public String toString() {
        return "(" + (first == null ? "null" : first.toString()) + ", " + (second == null ? "null" : second.toString()) + ", " +
                (third == null ? "null" : third.toString()) + ", " + (fourth == null ? "null" : fourth.toString()) + ", " +
                (fifth == null ? "null" : fifth.toString()) + ", " + (sixth == null ? "null" : sixth.toString()) + ")";
    }

    /**
     * Creates a new types parameterized sextuple with the specified
     * values.
     *
     * @param first     the first value in the sextuple.
     * @param second    the second value in the sextuple.
     * @param third     the third value in the sextuple.
     * @param fourth    the fourth value in the sextuple.
     * @param fifth     the fifth value in the sextuple.
     * @param sixth     the sixth value in the sextuple.
     * @param <_Type1>  the first type parameter of the method, used
     *                  as the first type of the sextuple.
     * @param <_Type2>  the second type parameter of the method, used
     *                  as the second type of the sextuple.
     * @param <_Type3>  the third type parameter of the method, used
     *                  as the third type of the sextuple.
     * @param <_Type4>  the fourth type parameter of the method, used
     *                  as the fourth type of the sextuple.
     * @param <_Type5>  the fifth type parameter of the method, used
     *                  as the fifth type of the sextuple.
     * @param <_Type6>  the sixth type parameter of the method, used
     *                  as the sixth type of the sextuple.
     * @return a Sextuple parameterized with it's elements.
     */
    public static <_Type1, _Type2, _Type3, _Type4, _Type5, _Type6> Sextuple<_Type1, _Type2, _Type3, _Type4, _Type5, _Type6>
    create(_Type1 first, _Type2 second, _Type3 third, _Type4 fourth, _Type5 fifth, _Type6 sixth) {
        return new Sextuple<>(first, second, third, fourth, fifth, sixth);
    }

    /**
     * Returns the element in the tuple at the specified
     * index.
     * <p>
     * If {@code elementIndex} doesn't refer to an existing
     * element in the tuple, throws IndexOutOfBoundsException.
     * <p>
     * For sextuples, {@code elementIndex} is in {0, 1, 2, 3, 4, 5}.
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
        if(elementIndex == 4)
            return fifth;
        if(elementIndex == 5)
            return sixth;
        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns 6 for sextuples.
     *
     * @return the number of element in the Tuple.
     */
    @Override
    public int count() {
        return 6;
    }
}
