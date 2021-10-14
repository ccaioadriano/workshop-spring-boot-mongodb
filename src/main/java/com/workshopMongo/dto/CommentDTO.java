package com.workshopMongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;
	private AuthorDTO author;
	private String text;

	public CommentDTO() {

	}

	public CommentDTO(Date date, AuthorDTO author, String text) {
		super();
		this.date = date;
		this.author = author;
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
