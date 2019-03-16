/**
 * 
 */
package com.flipkart.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rochak
 *
 */
public class Person {
    int id;

    String name;

    List<Integer> productIds;

    public Person(int _id, String _name) {
        id = _id;
        name = _name;
        productIds = new ArrayList<Integer>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void addProductId(int productId) {
        productIds.add(productId);
    }

    public void removeLastProductId(int productId) {
        int index = productIds.lastIndexOf(productId);
        if (index != -1) {
            productIds.remove(index);
        }
    }

    public void blacklist() {
        productIds = new ArrayList<Integer>();
    }
}
