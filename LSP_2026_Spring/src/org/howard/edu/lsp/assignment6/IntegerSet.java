package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet class representing a mathematical set of integers.
 * This set does not allow duplicate values and supports standard set operations.
 */
public class IntegerSet {

    private ArrayList<Integer> set;

    /**
     * Default constructor that initializes an empty set.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal (contain the same elements).
     * @param b the set to compare with
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) return false;
        return this.set.containsAll(b.set) && b.set.containsAll(this.set);
    }

    /**
     * Checks if the set contains a specific value.
     * @param value the value to check
     * @return true if the value exists in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * @return the largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) throw new RuntimeException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     * @return the smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) throw new RuntimeException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     * @param b the other set
     * @return a new set containing all unique elements from both sets
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        for (int num : b.set) {
            if (!result.set.contains(num)) {
                result.set.add(num);
            }
        }
        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and another set.
     * @param b the other set
     * @return a new set containing elements common to both sets
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (b.set.contains(num)) {
                result.set.add(num);
            }
        }
        return result;
    }

    /**
     * Returns a new set that is the difference of this set and another set.
     * @param b the other set
     * @return a new set containing elements in this set but not in b
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (!b.set.contains(num)) {
                result.set.add(num);
            }
        }
        return result;
    }

    /**
     * Returns a new set that is the complement of this set relative to another set.
     * @param b the other set
     * @return a new set containing elements in b but not in this set
     */
    public IntegerSet complement(IntegerSet b) {
        return b.diff(this);
    }

    /**
     * Checks if the set is empty.
     * @return true if the set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     * @return sorted string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}