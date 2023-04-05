package ru.netology.product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() {

        return items;
    }

    public Product[] findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return items;
            }
        }
        return null;
    }


    public void removeById(int id) {
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            Product[] a = findById(id);
            if (a == null) {
                throw new NotFoundException(
                        "ID с номером: " + id + " не существует");
            }
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }


}
