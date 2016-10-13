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
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

public class energi3 extends TabActivity implements OnClickListener {
	
		Button btstart, btstop;
		ImageView display;
		AnimationDrawable energi;
		WebView webview1,webview2;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView (R.layout.energi3);
			TabHost mTabHost = getTabHost();
		       
	        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("PENGERTIAN").setContent(R.id.PENGERTIAN));
	        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("CONTOH SOAL").setContent(R.id.CONTOH));
	      
	        mTabHost.setCurrentTab(0);
	       
			
			display = (ImageView)findViewById(R.id.mknikanim);
			btstart = (Button)findViewById(R.id.btStart);
			btstop = (Button)findViewById(R.id.btStop);
			
			btstart.setEnabled(true);
			btstop.setEnabled(false);
			
			btstart.setOnClickListener(this);
			btstop.setOnClickListener(this);
			
			display.setBackgroundResource(R.drawable.mknik);
			
			energi = 
					(AnimationDrawable) display.getBackground();
			
			 
		
		webview1 = (WebView) findViewById(R.id.webView1);
		webview1.setBackgroundColor(0);
		webview1.setBackgroundColor(Color.TRANSPARENT);
		webview1.getSettings().setBuiltInZoomControls(true);
		webview1.getSettings().setSupportZoom(true);
		String content1 = ambilResource(getResources(), R.raw.mem);
		String mimeType1 = "text/html";
		String encoding1 = "UTF-8";

		// webview.loadUrl("file:///android_asset/info.html");
		webview1.loadData(content1, mimeType1, encoding1);
		webview1.loadDataWithBaseURL("file:///android_asset", content1,
				mimeType1, encoding1, null);

		webview2 = (WebView) findViewById(R.id.webView2);
		webview2.setBackgroundColor(0);
		webview2.setBackgroundColor(Color.TRANSPARENT);
		webview2.getSettings().setBuiltInZoomControls(true);
		webview2.getSettings().setSupportZoom(true);
		String content2 = ambilResource(getResources(), R.raw.cem);
		String mimeType2 = "text/html";
		String encoding2 = "UTF-8";

		// webview.loadUrl("file:///android_asset/info.html");
		webview2.loadData(content2, mimeType2, encoding2);
		webview2.loadDataWithBaseURL("file:///android_asset", content2,
				mimeType2, encoding2, null);

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
		}

		
			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.activity_main, menu);
				return true;
			}

		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int id = v.getId();
				switch (id) {
				case R.id.btStart:
				
					energi.start();
					btstart.setEnabled(false);
					btstop.setEnabled(true);
					break;
					
				case R.id.btStop:
					
					energi.stop();
					btstart.setEnabled(true);
					btstop.setEnabled(false);
					break;
				default:
					break;
			
				}
			
				

}
			public void onBackPressed(){
				finish();
				System.exit(0);
				}
			
			}
	

		
