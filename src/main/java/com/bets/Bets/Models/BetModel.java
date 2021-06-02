package com.bets.Bets.Models;
public class BetModel {
    private Long id;
    private String name;
    private String Status;
    public BetModel() {
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }
    public BetModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }  
}
