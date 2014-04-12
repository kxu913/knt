package com.ny6design.model;

public class ShipMethod {
    private Integer id;

    private String description;

    private Double cost;

    private Integer fdefault;

    private Integer forder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getFdefault() {
        return fdefault;
    }

    public void setFdefault(Integer fdefault) {
        this.fdefault = fdefault;
    }

    public Integer getForder() {
        return forder;
    }

    public void setForder(Integer forder) {
        this.forder = forder;
    }
}