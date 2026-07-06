package com.libraryManager;

import com.libraryManager.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-ex2.xml");

        BookService service =
                context.getBean("bookService", BookService.class);

        service.displayBooks();
    }
}