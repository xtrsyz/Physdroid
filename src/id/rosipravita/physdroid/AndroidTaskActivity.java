package id.rosipravita.physdroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AndroidTaskActivity extends Activity {
	protected Button pendahuluan;
	protected Button materi;
	protected ProgressDialog pd1;
	protected Button close;
	protected Button latihan;
	protected Button profil;
	protected Button mstop;
	protected Button mstart;

	private boolean mIsBound = false;
	private MusicService mServ;
	private ServiceConnection Scon = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			mServ = ((MusicService.ServiceBinder) binder).getService();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mServ = null;
		}
	};

	void doBindService() {
		bindService(new Intent(this, MusicService.class), Scon,
				Context.BIND_AUTO_CREATE);
		mIsBound = true;
	}

	void doUnbindService() {
		if (mIsBound) {
			unbindService(Scon);
			mIsBound = false;
		}
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		doBindService();

		pd1 = ProgressDialog.show(AndroidTaskActivity.this, "Please Wait...",
				"System is loading module");
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(1000);
				} catch (Exception e) {
					Log.e("tag", e.getMessage());
				}
				pd1.dismiss();
			}

		}.start();

		setContentView(R.layout.main);
		profil = (Button) findViewById(R.id.btnpfl);
		profil.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gantihalaman4();
			}
		});
		latihan = (Button) findViewById(R.id.btntask);
		latihan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gantihalaman3();
			}
		});
		materi = (Button) findViewById(R.id.btnmat);
		materi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gantihalaman2();
			}
		});
		pendahuluan = (Button) findViewById(R.id.btnpdhl);
		pendahuluan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gantihalaman();
			}
		});
		close = (Button) findViewById(R.id.btnclose);
		close.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				keluar();
			}
		});

		mstop = (Button) findViewById(R.id.mstop);
		mstop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mServ.pauseMusic();
			}
		});

		mstart = (Button) findViewById(R.id.mstart);
		mstart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mServ.resumeMusic();
			}
		});

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//doUnbindService();
	}

	public void keluar() {
		mServ.stopMusic();
		//doUnbindService();
		finish();
		// System.exit(0);
	}

	public void gantihalaman() {
		Intent gh = new Intent(this, pendahuluan.class);
		startActivity(gh);
	}

	public void gantihalaman2() {
		Intent gh2 = new Intent(this, materi.class);
		startActivity(gh2);
	}

	public void gantihalaman3() {
		Intent gh3 = new Intent(this, latihan.class);
		startActivity(gh3);
	}

	private void gantihalaman4() {
		Intent gh4 = new Intent(this, Profil.class);
		startActivity(gh4);
	}
}