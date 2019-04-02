function generarArreglo(tamanio,id) {
    var arreglo = [];

    for (i = 0; i < tamanio; i++) {
        arreglo[i] = Math.round(Math.random() * tamanio);

    }
    
    if(id!=""){
        var arregloGenerado = document.getElementById(id);
        arregloGenerado.innerHTML = arreglo;
    }else{
        console.log('no declaraste id o lugar para publicar el resultado');
    }


    return arreglo;
}