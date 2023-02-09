package pl.coderslab;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long bookId);
    void addBook(Book book);
    void editBook(Book book);
    void deleteBook(long bookId);
}
