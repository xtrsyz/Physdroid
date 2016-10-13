package id.rosipravita.physdroid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {

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
		setContentView(R.layout.splash);
		//doBindService();
		Intent music = new Intent();
		music.setClass(this, MusicService.class);
		startService(music);
		startAnimating();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//doUnbindService();
	}

	private void startAnimating() {
		TextView judul_splash = (TextView) findViewById(R.id.judul_splash);
		Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
		judul_splash.startAnimation(anim1);

		Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
		judul_splash.startAnimation(anim2);

		anim2.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Splash.this, AndroidTaskActivity.class));
				Splash.this.finish();
			}
		});
		ImageView iv1 = (ImageView) findViewById(R.id.img1);
		Animation spinin = AnimationUtils.loadAnimation(this, R.anim.random);
		iv1.startAnimation(spinin);

	}
}