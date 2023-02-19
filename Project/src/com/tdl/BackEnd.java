package com.tdl;

public class BackEnd {
    public static void main(String[] args) {
        System.out.println("Backend Main");
    }
}

class Client{
    protected int client_id;
    protected String f_name,m_name,l_name;
    protected int age;
    protected String gender,phone_num;
    protected String username,pass;

    Client(){
        client_id=0;f_name="";m_name="";l_name="";age=0;gender=null;phone_num="xxx";username="";pass="";
    }
    Client(String f,String m,String l,int a,String g,String pn,String u,String p){
        f_name=f;   m_name=m;   l_name=l;
        age=a;
        gender=g;
        phone_num=pn;
        username=u;
        pass=p;
    }

    protected void displayDetails(){
        System.out.println(client_id+" "+f_name+" "+m_name+" "+l_name+" is of "+age+"\n"+gender+" "+phone_num+"\n"+username+" "+pass);
    }
}

class Task extends Client{
    //    int c_id_derived;
    int task_id;
    String t_title,t_desc;
    String t_flag;
    Task(){
        task_id=0;
        t_title=""; t_desc="";  t_flag="";
    }

    Task(Client c){
        this.client_id=c.client_id;
        this.f_name=c.f_name;   this.m_name=c.m_name;   this.l_name=c.l_name;
        this.age=c.age;     this.phone_num=c.phone_num;
        this.username=c.username;   this.pass=c.pass;

        task_id=0;
        t_title=""; t_desc="";  t_flag="";
    }

    Task(Client c,String t_title,String t_desc,String t_flag){
        this.client_id=c.client_id;
        this.f_name=c.f_name;   this.m_name=c.m_name;   this.l_name=c.l_name;
        this.age=c.age;     this.phone_num=c.phone_num;
        this.username=c.username;   this.pass=c.pass;

        task_id=0;
        this.t_title=t_title; this.t_desc=t_desc;  this.t_flag=t_flag;
    }

    @Override
    protected void displayDetails(){
        super.displayDetails();
        System.out.println(task_id+" "+t_title+" "+t_desc+" "+t_flag);
    }

}