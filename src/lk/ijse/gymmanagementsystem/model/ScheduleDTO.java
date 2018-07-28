/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.model;

import java.util.ArrayList;

/**
 *
 * @author jamith
 */
public class ScheduleDTO {
    private String schedule_id;
    private String membership_id;
    private String trainer_id;
    private String schedule_date;
    private ArrayList<ScheduleDetailDTO> scheduleDetailDTO;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String schedule_id, String membership_id, String trainer_id, String schedule_date, ArrayList<ScheduleDetailDTO> scheduleDetailDTO) {
        this.schedule_id = schedule_id;
        this.membership_id = membership_id;
        this.trainer_id = trainer_id;
        this.schedule_date = schedule_date;
        this.scheduleDetailDTO = scheduleDetailDTO;
    }

    /**
     * @return the schedule_id
     */
    public String getSchedule_id() {
        return schedule_id;
    }

    /**
     * @param schedule_id the schedule_id to set
     */
    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    /**
     * @return the membership_id
     */
    public String getMembership_id() {
        return membership_id;
    }

    /**
     * @param membership_id the membership_id to set
     */
    public void setMembership_id(String membership_id) {
        this.membership_id = membership_id;
    }

    /**
     * @return the trainer_id
     */
    public String getTrainer_id() {
        return trainer_id;
    }

    /**
     * @param trainer_id the trainer_id to set
     */
    public void setTrainer_id(String trainer_id) {
        this.trainer_id = trainer_id;
    }

    /**
     * @return the schedule_date
     */
    public String getSchedule_date() {
        return schedule_date;
    }

    /**
     * @param schedule_date the schedule_date to set
     */
    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    /**
     * @return the scheduleDetailDTO
     */
    public ArrayList<ScheduleDetailDTO> getScheduleDetailDTO() {
        return scheduleDetailDTO;
    }

    /**
     * @param scheduleDetailDTO the scheduleDetailDTO to set
     */
    public void setScheduleDetailDTO(ArrayList<ScheduleDetailDTO> scheduleDetailDTO) {
        this.scheduleDetailDTO = scheduleDetailDTO;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" + "schedule_id=" + schedule_id + ", membership_id=" + membership_id + ", trainer_id=" + trainer_id + ", schedule_date=" + schedule_date + ", scheduleDetailDTO=" + scheduleDetailDTO + '}';
    }

    
   
    
    
    
    
    
}
