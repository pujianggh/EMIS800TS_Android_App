package com.android.ts.emis.activity.common;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * H5通用加载器
 *
 * @author pujiang
 * @date 2018-4-13 16:55
 * @mail 515210530@qq.com
 * @Description:
 */
public class CommonWebActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.wv_content)
    WebView wvContent;

    private String mH5URL = "http://news.baidu.com";//Web地址

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_common_web);
        ButterKnife.bind(this);

        initWebView();
    }

    /**
     * 初始化WebView设置
     */
    protected void initWebView() {
        WebSettings webSettings = wvContent.getSettings();
        webSettings.setJavaScriptEnabled(true);//支持js
        webSettings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);// 设置JS可用
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);  //提高渲染的优先级
        webSettings.setNeedInitialFocus(false);
        webSettings.setLoadsImagesAutomatically(true);  //支持自动加载图片;

        webSettings.setDefaultTextEncodingName("UTF-8");

        wvContent.setWebViewClient(new H5WebViewClient());

        wvContent.loadUrl(mH5URL);
    }

    /**
     *
     */
    public class H5WebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            showLoadingDialog();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dismissLoadingDialog();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            gotoBack();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    /**
     * 返回
     */
    private void gotoBack() {
        if (wvContent.canGoBack() && !mH5URL.equals(wvContent.getUrl())) {
            wvContent.goBack();
        } else {
            finish();
        }
    }
}
