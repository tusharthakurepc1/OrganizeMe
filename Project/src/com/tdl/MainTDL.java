package com.tdl;

import java.sql.*;
import com.tdl.*;

public class MainTDL {
    public static void main(String[] args) {
        System.out.println("Main TDL");



        LoginGui gui=new LoginGui();
        gui.homeGUI();
        gui.init_Signup();



//        Client c1=new Client("User"," ","001",10,"_","+91 xxxxxxxxxx","user123","123");
//        Task t1=new Task(c1,"Task1","Wake Up 7.00 AM","Imp");
//        t1.displayDetails();
    }
}
