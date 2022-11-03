package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
// se definen los 4 metodos de un CRUD
//Create Read Update Delete

    //Retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);

//Dado un  categoria.id se busca en la tabla 
//y se retorna todo el objeto categoria
    public Categoria getCategoria(Categoria categoria);

//Si el categoria.id tiene un valor se busca y se actualiza
//Si el categoria.id no tiene valor, se inserta el objeto en la tabla
    public void save(Categoria categoria);

//elimina el registro que tiene el id igual a categoria.id
    public void delete(Categoria categoria);
}
