package integration;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<User> users;
    private List<Category> categories;

    public Category(String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.categories = new ArrayList<>();
    }


}
