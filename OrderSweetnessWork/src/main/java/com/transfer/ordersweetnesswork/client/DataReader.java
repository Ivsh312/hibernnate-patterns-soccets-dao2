/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.client;

import com.transfer.ordersweetnesswork.Present.Present;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class DataReader implements Runnable {

    private Present present;
    private Socket socket;
    private Client client;
    String fileName;
    String size;

    public DataReader(Socket socket, Client client) {
        this.client = client;
        this.socket = socket;
        this.fileName = fileName;
        this.size = size;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inputFile = new ObjectInputStream(socket.getInputStream());
            Present c = (Present) inputFile.readObject();
            System.out.println("client "+c);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

