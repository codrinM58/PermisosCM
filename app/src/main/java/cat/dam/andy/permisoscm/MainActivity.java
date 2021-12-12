package cat.dam.andy.permisoscm;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int CODE1 = 200;
    int CODE2 = 200;
    Button cam, emm;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cam = (Button) findViewById(R.id.cam);
        emm = (Button) findViewById(R.id.emm);
        cam.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                camara();
            }
        });
        emm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emmagatzematge();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void camara() {
        int permis = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permis == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permis de la camara concedit", Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, CODE1);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void emmagatzematge() {
        int permis = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permis == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permis de la emmagatzematge concedit", Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, CODE2);
        }
    }
}
