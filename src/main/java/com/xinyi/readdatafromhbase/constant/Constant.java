package com.xinyi.readdatafromhbase.constant;

import com.xinyi.readdatafromhbase.utils.PropertiesUtils;

import java.util.Properties;

public class Constant {


    private final static Properties prop = PropertiesUtils.getProperties();
    public final static String PROPERTY_FILE_NAME = "application.properties";

    //hbase 相关配置
    public final static String HBASE_MASTER = prop.getProperty("hbase.master");
    public final static String HBASE_ROOTDIR = prop.getProperty("hbase.rootdir");
    public final static String HBASE_ZOOKEEPER_QUORUM = prop.getProperty("hbase.zookeeper.quorum");
    public final static String HBASE_ZOOKEEPER_PROPERTY_CLIENTPORT = prop.getProperty("hbase.zookeeper.property.clientPort");

    //车牌表名
    public final static String HBASE_VEHICLE_TABLE_NAME = prop.getProperty("hbase.vehicle.table.name");
    //车牌列族名
    public final static String HBASE_VEHICLE_TABLE_FAMILY = prop.getProperty("hbase.vehicle.table.family");











}
