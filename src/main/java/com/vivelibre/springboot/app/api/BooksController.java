package com.vivelibre.springboot.app.api;

import com.vivelibre.springboot.app.domain.model.Book;
import com.vivelibre.springboot.app.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BooksController implements BooksApi{

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public ResponseEntity<List<Book>> getLongBooksAndHarryName() {

        return ResponseEntity.ok(booksService.get400pagesAnsHarryNameBooks());
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByJKRowling() {
        return ResponseEntity.ok(booksService.getBooksByJKRowling());
    }

    @Override
    public ResponseEntity<Map<String, Object>> getSortAndBooksNumber() {
        return ResponseEntity.ok(booksService.getBooksByAuthorAndSort());
    }

    @Override
    public ResponseEntity<List<Book>> booksDateFormatter(List<Book> books) {
        return ResponseEntity.ok(booksService.booksDateFormatter(books));
    }

    @Override
    public ResponseEntity<Map<String, Object>> getCalculatePageStats() {
        return ResponseEntity.ok(booksService.getCalculatePageStats());
    }

    @Override
    public ResponseEntity<Map<String, List<Book>>> getBooksByAuthor() {
        return ResponseEntity.ok(booksService.getBooksByAuthor());
    }
}
