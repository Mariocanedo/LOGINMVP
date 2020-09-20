package com.example.loginmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;
import com.example.loginmvp.Presenter.LoginPresenter;
import com.example.loginmvp.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    // DECLARACION DE VARIABLES
    private ProgressBar progressbar;
    EditText correo,password;
    Button ingresar;
    // intanciamos declaramos clase
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //inicializamos componentes
        progressbar = findViewById(R.id.progressbar);
        correo =(EditText) findViewById(R.id.correo);
        password= (EditText) findViewById(R.id.password);
        ingresar=(Button) findViewById(R.id.Ingresar);



        //init presenter
        loginPresenter = new LoginPresenter(this);



        // agregamos evento al button
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(correo.getText().toString(),password.getText().toString());
            }
        });



    }

    // HACE VISIBLE
    public void showProgress(){
        progressbar.setVisibility(View.VISIBLE);
    }

    // metodo progresbar
    public void hideProgress(){
        progressbar.setVisibility(View.GONE);
    }

    // añ final implementamos

    @Override
    public void onloginsucess(String message) {

        Toasty.success(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show();
    }


}
