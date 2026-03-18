package com.example.pr1.services;

import com.example.pr1.objects.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private Long ID = 0L;
    private final List<Book> library = new ArrayList<>();

    public List<Book> getAllBooks() { return library; }

    public Book addBook(Book book) {
        book.setId(++ID);
        library.add(book);
        return book;
    }

    public Book searchBookByID(Long id) {
        Book searched = null;

        for (Book book : library) {
            if (book.getId() == id) searched = book;
        }

        return searched;
    }

    public Book updateBookByID(Long id, Book book) {
        Book toUpdate = searchBookByID(id);
        if  (toUpdate != null) {
            toUpdate.setTitulo(book.getTitulo());
            toUpdate.setAutor(book.getAutor());
            toUpdate.setAnio(book.getAnio());
        }
        return toUpdate;
    }

    public boolean deleteBookByID(Long id) {
        boolean success = false;
        Book toDelete = searchBookByID(id);
        if (toDelete != null) {
            library.remove(toDelete);
            success = true;
        }
        return success;
    }

    public List<Book> searchBookByAutor(String autor) {
        List<Book> searched = new ArrayList<>();
        for (Book book : library) {
            if (book.getAutor().equals(autor)) searched.add(book);
        }
        return searched;
    }
}
