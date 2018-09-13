/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Lenovo
 */
public class Client {
    
    Socket socket;
    
    public Client() {
        try {
            this.socket = new Socket("192.168.100.2", 8888);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws UnknownHostException {
        Client client = new Client();
        client.play();
    }

    public void play(){
        Thread thReadThread = new Thread(new ReadThread(socket, this));
        thReadThread.start();
        Thread thWriteThread = new Thread(new WriteThread(socket, this));
        thWriteThread.start();                
    }
}
