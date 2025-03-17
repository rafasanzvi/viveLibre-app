//package com.vivelibre.springboot.app.api;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.vivelibre.springboot.app.domain.model.Author;
//import com.vivelibre.springboot.app.domain.model.Book;
//import com.vivelibre.springboot.app.service.BooksServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import java.util.*;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(MockitoExtension.class)
//class BooksServiceImplTest {
//
//	@InjectMocks
//	private BooksServiceImpl booksService;
//
//	private List<Book> mockBooks;
//
//	@BeforeEach
//	void setUp() {
//		Author author1 = new Author("J.K. Rowling");
//		Author author2 = new Author("Stephen King");
//
//		mockBooks = List.of(
//				new Book("Harry Potter", 450, author1, "1625097600000"),
//				new Book("The Shining", 350, author2, "1625097600000"),
//				new Book("Harry Potter and the Chamber of Secrets", 410, author1, "1625097600000"),
//				new Book("It", 1138, author2, "1625097600000")
//		);
//
//		List<Book> books = new ArrayList<>(mockBooks);
//	}
//
//	@Test
//	void testGet400pagesAnsHarryNameBooks() {
//		List<Book> result = booksService.get400pagesAnsHarryNameBooks();
//		assertThat(result).hasSize(2);
//		assertThat(result).extracting(Book::getTitle).contains("Harry Potter", "Harry Potter and the Chamber of Secrets");
//	}
//
//	@Test
//	void testGetBooksByJKRowling() {
//		List<Book> result = booksService.getBooksByJKRowling();
//		assertThat(result).hasSize(2);
//		assertThat(result).extracting(Book::getAuthor).extracting(Author::getName).containsOnly("J.K. Rowling");
//	}
//
//	@Test
//	void testGetBooksByAuthorAndSort() {
//		Map<String, Object> result = booksService.getBooksByAuthorAndSort();
//
//		assertThat(result.get("titles")).isInstanceOf(List.class);
//		List<String> titles = (List<String>) result.get("titles");
//		assertThat(titles).isSorted();
//
//		Map<String, Long> booksPerAuthor = (Map<String, Long>) result.get("booksPerAuthor");
//		assertThat(booksPerAuthor).containsEntry("J.K. Rowling", 2L).containsEntry("Stephen King", 2L);
//	}
//
//	@Test
//	void testGetCalculatePageStats() {
//		Map<String, Object> result = booksService.getCalculatePageStats();
//
//		assertThat(result.get("averagePages")).isEqualTo((450 + 350 + 410 + 1138) / 4.0);
//		assertThat(((Optional<Book>) result.get("maxPagesBook")).get().getTitle()).isEqualTo("It");
//		assertThat(((Optional<Book>) result.get("minPagesBook")).get().getTitle()).isEqualTo("The Shining");
//	}
//
//	@Test
//	void testGetBooksByAuthor() {
//		Map<String, List<Book>> result = booksService.getBooksByAuthor();
//
//		assertThat(result).containsKeys("J.K. Rowling", "Stephen King");
//		assertThat(result.get("J.K. Rowling")).hasSize(2);
//		assertThat(result.get("Stephen King")).hasSize(2);
//	}
//
//	@Test
//	void testGetAuthorDuplicatedAndNotTimestamp() {
//		Map<String, Object> result = booksService.getAuthorDuplicatedAndNotTimestamp();
//
//		Set<String> duplicateAuthors = (Set<String>) result.get("duplicateAuthors");
//		List<Book> booksWithoutTimestamp = (List<Book>) result.get("booksWithoutTimeStamp");
//
//		assertThat(duplicateAuthors).containsExactlyInAnyOrder("J.K. Rowling", "Stephen King");
//		assertThat(booksWithoutTimestamp).isEmpty();
//	}
//}
