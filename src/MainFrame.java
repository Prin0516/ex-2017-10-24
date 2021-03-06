import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private LoginFrame loginFrame;
    private  Random rnd=new Random(System.currentTimeMillis());
    private JMenuBar jmb=new JMenuBar();
    private JMenu mF=new JMenu("File");
    private JMenu mS=new JMenu("Set");
    private JMenu mG=new JMenu("Game");
    private JMenu mA=new JMenu("About");
    private JMenuItem jmiexit=new JMenuItem("Exit");
    private JMenuItem jmiloto=new JMenuItem("樂透開獎");
    private JButton jbtnexit=new JButton("Close");
    private JButton jbtnregen=new JButton("Generate");
    private JDesktopPane jdp=new JDesktopPane();
    private JInternalFrame jif=new JInternalFrame();
    private Container cp;
    private JPanel jpl=new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpl1=new JPanel(new GridLayout(1,2,3,3));
    private JLabel jlb[]=new JLabel[6];
    private int screenW=Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH=Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width=500,height=500;
    public MainFrame(LoginFrame log){
        loginFrame=log;
        init();
    }
    private void init(){
        this.setBounds(screenW/2-width/2,screenH/2-height/2,width,height);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                loginFrame.reset();
                loginFrame.setVisible(true);
            }
        });
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        jmb.add(mF);
        jmb.add(mS);
        jmb.add(mG);
        jmb.add(mA);
        mF.add(jmiexit);
        mG.add(jmiloto);
        this.setContentPane(jdp);
        cp=jif.getContentPane();
        cp.setLayout((new BorderLayout(5,5)));
        cp.add(jpl,BorderLayout.CENTER);
        cp.add(jpl1,BorderLayout.SOUTH);
        jpl1.add(jbtnexit);
        jpl1.add(jbtnregen);
        for(int i=0;i<6;i++){
            jlb[i]=new JLabel();
            jlb[i].setOpaque(true);
            jlb[i].setBackground(new Color(102, 189, 248));
            jpl.add(jlb[i]);
        }
        jmiexit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiloto.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              loginFrame.setVisible(true);
              dispose();
                loginFrame.reset();
            }
        });
        jmiloto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setBounds(10,10,300,100);
                jif.setVisible(true);
                jlabel();
            }
        });

        jbtnexit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jif.dispose();
            }

        });
        jbtnregen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlabel();
            }
        });
    }

    private void jlabel(){
        int data[]=new int[6];
        int i=0;
       while(i<6){
            int j=0;
            data[i]=rnd.nextInt(42)+1;
            boolean flag=true;
            while (j<i&&flag) {
                if(data[i]==data[j]){
                    flag=false;
                }
                j++;
            }
            if(flag){
                jlb[i].setText(Integer.toString(data[i]));
                i++;
            }
        }

    }


}