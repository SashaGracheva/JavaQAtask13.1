package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProductManagerTests {
    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Чапаев и пустота", 350, "Пелевин");
    Product item2 = new Book(2, "Сердце Пармы", 180, "Иванов");
    Product item3 = new Smartphone(3, "Xiaomi Redmi", 6990, "China");


    @Test
    public void shouldAddProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        Product[] actual = repo.findAll();
        Product[] expected = {item1, item2, item3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBy() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        Product[] actual = manager.searchBy("Сердце Пармы");
        Product[] expected = {item2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNotOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product item4 = new Smartphone(4, "Xiaomi Redmi", 8990, "China");
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        Product[] actual = manager.searchBy("Xiaomi Redmi");
        Product[] expected = {item3, item4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        Product[] actual = manager.searchBy("Сердце Москвы");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}



