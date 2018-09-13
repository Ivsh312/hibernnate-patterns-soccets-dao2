/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.server;

import com.transfer.ordersweetnesswork.Present.Present;
import com.transfer.ordersweetnesswork.entity.Sweetness;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
class ThreadServer implements Runnable {

    Server server;
    Socket socket;
    PrintWriter outputMsg;
    BufferedReader inputMsg;
    int id;
    Present present;
    String userName;
    private String codeForStartTransfer = "8934951934553323435465768";
    ObjectOutputStream outFile;

    public ThreadServer(Server server, Socket socket, int id) {
        this.id = id;
        this.server = server;
        this.socket = socket;
        present = new Present();
        try {
            outputMsg = new PrintWriter(socket.getOutputStream(), true);
            inputMsg = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.sentMSG("Server listens");
        try {
            this.userName = inputMsg.readLine();
            server.addUser(userName);
            String msg;
            OrderProcessing processing;
            this.sentMSG("input \"order\" for workcs service");
            while (true) {
                msg = inputMsg.readLine();
                if (msg.equals("order")) {
                    processing = new OrderProcessing(this);
                    System.out.println(msg);
                    List<? extends Sweetness> listSweetness = processing.processing();
                    if (listSweetness != null) {
                        present.addAll(listSweetness);
                        this.sentMSG("inpu + for add more or - for finishing");
                        while (true) {
                            msg = inputMsg.readLine();
                            if (msg.equals("+")) {
                                this.sentMSG("input \"order\" for workcs service");
                                break;
                            } else {
                                this.sentMSG("server " + present.toString());
                                this.sentMSG("8934951934553323435465768");
                                outFile = new ObjectOutputStream(this.socket.getOutputStream());
                                outFile.writeObject(present);
                                outFile.flush();
                            }
                        }
                    }
                    Thread.sleep(100);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void sentMSG(String msg) {
        outputMsg.println(msg);
        outputMsg.flush();
    }

    public void disconnect() {
        try {

            if (inputMsg != null) {
                inputMsg.close();
            }
            if (outputMsg != null) {
                outputMsg.close();
            }
            socket.close();
            System.out.println(userName + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Thread.interrupted();
        }
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getOutputMsg() {
        return outputMsg;
    }

    public void setOutputMsg(PrintWriter outputMsg) {
        this.outputMsg = outputMsg;
    }

    public BufferedReader getInputMsg() {
        return inputMsg;
    }

    public void setInputMsg(BufferedReader inputMsg) {
        this.inputMsg = inputMsg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
