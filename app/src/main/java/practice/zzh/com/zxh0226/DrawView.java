package practice.zzh.com.zxh0226;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zzh on 2016/2/27.
 */
public class DrawView extends View{
    //�����ʼX��Y����
    private float currentX = 300;
    private float currentY = 300;
    //���廭��
    Paint paint = new Paint();
    public DrawView(Context context){
        super(context);
    }
    public  DrawView(Context context,AttributeSet set){
        super(context,set);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(currentX,currentY,15,paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        currentX = event.getX();
        currentY = event.getY();
        //֪ͨ��ǰ�ؼ��ػ��Լ�
        invalidate();
        return true;
    }
}
