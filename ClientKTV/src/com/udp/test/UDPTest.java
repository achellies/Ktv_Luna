package com.udp.test;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UDPTest extends Activity implements OnClickListener {
	private Button send_btn;
	private EditText code_etxt, ip_etxt, port_etxt;
	private TextView result_txt;
	String code_etxt_str = "";
	String ip_etxt_str = "";
	String port_etxt_str = "";
	String result_data = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		send_btn = (Button) findViewById(R.id.send_btn);
		send_btn.setOnClickListener(this);

		code_etxt = (EditText) findViewById(R.id.code_etxt);// 指令
		ip_etxt = (EditText) findViewById(R.id.ip_etxt);// IP地址
		port_etxt = (EditText) findViewById(R.id.port_etxt);// 端口号
		result_txt = (TextView) findViewById(R.id.result_txt);// 反馈结果
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.send_btn:
			code_etxt_str = code_etxt.getText().toString();
			ip_etxt_str = ip_etxt.getText().toString();
			port_etxt_str = port_etxt.getText().toString();
			if (code_etxt_str.equals("")) {
				Toast.makeText(getApplicationContext(), "指令不可为空",
						Toast.LENGTH_SHORT).show();
			} else if (ip_etxt_str.equals("")) {
				Toast.makeText(getApplicationContext(), "IP不可为空",
						Toast.LENGTH_SHORT).show();
			} else if (port_etxt_str.equals("")) {
				Toast.makeText(getApplicationContext(), "端口号不可为空",
						Toast.LENGTH_SHORT).show();
			} else {
				new Thread(downloadRun).start();
				result_txt.setText(result_data);
			}
		}
	}

	Runnable downloadRun = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			SendCode();
		}
	};

	/**
	 * 发送指令
	 */
	private void SendCode() {
		// TODO Auto-generated method stub
		try {
			UDPClient UDPClient_o = new UDPClient();
			result_data = UDPClient_o.send_msg(code_etxt_str, ip_etxt_str,
					Integer.valueOf(port_etxt_str));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}