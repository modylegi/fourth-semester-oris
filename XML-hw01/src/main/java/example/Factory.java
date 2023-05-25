package example;

public class Factory {
    Book book;

    public Factory(Book book) {
        this.book = book;
    }

    public Factory() {}

    public String start() {
        return book.getGenre();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
