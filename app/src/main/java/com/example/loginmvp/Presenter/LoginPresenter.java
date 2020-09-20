package com.example.loginmvp.Presenter;
import com.example.loginmvp.View.ILoginView;
import com.example.loginmvp.Model.USer;

public class LoginPresenter implements  ILoginPresenter{


    //intanciamos con la vista
    ILoginView loginView;



    // constructor para comunicar con la vista

   public  LoginPresenter(ILoginView loginView){
       this.loginView =loginView;
   }



    //debemos importar la clase User
    @Override
    public void onLogin(String email, String password) {


        USer user = new USer(email, password);
        int loginCode= user.isValidData();

        if(loginCode ==0)
            loginView.onLoginError("Complete los campos");
        else if(loginCode ==1)
            loginView.onLoginError("Ingrese Correo válido");
        else if(loginCode == 2)
            loginView.onLoginError("La contraseña debe tener mas de 6 números");
        else
            loginView.onloginsucess("Logueado Correctamente");

    }

}
