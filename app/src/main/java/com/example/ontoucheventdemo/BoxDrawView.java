package com.example.ontoucheventdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class BoxDrawView extends View {

    private Paint mPaint = new Paint();
    private List<Box> mBoxes = new ArrayList<>();
    private Box mCurrentBox;

    public BoxDrawView(Context context){
        this(context, null);
    }

    public BoxDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Box box : mBoxes){
            float left = Math.min(box.getOrigin().x, box.getCurrent().x);
            float right = Math.max(box.getOrigin().x,box.getCurrent().x);
            float top = Math.min(box.getOrigin().y, box.getCurrent().y);
            float bottom = Math.min(box.getOrigin().y, box.getCurrent().y);
            canvas.drawRect(left,top,right,bottom, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        int action = event.getAction();

        switch (action){
            case ACTION_DOWN:
                mCurrentBox = new Box(current);
                mBoxes.add(mCurrentBox);
                break;
            case ACTION_MOVE:
                mCurrentBox.setCurrent(current);
                invalidate();
                break;
            case ACTION_UP:
            case ACTION_CANCEL:
                mCurrentBox = null;
                break;
        }
        return true;
    }

    public void clear(){
        mBoxes.clear();
        invalidate();
    }
}
