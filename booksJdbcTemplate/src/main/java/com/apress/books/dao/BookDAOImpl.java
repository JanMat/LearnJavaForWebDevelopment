package com.apress.books.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.apress.books.model.Book;


public class BookDAOImpl implements BookDAO {

	
	 DataSource dataSource;  
	  
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Book> findAllBooks() {  
	  List<Book> bookList = new ArrayList<Book>();  
	  
		String sql = "select * from book inner join author on book.id = author.book_id";
	  
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	  bookList = jdbcTemplate.query(sql, new BookRowMapper());  
	  return bookList;  
	 }  
	
}