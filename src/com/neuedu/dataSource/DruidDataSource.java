package com.neuedu.dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {
    private static Properties prop=new Properties();
    private static DruidDataSource dds=null;
    private DruidDataSource(){}
    public static DruidDataSource getDds()
    {
        if(null==dds)
        {
            dds=new DruidDataSource();
        }
        return dds;
    }

    public Connection getConnection()
    {
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            DataSource ds=DruidDataSourceFactory.createDataSource(prop);
            Connection conn=ds.getConnection();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
