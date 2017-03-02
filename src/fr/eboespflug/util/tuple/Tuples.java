package fr.eboespflug.util.tuple;

/**
 * /TMP/
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 2/12/2017.
 */
@SuppressWarnings("WeakerAccess")
public class Tuples {

    public static <_Type1, _Type2> Pair create(_Type1 a, _Type2 b) {
        return new Pair<>(a, b);
    }

    public static <_Type1, _Type2, _Type3> Triplet create(_Type1 a, _Type2 b, _Type3 c) {
        return new Triplet<>(a, b, c);
    }

    public static <_Type1, _Type2, _Type3, _Type4> Quadruple create(_Type1 a, _Type2 b, _Type3 c, _Type4 d) {
        return new Quadruple<>(a, b, c, d);
    }
}
