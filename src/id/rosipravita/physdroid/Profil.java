package id.rosipravita.physdroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Profil extends Activity{
	protected Button ren_kem;
	WebView mwebview1;
	 @Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.profil);
	        
	        ren_kem = (Button)findViewById(R.id.btnkem);
	        ren_kem.setOnClickListener(new View.OnClickListener() {
				   		
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	        
	        	mwebview1 = (WebView) findViewById(R.id.profil);
	    		mwebview1.getSettings().setAllowFileAccess(true);
	    		String content1 = ambilResource(getResources(), R.raw.profil);
	    		String mimeType1 = "text/html";
	    		String encoding1 = "UTF-8";
	    		mwebview1.getSettings().setBuiltInZoomControls(true);
	    		mwebview1.getSettings().setSupportZoom(true);
	    		mwebview1.setBackgroundColor(0);                      
	            mwebview1.setBackgroundColor(Color.TRANSPARENT);  

	    		// webview.loadData(content, mimeType, encoding);
	    		mwebview1.loadDataWithBaseURL("file:///android_asset", content1,
	    				mimeType1, encoding1, null);

	    		mwebview1.getSettings().setJavaScriptEnabled(true);

	    	}

	    	public static String ambilResource(Resources resources, int resId) {
	    		InputStream rawResource = resources.openRawResource(resId);
	    		String content = ubahKeString(rawResource);
	    		try {
	    			rawResource.close();
	    		} catch (IOException e) {
	    		}
	    		return content;

	    	}

	    	private static String ubahKeString(InputStream in) {
	    		String l;
	    		BufferedReader r = new BufferedReader(new InputStreamReader(in));
	    		StringBuilder s = new StringBuilder();
	    		try {
	    			while ((l = r.readLine()) != null) {
	    				s.append(l + "\n");
	    			}
	    		} catch (IOException e) {
	    		}
	    		return s.toString();

	    	

	    	
	 }
}