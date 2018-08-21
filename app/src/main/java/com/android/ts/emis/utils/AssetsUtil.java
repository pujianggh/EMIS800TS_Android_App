package com.android.ts.emis.utils;

import android.text.TextUtils;

import com.android.ts.emis.app.APPApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 键盘工具
 *
 * @author pujiang
 * @date 2018-1-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
public class AssetsUtil {

    /**
     * 根据文件名字 获取数据
     *
     * @param fileName
     * @return
     */
    public static String getString(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        try {
            InputStreamReader in = new InputStreamReader(APPApplication.getInstance().getAssets().open(fileName));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}