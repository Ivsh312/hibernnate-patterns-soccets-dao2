/*
 * client for work ith service
 *open 2 thread 
 *1 ReadThread missage
  * 2 sent missage
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
            this.socket = new Socket("192.168.1.2", 8888);
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
