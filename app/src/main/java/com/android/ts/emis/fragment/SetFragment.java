package com.android.ts.emis.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StateType;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.SelectQueryListActivity;
import com.android.ts.emis.activity.my.BindPhoneActivity;
import com.android.ts.emis.activity.my.OffLineDownloadActivity;
import com.android.ts.emis.activity.my.ResetPassWordActivity;
import com.android.ts.emis.activity.my.SettingActivity;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.utils.SPUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-工作信息
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class SetFragment extends BaseFragment {
    @BindView(R.id.rly_myGuarantee)
    RelativeLayout rlyMyGuarantee;
    @BindView(R.id.rly_bindPhone)
    RelativeLayout rlyBindPhone;
    @BindView(R.id.rly_restPassword)
    RelativeLayout rlyRestPassword;
    @BindView(R.id.rly_offlineDownload)
    RelativeLayout rlyOfflineDownload;
    @BindView(R.id.rly_setting)
    RelativeLayout rlySetting;
    @BindView(R.id.tv_my_userName)
    TextView tvMyUserName;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_set);
        unBinder = ButterKnife.bind(this, mContentView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
        if (!TextUtils.isEmpty(mUserPasswrd.getUserName())) {
            tvMyUserName.setText(mUserPasswrd.getUserName());
        }
    }

    @OnClick({R.id.rly_myGuarantee, R.id.rly_bindPhone, R.id.rly_restPassword, R.id.rly_offlineDownload,
            R.id.rly_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rly_myGuarantee:
                //startActivity(new Intent(getActivity(), MyWorkListActivity.class));
//                startActivity(new Intent(getActivity(), WorkOrderDetailsActivity.class)
//                        .putExtra(StrRes.INSTANCE.getTicketsCode(), "")
//                        .putExtra(StrRes.INSTANCE.getTitle(), ""));
                startActivity(new Intent(getActivity(), SelectQueryListActivity.class).putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getPeopleInfo()));
                break;
            case R.id.rly_bindPhone:
                startActivity(new Intent(getActivity(), BindPhoneActivity.class));
                break;
            case R.id.rly_restPassword:
                startActivity(new Intent(getActivity(), ResetPassWordActivity.class));
                break;
            case R.id.rly_offlineDownload:
                startActivity(new Intent(getActivity(), OffLineDownloadActivity.class));
                break;
            case R.id.rly_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }
}
