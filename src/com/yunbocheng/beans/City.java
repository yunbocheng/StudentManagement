package com.yunbocheng.beans;

import java.io.Serializable;

public class City implements Serializable {
    /*城市主键*/
    private Integer id;
    /*城市名称*/
    private  String name;
    /*城市所属的省份*/
    private Integer province;

    public City() {
    }

    public City(Integer id, String name, Integer province) {
        this.id = id;
        this.name = name;
        this.province = province;
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

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}
