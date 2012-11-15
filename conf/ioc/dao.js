var ioc = {
	dataSource : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		fields : {
			driverClassName : 'com.mysql.jdbc.Driver',
			url : 'jdbc:mysql://localhost:3306/tbmobile?useUnicode=true&characterEncoding=GBK',
			username : 'root',
			password : ''
		},
		events : {
			depose : "close"
		}
	},
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [{refer : "dataSource"}]
	}
}