package com.flipkart.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    private Map<Integer, Person> persons;

    private Map<Integer, Category> categories;

    private Map<Integer, Product> products;

    public App() {
        persons = new HashMap<Integer, Person>();
        categories = new HashMap<Integer, Category>();
        products = new HashMap<Integer, Product>();
    }

    public void createPerson(int id, String name) {
        persons.put(id, new Person(id, name));
    }

    public void createCategory(int id, String name) {
        categories.put(id, new Category(id, name));
    }

    public void createProduct(int id, String name, int categoryId) {
        products.put(id, new Product(id, name, categoryId));
        Category category = categories.get(categoryId);
        category.addProductId(id);
    }

    public void purchaseProduct(int personId, int productId) {
        Person person = persons.get(personId);
        person.addProductId(productId);
    }

    public void returnProduct(int personId, int productId) {
        Person person = persons.get(personId);
        person.removeLastProductId(productId);
    }

    public void blacklistPerson(int personId) {
        Person person = persons.get(personId);
        person.resetProductIds();
    }

    public Product getBestSellingProduct() {
        Product bestSellingProduct = null;
        Integer bestSellingProductId = null;
        int bestSellingProductQuantitySold = 0;
        Map<Integer, Set<Integer>> productIdToPersonIds = new HashMap<Integer, Set<Integer>>();
        for (Person person : persons.values()) {
            int personId = person.getId();
            List<Integer> productIds = person.getProductIds();
            for (int productId : productIds) {
                Set<Integer> personIds = productIdToPersonIds.getOrDefault(productId, new HashSet<Integer>());
                personIds.add(personId);
                productIdToPersonIds.put(productId, personIds);
                int productQuantitySold = personIds.size();
                if (productQuantitySold > bestSellingProductQuantitySold) {
                    bestSellingProductId = productId;
                    bestSellingProductQuantitySold = productQuantitySold;
                }
            }
        }
        if (bestSellingProductId != null) {
            bestSellingProduct = products.get(bestSellingProductId);
        }
        return bestSellingProduct;
    }
}
