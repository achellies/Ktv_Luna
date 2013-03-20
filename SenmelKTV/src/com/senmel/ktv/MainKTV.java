package com.senmel.ktv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.zxing.activity.CaptureActivity;

public class MainKTV extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button scanBarCodeButton = (Button) findViewById(R.id.barceode_scan);
		scanBarCodeButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 打开扫描界面扫描条形码或二维码
				Intent openCameraIntent = new Intent(MainKTV.this,
						CaptureActivity.class);
				startActivityForResult(openCameraIntent, 0);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 处理扫描结果（在界面上显示）
		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			TextView result_scan = (TextView) findViewById(R.id.result_scan);
			result_scan.setText(scanResult);
		}
	}
}
