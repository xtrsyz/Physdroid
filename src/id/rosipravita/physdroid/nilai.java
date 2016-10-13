package id.rosipravita.physdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class nilai extends Activity {
int mHasil;

String test,test2;

TextView txtnilai,txtjawaban,txtText;

   
   @Override
public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.nilai);
       Intent main=getIntent();
       mHasil=main.getExtras().getInt("mHasil");
       test=main.getExtras().getString("mJwb");
       txtnilai = (TextView) findViewById(R.id.txt);
       txtnilai.setText(Integer.toString(mHasil));
       txtText = (TextView) findViewById(R.id.text);
       txtText.setVisibility(View.GONE);
       txtjawaban = (TextView) findViewById(R.id.text1);
       test2="Hasil Jawaban Anda:  \n"+test;
       txtjawaban.setText(test2);
       
   }


   public void selesai(View view) {
	        	Intent kembali = new Intent(this , AndroidTaskActivity.class);
	        	startActivity(kembali);
	        	finish();
	}


@Override
public void onBackPressed(){
finish();
System.exit(0);
}
}