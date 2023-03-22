package com.tdl;

import java.sql.*;
import com.tdl.*;

public class MainTDL {
    public static void main(String[] args) {
//Main TDL Integrate.
        Home_Gui home=new Home_Gui();
        home.homeGUI();

        Important_Gui imp=new Important_Gui();
        imp.importantGUI();

//        LoginGui gui=new LoginGui();
//        gui.init_Login();
//        gui.init_Signup();


    }
}
