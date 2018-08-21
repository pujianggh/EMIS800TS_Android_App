package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.utils.PopupWindowUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 资产详情
 *
 * @author pujiang
 * @date 2018-6-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PropertyManageDetailsActivity extends BaseActivity {
    @BindView(R.id.layout_titleBar)
    LinearLayout layoutTitleBar;
    @BindView(R.id.lly_infoDetails)
    LinearLayout llyInfoDetails;
    @BindView(R.id.igv_allow)
    ImageView igvAllow;

    private int infoDetailFlag = 0;
    private PopupWindowUtil mPopupWindowUtil = null;
    private String mTitle = "";

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_property_manage_details);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_property_manage_details_title), null, "···", true);

        mTitle = getIntent().getStringExtra(StrRes.INSTANCE.getTitle());
        initData();
    }

    @OnClick({R.id.rly_infoDetailAllow, R.id.igv_allow, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                onBackPressed();
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
        }
    }

    private void initData() {
        setTitleBarLayout(R.drawable.icon_back_white_bar, mTitle, null, "···", true);
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
}
