package com.bets.Bets.Models;
public class BetModel {
    private Long id;
    private Integer numbergain;
    private String Status;
    private String created_at;
    private String updated_at;
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
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String update_at) {
        this.updated_at = update_at;
    }
}
