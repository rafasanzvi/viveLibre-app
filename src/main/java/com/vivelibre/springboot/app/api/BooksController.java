package com.vivelibre.springboot.app.api;

import com.vivelibre.springboot.app.domain.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController implements BooksApi{
    @Override
    public ResponseEntity<List<Book>> getBooks() {
        return null;
    }
}
