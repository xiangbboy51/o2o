package com.atom.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: li xiang
 * Date: 2020/6/13 20:59
 */
public class ImageUtil {

    public static final String RESOURCES_PATH = ImageUtil.class.getClassLoader().getResource("").getPath();

    public static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    public static final Random random = new Random();

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 处理缩略图  返回相对路径
     *
     * @param file       CommonsMultipartFile
     * @param targetAddr 业务路径
     * @return
     */
    public static String generatorImagePath(File file, String targetAddr) {
        //生成随机文件名字
        String fileName = generatorRandomFileName();
        //生成文件后缀名字
        String suffix = getFileSuffix(file);
        mkdirBaseFileFolderPath(targetAddr);
        //相对路径为
        String relativePath = targetAddr + fileName + suffix;
        logger.debug("(水印图片相对路径为{})", relativePath);
        //目标最终路径
        String destPath = PathUtil.getBasePath() + relativePath;
        try {
            Thumbnails.of(file)
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(RESOURCES_PATH + "/shuiyin.jpg")), 0.8f)
                    .outputQuality(0.8)
                    .toFile(new File(destPath));
        } catch (IOException e) {
            logger.error("[图片打水印失败! {}]", e.toString());
        }
        return relativePath;

    }

    private static void mkdirBaseFileFolderPath(String targetAddr) {
        String absolutePath = PathUtil.getBasePath() + targetAddr;
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static File commonMultipartFileToFile(CommonsMultipartFile commonsMultipartFile) {
        File newFile = new File(commonsMultipartFile.getOriginalFilename());
        try {
            commonsMultipartFile.transferTo(newFile);
        } catch (IOException e) {
            logger.info("multipart file transfer to file fail!");
        }
        return newFile;
    }


    private static String getFileSuffix(File file) {
        String suffix = file.getName();
        return suffix.substring(suffix.lastIndexOf("."));
    }

    private static String generatorRandomFileName() {
        int randomNum = random.nextInt(89999) + 1000;
        String format = SDF.format(new Date());
        return randomNum + format;
    }


    //测试水印
    public static void main(String[] args) throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("C:\\Users\\86134\\Desktop", "01.jpg"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(path + "/shuiyin.jpg")), 1.0f)
                .outputQuality(0.8f)
                .toFile(new File("C:\\Users\\86134\\Desktop", "01-water.jpg"));
    }

}
