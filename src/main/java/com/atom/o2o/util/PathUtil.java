package com.atom.o2o.util;

/**
 * @Author: li xiang
 * Date: 2020/6/13 23:12
 */
public class PathUtil {
    public static final String separator = System.getProperty("file.separator");

    /**
     * 项目根路径
     * @return
     */
    public static String getBasePath() {
        String basePath = null;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            basePath = "F:/o2o/image/";
        } else {
            basePath = "/usr/local/image/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    /**
     * 商定图片相对路径
     * @param shopId
     * @return
     */
    public static String getShopImgPath(Integer shopId) {
        String shopPath = "/upload/shop/" + shopId + "/";
        shopPath = shopPath.replace("/", separator);
        return shopPath;
    }

}
