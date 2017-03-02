package fr.eboespflug.util.tuple;

import java.util.Objects;

/**
 * A Quintuple is a Tuple composed by five elements.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/2/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Quintuple <_Type1, _Type2, _Type3, _Type4, _Type5> {
    /**
     * The first element of the Quintuple.
     */
    public _Type1 first;
    /**
     * The second element of the Quintuple.
     */
    public _Type2 second;
    /**
     * The third element of the Quintuple.
     */
    public _Type3 third;
    /**
     * The fourth element of the Quintuple.
     */
    public _Type4 fourth;
    /**
     * The fifth element of the Quintuple.
     */
    public _Type5 fifth;

    /**
     * Creates a new Quintuple with the specified values for the
     * elements.
     *
     * @param first  the first value of the Quintuple.
     * @param second the second value of the Quintuple.
     * @param third  the third value of the Quintuple.
     * @param fourth the third value of the Quintuple.
     * @param fifth the third value of the Quintuple.
     */
    public Quintuple(_Type1 first, _Type2 second, _Type3 third, _Type4 fourth, _Type5 fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    /**
     * Tests this Quintuple for equality with another Object.
     * <p>
     * Returns false if the Object to be tested is null or is not Quintuple.
     * <p>
     * Two quintuples are considered equal if and only if all element are
     * one by one equals.
     *
     * @param other the object which will be equality compared with the quintuple.
     * @return true if the Quintuple and the object are equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Quintuple))
            return false;
        Quintuple<?, ?, ?, ?, ?> p = (Quintuple<?, ?, ?, ?, ?>) other;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second) && Objects.equals(p.third, third) && Objects.equals(p.fourth, fourth)
                && Objects.equals(p.fifth, fifth);
    }

    /**
     * Generates a hash code for the Quintuple.
     * <p>
     * The generated hash code is calculated using the hashes of the
     * elements of the tuple.
     *
     * @return a hash for the Quintuple.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode())
                ^ (third == null ? 0 : third.hashCode()) ^ (fourth == null ? 0 : fourth.hashCode())
                ^ (fifth == null ? 0 : fifth.hashCode());
    }

    /**
     * Returns the String representation of the Quintuple.
     * <p>
     * The created string is composed of the string representation of
     * the underlying objects separated by a comma (',') and surrounded
     * by parenthesis ('(' and ')').
     *
     * @return the String representation of the Quintuple.
     */
    @Override
    public String toString() {
        return "(" + (first == null ? "null" : first.toString()) + ", " + (second == null ? "null" : second.toString()) + ", " +
                (third == null ? "null" : third.toString()) + ", " + (fourth == null ? "null" : fourth.toString()) + ", " +
                (fifth == null ? "null" : fifth.toString()) + ")" ;
    }

    /**
     * Creates a new types parameterized quintuple with the specified
     * values.
     *
     * @param first     the first value in the quintuple.
     * @param second    the second value in the quintuple.
     * @param third     the third value in the quintuple.
     * @param fourth    the fourth value in the quintuple.
     * @param fifth     the fifth value in the quintuple.
     * @param <_Type1>  the first type parameter of the method, used
     *                  as the first type of the quintuple.
     * @param <_Type2>  the second type parameter of the method, used
     *                  as the second type of the quintuple.
     * @param <_Type3>  the third type parameter of the method, used
     *                  as the third type of the quintuple.
     * @param <_Type4>  the fourth type parameter of the method, used
     *                  as the fourth type of the quintuple.
     * @param <_Type5>  the fifth type parameter of the method, used
     *                  as the fifth type of the quintuple.
     * @return a Quintuple parameterized with it's elements.
     */
    public static <_Type1, _Type2, _Type3, _Type4, _Type5> Quintuple<_Type1, _Type2, _Type3, _Type4, _Type5>
            create(_Type1 first, _Type2 second, _Type3 third, _Type4 fourth, _Type5 fifth) {
        return new Quintuple<>(first, second, third, fourth, fifth);
    }
}
