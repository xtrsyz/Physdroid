package id.rosipravita.physdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class latihan extends Activity {
	Button ren_kem;
	public int index, index2, index3, index4, index5, index6, index7, index8,
			index9, index10, jumlah;
	public int hasil1, hasil2, hasil3, hasil4, hasil5, hasil6, hasil7, hasil8,
			hasil9, hasil10;
	public static int nilai = 0;
	public TextView ba, bb, bc, bd, be, bf, bg, bh, bi, bj;
	public Spinner soal1, soal2, soal3, soal4, soal5, soal6, soal7, soal8,
			soal9, soal10;
	public Button submit;
	public static int mHasil = 0;
	public String jawaban, jawaban1, kunciString;
	public static String jwaban = "";

	String[] pert1 = { " Pilih jawaban", "A. 40 J", "B. 80 J", "C. 120 J",
			"D. 160 J", "E. 200 J" };
	String[] pert2 = { " Pilih jawaban", "A. 60 J", "B. 90 J", "C. 120 J",
			"D. 150 J", "E. 180 J" };
	String[] pert3 = { " Pilih jawaban", "A. 1612 J", "B. 1152 J", "C. 384 J",
			"D. 230 J", "E. 153 J" };
	String[] pert4 = { " Pilih jawaban", "A. sepertiga kalinya", "B. tetap",
			"C. tiga kali semula", "D. enam kali semula",
			"E. sembilan kali semula" };
	String[] pert5 = { " Pilih jawaban", "A. 8 J", "B. 12 J", "C. 16 J",
			"D. 24 J", "E. 36 J" };
	String[] pert6 = { " Pilih jawaban", "A. 200 J", "B. 250 J", "C. 300 J",
			"D. 350 J", "E. 400 J" };
	String[] pert7 = { " Pilih jawaban", "A. 2 J", "B. 10 J", "C. 12 J",
			"D. 22 J", "E. 24 J" };
	String[] pert8 = { " Pilih jawaban", "A. 1000 N", "B. 1500 N", "C. 2000 N",
			"D. 20.000 N", "E. 30.000 N" };
	String[] pert9 = { " Pilih jawaban", "A. [M][L]^-1[T]^-1",
			"B. [M][L]^2[T]^-1", "C. [M][L]^2[T]^-2", "D. [M][L]^-2[T]^-2",
			"E. [M][T]^-2" };
	String[] pert10 = { "Pilih jawaban ", "A. 3750 watt", "B. 2500 watt",
			"C. 1875 watt", "D. 1500 watt", "E. 1250 watt" };

	int[] kunci = { 4, 2, 3, 5, 1, 2, 4, 3, 3, 3 };
	int[] soal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kuis);

		ba = (TextView) findViewById(R.id.ba);
		bb = (TextView) findViewById(R.id.bb);
		bc = (TextView) findViewById(R.id.bc);
		bd = (TextView) findViewById(R.id.bd);
		be = (TextView) findViewById(R.id.be);
		bf = (TextView) findViewById(R.id.bf);
		bg = (TextView) findViewById(R.id.bg);
		bh = (TextView) findViewById(R.id.bh);
		bi = (TextView) findViewById(R.id.bi);
		bj = (TextView) findViewById(R.id.bj);
		soal1 = (Spinner) findViewById(R.id.soal1);
		soal2 = (Spinner) findViewById(R.id.soal2);
		soal3 = (Spinner) findViewById(R.id.soal3);
		soal4 = (Spinner) findViewById(R.id.soal4);
		soal5 = (Spinner) findViewById(R.id.soal5);
		soal6 = (Spinner) findViewById(R.id.soal6);
		soal7 = (Spinner) findViewById(R.id.soal7);
		soal8 = (Spinner) findViewById(R.id.soal8);
		soal9 = (Spinner) findViewById(R.id.soal9);
		soal10 = (Spinner) findViewById(R.id.soal10);

		submit = (Button) findViewById(R.id.submit);

		ba.setText("1. Seorang Anak menarik kereta membentuk sudut 37° terhadap bidang datar sejauh 5 m dengan gaya 40 N. Besar usaha yang dilakukan anak itu adalah ...");
		bb.setText("2. Sebuah balok bermassa 30 kg ditarik gaya 60 N yang membentuk sudut 60° terhadap horizontal. Pada saat balok dapat bergeser mendatar sejauh 3 m maka tentukan usaha yang dilakukan gaya tersebut!");
		bc.setText("3. Sebuah benda bergerak lurus dengan persamaan x(t) = 3t - 4t^2 + t^3 dinyatakan dalam satuan SI. Jika massa benda 2 kg, maka usaha yang dikerjakan oleh gaya pada benda tersebut selama 4 detik pertama adalah ...");
		bd.setText("4. Jika kecepatan benda berubah menjadi tiga kali kecepatan semula, energi kinetiknya berubah menjadi ...");
		be.setText("5. Sebuah benda bermassa 1 kg, mula-mula diam kemudian bergerak lurus dengan percepatan 2 m/s^2. Usaha yang diubah menjadi energi kinetik setelah 2 s adalah ...");
		bf.setText("6. Benda bermassa 5 kg dilempar vertikal ke atas dengan kecepatan awal 10 m/s. Besarnya energi potensial di titik tertinggi yang dicapai benda adalah ...");
		bg.setText("7. Sebuah benda dengan massa 1 kg didorong dari permukaan meja hingga kecepatan pada saat lepas dari bibir meja = 2 m/s. Energi mekanik benda pada saat ketinggiannya 1 m dari tanah adalah ...");
		bh.setText("8. Sebuah mobil mempunyai daya penggerak 60 KW dan bergerak dengan kecepatan 30 m/s. Besar gaya gerak mobil pada saat itu adalah ...");
		bi.setText("9. Usaha dan tenaga adalah dua besaran fisika yang memiliki dimensi yang sama, berikut ini yang merupakan dimensi dari besaran itu adalah ...");
		bj.setText("10. Sebuah mobil bermassa 5 kuintal bergerak dengan kecepatan 5 m/s, 10 sekon kemudian kecepatan mobil menjadi 10 m/s. Daya mobil selama 10 detik tersebut ialah ...");

		ArrayAdapter<String> pil1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert1);
		pil1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ren_kem = (Button) findViewById(R.id.btnkem);
		ren_kem.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		soal1.setAdapter(pil1);
		soal1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index = soal1.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		ArrayAdapter<String> pil2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert2);
		pil2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal2.setAdapter(pil2);
		soal2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index2 = soal2.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> pil3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert3);
		pil3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal3.setAdapter(pil3);
		soal3.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index3 = soal3.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> pil4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert4);
		pil4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal4.setAdapter(pil4);
		soal4.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index4 = soal4.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> pil5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert5);
		pil5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal5.setAdapter(pil5);
		soal5.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index5 = soal5.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> pil6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert6);
		pil6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal6.setAdapter(pil6);
		soal6.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index6 = soal6.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		ArrayAdapter<String> pil7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert7);
		pil7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal7.setAdapter(pil7);
		soal7.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index7 = soal7.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		ArrayAdapter<String> pil8 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert8);
		pil8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal8.setAdapter(pil8);
		soal8.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index8 = soal8.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		ArrayAdapter<String> pil9 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert9);
		pil9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal9.setAdapter(pil9);
		soal9.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index9 = soal9.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		ArrayAdapter<String> pil10 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, pert10);
		pil10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		soal10.setAdapter(pil10);
		soal10.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				index10 = soal10.getSelectedItemPosition();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}

	public void hitungPoin(View view) {
		int jwb[] = { index, index2, index3, index4, index5, index6, index7,
				index8, index9, index10 };
		int no;

		for (int i = 0; i < kunci.length; i++) {
			if (jwb[i] == 1) {
				jawaban = " A ";
			} else if (jwb[i] == 2) {
				jawaban = " B ";
			} else if (jwb[i] == 3) {
				jawaban = " C ";
			} else if (jwb[i] == 4) {
				jawaban = " D ";
			} else if (jwb[i] == 5) {
				jawaban = " E ";
			} else {
				jawaban = " - ";
			}
			if (kunci[i] == 1) {
				kunciString = "A";
			} else if (kunci[i] == 2) {
				kunciString = "B";
			} else if (kunci[i] == 3) {
				kunciString = "C";
			} else if (kunci[i] == 4) {
				kunciString = "D";
			} else if (kunci[i] == 5) {
				kunciString = "E";
			} else {
				kunciString = "Tidak dijawab";
			}
			if (jwb[i] == kunci[i]) {
				
				mHasil = mHasil + 10;
				// ini buat ganti String tulisan pada output hasil nilai, juga
				// yg di nilai.java juga, ini gabung....
				jawaban1 = jawaban + " =>(Benar)=> " + kunciString + " \n";
			} else {
				// ini buat ganti String tulisan pada output hasil nilai, juga
				// yg di nilai.java juga, ini gabung....
				jawaban1 = jawaban + " =>(Salah)=> " + kunciString + " \n";
			}
			no = i + 1;
			jwaban = jwaban + Integer.toString(no) + ". " + jawaban1;
		}
		Intent nilaisoal = new Intent(this, nilai.class);
		nilaisoal.putExtra("mHasil", mHasil);
		nilaisoal.putExtra("mJwb", jwaban);
		startActivity(nilaisoal);
		finish();

	}

	@Override
	public void onBackPressed() {
		finish();
		System.exit(0);
	}
}
