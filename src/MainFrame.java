import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JMenuBar jmb=new JMenuBar();
    private JMenu mF=new JMenu("File");
    private int screenW=Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH=Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width=500,height=500;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(screenW/2-width/2,screenH/2-height/2,width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        jmb.add(mF);
    }


}