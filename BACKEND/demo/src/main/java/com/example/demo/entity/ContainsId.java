package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class ContainsId implements Serializable {
    private Integer rid;
    private Integer igid;

    public ContainsId(){
        this.rid = rid;
        this.igid = igid;
    }
    //Constructor
    public ContainsId(Integer rid, Integer igid) {
        this.rid = rid;
        this.igid = igid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getIgid() {
        return igid;
    }

    public void setIgid(Integer igid) {
        this.igid = igid;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (!(o instanceof ContainsId) )return false;
        ContainsId that = (ContainsId) o;
        return Objects.equals(rid, that.rid) && Objects.equals(igid, that.igid);
    }

    @Override
    public int hashCode(){
        return Objects.hash(rid, igid);
    }






}
