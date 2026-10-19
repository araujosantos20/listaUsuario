package com.example.listausuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.listausuario.model.Usuario;
import com.example.listausuario.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private ConnectionFactory conexao;
    private SQLiteDatabase banco;
    public UsuarioDAO(Context context){
//ConnectionFactory com o banco de dados
        conexao = new ConnectionFactory(context, "banco.db", null, 1);
        banco = conexao.getWritableDatabase();
    }

    // Inserir
    public long insert(Usuario usuario) {
        ContentValues values = new ContentValues();// Vai avaliar os itens inseridos
        values.put("nome", usuario.getNome());
        values.put("cpf", usuario.getCpf());
        values.put("telefone", usuario.getTelefone());
        return (banco.insert("usuario", null, values));
    }

    // Alterar
    public void update(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("cpf", usuario.getCpf());
        values.put("telefone", usuario.getTelefone());
        String args[] = {usuario.getId().toString()};
        banco.update("usuario", values,"id=?",args);
    }

    //Excluir
    public void delete(Usuario usuario){
        String args[] = {usuario.getId().toString()};
        banco.delete("usuario","id=?",args);
    }

    public List<Usuario> obterTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = banco.query("usuario", new String[]{"id", "nome", "cpf",
                        "telefone"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Usuario u = new Usuario();
            u.setId(cursor.getInt(0));
            u.setNome((cursor.getString(1)));
            u.setCpf((cursor.getString(2)));
            u.setTelefone((cursor.getString(3)));
            usuarios.add(u);
        }
        return usuarios;
    }

    // Consultar
    public Usuario read(Integer id) {
        String args[] = {String.valueOf(id)};
        Cursor cursor = banco.query("usuario", new String[]{"id", "nome", "cpf", "telefone"},
                "id=?", args, null, null, null);
        cursor.moveToFirst();
        Usuario usuario = new Usuario();
        if(cursor.getCount() > 0){
            usuario.setId(cursor.getInt(0));
            usuario.setNome((cursor.getString(1)));
            usuario.setCpf((cursor.getString(2)));
            usuario.setTelefone((cursor.getString(3)));
        }
        return usuario;
    }
}
