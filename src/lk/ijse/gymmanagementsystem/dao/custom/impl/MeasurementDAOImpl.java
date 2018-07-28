/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.MeasurementDAO;
import lk.ijse.gymmanagementsystem.entity.Measurement;


public class MeasurementDAOImpl implements MeasurementDAO {

    @Override
    public boolean save(Measurement entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Measurement values(?,?,?,?,?,?,?,?,?,?,?)", entity.getMeasurement_id(),entity.getHeight(),entity.getWeight(),entity.getBmi(),entity.getBmi_status(),entity.getChest(),entity.getWaist(),entity.getThigs(),entity.getArms(),entity.getResult_date(),entity.getMembership_id())>0;
    }

    @Override
    public boolean update(Measurement entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public Measurement search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Measurement> getAll() throws Exception {
        return null;
    }
    
}
