package com.donato.libaryapi.service.impl;

import com.donato.libaryapi.exception.BusinessException;
import com.donato.libaryapi.model.entity.Book;
import com.donato.libaryapi.model.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements com.donato.libaryapi.service.BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }



    @Override
    public Book save(Book book) {
        if(repository.existsByIsbn(book.getIsbn())) {
            throw new BusinessException("Isbn já cadastrado");
        }
        return repository.save(book);
    }
}
