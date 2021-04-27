package Dao;
import Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet res;

    //查看图书
    public List<Book> list(){

    }

    //查询图书
    public List<Book> listsel(){
        System.out.print("请输入你要查询的书(可关键字)：");
        Scanner scanner = new Scanner(System.in);
        String seq = scanner.nextLine();
        List<Book> listsel=new ArrayList<Book>();
        String sql="select * from books where name like"+ "'%"+seq+"%'";
        try {
            conn=DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            res=pst.executeQuery();
            while (res.next()){
                Book book=new Book();
                book.setBookId(res.getInt("id"));
                book.setBookName(res.getString("name"));
                book.setBookPrice(res.getString("price"));
                book.setBookPress(res.getString("press"));
                listsel.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return listsel;
    }

    //添加图书
    public boolean addBook(Book book){
        String sql="insert ignore into books(id,name,price,press) values(?,?,?,?)";
        try {
            conn= DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,book.getBookId());
            pst.setString(2,book.getBookName());
            pst.setString(3,book.getBookPrice());
            pst.setString(4,book.getBookPress());
            int i = pst.executeUpdate();
            if(i == 1) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return true;
    }

    //修改图书
    public boolean modBook(Book book){
        String sql="update ignore books set id=?,name=?,price=?,press=? where id=?";
        try {
            conn= DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,book.getBookId());
            pst.setString(2,book.getBookName());
            pst.setString(3,book.getBookPrice());
            pst.setString(4,book.getBookPress());
            pst.setInt(5,book.getBookId());
            int i = pst.executeUpdate();
            if(i == 1) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return true;
    }

    //删除图书
    public boolean delBook(int id){

    }
}

