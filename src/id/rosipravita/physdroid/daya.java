package id.rosipravita.physdroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.TabActivity;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TabHost;


public class daya extends TabActivity{
	
	WebView mwebview, mwebview1;
	MediaPlayer mp;
	
	    /** Called when the activity is first created. */
	    @Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView (R.layout.daya);
TabHost mTabHost = getTabHost();
		       
	        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("PENGERTIAN").setContent(R.id.PENGERTIAN));
	        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("CONTOH SOAL").setContent(R.id.CONTOH));
	      
	        mTabHost.setCurrentTab(0);
			  
	        mwebview = (WebView) findViewById(R.id.cdy);
			String content = ambilResource(getResources(), R.raw.cdy);
			String mimeType = "text/html";
			String encoding = "UTF-8";
			mwebview.getSettings().setBuiltInZoomControls(true);
			mwebview.getSettings().setSupportZoom(true);
			mwebview.setBackgroundColor(0);                      
	        mwebview.setBackgroundColor(Color.TRANSPARENT);  
	        mwebview.loadDataWithBaseURL("file:///android_asset", content,
					mimeType, encoding, null);

			mwebview.getSettings().setJavaScriptEnabled(true);
			
	        mwebview1 = (WebView) findViewById(R.id.mdy);
			mwebview1.getSettings().setAllowFileAccess(true);
			String content1 = ambilResource(getResources(), R.raw.mdy);
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
		public void onBackPressed(){
			finish();
			System.exit(0);
			}
		
		}


		
		