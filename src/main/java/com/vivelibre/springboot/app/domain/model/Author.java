package com.vivelibre.springboot.app.domain.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Author
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-15T21:57:21.387887400+01:00[Europe/Madrid]")
public class Author {

  private String name;

  private String firstSurname;

  private String bio;

  public Author name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */

  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Author firstSurname(String firstSurname) {
    this.firstSurname = firstSurname;
    return this;
  }

  /**
   * Get firstSurname
   * @return firstSurname
   */

  @Schema(name = "firstSurname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstSurname")
  public String getFirstSurname() {
    return firstSurname;
  }

  public void setFirstSurname(String firstSurname) {
    this.firstSurname = firstSurname;
  }

  public Author bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Get bio
   * @return bio
   */

  @Schema(name = "bio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Author author = (Author) o;
    return Objects.equals(this.name, author.name) &&
            Objects.equals(this.firstSurname, author.firstSurname) &&
            Objects.equals(this.bio, author.bio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, firstSurname, bio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Author {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstSurname: ").append(toIndentedString(firstSurname)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
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

