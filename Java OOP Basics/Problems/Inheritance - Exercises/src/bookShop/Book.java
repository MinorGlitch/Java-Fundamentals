package bookShop;

import java.util.function.Predicate;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private void setAuthor(String author) {
        String[] authorNames = author.split("\\s+");

        if (authorNames.length == 2 && startsWithDigit.test(authorNames[1])) {
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    private Predicate<String> startsWithDigit = name -> Character.isDigit(name.charAt(0));

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;

    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() +
                System.lineSeparator() +
                "Title: " + this.getTitle() +
                System.lineSeparator() +
                "Author: " + this.getAuthor() +
                System.lineSeparator() +
                "Price: " + this.getPrice() +
                System.lineSeparator();
    }
}
