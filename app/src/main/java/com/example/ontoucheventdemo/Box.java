package com.example.ontoucheventdemo;

import android.graphics.PointF;

public class Box  {

    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF mOrigin) {
        this.mOrigin = mOrigin;
        mCurrent = mOrigin;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
    }
}
