package com.vivelibre.springboot.app.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vivelibre.springboot.app.domain.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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
        return books;
    }
}
