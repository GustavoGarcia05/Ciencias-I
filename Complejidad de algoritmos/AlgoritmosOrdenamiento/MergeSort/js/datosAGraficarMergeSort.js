function generarDatosMergeSort() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcularM(i)];

        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;
}

function calcularM(tam) {

    var array = [];
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
    return mergesort(generarArregloSinEtiqueta(tam));
}


function generarArregloSinEtiqueta(tamanio) {
    var arreglo = [];

    for (var i = 0; i < tamanio; i++) {
        arreglo[i] = Math.round(Math.random() * tamanio);
    }
    return arreglo;
}