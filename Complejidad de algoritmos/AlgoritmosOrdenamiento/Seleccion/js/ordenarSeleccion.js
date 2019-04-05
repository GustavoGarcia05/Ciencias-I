//https://www.geogebra.org/m/ptHaMUwP
// Algoritmo tomado de: https://www.ecured.cu/Algoritmo_de_ordenamiento_por_selecci%C3%B3n

var tamanioS;
function iniciarSeleccion() {

    var vector = [];

    tamanioS = document.getElementById('entradaSeleccion').value;
    if (tamanioS <= 0 || tamanioS == "") {
        alert('expresion no valida');
    } else {
        vector = generarArreglo(tamanioS, 'vectorGeneradoS');

        ordenarPorSeleccionCasoNormal(vector);
        ordenarPorSeleccionMejorcaso(vector);
        ordenarPorSeleccionPeorcaso(vector);
        calculoPeorCasoS();
        calculoCasoNormalS();
        calculoMejorCasoS();

        var arregloOrdenado = document.getElementById('arregloOrdenadoS');
        arregloOrdenado.innerHTML = vector;
    }
}

//--------- Funciones de ordenamiento-------

function ordenarPorSeleccion(arreglo) {

    var contador = 0;

    contador = 1;
    for (var i = 0; i < tamanioS - 1; i++) {
        contador += 6;
        var min = i;
        for (var j = i + 1; j < tamanioS; j++) {
            contador += 5;
            if (arreglo[j] < arreglo[min]) {

                min = j;
                contador += 1;
            }
        }
        contador += 1;
        contador += 1;
        if (i != min) {
            contador += 7;
            var aux = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = aux;
        }
    }
    contador += 2;

    return contador;
}

//caso real(menor a mayor)
function ordenarPorSeleccionCasoNormal(vector) {

    var contadorCasoNormal = ordenarPorSeleccion(vector);
    var prueba = document.getElementById('resultadoCNSC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}

//mejor caso (ya esta ordenado)
function ordenarPorSeleccionMejorcaso(arreglo) {

    var contadorMejorcaso = ordenarPorSeleccion(arreglo);
    var prueba = document.getElementById('resultadoMCSC');
    prueba.innerHTML = contadorMejorcaso;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)
function ordenarPorSeleccionPeorcaso(arreglo) {

    var contadorPeorCaso = ordenarPorSeleccion(arreglo.reverse());
    contadorPeorCaso = calculoPeorCasoS();
    var prueba = document.getElementById('resultadoPCSC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;
}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante la funcion---

function calculoPeorCasoS() {
    var calculo = (2.4 * Math.pow(tamanioS, 2) + (16 * tamanioS) - 44); //
    var prueba = document.getElementById('resultadoPCSF');
    prueba.innerHTML = calculo;
    return calculo
}

function calculoCasoNormalS() {

    var calculo = (2.45 * Math.pow(tamanioS, 2) + 10.75 * tamanioS - 24.5);
    var prueba = document.getElementById('resultadoCNSF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoMejorCasoS() {
    var calculo = (2.5 * Math.pow(tamanioS, 2) + 5.5 * tamanioS - 5);
    var prueba = document.getElementById('resultadoMCSF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarSeleccion() {
    graficar(generarDatosSeleccion(), 'graficaSeleccion');
}