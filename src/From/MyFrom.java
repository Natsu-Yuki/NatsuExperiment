package From;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class MyFrom extends JFrame {
    JTable table;
    JButton b1,b2,b3,b4;
    JTextField tf;
    Object a[][];
    Student []student=new Student[6];
    Object columnName[]= {"学号","姓名","年龄","专业","兴趣","学分"};
    int i=0;
    ApplicationContext applicationContext;


    public MyFrom() {

        super("学生信息");
        a=new Object[60][6];
        table=new JTable(a,columnName);
        setSize(500,500);
        b1=new JButton("浏览学生信息");
        b2=new JButton("按学分排序");
        b3=new JButton("学号查询");
        b4=new JButton("退出");
        tf=new JTextField(20);


        applicationContext = new ClassPathXmlApplicationContext("configuration.xml");

        student[0]=(Student) applicationContext.getBean("s1");
        student[1]=(Student) applicationContext.getBean("s2");
        student[2]=(Student) applicationContext.getBean("s3");
        student[3]=(Student) applicationContext.getBean("s4");
        student[4]=(Student) applicationContext.getBean("s5");
        student[5]=(Student) applicationContext.getBean("s6");


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                while(i>=0)
                {
                    a[i][0]="";
                    a[i][1]="";
                    a[i][2]="";
                    a[i][3]="";
                    a[i][4]="";
                    a[i][5]="";
                    i--;
                }

                i=0;
                for(int j=0;j<student.length;j++)
                {
                    a[i][0]=student[j].getSno();
                    a[i][1]=student[j].getName();
                    a[i][2]=student[j].getAge();
                    a[i][3]=student[j].getPro();
                    a[i][4]=student[j].getHobby();
                    a[i][5]=student[j].getCredits();
                    i++;
                }
                repaint();

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(i>=0)
                {
                    a[i][0]="";
                    a[i][1]="";
                    a[i][2]="";
                    a[i][3]="";
                    a[i][4]="";
                    a[i][5]="";
                    i--;
                }
                i=0;
                Student[] x1=new Student[6];
                for(int m=0;m<student.length;m++)
                    x1[m]=student[m];
                Arrays.sort(x1);
                for(int j=0;j<student.length;j++)
                {
                    a[i][0]=x1[j].getSno();
                    a[i][1]=x1[j].getName();
                    a[i][2]=x1[j].getAge();
                    a[i][3]=x1[j].getPro();
                    a[i][4]=x1[j].getHobby();
                    a[i][5]=x1[j].getCredits();
                    i++;
                }
                repaint();

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=tf.getText().trim();
                if(str.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "请输入学号","提示",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                while(i>0)
                {
                    a[i][0]="";
                    a[i][1]="";
                    a[i][2]="";
                    a[i][3]="";
                    a[i][4]="";
                    a[i][5]="";
                    i--;
                }
                i=0;
                for(int j=0;j<student.length;j++)
                {
                    if(student[j].getSno().equals(str))
                    {
                        a[i][0]=student[j].getSno();
                        a[i][1]=student[j].getName();
                        a[i][2]=student[j].getAge();
                        a[i][3]=student[j].getPro();
                        a[i][4]=student[j].getHobby();
                        a[i][5]=student[j].getCredits();
                        i++;
                    }
                }
                repaint();

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        Container con=getContentPane();
        con.setLayout(new FlowLayout());
        con.add(b1);
        con.add(b2);
        con.add(b3);
        con.add(tf);
        con.add(b4);
        Container container=getContentPane();
        con.add(new JScrollPane(table));
        setVisible(true);
        setResizable(false);
        validate();
        addWindowFocusListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {System.exit(0);}});



    }




}
