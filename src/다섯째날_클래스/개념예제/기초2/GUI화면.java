package 다섯째날_클래스.개념예제.기초2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by snake on 16. 8. 23.
 */
public class GUI화면 extends JFrame implements 화면관리, ActionListener {
    JTextField jtfInput;
    JTextArea jtAreaOutput;
    String newline = "\n";

    @Override
    public void 화면종료() {
        dispose();
    }

    public void createGui() {
        jtfInput = new JTextField(20);
        jtfInput.addActionListener(this);
        jtAreaOutput = new JTextArea(5, 20);
        jtAreaOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtAreaOutput,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        GridBagLayout gridBag = new GridBagLayout();
        Container contentPane = getContentPane();
        contentPane.setLayout(gridBag);
        GridBagConstraints gridCons1 = new GridBagConstraints();
        gridCons1.gridwidth = GridBagConstraints.REMAINDER;
        gridCons1.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(jtfInput, gridCons1);
        GridBagConstraints gridCons2 = new GridBagConstraints();
        gridCons2.weightx = 1.0;
        gridCons2.weighty = 1.0;
        contentPane.add(scrollPane, gridCons2);

        pack();
        setVisible(true);
    }

    public GUI화면(){
        createGui();
    }

    @Override
    public void 리포팅하기(String 메시지) {
        String text = jtfInput.getText();
        jtAreaOutput.append(text + 메시지 + newline);
        jtfInput.selectAll();
    }

    String sReuslt = "";
    @Override
    public String 입력받기(String 메시지) {
        jtAreaOutput.append(메시지 + ":" + newline);
        jtfInput.selectAll();

        jtfInput.setText("");
        Thread test = new Thread(new Runnable() {
            @Override
            public void run() {
                do{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String text = jtfInput.getText();
                    if(bAction == true ){
                        sReuslt = text;
                        break;
                    }
                } while(true);
            }
        });
        test.start();

        try {
            test.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bAction = false;
        return sReuslt;
    }

    boolean bAction = false;
    @Override
    public void actionPerformed(ActionEvent e) {
        bAction = true;
    }
}
