package com.example.listausuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listausuario.dao.UsuarioDAO;
import com.example.listausuario.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaUsuarios;
    private List<Usuario> usuarios = new ArrayList<>();
    private UsuarioDAO u;
    private ArrayAdapter<Usuario> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        u = new UsuarioDAO(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaUsuarios = findViewById(R.id.listaUsuarios);

        adapter = new ArrayAdapter<>(
                this,
                R.layout.item_usuario,
                R.id.txtUsuario,
                usuarios
        );

        listaUsuarios.setAdapter(adapter);

        listaUsuarios.setOnItemClickListener((parent, view, position, id) -> {

            Usuario selecionado = usuarios.get(position);

            Intent it = new Intent(this, telaManutencao.class);

            it.putExtra("id", selecionado.getId());
            it.putExtra("nome", selecionado.getNome());
            it.putExtra("cpf", selecionado.getCpf());
            it.putExtra("telefone", selecionado.getTelefone());

            startActivity(it);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        usuarios.clear();
        usuarios.addAll(u.obterTodos());

        adapter.notifyDataSetChanged();
    }

    public void telaCadastro(View view) {
        Intent it = new Intent(this, telaCadastro.class);
        startActivity(it);
    }
}