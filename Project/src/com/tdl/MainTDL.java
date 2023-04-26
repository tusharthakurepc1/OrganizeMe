package com.tdl;

import java.sql.*;
import java.time.LocalDateTime;

import com.mysql.cj.log.Log;
import com.tdl.*;

import javax.xml.crypto.Data;

public class MainTDL {
    public static void main(String[] args) {
    //Main TDL Integrate.

        LoginGui o1=new LoginGui();
//        o1.init_Login();
        o1.retriveLoginInfo();


    }
}



