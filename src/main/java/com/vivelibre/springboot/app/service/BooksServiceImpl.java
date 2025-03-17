package com.vivelibre.springboot.app.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivelibre.springboot.app.domain.model.Book;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BooksServiceImpl implements BooksService{

    private List<Book> books;

    @PostConstruct
    public void loadBooksFromJson() {

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            books = objectMapper.readValue(new ClassPathResource("books.json").getInputStream(),
                    new TypeReference<List<Book>>() {});
        } catch (JsonParseException e) {
            throw new RuntimeException("Syntax error in books.json: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + e.getMessage());
        }
        }

    @Override
    public List<Book> get400pagesAnsHarryNameBooks() {

        log.info("get400pagesAnsHarryNameBooks method implementation");
        return books.stream().filter(book -> book.getPages() > 400 && book.getTitle().toLowerCase().contains("harry")).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByJKRowling() {

        log.info("getBooksByJKRowling method implementation");
        return books.stream().filter(book -> book.getAuthor().getName().contains("J.K. Rowling")).collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> getBooksByAuthorAndSort() {

        log.info("getBooksByAuthorAndSort method implementation START");

        //To get books sorted alphabetically
        List<String> titles = books.stream().map(Book::getTitle).sorted().toList();

        log.info("titles: {}", titles);

        //Count books written by author
        Map<String, Long> booksPerAuthor = books.stream().collect(Collectors.groupingBy(book -> book.getAuthor().getName(), Collectors.counting()));

        log.info("booksPerAuthor: {}", booksPerAuthor);

        //Combine the results in a Map to return both collections
        Map<String, Object> result = new HashMap<>();
        result.put("titles", titles);
        result.put("booksPerAuthor", booksPerAuthor);

        return result;
    }

    @Override
    public List<Book> booksDateFormatter(List<Book> books) {

        books.forEach(book -> {
            LocalDate date = Instant.ofEpochMilli(Long.decode(book.getPublicationTimestamp()))
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        });
        return books;
    }

    @Override
    public Map<String, Object> getCalculatePageStats() {

        if(books == null || books.isEmpty()){
            log.warn("The list of books is empty");
            return Map.of(
                    "averagePages", 0.0,
                    "maxPagesBook", null,
                    "minPagesBook", null
            );
        }

        //Calculate page's average
        double average = books.stream()
                .mapToInt(Book::getPages)
                .average()
                .orElse(0.0);
        log.info("Page average: {}", average);

        //Find the book with more number of pages
        Optional<Book> maxPagesBook = books.stream()
                .max(Comparator.comparingInt(Book::getPages));

        maxPagesBook.ifPresent(book ->
                log.info("The book with more number of pages: {}", book.getTitle()));

        //Find the book with less number of pages
        Optional<Book> minPagesBook = books.stream()
                .min(Comparator.comparingInt(Book::getPages));

        minPagesBook.ifPresent(book ->
                log.info("The book with less number of pages: {}", book.getTitle()));

        //Return the results as a map
        return Map.of(
                "averagePages", average,
                "maxPagesBook", maxPagesBook,
                "minPagesBook", minPagesBook
        );
    }

    @Override
    public Map<String, List<Book>> getBooksByAuthor() {

        if(books == null || books.isEmpty()){
            log.warn("The list of books is empty or null");
            return Map.of();
        }

        books.forEach(book -> {
            int wordCount = book.getPages() * 250;
            book.setWordCount(wordCount);
            log.info("The book has a new field, wordCount: {}", wordCount);
        });

        //Books by Author
        return books.stream().collect(Collectors.groupingBy(book -> book.getAuthor().getName()));
    }

    @Override
    public Map<String, Object> getAuthorDuplicatedAndNotTimestamp() {

        //Verify duplicated Authors
        Set<String> duplicateAuthors = books.stream()
                .collect(Collectors.groupingBy(book -> book.getAuthor().getName(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        //Find books without publicationTimeStamp
        List<Book> booksWithoutTimeStamp = books.stream()
                .filter(book -> book.getPublicationTimestamp() == null)
                .toList();

        Map<String, Object> result = new HashMap<>();
        result.put("duplicateAuthors", duplicateAuthors);
        result.put("booksWithoutTimeStamp", booksWithoutTimeStamp);

        return result;
    }

    @Override
    public List<Book> getNewestBooks() {
        return books.stream()
                .filter(book -> book.getPublicationDate() != null)
                .sorted(Comparator.comparing(Book::getPublicationDate).reversed())
                .collect(Collectors.toList());
    }

}
