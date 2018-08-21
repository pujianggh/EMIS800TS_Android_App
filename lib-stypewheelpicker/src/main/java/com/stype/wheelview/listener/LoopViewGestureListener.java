package com.stype.wheelview.listener;

import android.view.MotionEvent;

import com.stype.wheelview.view.WheelView;


/**
 * @author pujiang
 * @date 2018-5-24 13:31
 * @mail 515210530@qq.com
 * @Description:
 */
public final class LoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {

    private final WheelView wheelView;


    public LoopViewGestureListener(WheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelView.scrollBy(velocityY);
        return true;
    }
}
