package com.example.android.week1appwb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.week1appwb.data.ServiceExample;

/* Этот экран - главная Activity, с помощью любой активити пользователь взаимодействует с приложением.
* Конкретно на этом экране приведены 4 основных компонента Android-приложения. Для каждого компонента
* приведена краткая информация и кнопка, которая показывает функционал определнного компонента.
*
* Примеры приложений, где используется Activity - собственно любое приложение, где пользователь
* взаимодействует с UI или видит перед собой экран (YouTube, Telegram, Twitch и тд).*/

public class MainActivity extends AppCompatActivity {

    private Button activityButton, serviceButton, broadcastReceiverButton, contentProviderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        thisIsActivity();
        goToServiceActivity();
        goToBroadcastReceiverActivity();
        goToContentProviderActivity();
    }

    private void initialization() {
        activityButton = findViewById(R.id.activityButton);
        serviceButton = findViewById(R.id.serviceButton);
        broadcastReceiverButton = findViewById(R.id.broadcastReceiverButton);
        contentProviderButton = findViewById(R.id.contentProviderButton);
    }

    private void thisIsActivity() {
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.this_is_activity, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void goToServiceActivity() {
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ServiceExampleActivity.class));
            }
        });
    }

    private void goToBroadcastReceiverActivity() {
        broadcastReceiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReceiverExampleActivity.class));
            }
        });
    }

    private void goToContentProviderActivity() {
        contentProviderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProviderExampleActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getApplicationContext(), ServiceExample.class));
    }
}