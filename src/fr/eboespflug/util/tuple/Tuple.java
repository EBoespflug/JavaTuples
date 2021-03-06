package fr.eboespflug.util.tuple;

/**
 * The Tuple interface provide an unified
 * interface for Tuple manipulation.
 * <p>
 * However, most of the method provided by the
 * Tuple interface are not type-safe as the element
 * are manipulated by Object references.
 *
 * @author Etienne Boespflug
 * @since 1.0
 *
 * Created by Etienne Boespflug on 3/1/2017.
 */
public interface Tuple
{
    /**
     * Returns the element in the tuple at the specified
     * index.
     * <p>
     * If {@code elementIndex} doesn't refer to an existing
     * element in the tuple, throws IndexOutOfBoundsException.
     *
     * @param elementIndex the index of the element in the tuple.
     * @return the element as the specified index as an Object.
     */
    Object get(int elementIndex) throws IndexOutOfBoundsException;

    /**
     * Returns the type (Class) of the element in the tuple at the
     * specified index.
     * <p>
     * If {@code elementIndex} doesn't refer to an existing
     * element in the tuple, throws IndexOutOfBoundsException.
     *
     * TODO() what for null element ?
     *
     * @param elementIndex the index of the element in the tuple.
     * @return the type (Class) of the element as the specified index.
     */
    default Class getType(int elementIndex) throws IndexOutOfBoundsException
    {
        return get(elementIndex).getClass();
    }

    /**
     * @return the number of element in the Tuple.
     */
    int count();
}
