package com.boot.rest.book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.rest.dao.BookRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {

			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);

		} catch (Exception e) {
		}

		return book;
	}

	public Book addBook(Book book) {
		try {
			// list.add(book);

			this.bookRepository.save(book);

			System.out.println("Done..!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	public void deleteBook(int id) {
		try {
			// list = list.stream().filter(e -> e.getId() !=
			// id).collect(Collectors.toList());
			this.bookRepository.deleteById(id);

			System.out.println("Deleted...!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Book updateBook(int id, Book book) {
//		list = list.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setAuthor(book.getAuthor());
//				b.setName(book.getName());
//			}
//			return b;
//		}).collect(Collectors.toList());
//		return book;
		book.setId(id);
		this.bookRepository.save(book);
		return book;

	}

}
