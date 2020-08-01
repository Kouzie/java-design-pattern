package command;

import javax.swing.*;
import java.awt.event.*;

/*
 * Command (명령)
 * 메서드를 호출한 결과는 객체에 반영된다.
 *
 * 명령을 클래스로 표현, 각종 명령을 여러번 재실행, 명령집합을 모아서 모두 실행 시키거나 할 수 있다.
 *
 *
 * 구성요소
 * Command(명령) - 명령의 인터페이스, API 정의, Command 가 해당 역할
 * ConcreteCommand(구체적 명령) - Command 의 구현, MacroCommand, DrawCommand 가 해당역할
 * Receiver(수신자) - Command 명령을 실행할, 명령을 받아들이는 수신자, DrawCommand의 명령을 받아 수행하는 DrawCanvas 가 해당 역할
 * Client(의뢰자) - ConcreteCommand 를 생성하고 Receiver 에게 명령을 할당, CommandMain 의 생성된 Frame 이 해당역할
 * Invoker(기동자) - Command 의 execute 를 실행시키는 클래스, CommandMain 클래스도 당장 하나의 점 찍기를 위해 명령생성, 실행하고
 *  DrawCanvas 도 지금까지 받아들였던 명령 모음집을 한번에 실행시키는 print 함수가 있기에 2개의 Invoker 가 존재한다.
 * */
public class CommandMain extends JFrame implements ActionListener {

    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton = new JButton("clear");

    public CommandMain(String title) {
        super(title);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new CommandMain("Command Pattern Sample");
    }
}
