package com.vivelibre.springboot.app.api;

import com.vivelibre.springboot.app.domain.model.Book;
import com.vivelibre.springboot.app.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController implements BooksApi{

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public ResponseEntity<List<Book>> getBooks() {
        return null;
    }

    @Override
    public ResponseEntity<List<Book>> getLongBooksAndHarryName() {
        return ResponseEntity.ok(booksService.get400pagesAnsHarryNameBooks());
    }
}
