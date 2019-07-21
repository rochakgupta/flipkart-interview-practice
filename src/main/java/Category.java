import java.util.HashSet;
import java.util.Set;

public class Category {
    int id;

    String name;

    Set<Integer> productIds;

    public Category(int _id, String _name) {
        id = _id;
        name = _name;
        productIds = new HashSet<Integer>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addProductId(int productId) {
        productIds.add(productId);
    }
}
