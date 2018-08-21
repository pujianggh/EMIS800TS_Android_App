package com.android.ts.emis.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.home.ProjectMessageActivity;
import com.android.ts.emis.adapter.MessageAdapter;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.mode.HouseListBean;
import com.android.ts.emis.mode.MessageInfoBean;
import com.android.ts.emis.mvp.presenter.MessageInfoPresenter;
import com.android.ts.emis.mvp.view.IMessageInfoView;
import com.android.ts.emis.net.OkhttpUtil;
import com.android.ts.emis.utils.SPUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 首页-消息中心
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageFragment extends BaseFragment implements IMessageInfoView {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;
    @BindView(R.id.tv_title_bar)
    TextView tvTitleBar;

    private MessageAdapter mAdapter;
    private MessageInfoPresenter mPresenter;
    private List<MessageInfoBean.DataBean.MessageListBean> datas;
    private String mHouseCode = "";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_message);
        unBinder = ButterKnife.bind(this, mContentView);

        mPresenter = new MessageInfoPresenter(getActivity(), this);

        if (!TextUtils.isEmpty(mUserPasswrd.getHouseCode())) {
            mHouseCode = mUserPasswrd.getHouseCode();
            tvTitleBar.setText(mUserPasswrd.getHouseName());
        }

        getResponseData(true);
        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                getResponseData(true);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                if (mTotalPage > mPage) {
                    mPage++;
                    mPresenter.getMessageInfoLists(mPage + "", mSize + "", mUserPasswrd.getUserCode(), mHouseCode, OkhttpUtil.GetUrlMode.PULL_UP);
                } else {
                    rlRootRefresh.endLoadingMore();
                }
                return mTotalPage > mPage;
            }
        });
    }

    @Override
    public void getMessageInfos(MessageInfoBean messageInfoBean) {
        rlRootRefresh.endRefreshing();
        if (messageInfoBean != null && messageInfoBean.getData() != null && messageInfoBean.getData().getMessageList() != null) {
            mAdapter = new MessageAdapter(getActivity());
            lvListData.setAdapter(mAdapter);
            datas = messageInfoBean.getData().getMessageList();
            mAdapter.setData(datas);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addMessageInfos(MessageInfoBean messageInfoBean) {
        rlRootRefresh.endLoadingMore();
        datas.addAll(messageInfoBean.getData().getMessageList());
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.tv_title_bar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title_bar:
                startActivityForResult(new Intent(getActivity(), ProjectMessageActivity.class), RequestCode.INSTANCE.getResult_ProjectMessage());
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestCode.INSTANCE.getResult_ProjectMessage() && resultCode == getActivity().RESULT_OK && data != null) {
            HouseListBean moduleBean = (HouseListBean) data.getSerializableExtra(StrRes.INSTANCE.getMode());
            if (moduleBean != null) {
                tvTitleBar.setText(moduleBean.getHouseName());
                mUserPasswrd.setHouseName(moduleBean.getHouseName());
                mUserPasswrd.setHouseCode(moduleBean.getHouseCode());
                mUserPasswrd.setRuleCode(moduleBean.getRuleCode());
                SPUtil.INSTANCE.putAllModle(mAPPApplication, mUserPasswrd);
                SPUtil.INSTANCE.putString(StrRes.INSTANCE.getHouseName(), moduleBean.getHouseName());
                SPUtil.INSTANCE.putString(StrRes.INSTANCE.getHouseCode(), moduleBean.getHouseCode());
                SPUtil.INSTANCE.putString(StrRes.INSTANCE.getRuleCode(), moduleBean.getRuleCode());
                mHouseCode = moduleBean.getHouseCode();
                getResponseData(true);
            }
        }
    }

    private void getResponseData(boolean isRefresh) {
        OkhttpUtil.GetUrlMode mode = OkhttpUtil.GetUrlMode.NORMAL;
        if (isRefresh) {
            mPage = 1;
        } else {
            mPage++;
            mode = OkhttpUtil.GetUrlMode.PULL_UP;
        }
        mPresenter.getMessageInfoLists(mPage + "", mSize + "", mUserPasswrd.getUserCode(), mHouseCode, mode);
    }
}
