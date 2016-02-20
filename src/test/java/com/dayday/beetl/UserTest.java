package com.dayday.beetl;

import java.util.List;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.HumpNameConversion;
import org.beetl.sql.core.NameConversion;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.db.DBStyle;

import com.dayday.dao.User;

public class UserTest {
	
	public static void main(String[] args) {
		// 创建一个简单的ConnectionSource，只有一个master
		ConnectionSource source = ConnectionSourceHelper.simple(driver,url,userName,password);
		// 采用mysql 习俗
		DBStyle mysql = new MysqlStyle();
		// sql语句放在classpagth的/sql 目录下
		SQLLoader loader = new ClasspathLoader("/sql"); 
		// 数据库命名跟java命名采用驼峰转化
		NameConversion nc = new  HumpNameConversion();
		// 最后，创建一个SQLManager
		SqlManager sqlManager = new SqlManager(source,mysql,loader); 

		//使用内置的生成的sql 新增用户
		User user = new User();
		user.setAge(19);
		user.setName("xiandafu");
		sqlManager.insert(user);
		//使用内置sql查询用户
		int id = 1;
		user = sqlManager.unque(User.class,id);

		//使用user.md 文件里的select语句，参考下一节
		User query = new User();
		query.setName("xiandafu");
		List<User> list = sqlManager.select("user.select",User.class,query)
	}

}
