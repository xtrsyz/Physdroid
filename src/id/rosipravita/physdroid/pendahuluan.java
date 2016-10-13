package id.rosipravita.physdroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.TabActivity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TabHost;

public class pendahuluan extends TabActivity {

	WebView mwebview, mwebview1;
	Button btnkem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pendahuluan);

		TabHost mTabHost = getTabHost();

		mTabHost.addTab(mTabHost.newTabSpec("tab_test1")
				.setIndicator("PETUNJUK").setContent(R.id.PETUNJUK));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2")
				.setIndicator("KOMPETENSI").setContent(R.id.KOMPETENSI));

		mTabHost.setCurrentTab(0);

		Button balik = (Button) findViewById(R.id.btnkem);
		balik.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		mwebview = (WebView) findViewById(R.id.komp);
		String content = ambilResource(getResources(), R.raw.pendahuluan);
		String mimeType = "text/html";
		String encoding = "UTF-8";
		mwebview.getSettings().setBuiltInZoomControls(true);
		mwebview.getSettings().setSupportZoom(true);
		mwebview.setBackgroundColor(0);                      
        mwebview.setBackgroundColor(Color.TRANSPARENT);  
        mwebview.loadDataWithBaseURL("file:///android_asset", content,
				mimeType, encoding, null);

		mwebview.getSettings().setJavaScriptEnabled(true);
	
		
		mwebview1 = (WebView) findViewById(R.id.ptjuk);
		mwebview1.getSettings().setAllowFileAccess(true);
		String content1 = ambilResource(getResources(), R.raw.ptjuk);
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

	public static void setOnClickListener(OnClickListener onClickListener) {
		// TODO Auto-generated method stub
		//

	}
}