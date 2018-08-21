package com.android.ts.emis.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 时间倒计时
 *
 * @author pujiang
 * @date 2017-8-29 18:13
 * @mail 515210530@qq.com
 * @Description:
 */
public class TimerUtils extends CountDownTimer {

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimerUtils(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    private TextView textView;

    /***
     * 1000 =1s   start方法会启动
     * @param millisInFuture   需要的时长
     * @param countDownInterval   每次减少多少时间
     * @param textView   显示的控件
     */
    public TimerUtils(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
    }



    /***
     * 剩余时间
     * @param millisUntilFinished
     */
    @Override
    public void onTick(long millisUntilFinished) {
        textView.setEnabled(false);
        textView.setText(millisUntilFinished /1000 +"S后重新获取");

    }

    @Override
    public void onFinish() {
        textView.setEnabled(true);
        textView.setText("重新获取");
    }
}
