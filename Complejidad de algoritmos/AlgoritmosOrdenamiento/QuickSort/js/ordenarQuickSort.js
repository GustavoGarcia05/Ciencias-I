//https://www.geogebra.org/m/ptHaMUwP
// Algoritmo tomado de: https://medium.com/@ger86/algoritmos-de-ordenaci%C3%B3n-quicksort-en-javascript-f064db39e6ad

var tamanioQ;
function iniciarQuickSort() {

    var vector = [];

    tamanioQ = document.getElementById('entradaQuickSort').value;
    if (tamanioQ <= 0 || tamanioQ == "") {
        alert('expresion no valida');
    } else {
        vector = generarArreglo(tamanioQ, 'vectorGeneradoQ');

        ordenarPorQuickSortCasoNormal(vector);
        ordenarPorQuickSortMejorcaso(vector);
        ordenarPorQuickSortPeorcaso(vector);
        calculoPeorCasoQ();
        calculoCasoNormalQ();
        calculoMejorCasoQ();

        var arregloOrdenado = document.getElementById('arregloOrdenadoQ');
        arregloOrdenado.innerHTML = vector.sort((a, b) => a - b);
    }
}

//--------- Funciones de ordenamiento-------

var conta = 0;
const defaultSortingAlgorithm = (a, b) => {
    if (a < b) {
        conta += 1;
        return -1;
    }
    if (a > b) {
        conta += 1;
        return 1;
    }
    return 0;
};

const quickSort = (unsortedArray, sortingAlgorithm = defaultSortingAlgorithm) => {
    // immutable version
    const sortedArray = [...unsortedArray];
    conta += 1;

    const swapArrayElements = (arrayToSwap, i, j) => {
        const a = arrayToSwap[i];
        arrayToSwap[i] = arrayToSwap[j];
        arrayToSwap[j] = a;
        conta += 5;
    };


    const partition = (arrayToDivide, start, end) => {
        const pivot = arrayToDivide[end];
        let splitIndex = start;
        conta += 2;
        for (let j = start; j <= end - 1; j++) {
            const sortValue = sortingAlgorithm(arrayToDivide[j], pivot);
            if (sortValue === -1) {
                swapArrayElements(arrayToDivide, splitIndex, j);
                splitIndex++;
                conta += 1;
            }
            conta += 4;
        }
        conta += 1;
        swapArrayElements(arrayToDivide, splitIndex, end);
        return splitIndex;
    };

    // Recursively sort sub-arrays.
    const recursiveSort = (arraytoSort, start, end) => {
        // stop condition
        conta += 1;
        if (start < end) {
            const pivotPosition = partition(arraytoSort, start, end);
            recursiveSort(arraytoSort, start, pivotPosition - 1);
            recursiveSort(arraytoSort, pivotPosition + 1, end);
            conta += 3;
        }
    };

    // Sort the entire array.
    recursiveSort(sortedArray, 0, unsortedArray.length - 1);
    conta += 1;
    return conta;
};


//--------- Funciones de operaciones fundamentales-------

//caso real(menor a mayor)
function ordenarPorQuickSortCasoNormal(vector) {

    var contadorCasoNormal = quickSort(vector);
    var prueba = document.getElementById('resultadoCNQC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}

//mejor caso (ya esta ordenado)
function ordenarPorQuickSortMejorcaso(arreglo) {

    var contadorMejorcaso = quickSort(arreglo);
    var prueba = document.getElementById('resultadoMCQC');
    prueba.innerHTML = contadorMejorcaso;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)
function ordenarPorQuickSortPeorcaso(arreglo) {

    var contadorPeorCaso = quickSort(arreglo.reverse());
    var prueba = document.getElementById('resultadoPCQC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;
}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante la funcion---

function calculoPeorCasoQ() {
    var calculo = (10 * Math.pow(tamanioQ, 2)); //
    var prueba = document.getElementById('resultadoPCQF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoCasoNormalQ() {

    var calculo = (10 * tamanioQ * Math.log2(tamanioQ));
    var prueba = document.getElementById('resultadoCNQF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoMejorCasoQ() {
    var calculo = (10 * tamanioQ * Math.log2(tamanioQ));
    var prueba = document.getElementById('resultadoMCQF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarQuickSort() {
    graficar(generarDatosQuickSort(), 'graficaQuickSort');
}
