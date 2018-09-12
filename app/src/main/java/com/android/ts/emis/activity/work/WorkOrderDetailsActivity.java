package com.android.ts.emis.activity.work;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.kotlinapp.action.config.AppConfig;
import com.android.kotlinapp.action.config.StateType;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.SelectQueryListActivity;
import com.android.ts.emis.activity.common.SignatureHandActivity;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.ConstantsResults;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.config.ResultCode;
import com.android.ts.emis.mode.TicketDetailInfoBean;
import com.android.ts.emis.mode.json.UpdateTicketJson;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
import com.android.ts.emis.mvp.impl.WrokOrderInfoImpl;
import com.android.ts.emis.mvp.presenter.WorkOrderDetailsPresenter;
import com.android.ts.emis.mvp.view.IWorkOrderDetailsView;
import com.android.ts.emis.utils.PopupWindowUtil;
import com.libcommon.action.utils.APPToolsUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作-工单详情
 *
 * @author pujiang
 * @date 2018-6-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderDetailsActivity extends BaseActivity implements IWorkOrderDetailsView {
    @BindView(R.id.layout_titleBar)
    LinearLayout layoutTitleBar;
    @BindView(R.id.lly_infoDetails)
    LinearLayout llyInfoDetails;
    @BindView(R.id.igv_allow)
    ImageView igvAllow;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_createrMessage)
    TextView tvCreaterMessage;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_yyTime)
    TextView tvYyTime;
    @BindView(R.id.tv_kgTime)
    TextView tvKgTime;
    @BindView(R.id.tv_jbTime)
    TextView tvJbTime;
    @BindView(R.id.tv_wcTime)
    TextView tvWcTime;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.tv_serverType)
    TextView tvServerType;
    @BindView(R.id.tv_gjTime)
    TextView tvGjTime;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.lly_dshState)
    LinearLayout llyDshState;
    @BindView(R.id.lly_signHand)
    LinearLayout llySignHand;
    @BindView(R.id.igv_signHand)
    ImageView mIgvSignHand;
    @BindView(R.id.rlv_photos)
    RecyclerView rlvPhotos;
    @BindView(R.id.lly_bottom)
    LinearLayout llyBottom;
    @BindView(R.id.lly_history)
    LinearLayout llyHistory;
    @BindView(R.id.rly_root)
    RelativeLayout rlyRoot;

    private PopupWindowUtil mPopupWindowUtil = null;
    private String mTicketsCode = "";
    private int infoDetailFlag = 0;
    private IWorkOrderInfo iWorkOrderInfo;
    private TicketDetailInfoBean mBean;
    private WorkOrderDetailsPresenter mPresenter;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_orderdetails);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_gd), "", "···", true);
        mPresenter = new WorkOrderDetailsPresenter(this, this);

        initData();
        initEvent();
    }

    @OnClick({R.id.rly_infoDetailAllow, R.id.igv_allow, R.id.igv_iphone, R.id.btn_next,
            R.id.btn_inputContent, R.id.btn_Ok, R.id.lly_signHand, R.id.igv_signHand})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                if (mBean == null || mBean.getData() == null) return;
                if (mBean.getData().getTicketsStatus() == 1) {//接单

                    if (iWorkOrderInfo == null)
                        iWorkOrderInfo = new WrokOrderInfoImpl();
                    showLoading();
                    UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                    updateTicketJson.setActionType(4);
                    updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                    updateTicketJson.setTicketsStatus(3);
                    updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                    List<UpdateTicketJson.ExecutorListBean> listBeans = new ArrayList<>();
                    UpdateTicketJson.ExecutorListBean bean = new UpdateTicketJson.ExecutorListBean();
                    bean.setExecutorCode("ET_PROPERTY_20170619154204");
                    bean.setID(28);
                    listBeans.add(bean);
                    updateTicketJson.setExecutorList(listBeans);
                    mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);

                } else if (mBean.getData().getTicketsStatus() == 6) {//验证

                    if (mBean == null || mBean.getData() == null) return;
                    if (iWorkOrderInfo == null)
                        iWorkOrderInfo = new WrokOrderInfoImpl();
                    showLoading();
                    UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                    updateTicketJson.setActionType(22);
                    updateTicketJson.setIsPass("1");
                    updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                    updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                    updateTicketJson.setDescription("测试性通过处理");

                    mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);

                } else if (mBean.getData().getTicketsStatus() == 7) {//评价工单
                    startActivity(new Intent(getApplicationContext(), WorkOrderEvaluateActivity.class)
                            .putExtra(StrRes.INSTANCE.getTicketsCode(), mBean.getData().getTicketsCode()));
                } else if (mBean.getData().getTicketsStatus() == 0) {
                    startActivity(new Intent(getApplicationContext(), SelectQueryListActivity.class)
                            .putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getPeopleInfo())
                            .putExtra(StrRes.INSTANCE.getTicketsCode(), mBean.getData().getTicketsCode()));
                }
                break;
            case R.id.rly_infoDetailAllow:
            case R.id.igv_allow:
                if (infoDetailFlag % 2 == 0) {
                    llyInfoDetails.setVisibility(View.VISIBLE);
                    igvAllow.setImageResource(R.drawable.icon_workorder_detail_allow2);
                } else {
                    llyInfoDetails.setVisibility(View.GONE);
                    igvAllow.setImageResource(R.drawable.icon_workorder_detail_allow);
                }
                infoDetailFlag++;
                break;
            case R.id.igv_iphone:
                if (mBean != null && !TextUtils.isEmpty(mBean.getData().getRepairMobile()))
                    APPToolsUtil.diallPhone(this, mBean.getData().getRepairMobile());
                break;
            case R.id.btn_inputContent:
                startActivityForResult(new Intent(this, WorkContentInputActivity.class),
                        RequestCode.INSTANCE.getResult_WorkContentInput());
                break;
            case R.id.btn_Ok:

                if (mBean == null || mBean.getData() == null) return;
                if (iWorkOrderInfo == null)
                    iWorkOrderInfo = new WrokOrderInfoImpl();
                showLoading();
                UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                updateTicketJson.setActionType(13);
                updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);

                break;
            case R.id.igv_signHand:
            case R.id.lly_signHand:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissionInfo(RequestCode.INSTANCE.getResult_SignatureHand_Permission(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
                } else {
                    startActivityForResult(new Intent(this, SignatureHandActivity.class), RequestCode.INSTANCE.getResult_SignatureHand());
                }
                break;
        }
    }

    @Override
    public void successBackPressed() {
        onBackPressed();
    }

    private void initData() {
        mTicketsCode = getIntent().getStringExtra(StrRes.INSTANCE.getTicketsCode());
        mTitleBar.setTitleText(mTicketsCode);

        if (iWorkOrderInfo == null)
            iWorkOrderInfo = new WrokOrderInfoImpl();
        showLoading();
        mPresenter.getWorkOrderDetailsInfo(mTicketsCode);
    }

    @Override
    public void setUIData(TicketDetailInfoBean bean) {
        if (bean == null) return;
        if (bean.getData() == null) return;
        mBean = bean;
        tvCompany.setText("");
        tvCreaterMessage.setText("");
        tvLocation.setText("");
        tvYyTime.setText(mBean.getData().getForecastBeginTime());
        tvMessage.setText("");

        tvDepartment.setText(mBean.getData().getDepartment());
        tvServerType.setText("");
        tvGjTime.setText(mBean.getData().getForecastEndTime());

        tvState.setText(mBean.getData().getTicketsStatusName());
        tvState.setBackgroundResource(ConstantsResults.getTicketsStatusColor(mBean.getData().getTicketsStatus()));

        btnNext.setText(ConstantsResults.getTicketsStatusText(mBean.getData().getTicketsStatus()));
        //UIViewToolsUtil.initUIPhotosData(this, mBean.getPhotosList(), rlvPhotos, 5);

        //0:全部 1：待处理工单 2：待派批工单（待派工) 3：待审批工单 4：待存档工单 5：待评价工单
        llyBottom.setVisibility(View.GONE);
        llyDshState.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        if (mBean.getData().getTicketsStatus() == 1) {//已创建-接单
            llyBottom.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);

        } else if (mBean.getData().getTicketsStatus() == 3) {//处理中-填写工作内容，完工
            llyBottom.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.GONE);
            llyDshState.setVisibility(View.VISIBLE);

        } else if (mBean.getData().getTicketsStatus() == 6) {//已存档-验证
            llyBottom.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setText(getResources().getString(R.string.text_state_yz));
            llyDshState.setVisibility(View.GONE);

        } else if (mBean.getData().getTicketsStatus() == 7) {//已存档-验证
            llyBottom.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setText(getResources().getString(R.string.text_state_pj));

        }
    }

    private void initEvent() {

        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBean == null || mBean.getData() == null) return;
                if (mPopupWindowUtil == null)
                    mPopupWindowUtil = new PopupWindowUtil(mContext);
                if (mBean.getData().getTicketsStatus() == 1) {//已创建-接单
                    mPopupWindowUtil.showWorkOrderAcceptWindow(layoutTitleBar, new PopupWindowUtil.OnPopuwindowClick() {
                        @Override
                        public void onPopuwindowClick(int id) {
                            switch (id) {
                                case R.id.lly_table1:
                                    break;
                                case R.id.lly_table2:
                                    break;
                                case R.id.lly_table3:
                                    break;
                                case R.id.lly_table4:
                                    break;
                            }
                        }
                    });
                } else if (mBean.getData().getTicketsStatus() == 3) {//处理中
                    mPopupWindowUtil.showWorkOrderCLZWindow(layoutTitleBar, new PopupWindowUtil.OnPopuwindowClick() {
                        @Override
                        public void onPopuwindowClick(int id) {
                            switch (id) {
                                case R.id.lly_table1:
                                    break;
                                case R.id.lly_table2:
                                    toZTInfo();
                                    break;
                                case R.id.lly_table3:
                                    toZFGDInfo();
                                    break;
                                case R.id.lly_table4:
                                    toTDInfo();
                                    break;
                                case R.id.lly_table5:
                                    break;
                            }
                        }
                    });
                }

            }
        });

    }

    @Override
    public void permissionSuccess(int requestCode) {
        if (RequestCode.INSTANCE.getResult_SignatureHand_Permission() == requestCode) {
            startActivityForResult(new Intent(this, SignatureHandActivity.class), RequestCode.INSTANCE.getResult_SignatureHand());
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        if (RequestCode.INSTANCE.getResult_SignatureHand_Permission() == requestCode) {
            showToast(getResources().getString(R.string.text_permission_fail_cc));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestCode.INSTANCE.getResult_SignatureHand() && resultCode == ResultCode.INSTANCE.getResult_SignatureHand()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeFile(AppConfig.INSTANCE.getFILE_CACHE_PATH(), options);
            if (bitmap != null) {
                mIgvSignHand.setVisibility(View.VISIBLE);
                mIgvSignHand.setImageBitmap(bitmap);
            }
        } else if (requestCode == RequestCode.INSTANCE.getResult_WorkOrderEvaluate() && resultCode == RESULT_OK && data != null) {
            String mSource = data.getStringExtra(StrRes.INSTANCE.getSource());
            onBackPressed();
        } else if (requestCode == RequestCode.INSTANCE.getResult_PeopeSelect() && resultCode == RESULT_OK && data != null) {
            String mSource = data.getStringExtra(StrRes.INSTANCE.getSource());
            onBackPressed();
        } else if (requestCode == RequestCode.INSTANCE.getResult_WorkContentInput() && resultCode == RESULT_OK && data != null) {
            String mSource = data.getStringExtra(StrRes.INSTANCE.getSource());
            onBackPressed();
        }
    }

    /**
     * 暂停
     */
    private void toZTInfo() {
        if (mPopupWindowUtil == null)
            mPopupWindowUtil = new PopupWindowUtil(mContext);
        mPopupWindowUtil.showTDGDWorkOrderWindow(rlyRoot, "暂停工单", "暂停原因", "不继续工作", "继续工作", 2,
                new PopupWindowUtil.OnPopuwindowClickInput() {
                    @Override
                    public void onPopuwindowClick(int id, String message) {
                        if (id == R.id.btn_next) {//暂停-继续工作
                            showLoading();
                            UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                            updateTicketJson.setActionType(6);
                            updateTicketJson.setTicketsStatus(4);
                            updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                            updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                            if (!TextUtils.isEmpty(message))
                                updateTicketJson.setDescription(message);
                            mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);
                        } else if (id == R.id.btn_next0) {//暂停-不继续工作
                            showLoading();
                            UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                            updateTicketJson.setActionType(8);
                            updateTicketJson.setTicketsStatus(5);
                            updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                            updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                            if (!TextUtils.isEmpty(message))
                                updateTicketJson.setDescription(message);
                            mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);
                        }
                    }
                });
    }

    /**
     * 作废工单
     */
    private void toZFGDInfo() {
        if (mPopupWindowUtil == null)
            mPopupWindowUtil = new PopupWindowUtil(mContext);
        mPopupWindowUtil.showTDGDWorkOrderWindow(rlyRoot, "作废工单", "作废原因", "", "作废", 1,
                new PopupWindowUtil.OnPopuwindowClickInput() {
                    @Override
                    public void onPopuwindowClick(int id, String message) {
                        if (id == R.id.btn_next) {
                            showLoading();
                            UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                            updateTicketJson.setActionType(20);
                            updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                            updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                            if (!TextUtils.isEmpty(message))
                                updateTicketJson.setDescription(message);
                            mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);
                        }
                    }
                });
    }

    /**
     * 退单
     */
    private void toTDInfo() {
        if (mPopupWindowUtil == null)
            mPopupWindowUtil = new PopupWindowUtil(mContext);
        mPopupWindowUtil.showTDGDWorkOrderWindow(rlyRoot, "退单工单", "退单原因", "", "退单", 1,
                new PopupWindowUtil.OnPopuwindowClickInput() {
                    @Override
                    public void onPopuwindowClick(int id, String message) {
                        if (id == R.id.btn_next) {
                            showLoading();
                            UpdateTicketJson updateTicketJson = new UpdateTicketJson();
                            updateTicketJson.setActionType(5);
                            updateTicketJson.setTicketsCode(mBean.getData().getTicketsCode());
                            updateTicketJson.setTicketsStatus(3);
                            updateTicketJson.setUserCode(mUserPasswrd.getUserCode());
                            List<UpdateTicketJson.ExecutorListBean> listBeans = new ArrayList<>();
                            UpdateTicketJson.ExecutorListBean bean = new UpdateTicketJson.ExecutorListBean();
                            bean.setExecutorCode("ET_PROPERTY_20170619154204");
                            bean.setID(28);
                            if (!TextUtils.isEmpty(message))
                                bean.setRemark(message);
                            listBeans.add(bean);
                            updateTicketJson.setExecutorList(listBeans);
                            mPresenter.getUpdateWorkOrderDetailsInfo(updateTicketJson);
                        }
                    }
                });
    }
}
