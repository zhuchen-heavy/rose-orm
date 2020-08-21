package com.rose.sqlite.entity;

/**
 * <p>
 *  kp切换实体
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/14
 * @version: v1.0.0
 */
public class KeepalivedMessageDO {

    private Integer id;

    /**
     * 切换状态
     */
    private String state;

    /**
     * 切换时间
     */
    private String switchTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSwitchTime() {
        return switchTime;
    }

    public void setSwitchTime(String switchTime) {
        this.switchTime = switchTime;
    }

    @Override
    public String toString() {
        return "KeepalivedMessageDO{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", switchTime='" + switchTime + '\'' +
                '}';
    }
}
