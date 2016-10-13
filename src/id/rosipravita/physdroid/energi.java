package id.rosipravita.physdroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.TabActivity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;

public class energi extends TabActivity {
	
	WebView mwebview, webview1;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView (R.layout.energi);
			
			TabHost mTabHost = getTabHost();
		       
	        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("PENGERTIAN").setContent(R.id.PENGERTIAN));
	        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("CONTOH SOAL").setContent(R.id.CONTOH));
	      
	        mTabHost.setCurrentTab(0);
	        mwebview = (WebView) findViewById(R.id.cek);
			String content = ambilResource(getResources(), R.raw.cek);
			String mimeType = "text/html";
			String encoding = "UTF-8";
			mwebview.getSettings().setBuiltInZoomControls(true);
			mwebview.getSettings().setSupportZoom(true);
			mwebview.setBackgroundColor(0);                      
	        mwebview.setBackgroundColor(Color.TRANSPARENT);  
	        mwebview.loadDataWithBaseURL("file:///android_asset", content,
					mimeType, encoding, null);

			mwebview.getSettings().setJavaScriptEnabled(true);
	        
			webview1 = (WebView) findViewById(R.id.webView1);
	        webview1.getSettings().setBuiltInZoomControls(true);
			webview1.getSettings().setSupportZoom(true);
			webview1.setBackgroundColor(0);
			webview1.setBackgroundColor(Color.TRANSPARENT);
			String content1 = ambilResource(getResources(), R.raw.mek);
			String mimeType1 = "text/html";
			String encoding1 = "UTF-8";

			// webview.loadUrl("file:///android_asset/info.html");
			webview1.loadData(content1, mimeType1, encoding1);
			webview1.loadDataWithBaseURL("file:///android_asset", content1,
					mimeType1, encoding1, null);

			

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
		@Override
		public void onWindowFocusChanged(boolean hasFocus) {
			// TODO Auto-generated method stub
			super.onWindowFocusChanged(hasFocus);
			ImageView rocketImage = (ImageView) findViewById(R.id.mobil);
	        rocketImage.setBackgroundResource(R.drawable.mobil);

	        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
	        rocketAnimation.start();
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

		public void onBackPressed(){
			finish();
			System.exit(0);
			}
		
		}
		
