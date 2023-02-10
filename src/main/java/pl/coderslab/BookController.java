package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> allBooks() {
        log.info("Get all books");
        return bookService.getAllBooks();
    }

    @RequestMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("")
    public void editBook(@RequestBody Book book) {
        bookService.editBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

}

/*
    curl -X POST -i -H "Content-Type: application/json" -d '{"isbn":"1100294652","title":"The Road", "publisher":"Reading World","type":"science fiction", "author":"Cormac McCarthy"}' http://localhost:8080/books
    curl -X DELETE -i  http://localhost:8080/books/2
    curl -X PUT -i -H "Content-Type: application/json" -d '{"id":3,"isbn":"1122233","title":"Old Man And The Sea",  "publisher":"World Industries","type":"novel", "author":"Ernest Hemingway"}' http://localhost:8080/books
 */
