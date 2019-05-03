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
        arregloOrdenado.innerHTML = vector.sort();
    }
}

//--------- Funciones de ordenamiento-------

var cont = 0;
const defaultSortingAlgorithm = (a, b) => {
    if (a < b) {
        cont += 1;
        return -1;
    }
    if (a > b) {
        cont += 1;
        return 1;
    }
    return 0;
};

const quickSort = (
        unsortedArray,
        sortingAlgorithm = defaultSortingAlgorithm
        ) => {
    // immutable version
    const sortedArray = [...unsortedArray];

    cont += 1;

    const swapArrayElements = (arrayToSwap, i, j) => {
        const a = arrayToSwap[i];
        arrayToSwap[i] = arrayToSwap[j];
        arrayToSwap[j] = a;
    };

    cont += 5;

    const partition = (arrayToDivide, start, end) => {
        const pivot = arrayToDivide[end];
        let splitIndex = start;
        cont += 2;
        for (let j = start; j <= end - 1; j++) {
            const sortValue = sortingAlgorithm(arrayToDivide[j], pivot);
            if (sortValue === -1) {
                swapArrayElements(arrayToDivide, splitIndex, j);
                splitIndex++;
                cont += 1;
            }
            cont += 4;
        }
        cont += 1;
        swapArrayElements(arrayToDivide, splitIndex, end);
        return splitIndex;
    };

    // Recursively sort sub-arrays.
    const recursiveSort = (arraytoSort, start, end) => {
        // stop condition
        cont += 1;
        if (start < end) {
            const pivotPosition = partition(arraytoSort, start, end);
            recursiveSort(arraytoSort, start, pivotPosition - 1);
            recursiveSort(arraytoSort, pivotPosition + 1, end);
            cont += 3;
        }
    };

    // Sort the entire array.
    recursiveSort(sortedArray, 0, unsortedArray.length - 1);
    cont += 1;
    return cont;
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
    var calculo = (Math.pow(tamanioQ, 2)); //
    var prueba = document.getElementById('resultadoPCQF');
    prueba.innerHTML = calculo;
    return calculo
}

function calculoCasoNormalQ() {

    var calculo = (tamanioQ * Math.log10(tamanioQ));
    var prueba = document.getElementById('resultadoCNQF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoMejorCasoQ() {
    var calculo = (tamanioQ * Math.log10(tamanioQ));
    var prueba = document.getElementById('resultadoMCQF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarQuickSort() {
    graficar(generarDatosQuickSort(), 'graficaQuickSort');
}


function prueba() {
    console.log(quickSort([1, 2, 20, 99, 9, 100, 551, 1, 2]) + "cont: " + cont);
}