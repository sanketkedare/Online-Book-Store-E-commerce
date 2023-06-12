package com.boot.rest.book;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int autherId;
	@Column(name = "first")
	private String firstName;
	@Column(name = "last")
	private String lastName;
	@Column(name = "lang")
	private String langauge;

	@OneToOne(mappedBy = "Author")
	@JsonBackReference
	private Book book;

	public int getAutherId() {
		return autherId;
	}

	public void setAutherId(int autherId) {
		this.autherId = autherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public Author() {
		super();
	}

	public Author(int autherId, String firstName, String lastName, String langauge, Book book) {
		super();
		this.autherId = autherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.langauge = langauge;
		this.book = book;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLangauge() {
		return langauge;
	}

	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Author [autherId=" + autherId + ", firstName=" + firstName + ", lastName=" + lastName + ", langauge="
				+ langauge + "]";
	}

}
