package com.tdl;

import java.sql.*;
import com.tdl.*;

public class MainTDL {
    public static void main(String[] args) {
//        System.out.println("Hello");
//        Test_DB.try_meth();
        LoginGui o1=new LoginGui();
//        o1.init_Login();
        o1.init_Signup();
    }
}

class Test_DB{
    public static void try_meth(){
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
