package com.demo;

import cn.z.ip2region.Ip2Region;

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
        Ip2Region.initByFile("/file/ip2region/data.db");
        // Ip2Region.initByUrl("https://cdn.jsdelivr.net/gh/lionsoul2014/ip2region/data/ip2region.db");
        System.out.print(Ip2Region.parse("202.108.22.5"));
    }

}
