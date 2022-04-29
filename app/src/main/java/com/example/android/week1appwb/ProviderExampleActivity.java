package com.example.android.week1appwb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.week1appwb.provider.MemberCursorAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.android.week1appwb.provider.MembersContract.MemberEntry;

/* Этот экран - активти, которая демонстрирует работу такого комопнента как Content Provider. На этом экране
 * находится информация о примере использования Content Provider и интуитивно понятный интерфейс для работы с
 * базой данных. Можно добавлять, редактировать и удалять данные из базы. Весь этот функционал беспечивает
 * Content Provider.
 *
 * Примеры приложений, где используется Content Provider - мессенджеры (Telegram, WhatsApp и тд - получают
 * доступ к спискам контактов, которые хранятся в телефоне)*/

public class ProviderExampleActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks {

    private static final int MEMBER_LOADER = 123;
    private MemberCursorAdapter memberCursorAdapter;
    private ListView dataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_example);

        dataListView = findViewById(R.id.dataListView);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMemberActivity.class);
                startActivity(intent);
            }
        });

        memberCursorAdapter = new MemberCursorAdapter(this, null, false);
        dataListView.setAdapter(memberCursorAdapter);

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AddMemberActivity.class);
                Uri currentMemberUri = ContentUris.withAppendedId(MemberEntry.CONTENT_URI, id);
                intent.setData(currentMemberUri);
                startActivity(intent);
            }
        });

        getSupportLoaderManager().initLoader(MEMBER_LOADER, null, this);
    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String[] projection = {
                MemberEntry._ID,
                MemberEntry.COLUMN_FIRST_NAME,
                MemberEntry.COLUMN_LAST_NAME,
        };
        return new CursorLoader(this, MemberEntry.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, Object data) {
        memberCursorAdapter.swapCursor((Cursor) data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {
        memberCursorAdapter.swapCursor(null);
    }
}