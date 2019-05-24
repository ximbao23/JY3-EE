package com.neuedu.dao;

import com.neuedu.dataSource.DruidDataSource;
import com.neuedu.pojo.Product;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ProDaoImpl implements ProDao{
    private DruidDataSource dds;
    private QueryRunner qs;

    public ProDaoImpl()
    {
        dds=DruidDataSource.getDds();
        qs=new QueryRunner();
    }

    @Override
    public void addOneProduct(Product product) {
        Connection connection=dds.getConnection();
        String sql="INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            qs.update(connection,sql,product.getPro_id(),product.getPro_name(),product.getPro_price(),product.getPro_img(),product.getPro_des(),product.getPro_stock(),product.getPro_date(),product.getPro_cate_id(),product.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
