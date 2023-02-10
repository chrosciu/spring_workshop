package pl.coderslab;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class JpaBookService implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long bookId) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        book.setTitle("AAAA");
    }

    @Override
    public void editBook(Book book) {

    }

    @Override
    public void deleteBook(long bookId) {

    }
}
