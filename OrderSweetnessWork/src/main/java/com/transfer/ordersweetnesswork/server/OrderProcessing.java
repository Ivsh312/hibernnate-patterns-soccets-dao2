/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.server;

import com.transfer.ordersweetnesswork.DAO.ISweetness;
import com.transfer.ordersweetnesswork.Present.Present;
import com.transfer.ordersweetnesswork.Service.ChocolateCandyDAO;
import com.transfer.ordersweetnesswork.Service.IcicleDAO;
import com.transfer.ordersweetnesswork.Service.ToffeeDAO;
import com.transfer.ordersweetnesswork.entity.Sweetness;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class OrderProcessing {

    private ThreadServer threadServer;
    private Present present;

    public OrderProcessing(ThreadServer threadServer) {
        this.threadServer = threadServer;
    }

    public List<? extends Sweetness> processing() throws IOException {
        BufferedReader input = threadServer.getInputMsg();
        threadServer.sentMSG("input type, taste and value separated by commas");
        String stringParams = input.readLine()
                .toLowerCase(Locale.UK);
        String[] params;
        params = stringParams.split(", ");
        int i = 0;
        while (i < 3) {
            if (params.length == 3) {

                FileInputStream fis;
                try {
                    List<? extends Sweetness> listSweetness = this.requestDb(params);
                    if (listSweetness == null) {
                        threadServer.sentMSG("null((");
                        return null;
                    } else {
                        return listSweetness;
                    }
                } catch (SQLException ex) {

                    System.out.println(ex.getMessage());
                }
            } else {
                threadServer.sentMSG("iiiiiiinvalid format params");
                i++;
            }
        }
        return null;
    }

    public List<? extends Sweetness> requestDb(String[] params) throws SQLException {
        threadServer.sentMSG("req");
        //ISweetness sweetness;
        Integer numbers;
        numbers = Integer.parseInt(params[2]);
        ISweetness sweetness;
        switch (params[0]) {
            case "icicle":
                sweetness = new IcicleDAO();
//            return sweetness.getByTestyDesiredAmount("1", 8);
                return sweetness.getByTestyDesiredAmount(params[1], numbers);
            case "toffee":
                sweetness = new ToffeeDAO();
                return sweetness.getByTestyDesiredAmount(params[1], numbers);
            case "chocolatecandyЩЩЩЩ":
                sweetness = new ChocolateCandyDAO();
                return sweetness.getByTestyDesiredAmount(params[1], numbers);
            default:
                threadServer.sentMSG("null");
                return null;
        }
    }
}
