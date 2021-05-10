package com.itbulls.learnit.isidro.oop.books;

import java.util.Objects;

public class Publisher {
	
	private int id;
	private String publisherName;
	
	public Publisher(int id, String publisherName) {

		this.id = id;
		this.publisherName = publisherName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Publisher other = (Publisher) obj;
		return Objects.equals(other.id,id) && Objects.equals(other.publisherName, publisherName);
	}
	
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisherName=" + publisherName + "]";
	}

}
