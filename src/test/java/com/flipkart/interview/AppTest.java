package com.flipkart.interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppTest {
    private static App app;

    private Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    @BeforeClass
    public static void initialize() {
        app = new App();
        app.createPerson(1, "Person 1");
        app.createPerson(2, "Person 2");
        app.createPerson(3, "Person 3");
        app.createCategory(1, "Category 1");
        app.createProduct(1, "Category 1 Product 1", 1);
        app.createProduct(2, "Category 1 Product 2", 1);
        app.createProduct(3, "Category 1 Product 3", 1);
        app.createCategory(2, "Category 2");
        app.createProduct(4, "Category 2 Product 1", 2);
        app.createProduct(5, "Category 2 Product 1", 2);
        app.createProduct(6, "Category 2 Product 1", 2);
    }

    @Test
    public void testBestSellingProduct() {
        app.purchaseProduct(1, 5);
        app.purchaseProduct(1, 4);
        app.purchaseProduct(1, 3);
        app.purchaseProduct(2, 1);
        app.purchaseProduct(2, 1);
        app.purchaseProduct(2, 3);
        app.purchaseProduct(3, 1);
        app.purchaseProduct(3, 4);
        app.purchaseProduct(3, 6);
        app.blacklistPerson(1);
        app.returnProduct(2, 1);
        Product product = app.getBestSellingProduct();
        print(product);
        assertNotNull(product);
        assertEquals(1, product.getId());
    }

    public void print(Object object) {
        System.out.println(gson.toJson(object));
    }
}
