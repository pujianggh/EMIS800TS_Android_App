package com.libcommon.action.utils;

import android.graphics.Bitmap;

import java.io.FileOutputStream;

/**
 * 图片处理工具类
 *
 * @author pujiang
 * @date 2018-1-5 19:01
 * @mail 515210530@qq.com
 * @Description:
 */
public class ImageUtil {

    /**
     * 保存bitmap到SD卡
     *
     * @param bitmap
     * @param filePath
     * @param imageame
     * @return
     */
    public static String saveBitmapToSDCard(Bitmap bitmap, String filePath, String imageame) {
        if (bitmap == null || filePath == null || imageame == null) {
            return null;
        }
        FileUtil.makeRootDirectory(filePath);
        String path = filePath + "/" + imageame;
        FileUtil.isFileExistDelete(path);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            if (fos != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.close();
                fos = null;
            }
            return path;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
