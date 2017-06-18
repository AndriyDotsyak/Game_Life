package Client;

import java.net.*;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Life_Client {
    public static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String JsonOutput = null;
    public static String JsonInput = null;
    public static int[][] field_json;

    private static void Update() {
        field_json = GSON.fromJson(JsonInput, int[][].class);

        for(int i = 1; i < 21; i ++) {
            for(int j = 1; j < 21; j++) {
                System.out.print(field_json[i][j] +"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Creation_Life CL = new Creation_Life();
        CL.Creation();
        CL.New_Life();

        JsonOutput = GSON.toJson(Creation_Life.field);

        int serverPort = 7070;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("З'єднання з сервером IP: " + address + " PORT: " + serverPort +" ...");
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("З'єднання з сервером встановлено!");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            System.out.println("Відправлення даних на сервер...");
            out.writeUTF(JsonOutput);
            out.flush();
            System.out.println("Дані відправлено на сервер!");

            while (true) {
                System.out.println("Отримані дані з сервера: ");
                JsonInput = in.readUTF();

                Update();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
