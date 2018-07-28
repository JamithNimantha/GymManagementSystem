/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.MemberDAO;
import lk.ijse.gymmanagementsystem.entity.Member;

/**
 *
 * @author jamith
 */
public class MemberDAOImpl implements MemberDAO{

    @Override
    public boolean save(Member entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Member values(?,?,?,?,?,?,?) ", entity.getMember_id(),entity.getFull_name(),entity.getAddress(),entity.getGender(),entity.getMobile_number(),entity.getDate_of_birth(),entity.getEmail())>0;
    }

    @Override
    public boolean update(Member entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public Member search(String id) throws Exception {
        return  null;
    }

    @Override
    public ArrayList<Member> getAll() throws Exception {
        ArrayList<Member> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from Member");
        while (rst.next()) {            
            arrayList.add(new Member(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
        }
        
        return arrayList;
    }

    @Override
    public Member searchMemberIDUsingFullName(String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Member where full_name=? ",name);
        if(rst.next()){
            //System.out.println("not null");
            return new Member(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7));
        }else{
            
            return null;
        }
    }
    
}
