package com.yunbocheng.beans;

import java.io.Serializable;

public class Province implements Serializable {
    private Integer id;
    private String name;
    private String Capital;

    public Province() {
    }

    public Province(Integer id, String name, String capital) {
        this.id = id;
        this.name = name;
        Capital = capital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Capital='" + Capital + '\'' +
                '}';
    }
}
