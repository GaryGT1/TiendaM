package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
// se definen los 4 metodos de un CRUD
//Create Read Update Delete

    //Retorna la lista de articulos
    public List<Articulo> getArticulos(boolean activos);

//Dado un  articulo.id se busca en la tabla 
//y se retorna todo el objeto articulo
    public Articulo getArticulo(Articulo articulo);

//Si el articulo.id tiene un valor se busca y se actualiza
//Si el articulo.id no tiene valor, se inserta el objeto en la tabla
    public void save(Articulo articulo);

//elimina el registro que tiene el id igual a articulo.id
    public void delete(Articulo articulo);
}
