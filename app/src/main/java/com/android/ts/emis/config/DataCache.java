package com.android.ts.emis.config;

import android.text.TextUtils;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.mode.CacheDepartment;
import com.android.ts.emis.mode.CacheEquipmentType;
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


    /**
     * 服务类型数据
     *
     * @param houseCode
     * @return
     */
    public static List<StateInfoBean.Data> getServerTypeCache(String houseCode) {
        String json = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getTicketTypeJson());
        if (TextUtils.isEmpty(json)) return null;
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
            return getServerTypeChildrenInfo(ticketsTypeBeans);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    /**
     * 服务类型数据,子数据
     *
     * @param ticketsTypeBeans
     * @return
     */
    private static List<StateInfoBean.Data> getServerTypeChildrenInfo(List<CacheServerType.DataBean.TicketsTypeBean> ticketsTypeBeans) {
        List<StateInfoBean.Data> list = new ArrayList<>();

        if (ticketsTypeBeans == null) return null;

        int size = ticketsTypeBeans.size();
        StateInfoBean.Data data;
        for (int i = 0; i < size; i++) {
            data = new StateInfoBean.Data();
            data.setName(ticketsTypeBeans.get(i).getTicketsTypeName());
            data.setCode(ticketsTypeBeans.get(i).getTicketsTypeCode());
            if (ticketsTypeBeans.get(i).getChildren() != null) {
                data.setData(getServerTypeChildrenInfo(ticketsTypeBeans.get(i).getChildren()));
            }
            list.add(data);
        }
        return list;
    }


    /**
     * 模拟部门数据
     */
    public static List<StateInfoBean.Data> getDepartmentCache() {
        String json = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getEquipmentJson());
        if (TextUtils.isEmpty(json)) return null;
        List<StateInfoBean.Data> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            CacheDepartment bean = gson.fromJson(json, CacheDepartment.class);
            if (bean != null && bean.getData() != null) {
                int size = bean.getData().size();
                StateInfoBean.Data data;
                for (int i = 0; i < size; i++) {
                    data = new StateInfoBean.Data();
                    data.setName(bean.getData().get(i).getDictionaryName());
                    data.setCode(bean.getData().get(i).getDictionaryCode());
                    list.add(data);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }


    /**
     * 位置信息数据
     *
     * @param houseCode
     * @return
     */
    public static List<StateInfoBean.Data> getLocationCache(String houseCode) {
        String json = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getLoginJson());
        if (TextUtils.isEmpty(json)) return null;
        try {
            Gson gson = new Gson();
            CacheLocation bean = gson.fromJson(json, CacheLocation.class);
            List<CacheLocation.DataBean.EstateBean> estateBeans = null;

            if (bean != null && bean.getData() != null && "success".equals(bean.getStatus())) {
                int size = bean.getData().size();
                for (int i = 0; i < size; i++) {
                    if (houseCode.equals(bean.getData().get(i).getHouseCode())) {
                        estateBeans = bean.getData().get(i).getEstate();
                    }
                }
            }
            return getLocationChildrenInfo(estateBeans);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    /**
     * 位置信息数据,子数据
     *
     * @param estateBeans
     * @return
     */
    private static List<StateInfoBean.Data> getLocationChildrenInfo(List<CacheLocation.DataBean.EstateBean> estateBeans) {
        List<StateInfoBean.Data> list = new ArrayList<>();

        if (estateBeans == null) return null;

        int size = estateBeans.size();
        StateInfoBean.Data data;
        for (int i = 0; i < size; i++) {
            data = new StateInfoBean.Data();
            data.setName(estateBeans.get(i).getName());
            data.setCode(estateBeans.get(i).getEstateCode());
            if (estateBeans.get(i).getChildren() != null) {
                data.setData(getLocationChildrenInfo(estateBeans.get(i).getChildren()));
            }
            list.add(data);
        }
        return list;
    }


    /**
     * 工单类型信息
     *
     * @param houseCode
     * @return
     */
    public static List<StateInfoBean.Data> getEquipmentTypeCache(String houseCode) {
        String json = SPUtil.INSTANCE.getString(StrRes.INSTANCE.getEquipmentTypeJson());
        if (TextUtils.isEmpty(json)) return null;
        try {
            Gson gson = new Gson();
            CacheEquipmentType bean = gson.fromJson(json, CacheEquipmentType.class);
            List<CacheEquipmentType.DataBean.EquipmentTypeBean> equipmentTypeBeans = null;

            if (bean != null && bean.getData() != null && "success".equals(bean.getStatus())) {
                int size = bean.getData().size();
                for (int i = 0; i < size; i++) {
                    if (houseCode.equals(bean.getData().get(i).getHouseCode())) {
                        equipmentTypeBeans = bean.getData().get(i).getEquipmentType();
                    }
                }
            }
            return getEquipmentTypeChildrenInfo(equipmentTypeBeans);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    /**
     * 工单类型信息数据,子数据
     *
     * @param equipmentTypeBeans
     * @return
     */
    private static List<StateInfoBean.Data> getEquipmentTypeChildrenInfo(List<CacheEquipmentType.DataBean.EquipmentTypeBean> equipmentTypeBeans) {
        List<StateInfoBean.Data> list = new ArrayList<>();

        if (equipmentTypeBeans == null) return null;

        int size = equipmentTypeBeans.size();
        StateInfoBean.Data data;
        for (int i = 0; i < size; i++) {
            data = new StateInfoBean.Data();
            data.setName(equipmentTypeBeans.get(i).getEquipmentTypeName());
            data.setCode(equipmentTypeBeans.get(i).getEquipmentTypeCode());
            if (equipmentTypeBeans.get(i).getChildren() != null) {
                data.setData(getEquipmentTypeChildrenInfo(equipmentTypeBeans.get(i).getChildren()));
            }
            list.add(data);
        }
        return list;
    }

}
