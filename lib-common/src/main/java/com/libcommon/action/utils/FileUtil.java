package com.libcommon.action.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件操作工具
 *
 * @author pujiang
 * @date 2017-9-19 16:35
 * @mail 515210530@qq.com
 * @Description:
 */
public class FileUtil {

    /**
     * 首先默认缓存文件路径,保存到SD卡
     *
     * @return
     */
    public static String getCachePath(){
        if (Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED)){
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }else {
            return "/mnt/sdcard";
        }
    }

    /**
     * 将字符串写入到文本文件中
     * @param strcontent
     * @param filePath
     * @param fileName
     */
    public static void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);
        String strFilePath = filePath+fileName;
        LogAPPUtil.d("writeTxtToFile:-->" + strFilePath);
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        RandomAccessFile raf = null;
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
        } catch (Exception e) {
            e.getStackTrace();
            LogAPPUtil.e("writeTxtToFile->"+e.getStackTrace());
        }finally {
            if(raf!=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成文件
     *
     * @param filePath
     * @param fileName
     * @return
     */
    public static File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogAPPUtil.e("makeFilePath->"+e.getStackTrace());
        }
        return file;
    }


    /**
     * 生成文件夹
     *
     * @param filePath
     */
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.getStackTrace();
            LogAPPUtil.e("makeRootDirectory->"+e.getStackTrace());
        }
    }

    /**
     * 判断文件路径是否存在
     *
     * @param path
     * @return
     */
    public static boolean isFileExist(String path) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断文件路径是否存在,存在时删除
     *
     * @param path
     * @return
     */
    public static void isFileExistDelete(String path) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * 根据文件路径 获取文件大小
     *
     * @param path
     * @return
     */
    public static long getFileSize(String path) {
        File file = new File(path);
        if (file != null && file.exists()) {
            return file.length();
        }
        return -1;
    }

}
