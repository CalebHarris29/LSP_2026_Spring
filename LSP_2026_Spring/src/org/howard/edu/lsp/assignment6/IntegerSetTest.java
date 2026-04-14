package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());

        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testNotEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(3);

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);

        assertTrue(set.contains(5));
        assertFalse(set.contains(10));
    }

    @Test
    public void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(9);
        set.add(1);

        assertEquals(9, set.largest());
    }

    @Test
    public void testLargestException() {
        IntegerSet set = new IntegerSet();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            set.largest();
        });

        assertEquals("Set is empty", exception.getMessage());
    }

    @Test
    public void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(9);
        set.add(1);

        assertEquals(1, set.smallest());
    }

    @Test
    public void testSmallestException() {
        IntegerSet set = new IntegerSet();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            set.smallest();
        });

        assertEquals("Set is empty", exception.getMessage());
    }

    @Test
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);

        assertEquals(2, set.length());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
    }

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.remove(1);

        assertFalse(set.contains(1));
        assertEquals(1, set.length());
    }

    @Test
    public void testRemoveNonExistentElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(5);

        assertEquals(1, set.length());
        assertTrue(set.contains(1));
    }

    @Test
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(2);
        set2.add(3);

        IntegerSet result = set1.union(set2);

        assertEquals("[1, 2, 3]", result.toString());
    }

    @Test
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertEquals("[2, 3]", result.toString());
    }

    @Test
    public void testIntersectNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertTrue(result.isEmpty());
        assertEquals("[]", result.toString());
    }

    @Test
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);

        IntegerSet result = set1.diff(set2);

        assertEquals("[1, 3]", result.toString());
    }

    @Test
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);

        assertEquals("[3, 4]", result.toString());
    }

    @Test
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());

        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToString() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());

        set.add(3);
        set.add(1);
        set.add(2);

        assertEquals("[1, 2, 3]", set.toString());
    }
}