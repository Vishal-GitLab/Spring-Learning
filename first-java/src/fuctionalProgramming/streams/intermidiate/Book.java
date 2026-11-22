package fuctionalProgramming.streams.intermidiate;


// stream ko ham custom class par bhi use kar sakte hai
public class Book {
    public String title;
    int publicationsYear;
    public double price;
    String category;

    public Book(String title, double price, int publicationsYear, String category )  {
        this.title = title;
        this.price = price;
        this.publicationsYear = publicationsYear;
        this.category = category;
    }

    @Override
    public String toString() {
    return "Book{" +
          "category='" + category + '\'' +
           ", title='" + title + '\'' +
          ", publicationsYear=" + publicationsYear +
            ", price=" + price +
            '}';

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublicationsYear() {
        return publicationsYear;
    }

    public void setPublicationsYear(int publicationsYear) {
        this.publicationsYear = publicationsYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
