package org.howard.edu.lsp.assignment3;

/**
 * Represents a transformation step that converts an input object of type T
 * into a (possibly modified) object of the same type.
 *
 * @param <T> the object type being transformed
 *
 * @author Caleb Harris
 * @version 1.0
 */
public interface Transformer<T> {

    /**
     * Applies a transformation to the given input.
     *
     * @param input the input object
     * @return the transformed object
     */
    T apply(T input);
}