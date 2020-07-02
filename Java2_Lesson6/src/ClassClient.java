import javax.swing.*;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClassClient extends JFrame {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 2222;
    private static final String END_MESSAGE = "/end";

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClassClient() {
        openConnection();
        mainStream();
    }

    // создание связи
    public void openConnection() {
        try {
            try {
                socket = new Socket(SERVER_ADDR, SERVER_PORT);
                System.out.println("Связь с сервером выполнена");
                System.out.println("Введите сообщение для сервера:");
            } catch (Exception e){
                System.out.println("Сервер не доступен");
                return;
            }

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase(END_MESSAGE)) {
                            break;
                        }
                        System.out.println("S > "+ strFromServer);

                    }
                } catch (Exception e) {
                    System.out.println("Соединение не доступно");
                    // e.printStackTrace();
                }
                finally {
                    close(in, out, socket);
                }
            }).start();
        } catch (IOException e) {
            System.out.println("Ошибка соединения с сервером. " + e.getMessage());
            e.printStackTrace();
        }
    }

    // создание основного потока, для отправки сообщений
    private void mainStream() {
        if (socket == null) {
            return;
        }
        while (true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            try{
                if (socket == null ||socket.isClosed() || out == null){
                    System.out.println("Неустановлена связь с сервером");
                } else {
                    out.writeUTF(str);
                    out.flush();
                    if (str.equals(END_MESSAGE)) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка в отправки сообщений серверу:" + e.getMessage());
                // e.printStackTrace();
            }
        }
        close(in, out, socket);

    }

    private void close(Closeable... objects) {
        for (Closeable o : objects) {
            try {
                if (o != null) {
                    o.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) {
        new ClassClient();
    }
}