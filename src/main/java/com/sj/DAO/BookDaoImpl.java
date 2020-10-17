package com.sj.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sj.DBConnector.DbConnector;
import com.sj.service.Book;

@Service
public class BookDaoImpl implements BookDAO {
	// TODO Auto-generated constructor stub
	Book b1;
	Book b2;
	Book b3;
	
	Connection con;

	
	  BookDaoImpl() { 
		  b1 = new Book(4,"java","james",200);
		  b2=new Book(5,"c","dennis",400); 
		  b3=new Book(6,"c++","bjarne",100);
	  
	  }
	  
	 
	public Book createBook(Book book) {
		try {
			con = (Connection) DbConnector.getConnection();
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into book3 value(?,?,?,?)");
			pst.setInt(1, b1.getId());
			pst.setString(2, b1.getTitle());
			pst.setString(3, b1.getAuthor());
			pst.setInt(4, b1.getPrice());
			pst.execute();
			
			
			pst.setInt(1, b2.getId());
			pst.setString(2, b2.getTitle());
			pst.setString(3, b2.getAuthor());
			pst.setInt(4, b2.getPrice());
			pst.execute();
			
			pst.setInt(1, b3.getId());
			pst.setString(2, b3.getTitle());
			pst.setString(3, b3.getAuthor());
			pst.setInt(4, b3.getPrice());

			pst.execute();
			System.out.println("inserted");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}

	public List<Book> showAll() {
		try {
			con = (Connection) DbConnector.getConnection();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from book3");
			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book b = new Book();

				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getInt(4));

				list.add(b);

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
