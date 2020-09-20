package com.example.loginmvp.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class USer implements IUser{

    // 4.- Generamos Constructor desde code
    public USer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //3 .-Declaramos las variables
    private String email, password;




    // 5. return valores
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        //6.-
        // 1.-checkeamos imail is Empty , no tiene contenido cero, en blanco
        // 2.-check Email is matches pattern
        // 3.- Check password length >6
// matcher comparador
        if (TextUtils.isEmpty(getEmail()) || (TextUtils.isEmpty(getPassword())))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() <= 6)
            return 2;
        else
            return -1;

    }
}
