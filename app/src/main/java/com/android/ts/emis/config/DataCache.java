package com.android.ts.emis.config;

import android.text.TextUtils;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.mode.CacheLocation;
import com.android.ts.emis.mode.CacheServerType;
import com.android.ts.emis.mode.HouseListBean;
import com.android.ts.emis.mode.StateInfoBean;
import com.android.ts.emis.mode.UserInfoBean;
import com.android.ts.emis.utils.SPUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
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

    public static List<StateInfoBean.Data> getServerTypeCache(String houseCode) {
        String json = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getTicketTypeJson());
        if (TextUtils.isEmpty(json)) return null;
        List<StateInfoBean.Data> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            CacheServerType bean = gson.fromJson(json, CacheServerType.class);
            List<CacheServerType.DataBean.TicketsTypeBean> ticketsTypeBeans = null;

            if (bean != null && bean.getData() != null && "success".equals(bean.getStatus())) {
                int size = bean.getData().size();
                for (int i = 0; i < size; i++) {
                    if (houseCode.equals(bean.getData().get(i).getHouseCode())) {
                        ticketsTypeBeans = bean.getData().get(i).getTicketsType();
                    }
                }
            }

            if (ticketsTypeBeans == null) return null;

            int size = ticketsTypeBeans.size();
            StateInfoBean.Data data;
            for (int i = 0; i < size; i++) {
                data = new StateInfoBean.Data();
                data.setName(ticketsTypeBeans.get(i).getTicketsTypeName());
                data.setCode(ticketsTypeBeans.get(i).getTicketsTypeCode());

                if (ticketsTypeBeans.get(i).getChildren() != null) {
                    int size2 = ticketsTypeBeans.get(i).getChildren().size();
                    List<StateInfoBean.Data> data2s = new ArrayList<>();
                    StateInfoBean.Data data2;
                    for (int j = 0; j < size2; j++) {
                        data2 = new StateInfoBean.Data();
                        data2.setName(ticketsTypeBeans.get(i).getChildren().get(j).getTicketsTypeName());
                        data2.setCode(ticketsTypeBeans.get(i).getChildren().get(j).getTicketsTypeCode());
                        data2s.add(data2);
                        data.setData(data2s);
                    }
                }
                list.add(data);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 模拟部门数据
     */
    public static List<StateInfoBean.Data> getDepartmentCache() {
        String json = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getEstateJson());
        if (TextUtils.isEmpty(json)) return null;
        List<StateInfoBean.Data> list;
        try {
            Gson gson = new Gson();
            CacheLocation bean = gson.fromJson(json, CacheLocation.class);
//            if (bean != null && bean.getData() != null && bean.getData().getHouseList() != null)
//                return bean.getData().getHouseList();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
