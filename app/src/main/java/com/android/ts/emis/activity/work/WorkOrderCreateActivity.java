package com.android.ts.emis.activity.work;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StateType;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.QRCodeActivity;
import com.android.ts.emis.adapter.WorkOrderDeviceAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.handle.EditTextListener;
import com.android.ts.emis.mode.AddTicketBean;
import com.android.ts.emis.mode.StateInfoBean;
import com.android.ts.emis.mode.json.AddTicketJson;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
import com.android.ts.emis.mvp.impl.WrokOrderInfoImpl;
import com.android.ts.emis.utils.PopupWindowUtil;
import com.android.ts.emis.utils.SPUtil;
import com.android.ts.emis.view.ExpandListView;
import com.libcommon.action.net.INetWorkCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import okhttp3.Headers;

/**
 * 工作-工单创建
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderCreateActivity extends BaseActivity {
    @BindView(R.id.layout_titleBar)
    LinearLayout layoutTitleBar;
    @BindView(R.id.tv_createrName)
    TextView tvCreaterName;
    @BindView(R.id.edt_phoneNumber)
    EditText edtPhoneNumber;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_workOrderType)
    TextView tvWorkOrderType;
    @BindView(R.id.tv_serverType)
    TextView tvServerType;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.lly_device)
    LinearLayout llyDevice;
    @BindView(R.id.lv_list_data)
    ExpandListView lvListData;
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.tv_contentTip)
    TextView tvContentTip;
    @BindView(R.id.snpl_moment_add_photos)
    BGASortableNinePhotoLayout mPhotosSnpl;//拖拽排序九宫格控件

    private WorkOrderDeviceAdapter mAdapter;
    private List<StateInfoBean.Data> datas;
    private PopupWindowUtil mPopupWindowUtil = null;
    private IWorkOrderInfo iWorkOrderInfo;
    private String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_create);
        ButterKnife.bind(this);

        initData();
        initPhotoPicker();
    }

    @OnClick({R.id.igv_addDevice, R.id.rly_department, R.id.rly_location,
            R.id.rly_workOrderType, R.id.rly_serverType, R.id.rly_priority, R.id.btn_next})
    public void onClick(View view) {
        Intent intent = new Intent(this, StateQueryListActivity.class);
        switch (view.getId()) {
            case R.id.btn_next://工单提交
                commitOrderInfo();
                break;
            case R.id.rly_department:
                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getDepartmentInfo());
                startActivityForResult(intent, RequestCode.INSTANCE.getResult_StateDepartment());
                break;
            case R.id.rly_location://位置
                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getLocation());
                startActivityForResult(intent, RequestCode.INSTANCE.getResult_StateLocation());
                break;
            case R.id.rly_workOrderType://工单类型
                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getWorkOrderType());
                startActivityForResult(intent, RequestCode.INSTANCE.getResult_StateWorkOrderType());
                break;
            case R.id.rly_serverType://服务类型
                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getServerType());
                startActivityForResult(intent, RequestCode.INSTANCE.getResult_StateServerType());
                break;
            case R.id.rly_priority:
                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getPriority());
                startActivityForResult(intent, RequestCode.INSTANCE.getResult_StatePriority());
                break;
            case R.id.igv_addDevice://添加维修设备
                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getDevice());
                startActivityForResult(intent, RequestCode.INSTANCE.getResult_Device());
                break;
        }
    }

    @Override
    public void permissionSuccess(int requestCode) {
        if (RequestCode.INSTANCE.getResult_TakePhotoChoice() == requestCode) {
            choicePhotoWrapper();
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        if (RequestCode.INSTANCE.getResult_TakePhotoChoice() == requestCode) {
            showToast(getResources().getString(R.string.text_permission_fail_xj));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestCode.INSTANCE.getResult_StateDepartment() && resultCode == RESULT_OK && data != null) {
            String querySource = data.getStringExtra(StrRes.INSTANCE.getSource());
            if (!TextUtils.isEmpty(querySource))
                tvDepartment.setText(querySource);
        } else if (requestCode == RequestCode.INSTANCE.getResult_StateLocation() && resultCode == RESULT_OK && data != null) {
            String querySource = data.getStringExtra(StrRes.INSTANCE.getSource());
            if (!TextUtils.isEmpty(querySource))
                tvLocation.setText(querySource);
        } else if (requestCode == RequestCode.INSTANCE.getResult_StateWorkOrderType() && resultCode == RESULT_OK && data != null) {
            String querySource = data.getStringExtra(StrRes.INSTANCE.getSource());
            if (!TextUtils.isEmpty(querySource))
                tvWorkOrderType.setText(querySource);
        } else if (requestCode == RequestCode.INSTANCE.getResult_StateServerType() && resultCode == RESULT_OK && data != null) {
            String querySource = data.getStringExtra(StrRes.INSTANCE.getSource());
            if (!TextUtils.isEmpty(querySource))
                tvServerType.setText(querySource);
        } else if (requestCode == RequestCode.INSTANCE.getResult_StatePriority() && resultCode == RESULT_OK && data != null) {
            String querySource = data.getStringExtra(StrRes.INSTANCE.getSource());
            if (!TextUtils.isEmpty(querySource))
                tvPriority.setText(querySource);
        } else if (requestCode == RequestCode.INSTANCE.getResult_Device() && resultCode == RESULT_OK && data != null) {
            StateInfoBean.Data moduleBean = (StateInfoBean.Data) data.getSerializableExtra(StrRes.INSTANCE.getMode());
            if (moduleBean != null) {
                datas.add(moduleBean);
                //mAdapter.addLastItem(moduleBean);
                refreshDeviceInfo(datas);
            }
        } else if (requestCode == RequestCode.INSTANCE.getResult_PhotoChoice() && resultCode == RESULT_OK && data != null) {
            mPhotosSnpl.addMoreData(BGAPhotoPickerActivity.getSelectedPhotos(data));
        } else if (requestCode == RequestCode.INSTANCE.getResult_PhotoPreview() && resultCode == RESULT_OK && data != null) {
            mPhotosSnpl.setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
        } else if (requestCode == RequestCode.INSTANCE.getResult_QRCode() && resultCode == RESULT_OK && data != null) {
            String result = data.getStringExtra(StrRes.INSTANCE.getResult());
            if (!TextUtils.isEmpty(result)) {
                edtPhoneNumber.setText("03-5379-8105");
                tvLocation.setText("東京都新宿区新宿1-8-5");

                StateInfoBean.Data moduleBean = new StateInfoBean.Data();
                moduleBean.setName("ATM机");
                moduleBean.setCode("ACS-01F-N01-060");
                moduleBean.setAddress("東京都新宿区新宿1-8-1");
                datas.add(moduleBean);
                refreshDeviceInfo(datas);
            }
        }
    }

    private void initData() {
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
        if (!TextUtils.isEmpty(mUserPasswrd.getUserName())) {
            tvCreaterName.setText(mUserPasswrd.getUserName());
        }
        EditTextListener.setEditTextUpdateTipListener(edtContent, tvContentTip, 1000);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_work_order_create_title), null, "···", true);
        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindowUtil == null)
                    mPopupWindowUtil = new PopupWindowUtil(mContext);
                mPopupWindowUtil.showWorkOrderCreateWindow(layoutTitleBar, new PopupWindowUtil.OnPopuwindowClick() {
                    @Override
                    public void onPopuwindowClick(int id) {
                        switch (id) {
                            case R.id.igv_add:
                                Intent intent = new Intent(mContext, StateQueryListActivity.class);
                                intent.putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getDevice());
                                startActivityForResult(intent, RequestCode.INSTANCE.getResult_Device());
                                break;
                            case R.id.igv_ewm:
                                startActivityForResult(new Intent(mContext, QRCodeActivity.class), RequestCode.INSTANCE.getResult_QRCode());
                                break;
                        }
                    }
                });
            }
        });

        mAdapter = new WorkOrderDeviceAdapter(this);
        lvListData.setAdapter(mAdapter);
        datas = new ArrayList<>();
        mAdapter.setData(datas);
    }

    /**
     * 提交工单
     */
    private void commitOrderInfo() {
        showLoading();
        AddTicketJson addTicketJson = new AddTicketJson();
        addTicketJson.setOrderType("CM");
        addTicketJson.setHouseCode(mUserPasswrd.getHouseCode());
        addTicketJson.setHousePhaseCode("");
        addTicketJson.setEstateCode(mUserPasswrd.getEstateCode());
        addTicketJson.setTicketsFrom("APP");
        addTicketJson.setRepairBy(mUserPasswrd.getUserName());
        addTicketJson.setRepairBy(edtPhoneNumber.getText().toString());
        addTicketJson.setDepartment(tvDepartment.getText().toString());
        addTicketJson.setDepartment("IT");
        addTicketJson.setTaskTypeCode("");//工单类型编号
        addTicketJson.setTaskTypeName("");
        addTicketJson.setPriorityCode("");
        addTicketJson.setTicketsTitle("");
        addTicketJson.setTicketsDescription(edtContent.getText().toString());
        addTicketJson.setUserCode(mUserPasswrd.getUserCode());


        addTicketJson.setOrderType("CM");
        addTicketJson.setHouseCode(mUserPasswrd.getHouseCode());
        addTicketJson.setHousePhaseCode("9d642d20-7520-4027-8048-61299a040ebc");
        addTicketJson.setEstateCode("557cc8f-e614-4672-bc0a-906196aa1ea2");
        addTicketJson.setTicketsFrom("APP");
        addTicketJson.setRepairBy(mUserPasswrd.getUserName());
        addTicketJson.setDepartment("IT");
        addTicketJson.setTicketsTypeCode("20180424150207146360");
        addTicketJson.setTicketsTypeName("自检->cathy测试->子节点");
        addTicketJson.setTaskTypeCode("20180424150236431577");//工单类型编号
        addTicketJson.setTaskTypeName("子-1->子-2");
        addTicketJson.setPriorityCode("20150414170730110785");
        addTicketJson.setTicketsTitle("");
        addTicketJson.setTicketsDescription(edtContent.getText().toString());
        addTicketJson.setUserCode(mUserPasswrd.getUserCode());
        if (iWorkOrderInfo == null)
            iWorkOrderInfo = new WrokOrderInfoImpl();
        iWorkOrderInfo.getAddTickets(mAPPApplication, new INetWorkCallBack() {
            @Override
            public void noNetWork() {
                hideLoading();
            }

            @Override
            public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
                hideLoading();
                AddTicketBean bean = (AddTicketBean) t;
                if (bean != null) {
                    showToast(bean.getMessage());
                    if ("success".equals(bean.getStatus())) onBackPressed();
                }
            }

            @Override
            public void onError(int status, String str, Class cla, String constantUrl) {
                hideLoading();
            }
        }, addTicketJson);
    }

    private void initPhotoPicker() {
        //mPhotosSnpl.setData(null);//是否可编辑
        //mPhotosSnpl.setMaxItemCount(1);//是否可编辑
        mPhotosSnpl.setMaxItemCount(9);//是否可编辑
        mPhotosSnpl.setEditable(true);//是否可编辑
//        mPhotosSnpl.setPlusEnable(true);//
//        mPhotosSnpl.setSortable(true);//
        // 设置拖拽排序控件的代理
        mPhotosSnpl.setDelegate(new BGASortableNinePhotoLayout.Delegate() {
            @Override
            public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissionInfo(RequestCode.INSTANCE.getResult_TakePhotoChoice(), perms);
                    return;
                }
                choicePhotoWrapper();
            }

            @Override
            public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                mPhotosSnpl.removeItem(position);
            }

            @Override
            public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(mContext)
                        .previewPhotos(models) // 当前预览的图片路径集合
                        .selectedPhotos(models) // 当前已选中的图片路径集合
                        .maxChooseCount(mPhotosSnpl.getMaxItemCount()) // 图片选择张数的最大值
                        .currentPosition(position) // 当前预览图片的索引
                        .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                        .build();
                startActivityForResult(photoPickerPreviewIntent, RequestCode.INSTANCE.getResult_PhotoPreview());
            }

            @Override
            public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
                //排序发生变化
            }
        });
    }

    private void choicePhotoWrapper() {
        if (checkPermissions(perms)) {
            // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
            File takePhotoDir = new File(com.libcommon.action.config.AppConfig.FILE_PHOTO_PATH);

            Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(this)
                    .cameraFileDir(takePhotoDir) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                    .maxChooseCount(mPhotosSnpl.getMaxItemCount() - mPhotosSnpl.getItemCount()) // 图片选择张数的最大值
                    .selectedPhotos(null) // 当前已选中的图片路径集合
                    .pauseOnScroll(false) // 滚动列表时是否暂停加载图片
                    .build();
            startActivityForResult(photoPickerIntent, RequestCode.INSTANCE.getResult_PhotoChoice());
        } else {//重新提示开启权限
            requestPermissionInfo(RequestCode.INSTANCE.getResult_TakePhotoChoice(), perms);
        }
    }

    /**
     * 属性提交设备数据
     *
     * @param datas
     */
    public void refreshDeviceInfo(List<StateInfoBean.Data> datas) {
        this.datas = datas;
        if (this.datas == null) return;
        if (this.datas.size() == 0) {
            llyDevice.setVisibility(View.GONE);
        } else {
            llyDevice.setVisibility(View.VISIBLE);
        }
    }
}
