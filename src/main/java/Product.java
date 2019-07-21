public class Product {
    int id;

    String name;

    int categoryId;

    public Product(int _id, String _name, int _categoryId) {
        id = _id;
        name = _name;
        categoryId = _categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
