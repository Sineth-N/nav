package com.d2s2.sinethn.nav.Volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.d2s2.sinethn.nav.MyApplication;

import org.apache.http.protocol.RequestDate;

/**
 * Created by Sineth N on 8/15/2015.
 */
public class VolleySingleton {
    private static VolleySingleton ourInstance ;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    public static synchronized VolleySingleton getInstance() {
        if(ourInstance==null){
            synchronized (VolleySingleton.class) {
                ourInstance = new VolleySingleton();
                return ourInstance;
            }

        }else {
            return ourInstance;
        }
    }

    private VolleySingleton() {
        requestQueue= Volley.newRequestQueue(MyApplication.getAppContext());
        imageLoader=new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private LruCache<String,Bitmap> cache=new LruCache<>((int) (Runtime.getRuntime().maxMemory()/1024/8));
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }



            @Override

            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }
    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
    public ImageLoader getImageLoader(){
        return imageLoader;
    }
}
