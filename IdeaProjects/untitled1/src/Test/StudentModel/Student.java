package Test.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Student extends javax.swing.JFrame {
/**
 *
 * @author edz
 */
    /**
     * Creates new form student
     */
    public Student() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
   private   void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("学生系统");

        jButton1.setText("修改");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket socket = Sockett.socket;
                OutputStream outputStream = null;
                try {
                    outputStream = socket.getOutputStream();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    outputStream.write("4".getBytes());
                    outputStream.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
                new StuUpdate().setVisible(true);
            }
        });

        jButton2.setText("考试");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Socket socket = Sockett.socket;
                    OutputStream outputStream = null;
                    try {
                        outputStream = socket.getOutputStream();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        outputStream.write("2".getBytes());
                        outputStream.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    StuTest stuTest = null;
                    try {
                        stuTest = new StuTest();
                        stuTest.setVisible(true);
                        new daojis(stuTest).start();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    dispose();

            }
        });
        jButton3.setText("查成绩");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket socket = Sockett.socket;
                OutputStream outputStream = null;
                try {
                    outputStream = socket.getOutputStream();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    outputStream.write("3".getBytes());
                    System.out.println("传3");
                    outputStream.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                InputStream i=null;
                try {
                    byte [] bytes=new byte[100];
                    int y=0;
                    i=Sockett.socket.getInputStream();
                    y=i.read(bytes);
                    JFrame jFrame=new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "您的成绩为"+new String(bytes,0,y), "成绩", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        jButton5.setText("退出");
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
                new sssssssss().setVisible(true);
            }
        });
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jTextField1.setText("       半 圆 学 生 系 统");
        jTextField1.setActionCommand("<Not Set>");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(109, 109, 109)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(201, 201, 201)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton5))))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1)
                                .addGap(25, 25, 25)
                                .addComponent(jButton2)
                                .addGap(25, 25, 25)
                                .addComponent(jButton3)
                                .addGap(25, 25, 25)
                                .addComponent(jButton5)
                                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}

