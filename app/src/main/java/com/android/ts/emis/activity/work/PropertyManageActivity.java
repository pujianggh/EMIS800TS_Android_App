package com.android.ts.emis.activity.work;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.QRCodeActivity;
import com.android.ts.emis.adapter.PropertyManageAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.mode.PropertyManageBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工作-资产管理
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PropertyManageActivity extends BaseActivity {
    @BindView(R.id.tv_propertyTip)
    TextView tvPropertyTip;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private PropertyManageAdapter mAdapter;
    private PropertyManageBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_property_manage);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_property_manage_title), null, true);

        initData();
    }

    private void initData() {
        mTitleBar.getRightCtv().setVisibility(View.VISIBLE);
        Drawable drawable = getResources().getDrawable(R.drawable.icon_title_ewm);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mTitleBar.getRightCtv().setCompoundDrawables(null, null, drawable, null);
        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(mContext, QRCodeActivity.class), RequestCode.INSTANCE.getResult_QRCode());
            }
        });

        mAdapter = new PropertyManageAdapter(this);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getPropertyManageModuleData();
        mAdapter.setData(moduleBean.getData());
    }
}
