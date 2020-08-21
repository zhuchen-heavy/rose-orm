package com.rose.sqlite.entity;

/**
 * <p>
 *  健康检查的DO实体类
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/14
 * @version: v1.0.0
 */
public class HealthMessageDO {

    private Integer id;

    /**
     * 组件标识
     */
    private String componentId;

    /**
     * 段标识
     */
    private String segmentId;

    /**
     * 服务名
     */
    private String name;

    /**
     * 服务状态
     */
    private String serviceState;

    /**
     * 采集时间
     */
    private String collectTime;

    /**
     * 采集的次数
     * 每次采集的collectCount都是一致的。
     */
    private String collectCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(String collectCount) {
        this.collectCount = collectCount;
    }

    @Override
    public String toString() {
        return "HealthMessageDO{" +
                "id=" + id +
                ", componentId='" + componentId + '\'' +
                ", segmentId='" + segmentId + '\'' +
                ", name='" + name + '\'' +
                ", serviceState='" + serviceState + '\'' +
                ", collectTime='" + collectTime + '\'' +
                ", collectCount='" + collectCount + '\'' +
                '}';
    }
}
