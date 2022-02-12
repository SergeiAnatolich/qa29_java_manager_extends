package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(1, "Adventures of Tom Sawyer", 100, "Mark Twain");
    private Product book2 = new Book(2, "Treasure Island", 150, "Robert Louis Stevenson");
    private Product book3 = new Book(3, "Alice in Wonderland", 130, "Lewis Carroll");
    private Product smartphone1 = new Smartphone(4, "3310", 1000, "Nokia");
    private Product smartphone2 = new Smartphone(5, "Galaxy", 1200, "Samsung");
    private Product smartphone3 = new Smartphone(6, "Xperia", 1150, "Sony");

    @Test
    void add() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Treasure Island");

        assertArrayEquals(expected, actual);
    }
}