package com.itbulls.learnit.isidro.oop.books;

public class BookService {
	
	public Book[] filterBooksByAuthor(Author author, Book[] books) {  	
    	if(author == null || books == null) {
    		return new Book[0];
    	}
    	
    	int authors = 0;
    	for(Book book : books) {
    		if(book.authorCheck(author)) {
    			authors++;
    		}
    	}
    	
    	Book[] authorBooks = new Book[authors];
    	int i = 0;
    	for(Book book : books) {
    		if(book.authorCheck(author)){
    			authorBooks[i++] = book;
    		}
    	}
    	
    	return authorBooks;    	
	}
	
	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
    	if(publisher == null || books == null) {
    		return new Book[0];
    	}
    	
    	int publishers = 0;
    	for(Book book : books){
    		if(book.getPublisher().equals(publisher)){
    			publishers++;
    		}
    	}
    	
    	Book[] publisherBooks = new Book[publishers];
    	int i = 0;
    	for(Book book : books){
    		if(book.getPublisher().equals(publisher)) {
    			publisherBooks[i++] = book;
    		}
    	}
    	
    	return publisherBooks;	
    }

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		if(books == null) {
			return new Book[0];
		}
		
		int year = 0;
		for(Book book : books) {
			if(book.getPublishingYear() >= yearFromInclusively) {
				year++;
			}
		}
		
		Book[] yearBooks = new Book[year];
		int i= 0;
		
		for(Book book : books) {
			if(book.getPublishingYear() >= yearFromInclusively) {
				yearBooks[i++] = book;
			}
		}
		return yearBooks;
	}
	
}