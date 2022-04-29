package com.example.android.week1appwb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.week1appwb.data.ServiceExample;

/* Этот экран - активти, которая демонстрирует работу такого комопнента как Service. На этом экране
* находится информация о примере использования сервиса и две кнопки для его демонстрации. При запуске
* сервиса включается музыка, которая играет в фоне и можно параллельно взаимодействовать с другими
* активити этого приложения, или же с другими приложениями вовсе. Музыка будет играть до тех пор,
*  пока приложение или сервис не будет остановлен.
*
* Примеры приложений, где используется Service - YouTube Music (музыка играет в любой момент времени),
* Twitch (функция картинка в картинке, можно читать ленту новостей и параллельно смотреть стрим в углу экрана).*/

public class ServiceExampleActivity extends AppCompatActivity {

    private Button serviceStartButton, serviceStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        initialization();
        startService();
        stopService();
    }

    private void initialization() {
        serviceStartButton = findViewById(R.id.serviceStartButton);
        serviceStopButton = findViewById(R.id.serviceStopButton);
    }

    private void startService() {
        serviceStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), ServiceExample.class));
            }
        });
    }

    private void stopService() {
        serviceStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), ServiceExample.class));
            }
        });
    }
}