package 다섯째날_클래스.개념예제.기초1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class 매장관리GUI extends JFrame
{

    public static final int 추가 = 1;
    public static final int 삭제 = 2;
    public static final int 검색 = 3;
    public static final int 조회 = 4;

    Label      lblMessage;
    Label      lblInput;
    JTextArea  txtMessage;
    TextField  txtInput;
    Button     btnAdd;
    Button     btnDel;
    Button     btnSearch;
    Button     btnReport;

    public 매장관리GUI(){
    }

    private void setUpUI() {
        GridLayout gu = new GridLayout(4,2);
        setLayout(gu);

        lblInput        = new Label("입력");
        txtInput        = new TextField();

        btnAdd    = new Button("추가");
        btnDel    = new Button("삭제");
        btnSearch = new Button("검색");
        btnReport = new Button("조회");

        Panel panGen = new Panel(new FlowLayout(FlowLayout.LEFT));

        txtMessage      = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtMessage);
        add(scrollPane);

        add(lblInput);
        add(txtInput);

        panGen.add(btnAdd);
        panGen.add(btnDel);
        panGen.add(btnSearch);
        panGen.add(btnReport);

        add(panGen);

        // add Event
        addAction();

        setSize(400, 300);
        setVisible(true);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addAction() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                On요청받다(txtInput.getText(), 추가);
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                On요청받다(txtInput.getText(), 삭제);

            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                On요청받다(txtInput.getText(), 검색);
            }
        });

        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                On요청받다(txtInput.getText(), 조회);
            }
        });
    }

    public void On요청받다(String 메시지, int 분류){

    }

    public void 매장영업시작(){
        setUpUI();
    }


    public void 리포팅하기(String 메시지){
        txtMessage.append(메시지 + "\n");
        txtMessage.setCaretPosition(txtMessage.getDocument().getLength());  // 맨아래로 스크롤한다.
        validate();
    }

}