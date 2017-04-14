package collections.Lesson.Set;

import java.util.SortedSet;
import java.util.*;

/**
 * Created by dos on 11.12.2016.
 */
public class TestSetTree {
    public static void main(String... args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);
        NavigableSet<Item> sortByDescryption = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescryption.addAll(parts);
        System.out.println(sortByDescryption);
        Integer a = 34;
        a.hashCode();
    }
}

class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }

    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription() {
        return "[description =" + description + ",partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    public int hashCode() {
        return Objects.hash(description, partNumber);
    }
}