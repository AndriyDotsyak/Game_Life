package Server;

import java.net.*;
import java.io.*;

public class Life_Server {
    public static String JsonOutput = null;
    public static String JsonInput = null;

    public static Rules_Life RL = new Rules_Life();

    public static void main(String[] args) {
        int port = 7070;
        int millis = 3000;

        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Очікування клієнта ...");

            Socket socket = ss.accept();
            System.out.println("Клієнт підключений!");
            System.out.println();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            System.out.println("Очікування даних...");
            JsonInput = in.readUTF();
            System.out.println("Отримані дані від клієнта: " + JsonInput);
            RL.Creation();

            while(true) {
                Thread.sleep(millis);

                RL.Dies();
                RL.Resurrection();
                RL.Reassignment();

                System.out.println("Відправляєм дані клієнту...");
                out.writeUTF(JsonOutput);
                out.flush();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}
