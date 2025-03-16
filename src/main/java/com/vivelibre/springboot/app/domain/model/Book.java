package com.vivelibre.springboot.app.domain.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/**
 * Book
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-15T22:09:19.942181200+01:00[Europe/Madrid]")
public class Book {

  private Integer id;

  private String title;

  private String publicationTimestamp;

  private Integer pages;

  private Integer wordCount;

  private String summary;

  private Author author;

  public Book id(Integer id) {
    this.id = id;
    return this;
  }

  public Integer getWordCount() {
    return wordCount;
  }

  public void setWordCount(Integer wordCount) {
    this.wordCount = wordCount;
  }

  /**
   * Get id
   * @return id
   */

  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */

  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book publicationTimestamp(String publicationTimestamp) {
    this.publicationTimestamp = publicationTimestamp;
    return this;
  }

  /**
   * Get publicationTimestamp
   * @return publicationTimestamp
   */

  @Schema(name = "publicationTimestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publicationTimestamp")
  public String getPublicationTimestamp() {
    return publicationTimestamp;
  }

  public void setPublicationTimestamp(String publicationTimestamp) {
    this.publicationTimestamp = publicationTimestamp;
  }

  public Book pages(Integer pages) {
    this.pages = pages;
    return this;
  }

  /**
   * Get pages
   * @return pages
   */

  @Schema(name = "pages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pages")
  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public Book summary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
   */

  @Schema(name = "summary", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("summary")
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Book author(Author author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   */
  @Schema(name = "author", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("author")
  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) &&
            Objects.equals(this.title, book.title) &&
            Objects.equals(this.publicationTimestamp, book.publicationTimestamp) &&
            Objects.equals(this.pages, book.pages) &&
            Objects.equals(this.summary, book.summary) &&
            Objects.equals(this.author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, publicationTimestamp, pages, summary, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    publicationTimestamp: ").append(toIndentedString(publicationTimestamp)).append("\n");
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

