package com.library.managementsystem.service;

import com.library.managementsystem.dto.RegisterBookRequest;
import com.library.managementsystem.entity.Book;
import com.library.managementsystem.entity.Borrower;

import java.util.List;

public interface BookService {
    Book registerBook(RegisterBookRequest request);

    List<Book> getAllBooks();

    Book borrowBook(Long bookId, Borrower borrower);

    Book returnBook(Long bookId);
}
