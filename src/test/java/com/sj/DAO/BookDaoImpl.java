package com.sj.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sj.DbConnector.DbConnector;
import com.sj.service.Book;


     @Service
	public class BookDaoImpl implements BookDAO   {
		// TODO Auto-generated constructor stub
		   Book b1;
		   Connection con;
		
		
		BookDaoImpl() {
			 b1 = new Book("java","james");
			 b1=new Book("c","dennis");
			 b1=new Book("c++","bjarne");
			
              }
		
		public Book createBook(Book book) {
			try {
				 con = (Connection) DbConnector.getConnection();
				PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into book value(?,?)");
				
				pst.setString(1, b1.getTitle());
				pst.setString(2, b1.getAuthor());
				
				pst.execute();
				System.out.println("inserted");
			}
			
			
			
			catch(Exception e ) {
				e.printStackTrace();
			}
			return b1;
		}
		
		
		public List<Book> showAll() {
			try {
				con=(Connection) DbConnector.getConnection();
				Statement st=(Statement) con.createStatement();
				ResultSet rs=st.executeQuery("select * from book");
				List<Book> list = new ArrayList<Book>();
				while(rs.next()) 
				{
					Book b = new Book();
					
					
					
					b.setTitle(rs.getString(1));
					b.setAuthor(rs.getString(2));
					
					
					
					list.add(b);
					
				}
				return list;
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		
		
		
		
	}


