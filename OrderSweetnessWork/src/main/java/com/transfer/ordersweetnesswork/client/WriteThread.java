/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class WriteThread implements Runnable {

    private Socket socket;
    private Client client;
    PrintWriter outputMsg;

    public WriteThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
        try {
            outputMsg = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {

        Scanner scan = new Scanner(System.in);
        System.out.println("input user name:");
        String nameUser = scan.nextLine();
        this.sentMSG(nameUser);
        String msg;

        System.out.println("Welcome, " + nameUser);
        this.sentMSG("client " + nameUser + " is connected");
        while (true) {
            msg = scan.nextLine();
            this.sentMSG(msg);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void sentMSG(String msg) {
        outputMsg.println(msg);
        outputMsg.flush();
    }
}
