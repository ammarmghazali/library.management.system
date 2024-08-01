package com.library.managementsystem.service.Impl;

import com.library.managementsystem.dto.RegisterBookRequest;
import com.library.managementsystem.entity.Book;
import com.library.managementsystem.entity.Borrower;
import com.library.managementsystem.repository.BookRepository;
import com.library.managementsystem.repository.BorrowerRepository;
import com.library.managementsystem.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;

    @Override
    @Transactional
    public Book registerBook(RegisterBookRequest request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .author(request.getAuthor())
                .borrower(request.getBorrowerId() == null ? null : borrowerRepository.findById(request.getBorrowerId()).get())
                .build();

        bookRepository.save(book);
        return book;
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book borrowBook(Long bookId, Borrower borrower) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getBorrower() != null) {
            throw new RuntimeException("Book is already borrowed");
        }
        book.setBorrower(borrower);
        return bookRepository.save(book);
    }

    @Override
    public Book returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getBorrower() == null) {
            throw new RuntimeException("Book is not borrowed");
        }
        book.setBorrower(null);
        return bookRepository.save(book);
    }

}
