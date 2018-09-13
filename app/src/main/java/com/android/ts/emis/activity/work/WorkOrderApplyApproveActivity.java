package com.android.ts.emis.activity.work;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StateType;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.SelectQueryListActivity;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.handle.EditTextListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工单申请审批
 *
 * @author pujiang
 * @date 2018-8-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderApplyApproveActivity extends BaseActivity {
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.tv_contentTip)
    TextView tvContentTip;
    @BindView(R.id.igv_add)
    ImageView igvAdd;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_apply_approve);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        EditTextListener.setEditTextUpdateTipListener(edtContent, tvContentTip, 1000);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_work_order_apply_approve_title), null, getResources().getString(R.string.text_button_tj), true);
        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(StrRes.INSTANCE.getSource(), edtContent.getText().toString());
                setResult(RESULT_OK, intent);
                onBackPressed();
            }
        });
    }

    @OnClick({R.id.igv_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.igv_add:
                startActivity(new Intent(getApplicationContext(), SelectQueryListActivity.class)
                        .putExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getPeopleInfo()));
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestCode.INSTANCE.getResult_PhotoChoice() && resultCode == RESULT_OK && data != null) {
        }
    }

}
