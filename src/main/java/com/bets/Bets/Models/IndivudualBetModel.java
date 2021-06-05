package com.bets.Bets.Models;
public class IndivudualBetModel {
    private Long idbet;
    private Long iduser;
    private Long credit;
    private String color;
    private Integer number;
    private String status;
    private Integer gain;
    private String name;
    public IndivudualBetModel() {
    }
    public Integer getNumber() {

        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Long getIdbet() {

        return idbet;
    }
    public String getStatus() {

        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getGain() {

        return gain;
    }
    public void setGain(Integer gain) {
        this.gain = gain;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIdbet(Long idbet) {
        this.idbet = idbet;
    }
    public Long getIduser() {

        return iduser;
    }
    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }
    public Long getCredit() {

        return credit;
    }
    public void setCredit(Long credit) {
        this.credit = credit;
    }
    public String getColor() {
        
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }  
}
