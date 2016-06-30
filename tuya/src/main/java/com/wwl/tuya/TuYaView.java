package com.wwl.tuya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/6/30.
 */
public class TuYaView extends View{
    //画板
    private Canvas canvas;

    //纸
    private Bitmap bitmap;

    //笔
    private Paint paint;
    //路径
    private Path path;

    //临时保存X Y
    private float mx,my;

    public TuYaView(Context context,int screenWith,int screenHeight) {
        super(context);

    }

    public TuYaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TuYaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TuYaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
