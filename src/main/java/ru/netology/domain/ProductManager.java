package ru.netology.domain;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int i = 0;
        Product[] tmp = new Product[1];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                tmp[0] = product;
            }
            result = tmp;
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getProductName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // if в одну строку:
//         return product.getProductName().contains(search);
    }

    public Product[] findAll() {
        return repository.findAll();
    }
}