package com.example.ontoucheventdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

public class DrawView extends View {

    static final float STROKE_WIDTH = 10f;

    private Path mPath = new Path();
    private Paint mPaint = new Paint();

    public DrawView(Context context){
        this(context, null);
        initPath();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPath();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case ACTION_DOWN:
                mPath.moveTo(eventX, eventY);
                return true;
            case ACTION_MOVE:
                mPath.lineTo(eventX, eventY);
                invalidate();
                return true;
                default:
                   return super.onTouchEvent(event);
        }
    }

    public void clear(){
        mPath.reset();
        invalidate();
    }

    private void initPath(){
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(STROKE_WIDTH);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }
}
