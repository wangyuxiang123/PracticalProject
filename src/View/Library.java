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

    }

    //添加图书
    public static void addBook(){

    }

    //修改图书
    public static void modBook(){

    }

    //删除图书
    public static void delBook(){

    }
}

