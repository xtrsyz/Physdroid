package id.rosipravita.physdroid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        startAnimating();
    }


private void startAnimating(){
	TextView judul_splash = (TextView) findViewById(R.id.judul_splash);
	Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
	judul_splash.startAnimation(anim1);
	
	TextView bawah_splash = (TextView) findViewById(R.id.bawah_splash);
	Animation anim2= AnimationUtils.loadAnimation(this, R.anim.anim2);
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
	ImageView iv1 = (ImageView)findViewById(R.id.img1);
	Animation spinin = AnimationUtils.loadAnimation(this, R.anim.random);
	iv1.startAnimation(spinin);	
	
}
}