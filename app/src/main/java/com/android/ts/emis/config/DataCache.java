package com.android.ts.emis.config;

import android.text.TextUtils;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.mode.HouseListBean;
import com.android.ts.emis.mode.UserInfoBean;
import com.android.ts.emis.utils.SPUtil;
import com.google.gson.Gson;

import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/21 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public class DataCache {

    /**
     * 获取项目信息
     *
     * @return
     */
    public static List<HouseListBean> getHouseListBeans() {
        String loginJson = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getLoginJson());
        if (TextUtils.isEmpty(loginJson)) return null;
        try {
            Gson gson = new Gson();
            UserInfoBean bean = gson.fromJson(loginJson, UserInfoBean.class);
            if (bean != null && bean.getData() != null && bean.getData().getHouseList() != null)
                return bean.getData().getHouseList();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
