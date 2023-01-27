package org.example.models;

import java.time.LocalDate;

public class Factura {
    final int id = count++;
    private static int count = 0;
    private final ItemFactura[] items = new ItemFactura[20];
    private String usuario;
    private LocalDate dateCreated;

    public Factura(String usuario) {
        if (usuario == null || usuario.isEmpty())
            throw new IllegalArgumentException("El usuario no puede ser nulo o vacío");
        setUsuario(usuario);
        dateCreated = LocalDate.now();
    }

    //region Getters
    public int getId() {
        return id;
    }
    public String getUsuario() {
        return usuario;
    }
    public LocalDate getDateCreated() {
        return dateCreated;
    }
    //endregion
    //region Setters
    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty())
            throw new IllegalArgumentException("El usuario no puede ser nulo o vacío");
        this.usuario = usuario;
    }
    //endregion
    //region CRUD
    //region Add
    public ItemFactura addItem(ItemFactura newItem){
        int index = findIndexByItem(newItem);
        if (index != -1){
            items[index].setCantidad(items[index].getCantidad() + 1);
            return items[index];
        }

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null){
                items[i] = newItem;
                return items[i];
            }
        }
        return null;
    }
    //endregion
    //region Remove
    public ItemFactura removeItem(int Index){
        if (Index < 0 || Index >= items.length)
            throw new IllegalArgumentException("El índice no puede ser menor a 0 o mayor a " + (items.length - 1));
        if (items[Index] == null) return null;
        ItemFactura item = items[Index];
        items[Index] = null;
        return item;
    }

    public ItemFactura removeItem(ItemFactura item){
        int index = findIndexByItem(item);
        if (index == -1) return null;
        return removeItem(index);
    }
    //endregion
    //region Update
    public ItemFactura updateItem(int Index, ItemFactura newItem){
        if (Index < 0 || Index >= items.length)
            throw new IllegalArgumentException("El índice no puede ser menor a 0 o mayor a " + (items.length - 1));
        if (items[Index] == null) return null;
        ItemFactura item = items[Index];
        items[Index] = newItem;
        return item;
    }

    public ItemFactura updateItem(ItemFactura item, ItemFactura newItem){
        int index = findIndexByItem(item);
        if (index == -1) return null;
        return updateItem(index, newItem);
    }
    //endregion
    //region Find
    public int findIndexByItem(ItemFactura item){
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item){
                return i;
            }
        }
        return -1;
    }
    public ItemFactura findItem(int Index){
        if (Index < 0 || Index >= items.length)
            throw new IllegalArgumentException("El índice no puede ser menor a 0 o mayor a " + (items.length - 1));
        return items[Index];
    }
    public ItemFactura findItem(String name){
        for (ItemFactura item : items) {
            if (item != null && item.getProducto().getNombre().equals(name)){
                return item;
            }
        }
        return null;
    }
    //endregion
    //endregion
}
