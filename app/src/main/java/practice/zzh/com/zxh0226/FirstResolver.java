package practice.zzh.com.zxh0226;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zzh on 2016/3/8.
 */
public class FirstResolver extends Activity {
    private ContentResolver resolver;
    Uri uri = Uri.parse("content://practice.zzh.com.zxh0226.firstContentProvider/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstresolver);
        resolver = getContentResolver();
        Button insertBtn = (Button)findViewById(R.id.insert);
        Button updateBtn = (Button)findViewById(R.id.update);
        Button deleteBtn = (Button)findViewById(R.id.delete);
        Button queryBtn = (Button)findViewById(R.id.query);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.insert(uri,null);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.update(uri,null,"update_where",null);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.delete(uri,null,null);
            }
        });
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.query(uri,null,null,null,null);
            }
        });
    }
    public void query(View source){
        Cursor c = resolver.query(uri,null,"query_where",null,null);
        Toast.makeText(this,"远程调用query返回游标为:"+c,Toast.LENGTH_SHORT);
    }
    public void update(View source){
        ContentValues values = new ContentValues();
        values.put("name","joker");
        int count = resolver.update(uri,values, "update_where",null);
        Toast.makeText(this,"远程调用query返回游标为:"+count,Toast.LENGTH_SHORT);
    }
    public void delete(View source){
        int count = resolver.delete(uri, "delete_where", null);
        Toast.makeText(this,"远程调用delete返回记录数为:"+count,Toast.LENGTH_SHORT);
    }
    public void insert(View source){
        ContentValues values = new ContentValues();
        values.put("name","joker");
        Uri newUri = resolver.insert(uri,values);
        Cursor c = resolver.query(uri,null,"query_where",null,null);
        Toast.makeText(this,"远程调用insert返回URI为:"+newUri,Toast.LENGTH_SHORT);
    }

}
