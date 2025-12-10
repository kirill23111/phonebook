package ru.netology;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    @Test
    void findByNameReturnsCorrectNumber() {
        PhoneBook book = new PhoneBook();
        book.add("Alice", "111");
        book.add("Bob", "222");

        assertEquals("111", book.findByName("Alice"));
        assertEquals("222", book.findByName("Bob"));
    }

    @Test
    void findByNameReturnsNullIfNotFound() {
        PhoneBook book = new PhoneBook();
        book.add("Alice", "111");

        assertNull(book.findByName("Charlie"));
    }
    @Test
    void printAllNamesPrintsSortedNames() {
        PhoneBook book = new PhoneBook();
        book.add("Charlie", "333");
        book.add("Alice", "111");
        book.add("Bob", "222");

        // Перехватываем вывод
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        book.printAllNames();

        System.setOut(original);

        String result = out.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "Alice",
                "Bob",
                "Charlie"
        );

        assertEquals(expected, result);
    }
}