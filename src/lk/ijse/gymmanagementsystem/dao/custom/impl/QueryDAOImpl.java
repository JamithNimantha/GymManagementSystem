/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.QueryDAO;
import lk.ijse.gymmanagementsystem.entity.CustomEntity;


public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> getToAttendanceTaable() throws Exception {
        ArrayList<CustomEntity> list = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select full_name,attendance_id,attendance_date,in_time,membership_id from Member m,Attendance a where m.member_id=a.membership_id");
        while (rst.next()) {
            list.add(new CustomEntity(rst.getString(1),rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
            
        }
        return list;

    }

    @Override
    public ArrayList<CustomEntity> getAllMeasurements() throws Exception {
        ArrayList<CustomEntity> arrayList = new ArrayList<>();
        ResultSet rst =CrudUtil.executeQuery("select full_name,measurement_id,weight,height,bmi,bmi_status,chest,waist,thigs,arms,result_date,membership_id from Member m,Measurement n where m.member_id=n.membership_id");
        while (rst.next()) { 
            arrayList.add(new CustomEntity(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getDouble(4), rst.getDouble(5), rst.getString(6), rst.getDouble(7), rst.getDouble(8), rst.getDouble(9), rst.getDouble(10), rst.getString(11), rst.getString(12)));
            
                
            }
        
        return arrayList;
    }

    @Override
    public ArrayList<CustomEntity> getAllMemberDetails() throws Exception {
        ArrayList<CustomEntity> arrayList =new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select distinct \n" +
                                                        "m.member_id,\n" +
                                                        "m.full_name,\n" +
                                                        "m.address,\n" +
                                                        "m.gender,\n" +
                                                        "m.mobile_number,\n" +
                                                        "m.date_of_birth,\n" +
                                                        "m.email,r.joining_date,\n" +
                                                        "p.package_name,\n" +
                                                        "t.full_name \n" +
                                                        "from Member m,Registration r,Membership n , Trainer t,Package p \n" +
                                                        "where (m.member_id=n.membership_id&&\n" +
                                                        " n.trainer_id=t.trainer_id &&\n" +
                                                        " n.package_id=p.package_id &&\n" +
                                                        " n.membership_id=r.member_id\n" +
                                                        ");");
        while (rst.next()) {
            arrayList.add(new CustomEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10)));
            
        }
        return arrayList;
    }

    @Override
    public ArrayList<CustomEntity> getAllPaymentDetails() throws Exception {

        ArrayList<CustomEntity>list = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select full_name,\n" +
                "payment_id,\n" +
                "payment_date,\n" +
                "payment_time,\n" +
                "payment_description,\n" +
                "payment_amount from Member m,Payment p \n" +
                "where m.member_id=p.membership_id");
        
        while (rst.next()) {
           list.add(new CustomEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDouble(6)));
        }
        return list;
    }
    
}
