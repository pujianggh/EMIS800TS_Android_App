package com.android.ts.emis.activity.work;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.mode.WorkOrderListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作-工单评价
 *
 * @author pujiang
 * @date 2018-6-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderEvaluateActivity extends BaseActivity {
    @BindView(R.id.layout_titleBar)
    LinearLayout layoutTitleBar;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.rg_serveFinish)
    RadioGroup rgServeFinish;
    @BindView(R.id.rg_servePlease)
    RadioGroup rgServePlease;
    @BindView(R.id.rg_serveDegree)
    RadioGroup rgServeDegree;

    private WorkOrderListBean.Data mBean = null;
    private String mServeFinish = "是";
    private String mServePlease = "满意";
    private String mServeDegree = "满意";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_orderevaluate);
        ButterKnife.bind(this);

        mBean = (WorkOrderListBean.Data) getIntent().getSerializableExtra(StrRes.INSTANCE.getMode());
        initData();
        initEvent();
    }

    @OnClick({R.id.btn_next, R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                Intent intent = new Intent();
                intent.putExtra(StrRes.INSTANCE.getSource(), edtContent.getText().toString());
                setResult(RESULT_OK, intent);
                showToast("评价成功!");
                onBackPressed();
                break;
            case R.id.btn_cancel:
                onBackPressed();
                break;
        }
    }

    private void initData() {
        if (mBean != null)
            setTitleBarLayout(R.drawable.icon_back_white_bar, mBean.getLocation(), null, true);
    }

    private void initEvent() {
        rgServeFinish.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                int id = group.getCheckedRadioButtonId();
                // 通过id实例化选中的这个RadioButton
                RadioButton choise = (RadioButton) findViewById(id);
                // 获取这个RadioButton的text内容
                mServeFinish = choise.getText().toString();
            }
        });
        rgServePlease.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                int id = group.getCheckedRadioButtonId();
                // 通过id实例化选中的这个RadioButton
                RadioButton choise = (RadioButton) findViewById(id);
                // 获取这个RadioButton的text内容
                mServePlease = choise.getText().toString();
            }
        });
        rgServeDegree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                int id = group.getCheckedRadioButtonId();
                // 通过id实例化选中的这个RadioButton
                RadioButton choise = (RadioButton) findViewById(id);
                // 获取这个RadioButton的text内容
                mServeDegree = choise.getText().toString();
            }
        });
    }
}
