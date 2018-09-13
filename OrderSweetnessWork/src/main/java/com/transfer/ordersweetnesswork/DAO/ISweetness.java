/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.DAO;

import com.transfer.ordersweetnesswork.entity.Sweetness;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ISweetness {
    public List<? extends Sweetness> getByTestyDesiredAmount(String taste, int numbers) throws SQLException;
}
