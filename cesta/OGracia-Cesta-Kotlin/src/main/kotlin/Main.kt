import factories.ProductoFactory
import models.*

fun main(){
    val ourBBDDUsers = BBDDUsuarios("Usuarios")
    val listaProductos = Array(100){ProductoFactory.getInstance().createProductoRandom()}
    var hojaPrint = 0
    ourBBDDUsers.getRandomBBDD()
    var currentUserPossitionInArray:Int = 0
    var isUserLogged = false
    var userReply:String
    ourBBDDUsers.arraytoString()
    do{
        RegexyMensajes.getInstance().printMensajeMenuLog(RegexyMensajes.getInstance().mensajeMenuLog)
        userReply = getUserAnswer(RegexyMensajes.getInstance().mensajeChoiceOption,
                                  RegexyMensajes.getInstance().regex12)
        when(userReply){
            "1"->{currentUserPossitionInArray = getUserLog(ourBBDDUsers)
              if(currentUserPossitionInArray!=-1)isUserLogged=true}
            "2"->{ val newUser:Usuario = getNewUser(ourBBDDUsers)
                  ourBBDDUsers.addNewUser(newUser)
            }
        }
    }while(!isUserLogged)

    RegexyMensajes.getInstance()
        .printMensajeWelcome(ourBBDDUsers.getListaUsuarios()[currentUserPossitionInArray].nombre)
    var cestaUser = Cesta(ourBBDDUsers.getListaUsuarios()[currentUserPossitionInArray])
    RegexyMensajes.getInstance().printListaProductos(listaProductos,hojaPrint)

    do{
        println("")
        println("")
        println("||__________________________||")
        println("||    Elige una Opción:     ||")
        println("||__________________________||")
        println("|   1.-Añadir Cesta          |")
        println("|   2.-Siguiente Pag         |")
        println("|   3.-Volver Pag            |")
        println("|   4.-Ver Cesta             |")
        println("|   5.-Borrar articulo       |")
        println("|   S.-Salir                 |")
        println("||___________________________||")
        userReply= getUserAnswer(RegexyMensajes.getInstance().mensajeChoiceOption,
                                 RegexyMensajes.getInstance().regexMenu09S)
        when(userReply){
            "1"-> {cestaUser=addCesta(cestaUser,listaProductos,hojaPrint)
                RegexyMensajes.getInstance().printListaProductos(listaProductos,hojaPrint)}
            "2"->{ if(hojaPrint>=9) println("Lo siento esta es la ultima pagina")
                else{hojaPrint+=1
                RegexyMensajes.getInstance().printListaProductos(listaProductos,hojaPrint)}}
            "3"->{if(hojaPrint<=0) println("Lo siento esta es la primera pagina")
            else{hojaPrint-=1
                RegexyMensajes.getInstance().printListaProductos(listaProductos,hojaPrint)}}
            "4"-> cestaUser.printCesta()
            "5"-> cestaUser=deteteCesta(cestaUser,listaProductos)

       }

    }while (userReply!="S")

}

fun deteteCesta(cestaUser: Cesta, listaProductos: Array<Producto>): Cesta {
    cestaUser.printCesta()
    val userlocalAnswer = getUserAnswer(RegexyMensajes.getInstance().mensajeBorrarCesta,
        RegexyMensajes.getInstance().regex120).toInt()-1
    if(cestaUser.lineasProductos[userlocalAnswer].producto.nombre=="")
        println(RegexyMensajes.getInstance().mensajeErrorPosicionVacia)
    else {
        val userCantidad = getUserAnswer(
            RegexyMensajes.getInstance().mensajeChoiceCantidadDelete,
            RegexyMensajes.getInstance().regexMenu110
        ).toInt()
        cestaUser.lineasProductos[userlocalAnswer].cantidadEnCesta -= userCantidad
        if (cestaUser.lineasProductos[userlocalAnswer].cantidadEnCesta <= 0) {
            cestaUser.lineasProductos[userlocalAnswer].producto=Producto("",0)
            cestaUser.ordenarCesta()
        }
    }
    return  cestaUser
}

fun addCesta(cestaUser: Cesta, listaProductos: Array<Producto>, hojaPrint: Int): Cesta {
    var lineaLibre = -1
    for(i in cestaUser.lineasProductos.indices){
        if(cestaUser.lineasProductos[i].producto.nombre==""){
            lineaLibre = i
            break
        }
    }

    val userlocalAnswer = getUserAnswer(RegexyMensajes.getInstance().mensajeagregarCesta,
    RegexyMensajes.getInstance().regexMenu19).toInt()
    val userCantidad = getUserAnswer(RegexyMensajes.getInstance().mensajeChoiceCantidad,
    RegexyMensajes.getInstance().regexMenu110).toInt()
    var lineaOcupada= -1
    for(i in cestaUser.lineasProductos.indices){
        if(cestaUser.lineasProductos[i].producto.nombre==listaProductos[userlocalAnswer-1+(10*hojaPrint)].nombre){
            lineaOcupada = i
            break
    }}

    if(lineaOcupada>=0) {
        cestaUser.lineasProductos[lineaOcupada].cantidadEnCesta += userCantidad
        cestaUser.lineasProductos[lineaOcupada].checkMax()
    }else if (lineaLibre > -1) {
            cestaUser.lineasProductos[lineaLibre].producto =
                listaProductos[userlocalAnswer - 1 + (10 * hojaPrint)]
            cestaUser.lineasProductos[lineaLibre].cantidadEnCesta += userCantidad
            cestaUser.lineasProductos[lineaLibre].checkMax()
    }else println("Cesta Llena ")

    return  cestaUser
}


/**
 * Funcion modelo peticion de informacion usuario Necesita mensaje y Regex de RegexMensajes class
 */
fun getUserAnswer(mensaje:String,regex:Regex): String {
    var localUserReply:String
    var isValidReply = false
    println(mensaje)
    do {
        print(RegexyMensajes.getInstance().mensajeEspacioRespuesta)
        localUserReply = readln().trim()
        if (!regex.matches(localUserReply)){ println("Error") }
        else{
            isValidReply = true
        }
    }while(!isValidReply)
    return localUserReply
}
/**
 * Funcion que loga al usuario Retorna posicion en array ourBBDDUsers
 */
fun getUserLog(ourBBDDUsers: BBDDUsuarios): Int {
    var localUserReply:String
    var isReplyCorrect = false
    var posicionEnArrayUser = -1
do {
    localUserReply = getUserAnswer(RegexyMensajes.getInstance().mensajeIntroduceNombre,
                                   RegexyMensajes.getInstance().regexNombreYPaswword)
    for (i in ourBBDDUsers.getListaUsuarios().indices) {
        if (ourBBDDUsers.getListaUsuarios()[i].nombre == localUserReply) {
            posicionEnArrayUser= i
            isReplyCorrect=true
        }
    }
}while(!isReplyCorrect)
     isReplyCorrect = false
    var contadorfallos = 3
    do {
        localUserReply = getUserAnswer(RegexyMensajes.getInstance().mensajeIntroducePassword,
                                       RegexyMensajes.getInstance().regexNombreYPaswword)
        val isPassword= ourBBDDUsers.getListaUsuarios()[posicionEnArrayUser].isPassword(localUserReply)
        if(isPassword) isReplyCorrect=true
             else{
            contadorfallos-=1
            println("Error Password incorrecta te quedan $contadorfallos intentos.")

            }
    }while(!isReplyCorrect&&contadorfallos!=0)
    if(contadorfallos==0){
        println(RegexyMensajes.getInstance().mensajeCuentaBlock)
        return -1
    }
    return posicionEnArrayUser
}
/**
 * Funcion que pide todos los valores nuevos a usuario
 */
fun getNewUser(ourBBDDUsers: BBDDUsuarios): Usuario {
    println("")
    var isValidName = false
    var isOriginalName = true
    var nombre:String
    do{
        nombre = getUserAnswer(RegexyMensajes.getInstance().mensajeNewUsuarioNombre,
                                   RegexyMensajes.getInstance().regexNombreYPaswword)
        for(i in ourBBDDUsers.getListaUsuarios().indices){
            if(ourBBDDUsers.getListaUsuarios()[i].nombre==nombre) isOriginalName = false
        }
        if(!isOriginalName){
            println("Nombre ya registrado")
            isOriginalName = true}
            else{
                isValidName = true
            }
    }while(!isValidName)
    val correo = getUserAnswer(RegexyMensajes.getInstance().mensajeIntroduceCorreo,
                               RegexyMensajes.getInstance().regexEmail)
    val dni = getUserAnswer(RegexyMensajes.getInstance().mensajeIntroduceDNI,
                            RegexyMensajes.getInstance().regexDNI)
    val password = getUserAnswer(RegexyMensajes.getInstance().mensajeIntroducePassword,
                                 RegexyMensajes.getInstance().regexNombreYPaswword)
    return Usuario(nombre,password,correo,dni)
}