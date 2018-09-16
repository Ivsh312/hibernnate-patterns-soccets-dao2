/*
 *class for working with a serialized object
 */
package com.transfer.ordersweetnesswork.client;

import com.transfer.ordersweetnesswork.Present.Present;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

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

