package niubenben;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyFrame1 myFrame1=new MyFrame1("大张伟");
        myFrame1.init();
        myFrame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
class MyFrame1 extends Frame{
    public MyFrame1(String title){
        super(title);
    }
    public void init(){
        this.setSize(300,300);
        this.setBackground(Color.green);
        Panel panel=new Panel();
        panel.setLayout(null);//去掉panel默认布局管理器
        panel.setBackground(Color.blue);
        panel.setBounds(0,0,200,200);
        Button button1=new Button("clickMe");
        button1.setBounds(0,0,100,100);
        button1.setBackground(Color.red);
        panel.add(button1);
        this.add(panel);
        this.setVisible(true);
    }
}
