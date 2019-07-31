package com.xinyi.readdatafromhbase.service;

import com.xinyi.readdatafromhbase.constant.Constant;
import com.xinyi.readdatafromhbase.utils.HBaseUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 功能说明: 根据时间段读取hbase的过车记录，并把所有的过车记录写入一个list集合里
 * author: defu.du
 * date: 2019/07/10 14:44:30
 * Copyright (C)1997-2019 深圳信义科技 All rights reserved.
 */
public class ReadDataFromHbase {

    private static final Logger logger = LoggerFactory.getLogger(ReadDataFromHbase.class);
    private static Connection hbaseConnection;
    private static List<String> resultList;
    private static Table table ;
    private static Scan scan ;
    private static ResultScanner results ;
    private static byte[] family = Bytes.toBytes(Constant.HBASE_VEHICLE_TABLE_FAMILY) ;
    private static FastDateFormat fdfWithBar = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
    private static FastDateFormat fdfWithNoBar = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public static void main(String[] args) {
        ReadDataFromHbase readDataFromHbase = new ReadDataFromHbase();
        List<String> rowData = readDataFromHbase.getDataFromHbase("2019-06-26 00:00:00","2019-06-26 19:00:01","huan:video");
        System.out.println(rowData.size());
        Iterator iterator = rowData.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

    }

    /**
     * @function 根据时间段读取hbase的过车记录，并把所有的过车记录写入一个list集合里
     * @param startTime 开始时间
     * @param stopTime  结束时间
     * @return List<String>
     */
    public static List<String> getDataFromHbase(String startTime,String stopTime,String tableName){
        try {
            logger.info("连接到Hbase......");
            hbaseConnection = HBaseUtils.getHBaseConnection();
            resultList = new ArrayList();
            table = hbaseConnection.getTable(TableName.valueOf(tableName));
            logger.info("连接Hbase成功.....");
            scan = new Scan();
            scan.withStartRow(Bytes.toBytes(fdfWithNoBar.format(fdfWithBar.parse(startTime))));
            scan.withStopRow(Bytes.toBytes(fdfWithNoBar.format(fdfWithBar.parse(stopTime))));
            scan.addFamily(family);
            results = table.getScanner(scan);
            logger.info("获取数据成功.....");
        }catch (Exception e){
            e.printStackTrace();
        }

        for(Result result: results){
            String region_id = Bytes.toString(result.getValue(family, Bytes.toBytes("region_id")));
            String modelname = Bytes.toString(result.getValue(family, Bytes.toBytes("modelname")));
            String location_name = Bytes.toString(result.getValue(family, Bytes.toBytes("location_name")));
            String image_url1 = Bytes.toString(result.getValue(family, Bytes.toBytes("image_url1")));
            String yearname = Bytes.toString(result.getValue(family, Bytes.toBytes("yearname")));
            String brandname = Bytes.toString(result.getValue(family, Bytes.toBytes("brandname")));
            String location_id = Bytes.toString(result.getValue(family, Bytes.toBytes("location_id")));
            String capture_time = Bytes.toString(result.getValue(family, Bytes.toBytes("capture_time")));
            String license_plate = Bytes.toString(result.getValue(family, Bytes.toBytes("license_plate")));
            String license_plate2 = Bytes.toString(result.getValue(family, Bytes.toBytes("license_plate2")));
            String plate_type_id2 = Bytes.toString(result.getValue(family, Bytes.toBytes("plate_type_id2")));
            String plate_color_id = Bytes.toString(result.getValue(family, Bytes.toBytes("plate_color_id")));
            String plate_type = Bytes.toString(result.getValue(family, Bytes.toBytes("plate_type")));
            String longitude = Bytes.toString(result.getValue(family, Bytes.toBytes("longitude")));
            String latitude = Bytes.toString(result.getValue(family, Bytes.toBytes("latitude")));
            String veh_type_id = Bytes.toString(result.getValue(family, Bytes.toBytes("veh_type_id")));
            String is_heavy_truck = Bytes.toString(result.getValue(family, Bytes.toBytes("is_heavy_truck")));
            String is_tank_truck = Bytes.toString(result.getValue(family, Bytes.toBytes("is_tank_truck")));


            String row = "[{"+"\"region_id\":"+"\""+region_id+"\""+","+"\"modelname\":"+"\""+modelname+"\""+","+"\"location_name\":"+"\""+location_name+"\""+","+
                    "\"image_url1\":"+"\""+image_url1+"\""+","+"\"yearname\":"+"\""+yearname+"\""+","+"\"brandname\":"+"\""+brandname+"\""+","+"\"location_id\":"+"\""+location_id+"\""+","+
                    "\"capture_time\":"+"\""+capture_time+"\""+","+"\"license_plate\":"+"\""+license_plate+"\""+","+"\"license_plate2\":"+"\""+license_plate2+"\""+","+"\"plate_type_id2\":"+"\""+plate_type_id2+"\""+","+
                    "\"plate_color_id\":"+"\""+plate_color_id+"\""+","+"\"plate_type\":"+"\""+plate_type+"\""+","+"\"longitude\":"+"\""+longitude+"\""+","+"\"latitude\":"+"\""+latitude+"\""+","+"\"veh_type_id\":"+"\""+veh_type_id+"\""+","+
                    "\"is_heavy_truck\":"+"\""+is_heavy_truck+"\""+","+"\"is_tank_truck\":"+"\""+is_tank_truck+"\""+"}]" ;
            resultList.add(row);
        }
        logger.info("写入数据到list中.....");
        return resultList ;
    }
}
