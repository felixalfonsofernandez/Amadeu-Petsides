package com.example.registrarse;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;

import android.util.Patterns;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;


import java.util.regex.Pattern;

public class Registrarse extends AppCompatActivity {
    private EditText correo;
    private EditText contraseña;
    private EditText contraseñaConfirmacion;
    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private EditText edad;
    private String correoo;
    private String contraseñaa;
    private String contraseñaConfirmacionn;
    private String nombree;
    private String apellidoo;
    private String telefonoo;
    private String edadd;
    private int edaddd;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);


        correo = findViewById(R.id.editText);
        contraseña = findViewById(R.id.editTextTextPassword);
        contraseñaConfirmacion = findViewById(R.id.contraseñaConfirmacion);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.editTextTextPersonName);
        telefono = findViewById(R.id.textInputPhone);
        edad = findViewById(R.id.editTextEdad);

        next = findViewById(R.id.submit);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });


    }


    public void validar() {
        correoo = correo.getText().toString();
        contraseñaa = contraseña.getText().toString();
        contraseñaConfirmacionn = contraseñaConfirmacion.getText().toString();
        nombree = nombre.getText().toString();
        apellidoo = apellido.getText().toString();
        telefonoo = telefono.getText().toString();
        edadd = edad.getText().toString();
        if(!edadd.isEmpty()){
            edaddd = Integer.parseInt(edadd);
        }
        if (!nombree.isEmpty() && !correoo.isEmpty() && !contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && !telefonoo.isEmpty() && !edadd.isEmpty()) {
            if (nombree.length() >= 2 && nombree.length() <=45) {
                if (isEmailValid(correoo)) {
                    if (contraseñaa.equals(contraseñaConfirmacionn)) {
                        if (apellidoo.length() >= 2 && apellidoo.length()<=60) {
                            if (telefonoo.length() == 9 && telefonoo.charAt(0) == '9') {
                                if (edaddd >= 18 && edaddd <= 75) {
                                    if (contraseñaa.length() >= 6 && contraseñaa.length() <= 30) {
                                        iralla();
                                    } else {
                                        Toast.makeText(this, "La contraseña debe tener entre 6-30 caracteres", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(this, "Usted debe tener entre 18-75 años para acceder a esta aplicación", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "Ingresar correctamente el número de celular", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "El apellido debe tener entre 2-60 caracteres", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Correo inválido", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "El nombre debe tener entre 2-45 caracteres", Toast.LENGTH_SHORT).show();
            }
        } else if (!nombree.isEmpty() && !correoo.isEmpty() && !contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && telefonoo.isEmpty() && !edadd.isEmpty()) {
            if (nombree.length() >= 2 && nombree.length() <=45) {
                if (isEmailValid(correoo)) {
                    if (contraseñaa.equals(contraseñaConfirmacionn)) {
                        if (apellidoo.length() >= 2 && apellidoo.length()<=60) {
                            if (edaddd >= 18 && edaddd <= 75) {
                                if (contraseñaa.length() >= 6 && contraseñaa.length() <= 30) {
                                    iralla();
                                } else {
                                    Toast.makeText(this, "La contraseña debe tener entre 6-30 caracteres", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "Usted debe tener entre 18-75 años para acceder a esta aplicación", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "El apellido debe tener entre 2-60 caracteres", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Las contraseña no coinciden", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Correo inválido", Toast.LENGTH_LONG).show();
                }
            }  else {
                Toast.makeText(this, "El nombre debe tener entre 2-45 caracteres", Toast.LENGTH_SHORT).show();
            }
        } else if (nombree.isEmpty() && !correoo.isEmpty() && !contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && !telefonoo.isEmpty() && !edadd.isEmpty()) {
            Toast.makeText(this, "Ingresar el nombre para registrarse en esta aplicación", Toast.LENGTH_SHORT).show();
        } else if (!nombree.isEmpty() && !correoo.isEmpty() && !contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && apellidoo.isEmpty() && !telefonoo.isEmpty() && !edadd.isEmpty()) {
            Toast.makeText(this, "Ingresar el apellido para registrarse en esta aplicación", Toast.LENGTH_SHORT).show();
        } else if (!nombree.isEmpty() && !correoo.isEmpty() && !contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && !telefonoo.isEmpty() && edadd.isEmpty()) {
            Toast.makeText(this, "Ingresar la edad para registrarse en esta aplicación", Toast.LENGTH_SHORT).show();
        } else if (!nombree.isEmpty() && correoo.isEmpty() && !contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && !telefonoo.isEmpty() && !edadd.isEmpty()) {
            Toast.makeText(this, "Ingresar el correo electrónico para registrarse en esta aplicación", Toast.LENGTH_SHORT).show();
        } else if (!nombree.isEmpty() && !correoo.isEmpty() && contraseñaa.isEmpty() && !contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && !telefonoo.isEmpty() && !edadd.isEmpty()) {
            Toast.makeText(this, "Ingresar la contraseña", Toast.LENGTH_SHORT).show();
        } else if (!nombree.isEmpty() && !correoo.isEmpty() && !contraseñaa.isEmpty() && contraseñaConfirmacionn.isEmpty() && !apellidoo.isEmpty() && !telefonoo.isEmpty() && !edadd.isEmpty()) {
            Toast.makeText(this, "Ingresar nuevamente la contraseña", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Para continuar inserta todos los campos (opcional el telefono)", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isEmailValid(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public void iralla(){
        Intent i = new Intent(this,Interfaz2.class);
        i.putExtra("dato",correo.getText().toString());
        i.putExtra("datob",contraseña.getText().toString());
        i.putExtra("datobb",contraseñaConfirmacion.getText().toString());
        i.putExtra("datobbb",nombre.getText().toString());
        i.putExtra("datobbbb",apellido.getText().toString());
        i.putExtra("datobbbbb",telefono.getText().toString());
        i.putExtra("datobbbbbb",edad.getText().toString());
        startActivity(i);
    }

}