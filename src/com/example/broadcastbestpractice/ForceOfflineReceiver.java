package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;

public class ForceOfflineReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, Intent intent) {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("Warning");
		dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(context, "success dfaseae ", Toast.LENGTH_SHORT).show();
				ActivityCollector.finishAll(); // 销毁所有活动
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent); // 重新启动LoginActivity
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		// 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}
	
//	@Override
//	public void onReceive(Context context, Intent intent) {
//		// TODO Auto-generated method stub
//		Toast.makeText(context,"afaeaefawef",Toast.LENGTH_SHORT).show();
//		
//	}

}
