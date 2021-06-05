package com.bets.Bets.Models;
public class BetModel {
    private Long id;
    private Integer numbergain;
    private String Status;
    public BetModel() {
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNumbergain() {
        return numbergain;
    }
    public void setNumbergain(Integer numbergain) {
        this.numbergain = numbergain;
    }
    
}
