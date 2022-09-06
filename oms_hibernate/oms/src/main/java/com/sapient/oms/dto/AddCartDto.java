package com.sapient.oms.dto;


import javax.validation.constraints.NotNull;

public class AddCartDto {
    private Integer id;
    private @NotNull Integer storeId;
    private @NotNull Integer userid;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public AddCartDto(Integer id, @NotNull Integer storeId, @NotNull Integer userid) {
        this.id = id;
        this.storeId = storeId;
        this.userid = userid;
    }
    public AddCartDto() {
    }
    public AddCartDto(@NotNull Integer storeId, @NotNull Integer userid) {
        this.storeId = storeId;
        this.userid = userid;
    }
    @Override
    public String toString() {
        return "AddCartDto [id=" + id + ", storeId=" + storeId + ", userid=" + userid + "]";
    }
    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    


 
}
