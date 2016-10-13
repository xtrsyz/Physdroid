package id.rosipravita.physdroid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class materi extends Activity{

	
	Button btenaga,bek,bep,bem,bdaya,bcontoh;
	MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView (R.layout.materi);
		
		
		Button tenaga = (Button) findViewById(R.id.btenaga);
		tenaga.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			ganti1();	
			StopSound();
			PlaySound("usaha");
			}
		});
		
		Button energi = (Button) findViewById(R.id.bek);
		energi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			ganti2();	
			StopSound();
			PlaySound("ek");
			}
		});
		Button potensial = (Button)findViewById(R.id.bep);
		potensial.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			ganti2a();	
			StopSound();
			PlaySound("ep");
			}
		});
		Button mekanik = (Button)findViewById(R.id.bem);
		mekanik.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			ganti2b();
			StopSound();
			PlaySound("em");
			}
		});
		
		Button daya = (Button) findViewById(R.id.bdaya);
		daya.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			ganti3();	
			StopSound();
			PlaySound("daya");
			}
		});
		
	}
	public void ganti3(){
	    Intent gh3 = new Intent(this, daya.class);
	    startActivity(gh3);
	    }
	public void ganti2b(){
	    Intent gh2b = new Intent(this, energi3.class);
	    startActivity(gh2b);
	    }
	public void ganti2a(){
	    Intent gh2a = new Intent(this, energi2.class);
	    startActivity(gh2a);
	    }
	public void ganti2(){
	    Intent gh2 = new Intent(this, energi.class);
	    startActivity(gh2);
	    }
	public void ganti1(){
	    Intent gh1 = new Intent(this, tenaga.class);
	    startActivity(gh1);
	    }
	public void PlaySound(String nama) {
		StopSound();
		int m6jrdf = getResources().getIdentifier(getPackageName() + ":raw/" + nama , null, null);
		mp = MediaPlayer.create(this,m6jrdf); 
		mp.start();
	}
	public void StopSound() {
		
	}
	
	

}
