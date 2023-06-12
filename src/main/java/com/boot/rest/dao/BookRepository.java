package com.boot.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.rest.book.Book;

public interface BookRepository extends CrudRepository<Book,Integer>
{
	public Book findById(int id);

}
