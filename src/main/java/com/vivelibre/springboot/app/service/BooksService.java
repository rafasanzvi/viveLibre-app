package com.vivelibre.springboot.app.service;

import com.vivelibre.springboot.app.domain.model.Book;

import java.util.List;
import java.util.Map;

public interface BooksService {

    List<Book> get400pagesAnsHarryNameBooks();

    List<Book> getBooksByJKRowling();

    Map<String, Object> getBooksByAuthorAndSort();

    List<Book> booksDateFormatter(List<Book> books);

    Map<String, Object> getCalculatePageStats();

    Map<String, List<Book>> getBooksByAuthor();

    Map<String, Object> getAuthorDuplicatedAndNotTimestamp();
}
