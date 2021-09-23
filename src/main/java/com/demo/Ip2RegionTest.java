package com.demo;

import cn.z.ip2region.Ip2Region;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * <h1>IP地址转区域测试</h1>
 *
 * <p>
 * createDate 2021/09/22 10:23:27
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
public class Ip2RegionTest {

    public static void main(String[] args) {
        initByUrl();
        // initByFile();
        // initByBytes();
        // initMore();
        // initException();
    }

    /**
     * 通过url初始化
     */
    static void initByUrl() {
        Ip2Region.initByUrl("https://cdn.jsdelivr.net/gh/lionsoul2014/ip2region/data/ip2region.db");
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // [main] INFO cn.z.ip2region.Ip2Region - 初始化，URL路径为https://cdn.jsdelivr.net/gh/lionsoul2014/ip2region/data/ip2region.db
        // [main] INFO cn.z.ip2region.Ip2Region - 加载数据文件成功，总共8.93MB
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 通过文件初始化
     */
    static void initByFile() {
        Ip2Region.initByFile("/file/ip2region/data.db");
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // [main] INFO cn.z.ip2region.Ip2Region - 初始化，文件路径为/file/ip2region/data.db
        // [main] INFO cn.z.ip2region.Ip2Region - 加载数据文件成功，总共8.93MB
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 通过bytes初始化
     */
    static void initByBytes() {
        try {
            Ip2Region.init(Files.readAllBytes((new File("/file/ip2region/data.db")).toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // [main] INFO cn.z.ip2region.Ip2Region - 加载数据文件成功，总共8.93MB
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 初始化多次
     */
    static void initMore() {
        Ip2Region.initByFile("/file/ip2region/data.db");
        Ip2Region.initByFile("/file/ip2region/data.db");
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // [main] INFO cn.z.ip2region.Ip2Region - 初始化，文件路径为/file/ip2region/data.db
        // [main] INFO cn.z.ip2region.Ip2Region - 加载数据文件成功，总共8.93MB
        // [main] WARN cn.z.ip2region.Ip2Region - 已经初始化过了，不可重复初始化！
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 初始化异常
     */
    static void initException() {
        Ip2Region.initByFile("/file/ip2region/data");
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // [main] INFO cn.z.ip2region.Ip2Region - 初始化，文件路径为/file/ip2region/data
        // [main] ERROR cn.z.ip2region.Ip2Region - 文件读取异常
        // java.nio.file.NoSuchFileException: \file\ip2region\data
        // [main] ERROR cn.z.ip2region.Ip2Region - memorySearch查询异常
        // java.lang.NullPointerException: null
        // Region{country='', province='', city='', area='', isp=''}
    }

}
