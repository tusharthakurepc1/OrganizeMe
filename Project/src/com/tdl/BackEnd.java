package com.tdl;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BackEnd {

    public static void main(String[] args) {

        Client c1=new Client("User"," ","005",99,"_","+91 xxxxxxxxxx","user","123");
        Task t1=new Task(c1,"Task 2",null,"2023-4-9-14-54","Check Notify 2","IMP");

//        DataBaseOperation.readAllClientData();
//        DataBaseOperation.writeTaskData(10004,t1);
//        DataBaseOperation.checkTaskTimeBg(DataBaseOperation.readTaskData(10004));


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

        }catch(SQLException e){
            System.out.println("Exception while Inserting Data.");
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
    }

    /*    Write the Task in the DB  */
    public static void writeTaskData(int c_id,Task t){
        LocalDateTime datetime=LocalDateTime.now();
        Connection con=createConn();
        try{
            String query="insert into task_details(c_id,title,time_of_start,time_reminder,t_desc,flag) values(?,?,?,?,?,?);";
            PreparedStatement ps_query_insert=con.prepareStatement(query);
            ps_query_insert.setInt(1,c_id);
            ps_query_insert.setString(2,t.t_title);
            t.time_of_start=datetime.getYear()+"-"+datetime.getMonthValue()+"-"+datetime.getDayOfMonth()+"-"+datetime.getHour()+"-"+datetime.getMinute();
            ps_query_insert.setString(3,t.time_of_start);
            ps_query_insert.setString(4,t.time_reminder);
            ps_query_insert.setString(5, t.t_desc);
            ps_query_insert.setString(6,t.t_flag);

            ps_query_insert.executeUpdate();
            System.out.println("Write Task Data");
            con.close();
            System.out.println("Connection close wt");

        }catch(SQLException sqle){
            System.out.println("Write Task Exception    !!Client Not Exist!!  with c_id: "+c_id);
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
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
        }catch(SQLException e){
            System.out.println("Can't Read Data Exception.");
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
    }

    /*    Check the id and password is in the DB  */
    public static boolean readUserPass(int id,String pass){
//        boolean flag=false;
        Statement statement=null;
        Connection con=createConn();
        try{
            String query="select c_id,pass from client_details;";
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
//                System.out.println("User: "+rs.getString(1)+" "+rs.getString(2));
                if(rs.getInt(1) == id && rs.getString(2).equals(pass)){
                    return true;
                }
            }

        }
        catch(NumberFormatException e){
            System.out.println("Please Enter the valid Id.");
        }
        catch(SQLException e){
//            System.out.println(e);
            System.out.println("Can't Read Data Exception.");
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }


        return false;
    }

    /*    Return the Client with given id & pass from the DB  */
    public static Client readStampData(int id,String pass){
        Connection con=createConn();
        Statement statement=null;
        Client data=null;
        try{
            String query="select *from client_details;";
            statement=con.createStatement();
            ResultSet result=statement.executeQuery(query);

            while(result.next()){

                if(result.getInt(1) == id && result.getString(9).equals(pass)){

//                    Assign the data to the Client Constructor.
                    data=new Client(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9));
                    data.displayDetails();
                    return data;
                }
            }
        }catch(SQLException e){
            System.out.println("Stamp Read Exception");
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
        return data;
    }

    /*  Update the Client Details with the Client Object.*/
    public static void updateClientDetails(int id,String pass,Client client_update){
        Connection con=createConn();
        Client update_temp=null;
        try{
            String query="update client_details set f_name=?,m_name=?,l_name=?,age=?,gender=?,phone_number=?,username=? where c_id = ? and pass =?;";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,client_update.f_name);
            ps.setString(2,client_update.m_name);
            ps.setString(3,client_update.l_name);
            ps.setInt(4,client_update.age);
            ps.setString(5,client_update.gender);
            ps.setString(6,client_update.phone_num);
            ps.setString(7,client_update.username);

            ps.setInt(8,id);
            ps.setString(9,pass);

            ps.executeUpdate();

            System.out.println("Updated Sucessfully");

        }catch(SQLException e){
            System.out.println("Update Exception");
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
    }

    /*  Update the password of the Client*/
    public static void updateClientPassword(int id,String pass,String new_pass){
        Connection con=createConn();
        Client update_temp=null;
        try{
            String query="update client_details set pass=? where c_id = ? and pass =?;";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,new_pass);
            ps.setInt(2,id);
            ps.setString(3,pass);


            ps.executeUpdate();

            System.out.println("Updated Password Sucessfully");

        }catch(SQLException e){
            System.out.println("Update Exception");
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
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
                Task t=new Task(result.getString(3),result.getString(5),result.getString(6),result.getString(4),result.getString(7));
                t.task_id=result.getInt(1);
//                t.displayDetails();
                data.add(t);
            }

        }catch(SQLException e){
            System.out.println("Read Task Data Error");
//            System.out.println(e);
        }catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
        return data;
    }

    /*    Return the Arraylist of all the task which belongs to the given client_id and task flag */
    public static ArrayList<Task> readTaskDataFlag(int c_id,String flag){
        Connection con=createConn();
        Statement statement=null;
        ResultSet result=null;
        ArrayList<Task> data=new ArrayList<>();
        try{
            String query="select *from task_details where c_id="+c_id+" and  flag=\""+flag+"\";";
            statement=con.prepareStatement(query);
            result=statement.executeQuery(query);

            while(result.next()){
                Task t=new Task(result.getString(3),result.getString(5),result.getString(6),result.getString(4),result.getString(7));
                t.task_id=result.getInt(1);
                data.add(t);
            }

        }catch(SQLException e){
            System.out.println("Other Exception while reading data.");
        } catch(Exception e) {
            System.out.println("Other Exception");
//            System.out.println(e);
        }finally {
            try{
                if(!con.isClosed()){
                    con.close();
                    System.out.println("Connection Closed");
                }
            }
            catch(Exception e2) {
                System.out.println(e2);
            }
        }
        return data;
    }

}