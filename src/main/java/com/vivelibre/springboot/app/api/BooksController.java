package com.vivelibre.springboot.app.api;

import com.vivelibre.springboot.app.client.ExternalServiceClient;
import com.vivelibre.springboot.app.client.TokenProcessor;
import com.vivelibre.springboot.app.domain.model.Book;
import com.vivelibre.springboot.app.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BooksController implements BooksApi{

    @Autowired
    private ExternalServiceClient externalServiceClient;

    @Autowired
    private TokenProcessor tokenProcessor;

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/token")
    public ResponseEntity<Map<String, String>> getProcessedToken() {

        String token = externalServiceClient.getToken();

        if(token == null || token.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("Error", "Token unable or empty"));
        }
        Map<String, String> response = tokenProcessor.processToken(token);
        return ResponseEntity.ok(response);
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

    @Override
    public ResponseEntity<Map<String, Object>> getAuthorDuplicatedAndNotTimestamp() {
        return ResponseEntity.ok(booksService.getAuthorDuplicatedAndNotTimestamp());
    }
}
