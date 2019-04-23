//https://www.geogebra.org/m/ptHaMUwP
// Algoritmo tomado de: https://www.ecured.cu/Algoritmo_de_ordenamiento_por_selecci%C3%B3n

var tamanioR;
var arregloRadix = [];
function iniciarRadix() {

    var vector = [];

    tamanioR = document.getElementById('entradaRadix').value;
    if (tamanioR <= 0 || tamanioR == "") {
        alert('expresion no valida');
    } else {
        vector = generarArreglo(tamanioR, 'vectorGeneradoR');

        ordenarPorRadixCasoNormal(vector);
        ordenarPorRadixMejorcaso(arregloRadix);
        ordenarPorRadixPeorcaso(arregloRadix);
        calculoPeorCasoR();
        calculoCasoNormalR();
        calculoMejorCasoR();

        var arregloOrdenado = document.getElementById('arregloOrdenadoR');
        arregloOrdenado.innerHTML = arregloRadix;
    }
}

//--------- Funciones de ordenamiento-------

function ordenarPorRadix(arreglo) {
    var contador = 0;
    let maxValue = arreglo[0]
    contador += 4;
    for (let i = 1; i < arreglo.length; i++) {
        if (arreglo[i] > maxValue) {
            maxValue = arreglo[i]
            contador += 4;
        }
        contador += 2;
    }
    const iterationCount = maxValue.toString().length
    contador += 1;
    for (let digit = 0; digit < iterationCount; digit++) {
        const bucketArray = Array.from({ length: 10 }, () => [])
        for (let i = 0; i < arreglo.length; i++) {
            const digitValue = Math.floor(arreglo[i] / Math.pow(10, digit)) % 10
            bucketArray[digitValue].push(arreglo[i])
            contador += 11;
        }
        arreglo = [].concat(...bucketArray)
        arregloRadix = arreglo;
        contador += 10;
    }
    contador += 2;
    return contador;
}

//caso real(menor a mayor)
function ordenarPorRadixCasoNormal(vector) {

    var contadorCasoNormal = ordenarPorRadix(vector);
    var prueba = document.getElementById('resultadoCNRC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}

//mejor caso (ya esta ordenado)
function ordenarPorRadixMejorcaso(arreglo) {

    var contadorMejorcaso = ordenarPorRadix(arreglo);
    var prueba = document.getElementById('resultadoMCRC');
    prueba.innerHTML = contadorMejorcaso;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)
function ordenarPorRadixPeorcaso(arreglo) {

    var contadorPeorCaso = ordenarPorRadix(arreglo.reverse());
    //contadorPeorCaso = calculoPeorCasoR();
    var prueba = document.getElementById('resultadoPCRC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;
}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante la funcion---

function calculoPeorCasoR() {
    var calculo = (2.4 * Math.pow(tamanioR, 2) + (16 * tamanioR) - 44); //
    var prueba = document.getElementById('resultadoPCRF');
    prueba.innerHTML = calculo;
    return calculo
}

function calculoCasoNormalR() {

    var calculo = (2.45 * Math.pow(tamanioR, 2) + 10.75 * tamanioR - 24.5);
    var prueba = document.getElementById('resultadoCNRF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoMejorCasoR() {
    var calculo = (2.5 * Math.pow(tamanioR, 2) + 5.5 * tamanioR - 5);
    var prueba = document.getElementById('resultadoMCRF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarRadix() {
    graficar(generarDatosRadix(), 'graficaRadix');
}