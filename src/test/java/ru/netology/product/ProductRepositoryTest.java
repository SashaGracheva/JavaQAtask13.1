package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product item1 = new Book(1, "Чапаев и пустота", 350, "Пелевин");
    Product item2 = new Book(2, "Сердце Пармы", 180, "Иванов");
    Product item3 = new Smartphone(3, "Xiaomi Redmi", 6990, "China");

    @Test
    public void shouldRemoveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(2);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoOne() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }
}
