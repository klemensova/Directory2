package cz.directory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cz.directory.bean.Entry;
import cz.directory.bean.EntryList;



public class DirectoryDao {
	private static final String INSERTENTRY = "INSERT INTO register (firstname, surname, phoneNumber) VALUES (?,?,?)";
	private static final String LOADENTRYLIST = "SELECT * FROM register";
	private static final String DELETEENTRY = "DELETE FROM register WHERE idDir =?";
	private static final String UPDATEENTRY = "UPDATE  register SET firstname=?, surname=?, phoneNumber=? WHERE idDir=?";
	private static final String SHOWENTRY = "SELECT * FROM register WHERE idDir=?";
	private static final String SELECTENTRY = "SELECT * FROM register WHERE surname LIKE ? OR firstname LIKE ?  OR phoneNumber LIKE ? ORDER BY surname, firstname DESC";

	public void saveEntry(Entry newEntry) {
		DataSource ds = getDataSource();

		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(INSERTENTRY)) {
			stmt.setString(1, newEntry.getFirstname());
			stmt.setString(2, newEntry.getSurname());
			stmt.setString(3, newEntry.getPhoneNumber());

			stmt.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public EntryList loadEntrylist() {
		EntryList ret = new EntryList();
		ArrayList<Entry> list = new ArrayList<Entry>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(LOADENTRYLIST)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Entry entry = new Entry();

				entry.setIdDir(rs.getInt("idDir"));
				entry.setFirstname(rs.getString("firstname"));
				entry.setSurname(rs.getString("surname"));
				entry.setPhoneNumber(rs.getString("phoneNumber"));

				list.add(entry);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret.setEntrylist(list);
		return ret;
	}

	public EntryList deleteEntry(Integer idDir) {
		EntryList ret = new EntryList();
		ArrayList<Entry> list = new ArrayList<>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(DELETEENTRY)) {

			stmt.setInt(1, idDir);
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret.setEntrylist(list);
		return ret;

	}
	public EntryList updateEntry(Integer idDir, Entry newEntry) {
		EntryList ret = new EntryList();
		ArrayList<Entry> list = new ArrayList<>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection();
				PreparedStatement stmt = con.prepareStatement(UPDATEENTRY)) {
			stmt.setInt(4, idDir);
			stmt.setString(1, newEntry.getFirstname());
			stmt.setString(2, newEntry.getSurname());
			stmt.setString(3, newEntry.getPhoneNumber());
			stmt.execute();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ret.setEntrylist(list);
		return ret;
	}

	
	
	public EntryList showEntry(Integer idDir) {
		EntryList ret = new EntryList();
		ArrayList<Entry> list = new ArrayList<>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection();
				PreparedStatement stmt = con.prepareStatement(SHOWENTRY)) {
			stmt.setInt(1, idDir);
		
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Entry ent = new Entry();
				ent.setIdDir(rs.getInt("idDir"));
				ent.setFirstname(rs.getString("firstname"));
				ent.setSurname(rs.getString("surname"));
				ent.setPhoneNumber(rs.getString("phoneNumber"));
				list.add(ent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ret.setEntrylist(list);
		return ret;
	}
	
	public EntryList selectEntry(String surname) {
		EntryList ret = new EntryList();
		ArrayList<Entry> list = new ArrayList<>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECTENTRY)) {
			stmt.setString(1, surname + "%");
			stmt.setString(2,  surname + "%");
			stmt.setString(3,  surname + "%");
		
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Entry ent = new Entry();
				ent.setIdDir(rs.getInt("idDir"));
				ent.setFirstname(rs.getString("firstname"));
				ent.setSurname(rs.getString("surname"));
				ent.setPhoneNumber(rs.getString("phoneNumber"));
				list.add(ent);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ret.setEntrylist(list);
		return ret;
	}

	private DataSource getDataSource() {
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:/comp/env/DirectoryResource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
