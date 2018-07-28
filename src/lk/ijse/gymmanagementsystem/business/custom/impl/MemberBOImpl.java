/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.MemberDAO;
import lk.ijse.gymmanagementsystem.dao.custom.MembershipDAO;
import lk.ijse.gymmanagementsystem.dao.custom.QueryDAO;
import lk.ijse.gymmanagementsystem.dao.custom.RegistrationDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.CustomEntity;
import lk.ijse.gymmanagementsystem.entity.Member;
import lk.ijse.gymmanagementsystem.entity.Membership;
import lk.ijse.gymmanagementsystem.entity.Registration;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import lk.ijse.gymmanagementsystem.model.MemberDTO;

/**
 *
 * @author jamith
 */
public class MemberBOImpl implements MemberBO{
    private static MemberDAO memberDAO;
    private static RegistrationDAO registrationDAO;
    private static MembershipDAO membershipDAO ;
    private static QueryDAO queryDAO;

    public MemberBOImpl() {
        memberDAO  = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);
        registrationDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
        membershipDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBERSHIP);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }
    
            
    @Override
    public boolean addMember(MemberDTO memberDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{    
            boolean rseult = memberDAO.save(new Member(memberDTO.getMember_id(), memberDTO.getFull_name(), memberDTO.getAddress(), memberDTO.getGender(), memberDTO.getMobile_number(), memberDTO.getDate_of_birth(), memberDTO.getEmail()));
            if(!rseult){
                connection.rollback();
                return false;
            }
            rseult=registrationDAO.save(new Registration(memberDTO.getRegistrationDTO().getRegistration_id(), memberDTO.getRegistrationDTO().getJoining_date(), memberDTO.getRegistrationDTO().getMember_id()));
            if(!rseult){
                connection.rollback();
                return false;
            }
            rseult  = membershipDAO.save(new Membership(memberDTO.getMembershipDTO().getMembership_id(),memberDTO.getMembershipDTO().getFirst_payment_id(), memberDTO.getMembershipDTO().getRegistration_id(),memberDTO.getMembershipDTO().getPackage_id(),memberDTO.getMembershipDTO().getTrainer_id()));
            if(!rseult){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        }finally{
            connection.setAutoCommit(true);
        }
        
    }

    @Override
    public ArrayList<String> getMemberNames() throws Exception {
        ArrayList<Member> memberList = memberDAO.getAll();
        ArrayList<String> nameList=new ArrayList<>();
        for (Member member : memberList) {
            nameList.add(member.getFull_name());
        }
        return nameList;
    }

    @Override
    public String searchMemberIDUsingFullName(String name) throws Exception {
        Member all=memberDAO.searchMemberIDUsingFullName(name);
        return all.getMember_id();
    }

    @Override
    public ArrayList<CustomDTO> getAllMemnerDetails() throws Exception {
        ArrayList<CustomEntity> customEntitys=queryDAO.getAllMemberDetails();
        ArrayList<CustomDTO> customDTOs= new ArrayList<>();
        for(CustomEntity c:customEntitys){
            customDTOs.add(new CustomDTO(c.getMember_id(), c.getFull_name(), c.getAddress(), c.getGender(), c.getMobile_number(), c.getDate_of_birth(), c.getEmail(), c.getJoining_date(), c.getPackage_name(), c.getT_full_name()));
        }
        return customDTOs;
    }
    
    
}
