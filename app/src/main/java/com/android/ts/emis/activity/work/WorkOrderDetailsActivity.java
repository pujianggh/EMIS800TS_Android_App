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
import android.widget.TextView;

import com.android.kotlinapp.action.config.AppConfig;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.SignatureHandActivity;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.ConstantsResults;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.config.ResultCode;
import com.android.ts.emis.mode.TicketDetailInfoBean;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
import com.android.ts.emis.mvp.impl.WrokOrderInfoImpl;
import com.android.ts.emis.utils.PopupWindowUtil;
import com.libcommon.action.net.INetWorkCallBack;
import com.libcommon.action.utils.APPToolsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;

/**
 * 工作-工单详情
 *
 * @author pujiang
 * @date 2018-6-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderDetailsActivity extends BaseActivity {
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

    private PopupWindowUtil mPopupWindowUtil = null;
    private String mTicketsCode = "";
    private int infoDetailFlag = 0;
    private IWorkOrderInfo iWorkOrderInfo;
    private TicketDetailInfoBean mBean;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_orderdetails);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_gd), null, true);

        initData();
        initEvent();
    }

    @OnClick({R.id.rly_infoDetailAllow, R.id.igv_allow, R.id.igv_iphone, R.id.btn_next,
            R.id.btn_inputContent, R.id.btn_Ok, R.id.lly_signHand, R.id.igv_signHand})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:

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

                onBackPressed();
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

    private void initData() {
        mTicketsCode = getIntent().getStringExtra(StrRes.INSTANCE.getTicketsCode());
        mTitleBar.setTitleText(mTicketsCode);

        if (iWorkOrderInfo == null)
            iWorkOrderInfo = new WrokOrderInfoImpl();
        showLoading();
        iWorkOrderInfo.getTicketsWorkOrderInfo(mContext, new INetWorkCallBack() {
            @Override
            public void noNetWork() {
                hideLoading();
            }

            @Override
            public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
                hideLoading();
                TicketDetailInfoBean bean = (TicketDetailInfoBean) t;
                setUIData(bean);
            }

            @Override
            public void onError(int status, String str, Class cla, String constantUrl) {
                hideLoading();
            }
        }, mTicketsCode);
    }

    private void setUIData(TicketDetailInfoBean bean) {
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

        //0:全部 1：待处理工单 2：待派批工单（待派工) 3：待审批工单 4：待存档工单 5：待评价工单
        llyDshState.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);

        tvState.setText(mBean.getData().getTicketsStatusName());
        tvState.setBackgroundResource(ConstantsResults.getTicketsStatusColor(mBean.getData().getTicketsStatus()));

        btnNext.setVisibility(View.VISIBLE);
        btnNext.setText(ConstantsResults.getTicketsStatusText(mBean.getData().getTicketsStatus()));
        //UIViewToolsUtil.initUIPhotosData(this, mBean.getPhotosList(), rlvPhotos, 5);
    }

    private void initEvent() {
        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindowUtil == null)
                    mPopupWindowUtil = new PopupWindowUtil(mContext);
                mPopupWindowUtil.showWorkOrderDetailsWindow(layoutTitleBar, new PopupWindowUtil.OnPopuwindowClick() {
                    @Override
                    public void onPopuwindowClick(int id) {
                        switch (id) {
                            case R.id.igv_add:
                                break;
                            case R.id.igv_ewm:
                                break;
                        }
                    }
                });
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
}
