package com.libraryManagerr.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void getBooks() {
        System.out.println("Fetching books from repository...");
    }

}