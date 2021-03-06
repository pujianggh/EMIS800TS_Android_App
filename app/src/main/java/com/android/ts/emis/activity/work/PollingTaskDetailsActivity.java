package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.ContentPagerAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.fragment.PollTaskDetailsFragment;
import com.android.ts.emis.mode.PollingInfoListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作-巡检任务-项目详情
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollingTaskDetailsActivity extends BaseActivity {
    @BindView(R.id.btn_tabLeft)
    Button btnTabLeft;
    @BindView(R.id.btn_tabCenter)
    Button btnTabCenter;
    @BindView(R.id.btn_tabRight)
    Button btnTabRight;
    @BindView(R.id.vp_view)
    ViewPager vpView;

    private PollingInfoListBean.Data bean;
    private ContentPagerAdapter mContentPagerAdapter;
    private Fragment[] fragments;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_polling_taskdetails);
        ButterKnife.bind(this);

        bean = (PollingInfoListBean.Data) getIntent().getSerializableExtra(StrRes.INSTANCE.getMode());
        if (bean != null)
            setTitleBarLayout(R.drawable.icon_back_white_bar, bean.getPollName(), null, getResources().getString(R.string.text_button_tb), true);

        initData();
    }

    @OnClick({R.id.btn_tabLeft, R.id.btn_tabCenter, R.id.btn_tabRight, R.id.igv_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tabLeft:
                vpView.setCurrentItem(0);
                break;
            case R.id.btn_tabCenter:
                vpView.setCurrentItem(1);
                break;
            case R.id.btn_tabRight:
                vpView.setCurrentItem(2);
                break;
            case R.id.igv_query:

                break;
        }
    }

    private void initData() {
        btnTabLeft.setText(getResources().getString(R.string.text_state_qb) + "(3)");
        btnTabCenter.setText(getResources().getString(R.string.text_state_wc) + "(2)");
        btnTabRight.setText(getResources().getString(R.string.text_state_wwc) + "(1)");
        fragments = new Fragment[3];

        fragments[0] = new PollTaskDetailsFragment();//完成
        Bundle bundle1 = new Bundle();
        bundle1.putInt(StrRes.INSTANCE.getType(), 0);
        fragments[0].setArguments(bundle1);

        fragments[1] = new PollTaskDetailsFragment();//未同步
        Bundle bundle2 = new Bundle();
        bundle2.putInt(StrRes.INSTANCE.getType(), 1);
        fragments[1].setArguments(bundle2);

        fragments[2] = new PollTaskDetailsFragment();//未完成
        Bundle bundle3 = new Bundle();
        bundle3.putInt(StrRes.INSTANCE.getType(), 2);
        fragments[2].setArguments(bundle3);

        mContentPagerAdapter = new ContentPagerAdapter(getSupportFragmentManager(), fragments);
        vpView.setAdapter(mContentPagerAdapter);
        vpView.setOffscreenPageLimit(3);//让ViewPager缓存2个页面
        vpView.setCurrentItem(0);//设置默认打开第一页
        vpView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setCurrentPage(0);
    }

    /**
     * 选择卡切换
     *
     * @param current
     */
    private void setCurrentPage(int current) {
        btnTabLeft.setSelected(false);
        btnTabLeft.setBackgroundResource(R.drawable.button_tar_left);
        btnTabCenter.setSelected(false);
        btnTabCenter.setBackgroundResource(R.drawable.button_tar_center);
        btnTabRight.setSelected(false);
        btnTabRight.setBackgroundResource(R.drawable.button_tar_right);
        if (current == 0) {
            btnTabLeft.setSelected(true);
            btnTabLeft.setBackgroundResource(R.drawable.button_tar_left_select);
        } else if (current == 1) {
            btnTabCenter.setSelected(true);
            btnTabCenter.setBackgroundResource(R.drawable.button_tar_center_select);
        } else if (current == 2) {
            btnTabRight.setSelected(true);
            btnTabRight.setBackgroundResource(R.drawable.button_tar_right_select);
        }
    }
}
