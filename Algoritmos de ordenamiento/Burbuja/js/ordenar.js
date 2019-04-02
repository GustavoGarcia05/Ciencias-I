


var tamanio;
function iniciarBurbuja() {

    var vector = [];

    tamanio = document.getElementById('entradaBurbuja').value;
    if (tamanio <= 0 || tamanio == "") {
        alert('expresion no valida');
    } else {
        vector = generarArreglo(tamanio, 'vectorGeneradoB');

        ordenarPorBurbujaCasoNormal(vector);
        ordenarPorBurbujaMejorcaso(vector);
        ordenarPorBurbujaPeorcaso(vector);
        calculoPeorCaso();
        calculoCasoNormal();
        calculoMejorCaso();



        var arregloOrdenado = document.getElementById('arregloOrdenadoB');
        arregloOrdenado.innerHTML = vector;

    }

}



//--------- Funciones de ordenamiento-------

function ordenarPorBurbuja(arreglo) {
    var contador = 0;

    for (i = 0; i < tamanio - 1; i++) {
        contador += 3;
        for (j = i + 1; j < tamanio; j++) {
            contador += 5;
            if (arreglo[i] >= arreglo[j]) {
                temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
                contador += 7;


            } contador += 1;
        } contador += 1;

    } contador += 2;

    return contador;
}

//caso real(menor a mayor)
function ordenarPorBurbujaCasoNormal(vector) {
    var contadorCasoNormal = ordenarPorBurbuja(vector);

    var prueba = document.getElementById('resultadoCNBC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}



//mejor caso (ya esta ordenado)
function ordenarPorBurbujaMejorcaso(arreglo) {
    var contadorMejorcaso = ordenarPorBurbuja(arreglo);

    var prueba = document.getElementById('resultadoMCBC');
    prueba.innerHTML = contadorMejorcaso;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)

function ordenarPorBurbujaPeorcaso(arreglo) {

    var contadorPeorCaso = ordenarPorBurbuja(arreglo.reverse());

    var prueba = document.getElementById('resultadoPCBC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;

}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante la funcion---

function calculoPeorCaso() {
    var calculo = 6 * (Math.pow(tamanio, 2)) - 3;
    var prueba = document.getElementById('resultadoPCBF');
    prueba.innerHTML = calculo;
    return calculo
}

function calculoCasoNormal() {

    var calculo = (17 * (Math.pow(tamanio, 2)) + (7 * tamanio) - 12) / 4;
    var prueba = document.getElementById('resultadoCNBF');
    prueba.innerHTML = calculo;
    return calculo;

}

function calculoMejorCaso() {
    var calculo = (5 * (Math.pow(tamanio, 2)) + (7 * tamanio) - 6) / 2;
    var prueba = document.getElementById('resultadoMCBF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarBurbuja(){
    graficar(generarDatosBurbuja(),'graficaBurbuja');
}