/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.vivelibre.springboot.app.api;

import com.vivelibre.springboot.app.domain.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-14T20:59:20.003255800+01:00[Europe/Madrid]")
@Validated
@Tag(name = "books", description = "the books API")
public interface BooksApi {

    /**
     * GET /books : Obtener todos los libros
     *
     * @return Lista de libros obtenida correctamente (status code 200)
     *         or Error interno del servidor. (status code 500)
     */
    @Operation(
        operationId = "getBooks",
        summary = "Obtener todos los libros",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de libros obtenida correctamente", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Book.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/books",
        produces = { "application/json" }
    )

    @GetMapping("/allBooks")
    ResponseEntity<List<Book>> getBooks();

    /**
     * GET /longBooksAndHarryName : Obtener todos los libros
     *
     * @return Lista de libros obtenida correctamente (status code 200)
     *         or Bad Request (status code 400)
     *         or Not found (status code 404)
     *         or Error interno del servidor. (status code 500)
     */
    @Operation(
            operationId = "getLongBooksAndHarryName",
            summary = "Obtener todos los libros",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de libros obtenida correctamente", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Book.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/longBooksAndHarryName",
            produces = { "application/json" }
    )

    @GetMapping("/longBooksAndHarryName")
    ResponseEntity<List<Book>> getLongBooksAndHarryName();
}
