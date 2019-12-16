package Test;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class ServerThread extends Thread {
    public static String name;
    public Socket socket;
    public Conntions conntions=new Conntions();
    public ServerThread(Socket socket) throws SQLException, ClassNotFoundException {
        this.socket=socket;
    }
    @Override
    public void run() {
        Seach seach = new Seach(socket);
        InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[1023];
            int y = 0;
            try {
                y = inputStream.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String tem = null;
            tem = new String(bytes, 0, y);
            String[] state = tem.split(",");
            String retrunp = "";
            try {
                if (conntions.select(state[0], state[1], state[2])) {
                    name = state[1];
                    System.out.println("123");
                    retrunp = "true";
                } else retrunp = "false";
            } catch (SQLException e) {
                e.printStackTrace();
            }
            OutputStream outputStream = null;
            try {
                outputStream = socket.getOutputStream();
                outputStream.write(retrunp.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int km=0;
            while (km==0) {
                InputStream inputStream1 = null;
                try {
                    inputStream1 = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] bytes1 = new byte[1023];
                int k = 0;
                try {
                    k = inputStream1.read(bytes1);
                    if (k == -1) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String pk = new String(bytes1, 0, k);
                System.out.println(pk);
                switch (pk) {
                    case "2":
                        try {
                            seach.example(conntions.example());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        try {
                            seach.chenji(state[1]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "4":
                        try {
                            seach.update();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "5":
                        try {
                            seach.insertti();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "6":
                        try {
                            seach.delexam();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "7":
                        try {
                            seach.upexa();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "8":
                        try {
                            seach.selexamine();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "9":
                        try {
                            seach.addstudent();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "10":
                        try {
                            seach.delstudent();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "11":
                        try {
                            seach.upstudent();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "12":
                        try {
                            seach.selstudent();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "13":k=1;break;
                }

            }
        }

}
