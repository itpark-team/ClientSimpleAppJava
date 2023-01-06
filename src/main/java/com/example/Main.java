package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    static void Log(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Socket socket;

        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        socket = new Socket(InetAddress.getByName("194.67.105.79"), 23465);
        Log("connect to server");

        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());

        System.out.print("Input info for server: ");
        String msgToServer = scanner.nextLine();

        dataOutputStream.writeUTF(msgToServer);
        dataOutputStream.flush();

        String msgFromServer = dataInputStream.readUTF();

        System.out.println("msg from server: " + msgFromServer);

        socket.close();

        Log("disconnected from server");
    }
}
