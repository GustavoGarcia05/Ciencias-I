function generarDatosQuickSort() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (var i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcularQ(i)];

        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;
}

function calcularQ(tam) {

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

    const quickSort = (unsortedArray, sortingAlgorithm = defaultSortingAlgorithm) => {
        // immutable version
        const sortedArray = [...unsortedArray];
        cont += 1;

        const swapArrayElements = (arrayToSwap, i, j) => {
            const a = arrayToSwap[i];
            arrayToSwap[i] = arrayToSwap[j];
            arrayToSwap[j] = a;
            cont += 5;
        };


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
    return quickSort(generarArregloSinEtiqueta(tam));
}



function generarArregloSinEtiqueta(tamanio) {
    var arreglo = [];

    for (var i = 0; i < tamanio; i++) {
        arreglo[i] = Math.round(Math.random() * tamanio);
    }

    return arreglo;
}