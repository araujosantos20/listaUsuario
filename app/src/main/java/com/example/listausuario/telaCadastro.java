package com.example.listausuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listausuario.dao.UsuarioDAO;
import com.example.listausuario.model.Usuario;

public class telaCadastro extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtTelefone;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new UsuarioDAO(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNome = findViewById(R.id.edtNome);
        edtCpf = findViewById(R.id.edtCpf);
        edtTelefone = findViewById(R.id.edtTelefone);
    }

    public void limpar(View view) {
        edtNome.setText(null);
        edtCpf.setText(null);
        edtTelefone.setText(null);
    }

    public void salvar(View view) {
        String nome = edtNome.getText().toString();
        String cpf = edtCpf.getText().toString();
        String telefone = edtTelefone.getText().toString();

        Usuario u = new Usuario(nome, cpf, telefone);
        dao.insert(u);
        Toast.makeText(getApplicationContext(), "Usuário cadastrado!", Toast.LENGTH_LONG).show();
        finish();
    }

    public void voltar(View view) {
        finish();
    }
}