/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import lk.ijse.gymmanagementsystem.model.MemberDTO;

/**
 *
 * @author jamith
 */
public interface MemberBO extends SuperBO{
    public boolean addMember(MemberDTO memberDTO)throws Exception;
    public ArrayList<String> getMemberNames() throws Exception;
    public String searchMemberIDUsingFullName(String name) throws Exception;
    public ArrayList<CustomDTO> getAllMemnerDetails() throws Exception;
    
}
