package com.hrms.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class DbUtils {
    private static Connection conn;
    private static Statement st;
    private static ResultSet rset;

    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection(ConfigsReader.getPropertyValue("dbUrl"),
                    ConfigsReader.getPropertyValue("dbUsername"),
                    ConfigsReader.getPropertyValue("dbPassword"));
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return conn;
    }

    public static ResultSet getResultSet(String query) {
        try {
            st = getConnection().createStatement();
            rset = st.executeQuery(query);
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return rset;
    }

    public static List<Map<String, String>> getDbDataIntoList(String query) {
        List<Map<String, String>> dbList = new ArrayList<>();
        Map<String, String> map;
        try {
            ResultSetMetaData rsetMdata = getResultSet(query).getMetaData();
            while (rset.next()) {
                map = new LinkedHashMap<>();
                for (int i = 1; i <rsetMdata.getColumnCount() ; i++) {
                    map.put(rsetMdata.getColumnName(i),rset.getString(i));
                }
                dbList.add(map);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }finally {
            closeConnection();
        }
        return dbList;
    }
    public  static  void closeConnection(){
        try {
            if(rset!=null){
                rset.close();
            }
            if(st!=null){
                st.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
