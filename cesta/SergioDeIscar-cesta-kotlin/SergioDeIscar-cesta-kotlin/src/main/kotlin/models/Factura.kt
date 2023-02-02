package factura.models

import java.time.LocalDate

class Factura(private val usuario: String, private val dateCreated: LocalDate) {
    val id = count++
    private val items: Array<ItemFactura?> = Array(20) { null }
    companion object {
        private var count = 0
    }

    constructor(usuario: String, dateCreate: LocalDate, items: Array<ItemFactura>): this(usuario, dateCreate){
        require(items.size in 1..this.items.size)
        for (i in items){
            addItem(i)
        }
    }

    //region CRUD
    // Add
    fun addItem(newItem: ItemFactura): ItemFactura?{
        val index = findIndexByItem(newItem)
        if (index != -1){
            items[index]?.cantidad = items[index]?.cantidad!! + 1
            return items[index]
        }

        for (i in items.indices){
            if (items[i] == null){
                items[i] = newItem
                return newItem
            }
        }
        return null
    }

    // Find
    fun findItem(name: String): ItemFactura?{
        for (i in items.indices){
            if (items[i] != null && items[i]?.item?.nombre == name){
                return items[i]
            }
        }
        return null
    }

    fun findItem(index: Int): ItemFactura?{
        require(index in items.indices)
        return items[index]
    }

    fun findItem(item: ItemFactura): ItemFactura?{
        return findItem(item.item.nombre)
    }

    fun findIndexByItem(item: ItemFactura): Int{
         for (i in items.indices){
             if (items[i] == item){
                 return i
             }
         }
        return -1
    }

    // Update
    fun updateItem(index: Int, newItem: ItemFactura): ItemFactura?{
        require(index in items.indices)
        if(items[index] != null) items[index] = newItem
        return items[index]
    }

    fun updateItem(oldItem: ItemFactura, newItem: ItemFactura): ItemFactura?{
        return updateItem(findIndexByItem(oldItem) ?: -1, newItem)
    }

    // Delete
    fun deleteItem(index: Int): Boolean{
        if (items[index] == null) return false
        items[index] = null
        return true
    }

    fun deleteItem(item: ItemFactura): Boolean{
        return deleteItem(findIndexByItem(item) ?: return false)
    }
    //endregion

    override fun toString(): String {
        val stringBuilder = StringBuilder("Factura ($id): Usuario -> $usuario, Date -> $dateCreated, Items -> ")
        for (i in items.indices){
            if (items[i] != null)
                stringBuilder.append("\n\t${i+1}->\t").append(items[i])
        }
        stringBuilder.append("\n\nValor Total:\t${totalValue()}")
        return stringBuilder.toString()
    }

    private fun totalValue(): Float {
        var count = 0.0f
        for (i in items){
            if (i != null)
                count += i.precioUnitario * i.cantidad
        }
        return count
    }
}