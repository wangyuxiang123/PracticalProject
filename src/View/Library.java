package View;

import Dao.Book;
import Dao.BookDao;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Library {
    public void menu(){
        while (true){
            System.out.println("--------------------");
            System.out.println("0.图书查看");
            System.out.println("1.图书增加");
            System.out.println("2.图书删除");
            System.out.println("3.图书修改");
            System.out.println("4.图书推荐");
            System.out.println("5.图书模糊查询");
            System.out.println("6.退   出");
            System.out.println("--------------------");
            Scanner sc =new Scanner(System.in);
            System.out.print("请输入你要进行的操作：");

            String bookfunction = sc.nextLine();
            switch (bookfunction){
                case "0":
                    scanBooks();
                    break;
                case "1":
                    addBook();
                    break;
                case "2":
                    delBook();
                    break;
                case "3":
                    modBook();
                    break;
                case "4":
                    recBook();
                    break;
                case "5":
                    selBook();
                    break;
                case "6":
                    System.out.println("成功退出图书管理系统！");
                    System.exit(0);
                    break;
            }

        }
    }

    //查看图书
    public static void scanBooks(){

    }

    //推荐图书
    public void recBook(){

    }
    //模糊查询图书
    public static void selBook(){
        BookDao dao=new BookDao();
        List<Book> listsel= dao.listsel();
        if(listsel.isEmpty()){
            System.out.println("查无此书");
            return;
        }
        System.out.println("ID\t书名\t价格\t出版社");
        for (Book bookList:listsel){
            System.out.println(" "+bookList.getBookId()+"       "+bookList.getBookName()+"        "+bookList.getBookPrice()+"        "+bookList.getBookPress());
        }
    }

    //添加图书
    public static void addBook(){
        Scanner sc=new Scanner(System.in);
        String name,price,press;
        int id;
        System.out.print("请输入添加图书的编号:");
        id=sc.nextInt();
        System.out.print("请输入图书书名:");
        Scanner sc1=new Scanner(System.in);
        name=sc1.nextLine();
        System.out.print("请输入图书价格:");
        price=sc1.nextLine();
        if(!price.contains("￥")){
            price = price+"￥";
        }
        System.out.print("请输入图书出版社:");
        press=sc1.nextLine();
        Book book = new Book(name, id, price, press);
        BookDao dao=new BookDao();
        boolean flag = dao.addBook(book);
        if (flag){
            System.out.println("保存成功！");
        }else{
            System.out.println("保存失败！");
        }
    }

    //修改图书
    public static void modBook(){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入修改图书的编号：");
        int id=sc.nextInt();
        System.out.print("请输入图书的书名");
        Scanner sc1=new Scanner(System.in);
        String name=sc1.nextLine();
        System.out.print("请输入图书价格");
        String price=sc1.nextLine();
        System.out.print("请输入图书出版社");
        String press=sc1.nextLine();
        Book book=new Book(name,id,price,press);
        BookDao dao=new BookDao();
        boolean flag = dao.modBook(book);
        if (flag){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }

    //删除图书
    public static void delBook(){

    }
}

