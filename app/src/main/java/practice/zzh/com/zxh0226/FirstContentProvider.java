package practice.zzh.com.zxh0226;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by zzh on 2016/3/8.
 */
public class FirstContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        Log.i("AppTag","contentProvider Create");
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.i("AppTag","contentProvider query");
        return null;
    }

    @Override
    public String getType(Uri uri) {
        Log.i("AppTag","contentProvider getType");
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i("AppTag", "contentProvider Insert");
        Toast.makeText(this.getContext(),"ProviderInsert",Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.i("AppTag","contentProvider Delete");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.i("AppTag","contentProvider Update");
        return 0;
    }
}
