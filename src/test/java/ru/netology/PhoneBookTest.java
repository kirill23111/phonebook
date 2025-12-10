package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void addSingleContactReturnsSize1() {
        PhoneBook book = new PhoneBook();
        int size = book.add("Alice", "111");
        assertEquals(1, size);
    }

    @Test
    void addMultipleContactsReturnsCorrectSize() {
        PhoneBook book = new PhoneBook();
        book.add("Alice", "111");
        int size = book.add("Bob", "222");
        assertEquals(2, size);
    }

    @Test
    void findByNumberReturnsCorrectName() {
        PhoneBook book = new PhoneBook();
        book.add("Alice", "111");
        book.add("Bob", "222");

        assertEquals("Alice", book.findByNumber("111"));
        assertEquals("Bob", book.findByNumber("222"));
    }

    @Test
    void findByNumberReturnsNullIfNotFound() {
        PhoneBook book = new PhoneBook();
        book.add("Alice", "111");

        assertNull(book.findByNumber("999"));
    }
}