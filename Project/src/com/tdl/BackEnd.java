package com.tdl;

import java.sql.*;

public class BackEnd {

    public static void main(String[] args) {

//        Client c1=new Client("User"," ","001",10,"_","+91 xxxxxxxxxx","user123","123");
//        Task t1=new Task("Task 1","Testing the query jdbc","IMP");

        System.out.println(DataBaseOperation.readUserPass("use123","12"));

    }
}

class DataBaseOperation{
    public static Connection createConn(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tdl_db","root","epc205");
            System.out.println("Connection Open");

        }catch(Exception e){
            System.out.println("Connection Exception.");
        }
        return con;
    }

//    Write the Client Details in the DB
    public static void writeClientData(Client obj){
        Connection con=DataBaseOperation.createConn();
        try{
            String query="insert into Client_Details(f_name,m_name,l_name,age,gender,phone_number,username,pass) values(?,?,?,?,?,?,?,?);";
            PreparedStatement ps_query_insert=con.prepareStatement(query);
            ps_query_insert.setString(1,obj.f_name);
            ps_query_insert.setString(2,obj.m_name);
            ps_query_insert.setString(3,obj.l_name);
            ps_query_insert.setInt(4,obj.age);
            ps_query_insert.setString(5,obj.gender);
            ps_query_insert.setString(6,obj.phone_num);
            ps_query_insert.setString(7, obj.username);
            ps_query_insert.setString(8, obj.pass);

            ps_query_insert.executeUpdate();
            System.out.println("Account Inserted.");
            con.close();
            System.out.println("Connection closed rw");

        }catch(Exception e){
            System.out.println("Exception while Inserting Data.");
            System.out.println(e);
        }
    }

//    Write the Task in the DB
    public static void writeTaskData(Task t){
        Connection con=createConn();
        try{
            String query="insert into task_details(c_id,title,t_desc,flag) values(?,?,?,?);";
            PreparedStatement ps_query_insert=con.prepareStatement(query);
            ps_query_insert.setInt(1,10);
            ps_query_insert.setString(2,t.t_title);
            ps_query_insert.setString(3,t.t_desc);
            ps_query_insert.setString(4,t.t_flag);

            ps_query_insert.executeUpdate();
            System.out.println("Write Task Data");
            con.close();
            System.out.println("Connection close wt");

        }catch(Exception e){
//            System.out.println(e);
            System.out.println("Write Task Error    !!Client Not Exist!!  with c_id: "+t.client_id);
        }
    }

//    Read all the client from the DB
    public static void readAllClientData(){
        Connection con=DataBaseOperation.createConn();
        Statement statement=null;
        boolean flag=true;
        try{
            String query="select *from Client_Details;";
            statement=con.createStatement();
            ResultSet data_set=statement.executeQuery(query);

            while(data_set.next()){
                System.out.print(data_set.getString(1)+"  ");
                System.out.print(data_set.getString(2)+"  ");
                System.out.print(data_set.getString(3)+"  ");
                System.out.print(data_set.getString(4)+"  ");
                System.out.print(data_set.getInt(5)+"  ");
                System.out.print(data_set.getString(6)+"  ");
                System.out.print(data_set.getString(7)+"  ");
                System.out.print(data_set.getString(8)+"  ");
                System.out.print(data_set.getString(9)+"  ");

                flag=false;
                System.out.println("----------------");
            }
            if(flag){
                System.out.println("Empty Set No Data.");
            }
            con.close();
            System.out.println("Connection Closed rd.");
        }catch(Exception e){
            System.out.println("Can't Read Data Exception.");
            System.out.println(e);
        }
    }

    public static boolean readUserPass(String username,String pass){
//        boolean flag=false;
        Statement statement=null;
        Connection con=createConn();
        try{
            String query="select username,pass from client_details;";
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
//                System.out.println("User: "+rs.getString(1)+" "+rs.getString(2));
                if(rs.getString(1).equals(username) && rs.getString(2).equals(pass))
                    return true;
            }


        }catch(Exception e){
//            System.out.println(e);
            System.out.println("Can't Read Data Exception.");
        }



        return false;
    }

}
