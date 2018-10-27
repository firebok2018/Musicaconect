package inc.firebok.com.music.activies;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.Authenticator;

import inc.firebok.com.music.MainActivity;
import inc.firebok.com.music.R;

public class SigIn extends AppCompatActivity {


    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;

    private static final int SIGN_IN_CODE=777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);

        signInButton = findViewById(R.id.siginGoogle);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSingInApi.getSignInIntent(googleApiClient);
                startActivity(intent);

            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SING_IN_API, gso)
                .build();


//        public void onConnectionFailed(ConnectionResult connectionResult){
//
//        }
        public void onAcivityResult(int requestCode, int resultCode,Intent data){
            super.onActivityResult(requestCode,resultCode,data);

            if(requestCode==777){
                GoogleSignInResult result= Auth.GoogleSignInApi.getSignResultFromIntent(data);
                handleSingInResult(result);
            }
        }


    }

    private void handleSingInResult(GoogleSignInResult result) {
        if(result.isSucces()){
            goMainScreen();

        }else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    
        }
    }
//https://www.youtube.com/watch?v=O3aemJ9eAAA&t=469s
    private void goMainScreen() {
        Intent intent= new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
