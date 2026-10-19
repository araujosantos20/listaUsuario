package com.example.listausuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listausuario.dao.UsuarioDAO;
import com.example.listausuario.model.Usuario;

public class telaManutencao extends AppCompatActivity {
    private TextView txvId;
    private TextView txvNome;
    private TextView txvCpf;
    private TextView txvTelefone;
    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtTelefone;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new UsuarioDAO(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_manutencao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txvId = findViewById(R.id.txvId);
        txvNome = findViewById(R.id.txvNome);
        txvCpf = findViewById(R.id.txvCpf);
        txvTelefone = findViewById(R.id.txvTelefone);
        edtNome = findViewById(R.id.edtNome);
        edtCpf = findViewById(R.id.edtCpf);
        edtTelefone = findViewById(R.id.edtTelefone);

        Intent it = getIntent();

        int id = it.getIntExtra("id", 0);
        String nome = it.getStringExtra("nome");
        String cpf = it.getStringExtra("cpf");
        String telefone = it.getStringExtra("telefone");

        txvId.setText("ID: " + id);
        txvNome.setText("Nome: " + nome);
        txvCpf.setText("CPF: " + cpf);
        txvTelefone.setText("Telefone: " + telefone);
    }

    public void excluir(View view) {
        Intent it = getIntent();

        int id = it.getIntExtra("id", 0);
        String nome = it.getStringExtra("nome");
        String cpf = it.getStringExtra("cpf");
        String telefone = it.getStringExtra("telefone");

        Usuario u = new Usuario(id, nome, cpf, telefone);
        dao.delete(u);
        Toast.makeText(getApplicationContext(), "Usuário excluído!", Toast.LENGTH_LONG).show();
        finish();
    }

    public void alterar(View view) {
        Intent it = getIntent();
        String nome;
        String cpf;
        String telefone;

        int id = it.getIntExtra("id", 0);

        if(edtNome.getText().toString().isEmpty()) {
            nome = it.getStringExtra("nome");
        } else {
            nome = edtNome.getText().toString();
        }

        if(edtCpf.getText().toString().isEmpty()) {
            cpf = it.getStringExtra("cpf");
        } else {
            cpf = edtCpf.getText().toString();
        }

        if(edtTelefone.getText().toString().isEmpty()) {
            telefone = it.getStringExtra("telefone");
        } else {
            telefone = edtTelefone.getText().toString();
        }


        Usuario u = new Usuario(id, nome, cpf, telefone);
        dao.update(u);
        Toast.makeText(getApplicationContext(), "Informações alteradas!", Toast.LENGTH_LONG).show();
        finish();
    }

    public void voltar(View view) {
        finish();
    }
}