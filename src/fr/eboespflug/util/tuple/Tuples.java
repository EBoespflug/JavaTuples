package fr.eboespflug.util.tuple;

/**
 * /TMP/
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 2/12/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Tuples {
    public static <_Type1> Single create(_Type1 a) {
        return new Single<>(a);
    }

    public static <_Type1, _Type2> Pair create(_Type1 a, _Type2 b) {
        return new Pair<>(a, b);
    }

    public static <_Type1, _Type2, _Type3> Triplet create(_Type1 a, _Type2 b, _Type3 c) {
        return new Triplet<>(a, b, c);
    }

    public static <_Type1, _Type2, _Type3, _Type4> Quadruple create(_Type1 a, _Type2 b, _Type3 c, _Type4 d) {
        return new Quadruple<>(a, b, c, d);
    }

    public static <_Type1, _Type2, _Type3, _Type4, _Type5> Quintuple create(_Type1 a, _Type2 b, _Type3 c, _Type4 d, _Type5 e) {
        return new Quintuple<>(a, b, c, d, e);
    }

    public static <_Type1, _Type2, _Type3, _Type4, _Type5, _Type6> Sextuple create(_Type1 a, _Type2 b, _Type3 c, _Type4 d, _Type5 e, _Type6 f) {
        return new Sextuple<>(a, b, c, d, e, f);
    }
}
