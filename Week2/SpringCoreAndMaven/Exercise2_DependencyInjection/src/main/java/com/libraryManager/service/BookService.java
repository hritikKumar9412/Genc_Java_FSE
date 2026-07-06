package com.libraryManager.service;

import com.libraryManager.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Book Service");
        bookRepository.getBooks();
    }
}