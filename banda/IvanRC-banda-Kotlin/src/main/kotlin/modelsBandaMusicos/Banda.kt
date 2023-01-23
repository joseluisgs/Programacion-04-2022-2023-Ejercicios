package modelsBandaMusicos

import factoryMusicosBanda.FactoryMusicos

class Banda(val numeroDeMusicos: Int) {

    val arrayMusicos: Array<Musico?> = Array<Musico?>(numeroDeMusicos){FactoryMusicos.getInstance()!!.createMusicoRandom()}

    /**
     * función que sirve para contar el número de trompetistas en el array
     * @return el numero de trompetistas en el array
     */
    fun contarTrompetistas(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Trompetista) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de cantantes en el array
     * @return el numero de cantantes en el array
     */
    fun contarCantantes(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Cantante) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de guitarristas en el array
     * @return el numero de guitarristas en el array
     */
    fun contarGuitarristas(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Guitarrista) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de bajista en el array
     * @return el numero de bajista en el array
     */
    fun contarBajistas(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Bajista) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de teclistas en el array
     * @return el numero de teclistas en el array
     */
    fun contarTeclistas(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Teclista) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de percusionista en el array
     * @return el numero de percusionista en el array
     */
    fun contarPercusionistas(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Percusionista) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de cantantesGuitarristas en el array
     * @return el numero de cantantesGuitarristas en el array
     */
    fun contarCantantesGuitarristas(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is CantanteGuitarrista) contador++
        }
        return contador
    }

    /**
     * función que sirve para contar el número de multinstrumentalista en el array
     * @return el numero de multinstrumentalista en el array
     */
    fun contarMultinstrumentales(): Int{
        var contador = 0
        for(i in arrayMusicos){
            if(i is Multinstrumental) contador++
        }
        return contador
    }

    /**
     * función que permite calcular el salario total
     * @return el salario total
     */
    fun hallarSalarioTotal(): Double{
        var salario = 0.0
        for(i in arrayMusicos){
            when(i){
                is Trompetista -> salario += i.recalcularSalario(i.salario)
                is Cantante -> salario += i.recalcularSalario(i.salario)
                is Guitarrista -> salario += i.recalcularSalario(i.salario)
                is Bajista -> salario += i.recalcularSalario(i.salario)
                is Teclista -> salario += i.recalcularSalario(i.salario)
                is Percusionista -> salario += i.recalcularSalario(i.salario)
                is CantanteGuitarrista -> salario += i.recalcularSalario(i.salario)
                is Multinstrumental -> salario += i.recalcularSalario(i.salario)
            }
        }
        return salario
    }

    /**
     * función que sirve para mostrar todos los musicos que hay en el array y de que tipo son
     */
    fun representarMusicosEnBanda(){
        for(i in arrayMusicos){
            when(i){
                is Trompetista -> println("Soy un Trompetista")
                is Cantante -> println("Soy un Cantante")
                is Guitarrista -> println("Soy un Guitarrista")
                is Bajista -> println("Soy un Bajista")
                is Teclista -> println("Soy un Teclista")
                is Percusionista -> println("Soy un Percusionista")
                is CantanteGuitarrista -> println("Soy un CantanteGuitarrista")
                is Multinstrumental -> println("Soy un Multinstrumental")
            }
        }
    }
}