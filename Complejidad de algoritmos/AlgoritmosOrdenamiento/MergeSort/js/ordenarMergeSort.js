//https://www.geogebra.org/m/ptHaMUwP
// Algoritmo tomado de: https://medium.com/techtrument/implementing-merge-sort-in-javascript-898d5f54a234

var tamanioM;
function iniciarMergeSort() {

    var vector = [];

    tamanioM = document.getElementById('entradaMergeSort').value;
    if (tamanioM <= 0 || tamanioM == "") {
        alert('expresion no valida');
    } else {
        vector = generarArreglo(tamanioM, 'vectorGeneradoM');

        ordenarPorMergeSortCasoNormal(vector);
        ordenarPorMergeSortMejorcaso(vector);
        ordenarPorMergeSortPeorcaso(vector);
        calculoPeorCasoM();
        calculoCasoNormalM();
        calculoMejorCasoM();

        var arregloOrdenado = document.getElementById('arregloOrdenadoM');
        arregloOrdenado.innerHTML = vector.sort((a, b) => a - b);
    }
}

//--------- Funciones de ordenamiento-------
var cont = 0;
function merge(leftArr, rightArr) {
    var sortedArr = [];
    cont += 1;
    while (leftArr.length && rightArr.length) {
        cont += 2;
        if (leftArr[0] <= rightArr[0]) {
            cont += 4;
            sortedArr.push(leftArr[0]);
            leftArr = leftArr.slice(1)
        } else {
            cont += 4;
            sortedArr.push(rightArr[0]);
            rightArr = rightArr.slice(1)
        }
    }
    cont += 1;
    while (leftArr.length) {
        cont += 1;
        sortedArr.push(leftArr.shift());
    }
    cont += 1;
    while (rightArr.length) {
        cont += 1;
        sortedArr.push(rightArr.shift());
    }
    return sortedArr;
}
function mergesort(arr) {
    cont += 1;
    if (arr.length < 2) {
        return cont;
    } else {
        cont += 7;
        var midpoint = parseInt(arr.length / 2);
        var leftArr = arr.slice(0, midpoint);
        var rightArr = arr.slice(midpoint, arr.length);
        merge(mergesort(leftArr), mergesort(rightArr));
        return cont;
    }
}

//caso real(menor a mayor)
function ordenarPorMergeSortCasoNormal(vector) {

    var contadorCasoNormal = mergesort(vector);
    var prueba = document.getElementById('resultadoCNMC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}

//mejor caso (ya esta ordenado)
function ordenarPorMergeSortMejorcaso(arreglo) {

    var contadorMejorcaso = mergesort(arreglo);
    var prueba = document.getElementById('resultadoMCMC');
    prueba.innerHTML = contadorMejorcaso;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)
function ordenarPorMergeSortPeorcaso(arreglo) {

    var contadorPeorCaso = mergesort(arreglo.reverse());
    var prueba = document.getElementById('resultadoPCMC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;
}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante la funcion---

function calculoPeorCasoM() {
    var calculo = (10 * tamanioM * Math.log2(tamanioM)); //
    var prueba = document.getElementById('resultadoPCMF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoCasoNormalM() {

    var calculo = (10 * tamanioM * Math.log2(tamanioM));
    var prueba = document.getElementById('resultadoCNMF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoMejorCasoM() {
    var calculo = (10 * tamanioM * Math.log2(tamanioM));
    var prueba = document.getElementById('resultadoMCMF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarMergeSort() {
    graficar(generarDatosMergeSort(), 'graficaMergeSort');
}
