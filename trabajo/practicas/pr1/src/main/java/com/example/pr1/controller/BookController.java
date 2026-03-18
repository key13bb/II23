package com.example.pr1.controller;


import com.example.pr1.objects.Book;
import com.example.pr1.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Book> getLibrary() {
        return service.getAllBooks();
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody Book book, UriComponentsBuilder uriBuilder) throws Exception {
        Book addedBook = service.addBook(book);
        URI location = uriBuilder.path("/libros/{id}").buildAndExpand(addedBook.getId()).toUri();
        return ResponseEntity.created(location).body(addedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        Book book = service.searchBookByID(id);
        return ResponseEntity.ofNullable(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        boolean success = service.deleteBookByID(id);
        if (success) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
        Book updatedBook = service.updateBookByID(id, book);
        return ResponseEntity.ofNullable(updatedBook);
    }

    @GetMapping("/autor/{autor}")
    public List<Book> searchAutor(@PathVariable String autor) {
        return service.searchBookByAutor(autor);
    }
}
