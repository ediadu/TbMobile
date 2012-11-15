package com.neusoft.talentbase.mobileweb.setup;

import com.neusoft.talentbase.mobileweb.po.User;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class UserSetup implements Setup {

	private static final Log log = Logs.get();
	@Override
	public void init(NutConfig config) {
		log.debug("IOC = " + config.getIoc());
		// TODO Auto-generated method stub
		Dao dao = config.getIoc().get(Dao.class);
		for(Class<?> clazz : Scans.me().scanPackage("com.neusoft.talentbase.mobileweb")){
			if(null!=clazz.getAnnotation(Table.class)){
				dao.create(clazz, false);
			}
		}
		
		if(dao.count(User.class) == 0){
			User user = new User();
			user.setName("admin");
			user.setPasswd("123");
			dao.insert(user);
		}
	}

	@Override
	public void destroy(NutConfig config) {
		// TODO Auto-generated method stub
		
	}

}
