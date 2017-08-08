package org.jay.basedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToHelper(View view) {
        startActivity(new Intent(this,HelperActivity.class));
    }

    public void goToNetWork(View view) {
        startActivity(new Intent(this,NetWorkActivity.class));
    }

    public void goToUtils(View view) {
        startActivity(new Intent(this,UtilsActivity.class));
    }

    public void goToWidget(View view) {
        startActivity(new Intent(this,WidgetActivity.class));
    }
}
