package Dao;

public class Book {
    private String bookName;
    private int bookId;
    private String bookPrice;
    private String bookPress;
    public Book(){

    }

    public Book(String bookName, String bookPrice, String bookPress) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookPress = bookPress;
    }

    public Book(String bookName, int bookId, String bookPrice, String bookPress) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.bookPress = bookPress;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }
}


