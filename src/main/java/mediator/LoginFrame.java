package mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("userName:"));
        add(textUser);
        add(new Label("userPass"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged();
        pack();
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // 버튼 이벤트 관리
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void createColleagues() {
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        this.checkGuest = new ColleagueCheckbox("Guest", checkboxGroup, true);
        this.checkLogin = new ColleagueCheckbox("Login", checkboxGroup, false);
        this.textUser = new ColleagueTextField("", 10);
        this.textPass = new ColleagueTextField("", 10);
        this.textPass.setEchoChar('*');
        this.buttonOk = new ColleagueButton("OK");
        this.buttonCancel = new ColleagueButton("Cancel");

        this.checkGuest.setMediator(this);
        this.checkLogin.setMediator(this);
        this.textUser.setMediator(this);
        this.textPass.setMediator(this);
        this.buttonOk.setMediator(this);
        this.buttonCancel.setMediator(this);

        this.checkGuest.addItemListener(checkGuest); // 변경시 자신의 itemStateChanged 호출
        this.checkLogin.addItemListener(checkLogin); // 변경시 자신의 itemStateChanged 호출
        this.textUser.addTextListener(textUser); // 변경시 자신의 textValueChanged 호출
        this.textPass.addTextListener(textPass); // 변경시 자신의 textValueChanged 호출
        this.buttonOk.addActionListener(this);
        this.buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userPassChanaged();
        }
    }

    private void userPassChanaged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

}
