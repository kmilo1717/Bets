package com.bets.Bets.Models;
public class UsuarioModel {
    private Long id;
    private String name;
    private Long credit;
    public UsuarioModel() {
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
    public Long getCredit() {
        return credit;
    }
    public void setCredit(Long credit) {
        this.credit = credit;
    }
}
