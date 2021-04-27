# 项目说明文档
```
.
├── mysql-connector-java-8.0.21.jar  	//驱动
├── out
│   └── production
│       └── PracticalProject
│           ├── Dao           				
│           │   ├── Book.class    			
│           │   └── BookDao.class		   
│           ├── jdbc.properties			    
│           ├── Main.class				  
│           ├── Utils
│           │   └── DBUtils.class
│           └── View
│               └── Library.class
├── PracticalProject.iml
├── pythonProject			//爬虫项目
│   ├── M.exe				//浏览器驱动
│   └── spyder.py			   //主函数
├── README.md
└── src
    ├── Dao				   //数据访问
    │   ├── BookDao.java   //操作数据库
    │   └── Book.java      //书对象，相当于数据库的每一行
    ├── jdbc.properties    //连接账号，地址
    ├── Main.java		   //主函数
    ├── Utils			   //工具类
    │   └── DBUtils.java   //连接数据库
    └── View			   //显示
        └── Library.java   //菜单以及对List操作
```
# 项目启动说明
```
Main.java
spyder.py //可能需要python环境和一些库，浏览器驱动已经包含
```