import java.util.*;

abstract class Category {
    String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }
}

class BookCategory extends Category {
    BookCategory() {
        super("Book");
    }
}

class ClothingCategory extends Category {
    ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    GadgetCategory() {
        super("Gadget");
    }
}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void display() {
        System.out.println(name + " | " + category.categoryName + " | Price: ₹" + price);
    }
}

public class Main {
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price = product.price - (product.price * percentage / 100);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 800, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 20000, new GadgetCategory());

        applyDiscount(book, 10);
        applyDiscount(phone, 15);

        book.display();
        shirt.display();
        phone.display();
    }
}=
