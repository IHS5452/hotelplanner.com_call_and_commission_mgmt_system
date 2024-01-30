/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Date;

/**
 *
 * @author iansc
 */
public class calls {
    
    
    String callID = "";
    String callStatus = "";
    Boolean isPrepaid;
    
    String LinkedSaleID = "";
    
    Date start;
    Date end;

    public String getCallID() {
        return callID;
    }

    public void setCallID(String callID) {
        this.callID = callID;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public Boolean getIsPrepaid() {
        return isPrepaid;
    }

    public void setIsPrepaid(Boolean isPrepaid) {
        this.isPrepaid = isPrepaid;
    }

    public String getLinkedSaleID() {
        return LinkedSaleID;
    }

    public void setLinkedSaleID(String LinkedSaleID) {
        this.LinkedSaleID = LinkedSaleID;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    
    
    
    
    
    
    
    
    
}
