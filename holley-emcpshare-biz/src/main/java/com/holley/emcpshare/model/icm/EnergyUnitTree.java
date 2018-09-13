package com.holley.emcpshare.model.icm;

import java.util.List;

public class EnergyUnitTree {

    private int                 id;
    private String              name;
    private int                 type;
    public List<EnergyUnitTree> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<EnergyUnitTree> getChildren() {
        return children;
    }

    public void setChildren(List<EnergyUnitTree> children) {
        this.children = children;
    }

}
