package com.android.ts.emis.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.fragment.MessageFragment;
import com.android.ts.emis.fragment.SetFragment;
import com.android.ts.emis.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页
 *
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.fm_main_index)
    FrameLayout fmMainIndex;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.tv_messageCount)
    TextView tvMessageCount;
    @BindView(R.id.tv_myCount)
    TextView tvMyCount;
    @BindView(R.id.tv_setCount)
    TextView tvSetCount;

    private FragmentManager fragmentManager;
    private FragmentTransaction transition;
    private List<Fragment> fragments;
    private MessageFragment messageFragment;
    private MyFragment myFragment;
    private SetFragment setFragment;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment(savedInstanceState);
        tvMessageCount.setVisibility(View.VISIBLE);
        tvMessageCount.setText("99+");
        tvSetCount.setVisibility(View.VISIBLE);
        tvSetCount.setText(" 2 ");
    }

    /**
     * 初始化Fragment
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        fragments = new ArrayList<>();

        rgMain.check(R.id.rb_mainMessage);
        messageFragment = new MessageFragment();
        fragments.add(messageFragment);
        hideOthersFragment(messageFragment, true);

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_mainMessage://消息中心
                        hideOthersFragment(messageFragment, false);
                        break;
                    case R.id.rb_mainMy://我的-工作中心
                        if (myFragment == null) {
                            myFragment = new MyFragment();
                            fragments.add(myFragment);
                            hideOthersFragment(myFragment, true);
                        } else {
                            hideOthersFragment(myFragment, false);
                        }
                        break;
                    case R.id.rb_mainSet://设置
                        if (setFragment == null) {
                            setFragment = new SetFragment();
                            fragments.add(setFragment);
                            hideOthersFragment(setFragment, true);
                        } else {
                            hideOthersFragment(setFragment, false);
                        }
                        break;
                }
            }
        });
    }

    /**
     * 动态显示Fragment
     *
     * @param showFragment 要增加的fragment
     * @param add          true：增加fragment；false：切换fragment
     */
    private void hideOthersFragment(Fragment showFragment, boolean add) {
        transition = fragmentManager.beginTransaction();
        if (add)
            transition.add(R.id.fm_main_index, showFragment);
        for (Fragment fragment : fragments) {
            if (showFragment.equals(fragment)) {
                transition.show(fragment);
            } else {
                transition.hide(fragment);
            }
        }
        transition.commit();
    }

}
