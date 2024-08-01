package com.library.managementsystem.controller;

import com.library.managementsystem.dto.RegisterBookRequest;
import com.library.managementsystem.entity.Book;
import com.library.managementsystem.entity.Borrower;
import com.library.managementsystem.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<Book> registerBook(@Valid @RequestBody RegisterBookRequest request) {
        return ResponseEntity.ok(bookService.registerBook(request));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("/{bookId}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @RequestBody Borrower borrower) {
        return ResponseEntity.ok(bookService.borrowBook(bookId, borrower));
    }

    @PutMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.returnBook(bookId));
    }
}
