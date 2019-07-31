package com.xinyi.readdatafromhbase.bean;

/**
 * 参数说明：
 *
 * xdataId              唯一ID
 * region_id    		区域编号
 * modelname    		型号中文名
 * location_name		点位中文名
 * image_url1   		图片地址
 * yearname     		年款中文
 * brandname    		品牌中文
 * location_id  		点位ID
 * capture_time 		过车时间
 * license_plate		车牌号码（识别前）
 * license_plate2		车牌号码（识别后）
 * plate_type_id2		车辆颜色
 * plate_color_id		车牌颜色
 * plate_type		    车辆类型
 * longitude		    经度
 * latitude		        纬度
 *
 * 功能说明:
 * author: defu.du
 * date: 2019-04-09 11:42:38
 * Copyright (C)1997-2018 深圳信义科技 All rights reserved.
 */

public class VehicleBean
{
    private Long region_id;
    private String modelname;
    private String location_name;
    private String image_url1;
    private String yearname;
    private String brandname;
    private Long location_id;
    private String capture_time;
    private String license_plate;
    private String license_plate2;
    private String plate_type_id2;
    private String plate_color_id;
    private String plate_type;
    private Double longitude;
    private Double latitude;
    private String veh_type_id ;
    private String is_heavy_truck ;
    private String is_tank_truck ;

    public VehicleBean(Long region_id, String modelname, String location_name, String image_url1, String yearname, String brandname, Long location_id, String capture_time, String license_plate, String license_plate2, String plate_type_id2, String plate_color_id, String plate_type, Double longitude, Double latitude, String veh_type_id, String is_heavy_truck, String is_tank_truck) {
        this.region_id = region_id;
        this.modelname = modelname;
        this.location_name = location_name;
        this.image_url1 = image_url1;
        this.yearname = yearname;
        this.brandname = brandname;
        this.location_id = location_id;
        this.capture_time = capture_time;
        this.license_plate = license_plate;
        this.license_plate2 = license_plate2;
        this.plate_type_id2 = plate_type_id2;
        this.plate_color_id = plate_color_id;
        this.plate_type = plate_type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.veh_type_id = veh_type_id;
        this.is_heavy_truck = is_heavy_truck;
        this.is_tank_truck = is_tank_truck;
    }

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getImage_url1() {
        return image_url1;
    }

    public void setImage_url1(String image_url1) {
        this.image_url1 = image_url1;
    }

    public String getYearname() {
        return yearname;
    }

    public void setYearname(String yearname) {
        this.yearname = yearname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public String getCapture_time() {
        return capture_time;
    }

    public void setCapture_time(String capture_time) {
        this.capture_time = capture_time;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getLicense_plate2() {
        return license_plate2;
    }

    public void setLicense_plate2(String license_plate2) {
        this.license_plate2 = license_plate2;
    }

    public String getPlate_type_id2() {
        return plate_type_id2;
    }

    public void setPlate_type_id2(String plate_type_id2) {
        this.plate_type_id2 = plate_type_id2;
    }

    public String getPlate_color_id() {
        return plate_color_id;
    }

    public void setPlate_color_id(String plate_color_id) {
        this.plate_color_id = plate_color_id;
    }

    public String getPlate_type() {
        return plate_type;
    }

    public void setPlate_type(String plate_type) {
        this.plate_type = plate_type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getVeh_type_id() {
        return veh_type_id;
    }

    public void setVeh_type_id(String veh_type_id) {
        this.veh_type_id = veh_type_id;
    }

    public String getIs_heavy_truck() {
        return is_heavy_truck;
    }

    public void setIs_heavy_truck(String is_heavy_truck) {
        this.is_heavy_truck = is_heavy_truck;
    }

    public String getIs_tank_truck() {
        return is_tank_truck;
    }

    public void setIs_tank_truck(String is_tank_truck) {
        this.is_tank_truck = is_tank_truck;
    }

    @Override
    public String toString() {
        return "VehicleBean{" +
                "region_id=" + region_id +
                ", modelname='" + modelname + '\'' +
                ", location_name='" + location_name + '\'' +
                ", image_url1='" + image_url1 + '\'' +
                ", yearname='" + yearname + '\'' +
                ", brandname='" + brandname + '\'' +
                ", location_id=" + location_id +
                ", capture_time='" + capture_time + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", license_plate2='" + license_plate2 + '\'' +
                ", plate_type_id2='" + plate_type_id2 + '\'' +
                ", plate_color_id='" + plate_color_id + '\'' +
                ", plate_type='" + plate_type + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", veh_type_id='" + veh_type_id + '\'' +
                ", is_heavy_truck='" + is_heavy_truck + '\'' +
                ", is_tank_truck='" + is_tank_truck + '\'' +
                '}';
    }
}
