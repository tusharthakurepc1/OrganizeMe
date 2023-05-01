package com.tdl;

import com.tdl.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class Planned_Gui {

    public void plannedGUI(int id,String pass){

        AtomicBoolean thread_status= new AtomicBoolean(false);
        Client data = DataBaseOperation.readStampData(id, pass);

        JFrame jfrm_planned=new JFrame("Planned");
        jfrm_planned.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_planned.setSize(800,620);
        jfrm_planned.setResizable(false);


        JLabel container_left=new JLabel();
        container_left.setBounds(10,10,300,560);
        container_left.setBackground(Color.decode("#33334d"));

        JLabel icon=new JLabel(""+data.f_name.charAt(0));
        icon.setBounds(20,25,50,50);
        icon.setForeground(Color.white);
        icon.setOpaque(true);
        icon.setBackground(Color.black);
        icon.setFont(new Font("Verdana", Font.BOLD, 37));
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        Border b = BorderFactory.createLineBorder(Color.darkGray);
        icon.setBorder(b);
        jfrm_planned.add(icon);


        JLabel name=new JLabel(data.f_name+" "+data.m_name+" "+data.l_name);
        name.setBounds(20,7,280,80);
        name.setForeground(Color.white);
        name.setFont(new Font("Verdana", Font.BOLD, 17));
        name.setHorizontalAlignment(SwingConstants.RIGHT);
        jfrm_planned.add(name);

        JLabel email=new JLabel(data.username);
        email.setBounds(20,25,250,80);
        email.setForeground(Color.GRAY);
        email.setFont(new Font("Rockwell", Font.PLAIN, 12));
        email.setHorizontalAlignment(SwingConstants.RIGHT);
        jfrm_planned.add(email);

        JButton home;
        home=new JButton("Home");
        home.setBackground(Color.decode("#E6E6FA"));
        home.setForeground(Color.BLACK);
        home.setBounds(20,100,280,40);
        home.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_planned.add(home);


//        JButton tasks;
//        tasks=new JButton("Tasks");
//        tasks.setBackground(Color.decode("#E6E6FA"));
//        tasks.setForeground(Color.BLACK);
//        tasks.setBounds(20,150,280,40);
//        tasks.setHorizontalAlignment(SwingConstants.LEFT);
//        jfrm_home.add(tasks);

        JButton important;
        important=new JButton("Important");
        important.setBackground(Color.decode("#E6E6FA"));
        important.setForeground(Color.BLACK);
        important.setBounds(20,150,280,40);
        important.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_planned.add(important);


        JButton planned;
        planned=new JButton("Planned");
        planned.setBackground(Color.decode("#E6E6FA"));
        planned.setForeground(Color.BLACK);
        planned.setBounds(20,200,280,40);
        planned.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_planned.add(planned);

        JButton groceries;
        groceries=new JButton("Groceries");
        groceries.setBackground(Color.decode("#E6E6FA"));
        groceries.setForeground(Color.BLACK);
        groceries.setBounds(20,250,280,40);
        groceries.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_planned.add(groceries);


        JButton settings;
        settings=new JButton("Settings");
        settings.setBackground(Color.decode("#E6E6FA"));
        settings.setForeground(Color.BLACK);
        settings.setBounds(20,300,280,40);
        settings.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_planned.add(settings);



        container_left.setOpaque(true);
        jfrm_planned.add(container_left);

        JLabel container_right=new JLabel();
        container_right.setBounds(320,10,450,560);
        container_right.setBackground(Color.decode("#33334d"));

        JLabel imp_label=new JLabel("Planned");
        imp_label.setBounds(340,7,280,80);
        imp_label.setForeground(Color.white);
        imp_label.setBackground(Color.white);
        imp_label.setFont(new Font("Verdana", Font.PLAIN, 37));
        imp_label.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_planned.add(imp_label);


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, dd MMM YYYY");
        LocalDateTime now = LocalDateTime.now();
        JLabel dateTime = new JLabel();
        dateTime.setText(dtf.format(now));
        dateTime.setBounds(340, 40, 280, 80);
        dateTime.setFont(new Font("Verdana", Font.PLAIN, 15));
        dateTime.setForeground(Color.white);
        dateTime.setBackground(Color.white);
        jfrm_planned.add(dateTime);


        JTextField add_text_field=new JTextField("\t\t         Time:"+now.getYear()+"-"+now.getMonthValue()+"-"+now.getDayOfMonth()+"-"+now.getHour()+"-"+(now.getMinute()+5));
        JButton add_btn=new JButton("ADD");
        add_text_field.add(add_btn);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(340,500,410,60);
        panel.setBackground(Color.white);
        panel.add(add_text_field, BorderLayout.CENTER);
        panel.add(add_btn,BorderLayout.EAST);
        add_btn.setBackground(Color.black);
        add_btn.setForeground(Color.WHITE);
        add_btn.setSize(10,10);
        jfrm_planned.add(panel);



        //Calling the thread Function to update the task which is in the JScrollPane
        Thread task_update=new Thread(
                ()->{
                    JScrollPane jsp;
                    boolean initial_sleep=true;
                    while(true) {
                        try {
                            if(thread_status.get()){
                                throw new InterruptedException("Swap");
                            }
                            jsp = new JScrollPane(scrollData(jfrm_planned,id), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            jsp.setBounds(350, 120, 400, 350);
                            jsp.setBackground(Color.BLACK);
                            jfrm_planned.add(jsp);

                            scrollData(jfrm_planned,id);

                            if(initial_sleep){
                                Thread.sleep(500);
                                initial_sleep=false;
                            }
                            else{
                                Thread.sleep(3000);
                            }
                        } catch (Exception e) {
                            System.out.println("Task Update Exception.");
                            return;
                        }
                    }
                }
        );
        task_update.setPriority(Thread.NORM_PRIORITY);
        task_update.start();


        //Thread to Update the time which is updated on 60 sec.
        Thread time_update=new Thread(
                ()->{
                    DateTimeFormatter dtf_temp;
                    LocalDateTime now_temp;
                    while(true) {
                        try {

                            dtf_temp = DateTimeFormatter.ofPattern("EEEE, dd MMM YYYY");
                            now_temp = LocalDateTime.now();
//                            int a=now_temp.getSecond();
                            dateTime.setText(dtf_temp.format(now_temp));


                            Thread.sleep(60000);
                        } catch (Exception e) {
                            System.out.println("Task Update Exception.");
                            return;
                        }
                    }
                }
        );
        time_update.start();


        home.addActionListener(
                e->{
                    Home_Gui o1=new Home_Gui();
                    o1.homeGUI(id, pass);
                    jfrm_planned.dispose();
                    thread_status.set(true);
                }
        );


        important.addActionListener(
                e -> {
                    Important_Gui o1 = new Important_Gui();
                    o1.importantGUI(id, pass);
                    jfrm_planned.dispose();
                    thread_status.set(true);
                }
        );

        groceries.addActionListener(
                e -> {
                    Groceries_Gui o1 = new Groceries_Gui();
                    o1.groceriesGUI(id, pass);
                    jfrm_planned.dispose();
                    thread_status.set(true);
                }
        );

        settings.addActionListener(
                e -> {
                    GUI_T o1 = new GUI_T();
                    o1.guiSettingFrame(id, pass);
                    jfrm_planned.dispose();
                    thread_status.set(true);
                }
        );


        add_btn.addActionListener(
                e -> {
                    String task_time_sp[]=add_text_field.getText().split("Time:");
                    for (String i:task_time_sp){
                        System.out.println(i);
                    }
                    if(task_time_sp.length == 2){
                        String task_desc=task_time_sp[0].trim();
                        if (task_desc.equals("")) {
                            return;
                        }
                        String time_deploy=task_time_sp[1].trim();
                        String chk_time[]=time_deploy.split("-");
                        if(chk_time.length == 5){
                            Task t1 = new Task("Task", "Current Time", time_deploy, task_desc, "PLAN");
                            DataBaseOperation.writeTaskData(id, t1);
                            add_text_field.setText("\t\t         Time:"+now.getYear()+"-"+now.getMonthValue()+"-"+now.getDayOfMonth()+"-"+now.getHour()+"-"+(now.getMinute()+5));
//                                homeGUIcp(id,pass);
//                                jfrm_home.dispose();
                        }
                        else{
                            System.out.println("Time Incompactable");
                            return;
                        }
                    }
                }
        );




        container_right.setOpaque(true);
        jfrm_planned.add(container_right);


        jfrm_planned.setLayout(null);
        jfrm_planned.setVisible(true);

    }

    public JPanel scrollData(JFrame super_fr,int id) {
        JPanel panel_outer = new JPanel();
        panel_outer.setLayout(new BoxLayout(panel_outer, BoxLayout.Y_AXIS));

        ArrayList<Task> content_task = DataBaseOperation.readTaskDataFlag(id,"PLAN");
        LocalDateTime time_now=LocalDateTime.now();
        for (int i = 0; i < content_task.size(); i++) {
            String time_spl[]=content_task.get(i).time_reminder.split("-");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try{
                String temp_month,temp_day;
                if(time_now.getMonthValue() < 10){
                    temp_month="0"+time_now.getMonthValue();
                }
                else{
                    temp_month=""+time_now.getMonthValue();
                }
                if(time_now.getDayOfMonth() < 10){
                    temp_day="0"+time_now.getDayOfMonth();
                }
                else{
                    temp_day=""+time_now.getDayOfMonth();
                }
                if(Integer.parseInt(time_spl[1]) < 10){
                    time_spl[1]="0"+time_spl[1];
                }
                if(Integer.parseInt(time_spl[2]) < 10){
                    time_spl[2]="0"+time_spl[2];
                }
                Date date1 = sdf.parse(time_spl[0]+"-"+time_spl[1]+"-"+time_spl[2]);
                Date date2 = sdf.parse(time_now.getYear()+"-"+temp_month+"-"+temp_day);
                int compare_time = date1.compareTo(date2);


//                System.out.println(time_spl[0]+" "+time_spl[1]+" "+time_spl[2]);
                if(compare_time < 0){
                    continue;
                }
                else{
                    String temp_min="",temp_hour="";
                    if(Integer.parseInt(time_spl[3]) < 10){
                        time_spl[3]="0"+time_spl[3];
                    }
                    if(Integer.parseInt(time_spl[4]) < 10){
                        time_spl[4]="0"+time_spl[4];
                    }
                    if(time_now.getHour() < 10){
                        temp_hour="0"+time_now.getHour();
                    }
                    else{
                        temp_hour=""+time_now.getHour();
                    }
                    if(time_now.getMinute() < 10){
                        temp_min="0"+time_now.getMinute();
                    }
                    else{
                        temp_min=""+time_now.getMinute();
                    }

//                    System.out.println(temp_hour+" "+temp_min+" 00");
//                    System.out.println(time_spl[3]+":"+time_spl[4]+":00");
                    LocalTime time1 = LocalTime.parse(time_spl[3]+":"+time_spl[4]+":00");
                    LocalTime time2 = LocalTime.parse(temp_hour+":"+temp_min+":00");

                    int compare_time2=time1.compareTo(time2);

                    if(compare_time==0 && compare_time2 < 0){
                        continue;
                    }
                }

            }catch(Exception time){
                System.out.println("Time Format Error");
            }
            JLabel task_title = new JLabel("    " + content_task.get(i).t_title);
            task_title.setBounds(100, 100, 300, 30);
            task_title.setFont(new Font("Arial", Font.PLAIN, 20));

            JLabel task_details = new JLabel(content_task.get(i).t_desc);
            task_details.setBounds(100, 100, 300, 30);
            task_details.setFont(new Font("Arial", Font.PLAIN, 15));

            JLabel task_time = new JLabel("         " + content_task.get(i).time_of_start + "                     " + content_task.get(i).time_reminder);
            task_time.setBounds(100, 100, 300, 30);
            task_time.setFont(new Font("Arial", Font.PLAIN, 10));

            Border blackline = BorderFactory.createLineBorder(Color.black);
            JPanel panel_inner = new JPanel();
            panel_inner.setSize(10, 10);
            panel_inner.setLayout(new BoxLayout(panel_inner, BoxLayout.Y_AXIS));
//            panel_inner.setBackground(Color.BLUE);
            panel_inner.setBorder(blackline);
            panel_inner.add(task_title);
            panel_inner.add(task_details);
            panel_inner.add(task_time);

            panel_inner.setMaximumSize(new Dimension(400, 60));

            panel_outer.setMaximumSize(new Dimension(500, 400));
            panel_outer.add(panel_inner);
        }

        return panel_outer;
    }
}

