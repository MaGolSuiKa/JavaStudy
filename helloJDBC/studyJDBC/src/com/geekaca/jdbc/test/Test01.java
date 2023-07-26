package com.geekaca.jdbc.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//          练习：对品牌表
//          增删查改
//          要定义实体类 Brand
public class Test01 {
    public static void main(String[] args) throws Exception {
        String brandName = "香飘飘";
        String brandName2 = "香飘飘奶茶";
        String companyName = "香飘飘";
        String companyName2 = "香飘飘公司";
        int ordered = 1;
        int ordered2 = 100;
        String description = "绕地球一圈";
        String description2 = "绕地球三圈";
        int status = 1;
        int id = 5;
        //testAdd(brandName,companyName,ordered,description,status);
        //testDelete(4);
        testUpdate(id, brandName2, companyName2, ordered2, description2, status);
        testSearch();
    }

    /**
     * 增加数据
     */
    public static void testAdd(String brandName, String companyName, int ordered,
                               String description, int status) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("studyJDBC/druid.properties"));
        //获取连接池对象
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name,company_name, ordered, description, status) values(?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, brandName);
        ps.setString(2, companyName);
        ps.setInt(3, ordered);
        ps.setString(4, description);
        ps.setInt(5, status);

        int sqlCount = ps.executeUpdate();
        System.out.println(sqlCount > 0);

        ps.close();
        conn.close();
    }
    /**
     * 删除数据
     */
    public static void testDelete(int id) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("studyJDBC/druid.properties"));
        //获取连接池对象
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        String sql = "delete from tb_brand where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int sqlCount = ps.executeUpdate();
        System.out.println(sqlCount > 0);

        ps.close();
        conn.close();
    }
    /**
     * 查找数据
     */
    public static void testSearch() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("studyJDBC/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "select * from tb_brand;";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        Brand brand = null;
        List<Brand> brandList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName =
                    rs.getString("brand_name");
            String companyName =
                    rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description =
                    rs.getString("description");
            int status = rs.getInt("status");
            //封装Brand对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brandList.add(brand);
        }
        System.out.println(brandList);
        rs.close();
        ps.close();
        conn.close();
    }
    /**
     * 修改数据
     */
    public static void testUpdate(int id, String brandName, String companyName, int ordered,
                                  String description, int status) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("studyJDBC/druid.properties"));
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "update tb_brand " +
                "set brand_name = ?,company_name = ?, ordered = ?, description = ?, status = ? " +
                "where id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, brandName);
        ps.setString(2, companyName);
        ps.setInt(3, ordered);
        ps.setString(4, description);
        ps.setInt(5, status);
        ps.setInt(6, id);

        int sqlCount = ps.executeUpdate();
        System.out.println(sqlCount > 0);

        ps.close();
        conn.close();
    }
}
