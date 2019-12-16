package Test.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;
import java.util.Enumeration;

public class sssssssss extends javax.swing.JFrame{
        public sssssssss() {
            initComponents();
        }
        public void xians(){
            new Student().setVisible(true);
        }
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
            buttonGroup1 = new javax.swing.ButtonGroup();
            jTextField1 = new javax.swing.JTextField();
            jButton2 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jPasswordField1 = new javax.swing.JPasswordField();
            jTextField2 = new javax.swing.JTextField();
            jRadioButton1 = new javax.swing.JRadioButton();
            jRadioButton2 = new javax.swing.JRadioButton();
            jButton1 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("半圆考试系统");
            setAutoRequestFocus(false);
            setFont(new java.awt.Font(".SF NS Text", 0, 24)); // NOI18N

            jButton2.setText("账号");

            jButton3.setText("密码");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });
        jTextField2.setBackground(new java.awt.Color(238, 238, 238));
            jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
            jTextField2.setText("欢迎登录半圆官网");
            jTextField2.setBorder(null);

            jRadioButton1.setText("学生");
            jRadioButton1.setSelected(true);
            jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton1ActionPerformed(evt);
                }
            });

            jRadioButton2.setText("教师");
            ButtonGroup buttonGroup=new ButtonGroup();
            buttonGroup.add(jRadioButton1);
            buttonGroup.add(jRadioButton2);

            jButton1.setText("登录");
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Enumeration<AbstractButton> radioBtns  =buttonGroup.getElements();
                    String json=null;
                    String pl=null;
                    while (radioBtns.hasMoreElements()) {
                    AbstractButton btn = radioBtns.nextElement();
                    if(btn.isSelected()){
                        pl=btn.getText();
                    json=btn.getText()+",";
                       break;
}
}
                    Socket socket= null;
                    try {
                        socket = new Socket("192.168.9.41",1111);
                        Sockett.socket=socket;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                     json+=jTextField1.getText()+","+jPasswordField1.getText();
                    OutputStream outputStream = null;
                    try {
                        outputStream = socket.getOutputStream();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        outputStream.write(json.getBytes());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        outputStream.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Reader reader= null;
                    try {
                        reader = new InputStreamReader(socket.getInputStream());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    char [] bytes=new char[64];
                    int x= 0;
                    try {
                        x = reader.read(bytes);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if(new String(bytes,0,x).equals("true")){
                        if(pl.equals("学生")){
                            xians();
                            System.out.println(pl);
                        }
                        else{

                                  new AdmMenu().setVisible(true);

                        }
                        dispose();
                        System.out.println("登入成功");
                    }
                    else {
                        System.out.println("登入失败");
                    }

                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(90, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2)
                                            .addComponent(jButton3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(127, 127, 127))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(130, 130, 130)
                                    .addComponent(jRadioButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton2)
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(131, 131, 131)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(121, 121, 121)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton3)
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jRadioButton1)
                                            .addComponent(jRadioButton2))
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1)
                                    .addContainerGap(74, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) throws IOException {


            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(sssssssss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(sssssssss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(sssssssss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(sssssssss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new sssssssss().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JPasswordField jPasswordField1;
        private javax.swing.JRadioButton jRadioButton1;
        private javax.swing.JRadioButton jRadioButton2;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        // End of variables declaration
}
