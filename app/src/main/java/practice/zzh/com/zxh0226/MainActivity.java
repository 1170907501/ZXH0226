package practice.zzh.com.zxh0226;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    int [] images= new int[]{R.drawable.people1,R.drawable.people2,R.drawable.people3,R.drawable.people4,R.drawable.people5};
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.root);
        final ImageView image = new ImageView(this);
        mainLayout.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击后切换图片
                image.setImageResource(images[++index%images.length]);
            }
        });
        //添加小球实例
        final DrawView drawView = new DrawView(this);
        mainLayout.addView(drawView);
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
    }


}
