package com.tdl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackEnd {

    public static void main(String[] args) {

        Client c1=new Client("User"," ","001",10,"_","+91 xxxxxxxxxx","user123","123");
        Task t1=new Task(c1,"Task 1","2023-3-19-19-0","2023-3-20-20-0","Dinner","IMP");

//        DataBaseOperation.readAllClientData();

    }
}


class DataBaseOperation{
    /*    return the connection */
    private static Connection createConn(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tdl_db","root","epc205");
            System.out.println("Connection Open");

        }catch(Exception e){
            System.out.println("Connection Exception.");
        }
        return con;
    }

    /*    Write the Client Details in the DB    */
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

    /*    Write the Task in the DB  */
    public static void writeTaskData(int c_id,Task t){
        Connection con=createConn();
        try{
            String query="insert into task_details(c_id,title,time_of_start,time_reminder,t_desc,flag) values(?,?,?,?,?,?);";
            PreparedStatement ps_query_insert=con.prepareStatement(query);
            ps_query_insert.setInt(1,c_id);
            ps_query_insert.setString(2,t.t_title);
            ps_query_insert.setString(3,t.time_of_start);
            ps_query_insert.setString(4,t.time_reminder);
            ps_query_insert.setString(5, t.t_desc);
            ps_query_insert.setString(6,t.t_flag);

            ps_query_insert.executeUpdate();
            System.out.println("Write Task Data");
            con.close();
            System.out.println("Connection close wt");

        }catch(Exception e){
//            System.out.println(e);
            System.out.println("Write Task Error    !!Client Not Exist!!  with c_id: "+c_id);
        }
    }

    /*    Read all the client from the DB   */
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

    /*    Check the username and password is in the DB  */
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

    /*    Return the Client with given username & pass from the DB  */
    public static Client readStampData(String username,String pass){
        Connection con=createConn();
        Statement statement=null;
        Client data=null;
        try{
            String query="select *from client_details;";
            statement=con.createStatement();
            ResultSet result=statement.executeQuery(query);

            while(result.next()){

                if(result.getString(8).equals(username) && result.getString(9).equals(pass)){

//                    Assign the data to the Client Constructor.
                    data=new Client(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9));

                    return data;
                }
            }
        }catch(Exception e){
            System.out.println("Stamp Read Failed");
        }
        return data;
    }

    /*    Return the ArrayList of all the task which belongs to the provided client_id. */
    public static ArrayList<Task> readTaskData(int c_id){
        Connection con=createConn();
        Statement statement=null;
        ResultSet result=null;
        ArrayList<Task> data=new ArrayList<Task>();

        try{
            String query="select *from task_details where c_id="+c_id+";";
            statement=con.prepareStatement(query);
            result=statement.executeQuery(query);

            while(result.next()){
                Task t=new Task(result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7));
                t.task_id=result.getInt(1);
//                t.displayDetails();
                data.add(t);
            }

        }catch(Exception e){
            System.out.println(e);
//            System.out.println("Read Task Data Error");
        }
        return data;
    }

}