package org.jay.basedemo;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.jay.baselib.helper.PermissionHelper;

public class HelperActivity extends AppCompatActivity {
    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);
        requestPermissions();

    }

    //1
    private void requestPermissions() {
        PermissionHelper
                .with(this)
                .permissions(PERMISSIONS)
                .CallBack(new PermissionHelper.OnPermissionRequestListener() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(HelperActivity.this, "permission granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied() {
                        PermissionHelper.showDeniedTipDialog(HelperActivity.this);
                        Toast.makeText(HelperActivity.this, "permission denied", Toast.LENGTH_SHORT).show();
                    }
                })
                .request();
    }
    //2
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void DeniedPermission(View view) {
        PermissionHelper.goToAppDetailsSetting(this);
    }
}
