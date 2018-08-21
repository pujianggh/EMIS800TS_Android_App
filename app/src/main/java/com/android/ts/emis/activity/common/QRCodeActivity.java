package com.android.ts.emis.activity.common;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.RequestCode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qrcode.zxing.ZXingView;

/**
 * 二维码扫描
 *
 * @author pujiang
 * @date 2018-5-20 20:19
 * @mail 515210530@qq.com
 * @Description:
 */
public class QRCodeActivity extends BaseActivity implements ZXingView.Delegate {
    @BindView(R.id.layout_titleBar)
    RelativeLayout mLayoutTitleBar;
    @BindView(R.id.zxv_content)
    ZXingView mZxvContent;
    @BindView(R.id.igv_back)
    ImageView mIgvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.igv_icon)
    ImageView mIgvIcon;

    private int mLightCount = 0;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_qrcode);
        ButterKnife.bind(this);

        mIgvIcon.setImageResource(R.drawable.icon_light_open);
        mZxvContent.setDelegate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissionInfo(RequestCode.INSTANCE.getResult_QRCode(), new String[]{Manifest.permission.CAMERA, Manifest.permission.VIBRATE});
        } else {
            mZxvContent.startCamera();
            mZxvContent.showScanRect();
            mZxvContent.startSpot();
            mZxvContent.startSpotAndShowRect();//显示扫描框
            //mZxvContent.stopSpotAndHiddenRect();//隐藏扫描框
            //mZxvContent.changeToScanBarcodeStyle();//扫描条码
            //mZxvContent.changeToScanQRCodeStyle();//扫描二维码
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        //showToast("扫描结果:" + result);
        vibrate();
        setResult(RESULT_OK, new Intent().putExtra(StrRes.INSTANCE.getResult(), result));
        onBackPressed();
        mZxvContent.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        //showToast("请打开相机权限!");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissionInfo(RequestCode.INSTANCE.getResult_QRCode(), new String[]{Manifest.permission.CAMERA, Manifest.permission.VIBRATE});
        }
    }

    @Override
    public void permissionSuccess(int requestCode) {
        if (RequestCode.INSTANCE.getResult_QRCode() == requestCode) {
            mZxvContent.startCamera();
            mZxvContent.showScanRect();
            mZxvContent.startSpot();
            mZxvContent.startSpotAndShowRect();//显示扫描框
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        if (RequestCode.INSTANCE.getResult_QRCode() == requestCode) {
            showToast(getResources().getString(R.string.text_permission_fail_xj));
        }
    }

    @OnClick({R.id.igv_back, R.id.tv_title, R.id.igv_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.igv_back:
            case R.id.tv_title:
                setResult(RESULT_OK, null);
                onBackPressed();
                break;
            case R.id.igv_icon:
                if (mLightCount % 2 == 0) {
                    mZxvContent.openFlashlight();
                    mIgvIcon.setImageResource(R.drawable.icon_light_close);
                } else {
                    mZxvContent.closeFlashlight();
                    mIgvIcon.setImageResource(R.drawable.icon_light_open);
                }
                ++mLightCount;
                break;
        }
    }

    /**
     * 震动操作
     */
    private void vibrate() {
        if (checkPermissions(new String[]{Manifest.permission.VIBRATE})) {
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(200);
        }
    }

    @Override
    protected void onStop() {
        mZxvContent.stopSpot();
        mZxvContent.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZxvContent.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(RESULT_OK, null);
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
