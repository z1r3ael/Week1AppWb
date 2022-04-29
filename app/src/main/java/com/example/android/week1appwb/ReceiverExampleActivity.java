package com.example.android.week1appwb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.example.android.week1appwb.data.ReceiverExample;

/* Этот экран - активти, которая демонстрирует работу такого комопнента как Broadcast Receiver. На этом экране
 * находится информация о примере использования Broadcast Receiver и кнопка для его демонстрации. При
 * нажатии на кнопку открываются настройки языка системы. И при смене языка наш компонент уведомит пользователя
 * с помощью тоста об изменениях в системе.
 *
 * Примеры приложений, где используется Broadcast Receiver - социальные сети (ВК, Instagram и тд. в случае
 * отсутствия соединения с интеренетом, покажут это в приложении.)*/

public class ReceiverExampleActivity extends AppCompatActivity {

    private Button openSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_example);

        openSettingsButton = findViewById(R.id.openSettingsButton);
        openSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
            }
        });
    }
}