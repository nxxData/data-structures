package niubenben;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteBook {
    public static void main(String[] args) {
        // write your code here
        new MyFrame("记事本");
    }
}
class MyFrame extends JFrame{
    private JTextArea tv_area=null;
    private JScrollPane s_pane=null;//带滚动条的面板
    private JMenuBar mb=null;//菜单栏
    private JMenu m_file=null;//文件菜单
    private JMenu m_help=null;//
    private JMenuItem item_new=null;//新建
    private JMenuItem item_open=null;//打开
    private JMenuItem item_exit=null;//退出
    private JMenuItem item_about=null;//关于
    public MyFrame(String title){
        super(title);
        init();
        registerListener();
    }
    //初始化相关的组件
    private void init(){
        tv_area=new JTextArea();
        s_pane=new JScrollPane(tv_area);
        s_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//设置水平条策略(需要的时候出现)

        Container container=this.getContentPane();
        container.add(s_pane,BorderLayout.CENTER);
        this.setSize(500,300);
        //初始化菜单
        mb=new JMenuBar();//菜单栏
        m_file=new JMenu("文件");
        item_new=new JMenuItem("新建");
        item_open=new JMenuItem("打开");
        item_exit=new JMenuItem("退出");
        m_file.add(item_new);
        m_file.add(item_open);
        m_file.add(item_exit);

        m_help=new JMenu("帮助");
        item_about=new JMenuItem("关于");
        m_help.add(item_about);
        mb.add(m_file);
        mb.add(m_help);
        //把菜单栏添加到窗体中
        this.setJMenuBar(mb);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时结束应用程序
        //设置窗口居中显示
        //定义一个工具包
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screenSize=toolkit.getScreenSize();
        int screenWidth=screenSize.width;//获取屏幕的宽度
        int screenHeight=screenSize.height;//获取屏幕的高度
        int windowWidth=this.getWidth();//获取当前窗体的宽度
        int windowHeight=this.getHeight();//获取当前窗体的宽度
        //居中显示
        this.setLocation((screenWidth-windowWidth)/2,(screenHeight-windowHeight)/2);
        this.setVisible(true);//显示窗体
    }
    //给相关的组件设置事件监听器
    private void registerListener(){
        item_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFile();
            }
        });
        item_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
                //加载到文本框中
            }
        });
        item_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        item_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutDialog(MyFrame.this,"关于记事本",true);
            }
        });
    }
    //退出
    private void exit() {
        newFile();
        System.exit(0);
    }

    //打开文件
    private void openFile() {
        FileDialog fileDialog=new FileDialog(this,"打开文件",FileDialog.LOAD);
        fileDialog.setVisible(true);
    }

    //新建的功能
    private void newFile(){
        if (!tv_area.getText().equals("")){
            int res=JOptionPane.showConfirmDialog(null,"是否保存?","提示信息",JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION){
                //文件保存对话框
                FileDialog fileDialog=new FileDialog(this,"保存文件",FileDialog.SAVE);
                fileDialog.setVisible(true);
            }
        }
    }
}

class AboutDialog extends JDialog{
    private JLabel desc=null;
    private JPanel panel=null;
    private JButton btn=null;
    public AboutDialog(Frame frame,String title,boolean modal){
        super(frame,title,modal);
        init();
        registerListener();
    }
    private void init(){
        desc=new JLabel();
        desc.setText("<html>这是一个自定义的记事本，开发初期阶段，还得<br/>大家多多指教</html>");
        desc.setHorizontalAlignment(JLabel.CENTER);
        panel=new JPanel();
        btn=new JButton("ok");
        panel.add(btn);
        this.add(desc);//默认放在边界中间
        this.add(panel,BorderLayout.SOUTH);//底部上北下南左西右东
        this.setSize(300,200);
    }
    private void registerListener(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDialog.this.dispose();//退出对话框
            }
        });
        //设置窗口居中显示
        //定义一个工具包
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screenSize=toolkit.getScreenSize();
        int screenWidth=screenSize.width;//获取屏幕的宽度
        int screenHeight=screenSize.height;//获取屏幕的高度
        int dialogWidth=this.getWidth();//获取当前窗体的宽度
        int dialogHeight=this.getHeight();//获取当前窗体的宽度
        //居中显示
        this.setLocation((screenWidth-dialogWidth)/2,(screenHeight-dialogHeight)/2);
        this.setVisible(true);//显示窗体
    }
}
