package com.example.android.et024_customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Aptivist-U001 on 10/29/2017.
 */

public class MyRectangle extends View {

    private static final String TAG = MyRectangle.class.getSimpleName() + "_TAG_";
    private Paint paint;
    private Canvas canvas;
    private Rect rectangle;

    private boolean showCircle;
    private boolean showSquare;
    private int figureColor = Color.MAGENTA;


    public MyRectangle(Context context) {
        this(context, null);
    }

    public MyRectangle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyRectangle: ");



        if (attrs != null) {
            parseAttributes(attrs);
        }

        rectangle = new Rect(100, 100, 300, 250);

        paint = new Paint();
        paint.setColor(figureColor);
    }

    private void parseAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme()
                .obtainStyledAttributes(attrs, R.styleable.MyRectangle,0,0);

        try {
            showCircle = typedArray.getBoolean(R.styleable.MyRectangle_showCircle, false);
            showSquare = typedArray.getBoolean(R.styleable.MyRectangle_showSquare, false);
            figureColor = typedArray.getColor(R.styleable.MyRectangle_figureColor, Color.MAGENTA);
        } finally {
            typedArray.recycle();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: " + widthMeasureSpec + " " + heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: " + changed + " " + left + " " + top + " " + right + " " + bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(rectangle, paint);

        Point a = new Point(0, 0);
        Point b = new Point(0, 100);
        Point c = new Point(87, 50);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);

        if(showCircle)
            canvas.drawCircle(600, 200, 100, paint);

        if(showSquare)
            canvas.drawRect(new Rect(700, 700, 900, 900), paint);
    }

}
