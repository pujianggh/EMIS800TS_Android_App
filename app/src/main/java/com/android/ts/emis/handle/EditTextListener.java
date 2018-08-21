package com.android.ts.emis.handle;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * EditText监听
 *
 * @author pujiang
 * @date 2018-5-26 21:50
 * @mail 515210530@qq.com
 * @Description:
 */
public class EditTextListener {

    /**
     * 监听EditText内容修改提示语
     *
     * @param edtContent
     * @param tvContentTip
     */
    public static void setEditTextUpdateTipListener(EditText edtContent, final TextView tvContentTip, final int limitLength) {
        edtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > limitLength) {
                    s.delete(limitLength, s.length());
                }
                int num = limitLength - s.length();
                if (!TextUtils.isEmpty(tvContentTip.getText().toString())) {
                    tvContentTip.setText("还能输入" + num + "字符");
                    return;
                }
                tvContentTip.setText("最多可以输入" + limitLength + "字符");
            }
        });

    }
}
