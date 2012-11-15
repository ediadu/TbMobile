package com.neusoft.talentbase.mobileweb.test.ioc;

import com.neusoft.talentbase.mobileweb.action.UserAction;
import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.alibaba.druid.pool.DruidDataSource;

public class IocTest {
	
	@Test
	public void test_conv_mvc_iocby() throws Throwable{
		ComboIocLoader loader = new ComboIocLoader(new String[]{
				"*org.nutz.ioc.loader.json.JsonLoader","ioc/",
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.neusoft.talentbase.mobileweb"
			});
		NutIoc ioc = new NutIoc(loader);
		Dao dao = ioc.get(Dao.class);
		UserAction action = ioc.get(UserAction.class);
		System.out.println(action.ping());
	}
	
	@Test
	public void test_js_ioc(){
		JsonLoader loader = new JsonLoader("ioc/");
		NutIoc ioc = new NutIoc(loader);
		Dao dao = ioc.get(Dao.class);
		System.out.println(dao);
		
	}
	
	@Test
	public void test_conv_js_ioc(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/tbmobile?useUnicode=true&characterEncoding=GBK");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		NutDao dao = new NutDao(dataSource);
		
		System.out.println(dao);
	}
}
