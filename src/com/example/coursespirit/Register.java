package com.example.coursespirit;

import com.example.coursespirit.db.UserBean;
import com.example.coursespirit.util.ToastUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class Register extends Activity implements OnClickListener {
	private static final String BMOB_APPLICATION_ID = "08a83f2371f73387e6ff9ee27097c9ec";
	private Button registerBtn;
	private EditText loginEt, registerEt, passwordEt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Bmob.initialize(this, BMOB_APPLICATION_ID);
		initView();
	}
	private void initView() {
		registerBtn = (Button) this.findViewById(R.id.id_register_btn);
		loginEt = (EditText) this.findViewById(R.id.id_login_name_et);
		registerEt = (EditText) this.findViewById(R.id.id_register_name_et);
		passwordEt = (EditText) this.findViewById(R.id.id_password_et);

		registerBtn.setOnClickListener(this);
	}
	
	private void register() {
		String loginId = loginEt.getText().toString();
		String userName = registerEt.getText().toString();
		String password = passwordEt.getText().toString();
		if (loginId.isEmpty() || password.isEmpty() || userName.isEmpty()) {
			ToastUtils.toast(this, "账号或昵称或密码不能为空!!");
			return;
		}

		final UserBean userBean = new UserBean();
		userBean.setLoginId(loginId);
		userBean.setPassword(password);
		userBean.setUserName(userName);
		/**
		 * 保存数据到Bmob服务器
		 */
		userBean.save(this, new SaveListener() {

			@Override
			public void onSuccess() {
				ToastUtils.toast(Register.this, userBean.toString() + " 注册成功");
				finish();
			}

			@Override
			public void onFailure(int arg0, String arg1) {
				ToastUtils.toast(Register.this, arg0 + "," + arg1 + " 注册失败");
			}
		});

	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_register_btn:
			register();
			break;
		}
	}


}
