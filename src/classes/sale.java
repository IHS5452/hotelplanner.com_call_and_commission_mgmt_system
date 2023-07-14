package classes;

import java.sql.Date;
import java.time.LocalDate;

public class sale {
    private String saleId;
    private String callId;
    private String callStatus;
    private Date callDate;
    private boolean isPrepaid;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isPaidOut;
    private Date paidOutDate;
    private String hotelName;
    private int totalBill;
    private int commissionPercentage;
    private int totalCommission;
    private boolean isCanceledBooking;
    private Date canceledDate;

    // Constructor
    public sale(String saleId, String callId, String callStatus, Date callDate, boolean isPrepaid, LocalDate checkInDate,
                LocalDate checkOutDate, boolean isPaidOut, Date paidOutDate, String hotelName, int totalBill,
                int commissionPercentage, int totalCommission, boolean isCanceledBooking, Date canceledDate) {
        this.saleId = saleId;
        this.callId = callId;
        this.callStatus = callStatus;
        this.callDate = callDate;
        this.isPrepaid = isPrepaid;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isPaidOut = isPaidOut;
        this.paidOutDate = paidOutDate;
        this.hotelName = hotelName;
        this.totalBill = totalBill;
        this.commissionPercentage = commissionPercentage;
        this.totalCommission = totalCommission;
        this.isCanceledBooking = isCanceledBooking;
        this.canceledDate = canceledDate;
    }

    public sale() {
        
    }

    // Getters and Setters (or use your IDE to generate them automatically)

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public boolean isPrepaid() {
        return isPrepaid;
    }

    public void setPrepaid(boolean prepaid) {
        isPrepaid = prepaid;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isPaidOut() {
        return isPaidOut;
    }

    public void setPaidOut(boolean paidOut) {
        isPaidOut = paidOut;
    }

    public Date getPaidOutDate() {
        return paidOutDate;
    }

    public void setPaidOutDate(Date paidOutDate) {
        this.paidOutDate = paidOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public int getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(int commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public int getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(int totalCommission) {
        this.totalCommission = totalCommission;
    }

    public boolean isCanceledBooking() {
        return isCanceledBooking;
    }

    public void setCanceledBooking(boolean canceledBooking) {
        isCanceledBooking = canceledBooking;
    }

    public Date getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(Date canceledDate) {
        this.canceledDate = canceledDate;
    }
    
    
}
