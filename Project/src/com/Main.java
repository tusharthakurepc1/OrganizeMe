package com;

import java.sql.*;

public class Main {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_projects","root","epc205");
            System.out.println("Connection Open");
            con.close();
        }catch(Exception e){
            System.out.println("Exception.");
            System.out.println(e);
        }
    }
}
