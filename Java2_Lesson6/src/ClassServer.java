import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClassServer {
    private static final int SERVER_PORT = 2222;
    private static final String END_MESSAGE = "/end";

    private Socket socket;
    private DataInputStream  in;
    private DataOutputStream out;

    public ClassServer(){
        createServer();
        mainStream();
    }

    // создание сервера
    private void createServer() {
       try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
           System.out.println("Введите сообщение для клиента:");
            new Thread(() -> {
                try {
                    while (true) {
                        String strFromClient = in.readUTF();
                        if (strFromClient.equals(END_MESSAGE)) {
                            break;
                        }
                        System.out.println("С > " + strFromClient);

                    }
               } catch (IOException e) {
                   System.out.println("Клиент недоступен");
                   //e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
           System.out.println("Ошибка в создании сервера:" + e.getMessage());
           //e.printStackTrace();
       }
    }



    // создание основного потока, для отправки сообщений
    private void mainStream() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            try{
                if (socket == null || socket.isClosed() || out == null){
                    System.out.println("Неустановлена связь с клиентом");
                } else {
                    out.writeUTF(str);
                    out.flush();
                    if (str.equals(END_MESSAGE)) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка в отправки сообщений клиенту:" + e.getMessage());
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


    public static void main(String[] args) {
        new ClassServer();
    }
}