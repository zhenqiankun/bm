package Test.StudentModel;

import Test.StudentModel.StuTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Llist implements ActionListener {
    public ButtonGroup buttonGroup;
    public JRadioButton x;

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JRadioButton getX() {
        return x;
    }

    public void setX(JRadioButton x) {
        this.x = x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StuTest.number = Integer.parseInt(x.getText()) - 1;
        String[] pll = StuTest.tem[StuTest.number].split("@");
        if (StuTest.result[StuTest.number] != null) {
            System.out.println("2");
            if (StuTest.result[StuTest.number].equals("A")) {
                StuTest.jRadioButton1.setSelected(true);
            } else if (StuTest.result[StuTest.number].equals("B")) {
                StuTest.jRadioButton2.setSelected(true);
            } else if (StuTest.result[StuTest.number].equals("C")) {
                StuTest.jRadioButton3.setSelected(true);
            } else StuTest.jRadioButton4.setSelected(true);
        } else {
            System.out.println("1");
          buttonGroup.clearSelection();
        }
        StuTest.jTextArea1.setText(StuTest.number + 1 + "," + pll[0]);
        StuTest.jTextArea2.setText(pll[1]);
        StuTest.jTextArea3.setText(pll[2]);
        StuTest.jTextArea4.setText(pll[3]);
        StuTest.jTextArea5.setText(pll[4]);

    }

}
