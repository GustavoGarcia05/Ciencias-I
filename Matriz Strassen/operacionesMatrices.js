function comenzar() {

    var matrizA = [[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]];
    var matrizB = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18, 19, 20]];

    var matrizA1 = [[1, 2, 1, 2], [4, 4, 5, 6], [6, 5, 3, 7], [7, 8, 9, 8]];
    var matrizB2 = [[2, 3, 4, 7], [6, 2, 6, 5], [5, 1, 7, 1], [4, 3, 8, 9]];

    var matrizPrueva = [
        [['a', 'b'], ['c', 'd']],
        [[1, 2], [3, 4]],
        [['A', 'B'], ['C', 'D']],
        [[11, 22], [33, 44]]
    ];

    var matrizA1 = [
        [1, 2, 1, 2],
        [4, 4, 5, 6],
        [6, 5, 3, 7],
        [7, 8, 9, 8]
    ];

    var matriz8x8 = [
        [1, 2, 3, 4, 5, 6, 7, 8],
        [11, 12, 13, 14, 15, 16, 17, 18],
        [21, 22, 23, 24, 25, 26, 27, 28],
        [31, 32, 33, 34, 35, 36, 37, 38],
        [41, 42, 43, 44, 45, 46, 47, 48],
        [51, 52, 53, 54, 55, 56, 57, 58],
        [61, 62, 63, 64, 65, 66, 67, 68],
        [71, 72, 73, 74, 75, 76, 77, 78]
    ];
    var matriz16x16 = [
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
        [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
    ];

    imprimirMatriz('8x8 ', matriz8x8);

    console.log('+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+');
    var ma = subDividir(matriz8x8);
    for (var i = 0; i < 4; i++) {
        imprimirMatriz('dividida: ', ma[i]);
        console.log('-----------------')
    }
    console.log('+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+');

    var mb = reorganizarMatriz(ma);
    //Strassenn(matrizA1, matrizB2);
    //imprimirMatriz('reoganizada: ', mb);

}


//---------------------Operaciones internas de Strassen------------------
function subDividir(matriz) {
    var matrizSubdividida = [];
    var numeroSubMatrices = 4;
    var tamanioSubDivisiones = matriz.length / 2;

    var coordenadaX = 0;
    var coordenadaY = 0;

    for (var k = 0; k < numeroSubMatrices; k++) {
        var matrizAuxiliar = [];
        if (k < 2) {
            coordenadaX = 0;
            coordenadaY = k * (tamanioSubDivisiones);
        } else {
            coordenadaX = tamanioSubDivisiones;
            var kAux = k - (numeroSubMatrices / 2);
            coordenadaY = kAux * (tamanioSubDivisiones);
        }
        //console.log('x,y: ' + coordenadaX + ',' + coordenadaY);
        for (var i = coordenadaX; i < tamanioSubDivisiones + coordenadaX; i++) {
            matrizAuxiliar.push([]);
            for (var j = coordenadaY; j < tamanioSubDivisiones + coordenadaY; j++) {
                matrizAuxiliar[i - coordenadaX].push(matriz[i][j]);
            }
        }
        matrizSubdividida.push(matrizAuxiliar);
    }
    return matrizSubdividida;
}

function calcularPotenciaDe2AlaN(matriz) {
    var potenciaDe2AlaNActual;


    var numeroFilas = matriz.length;
    var numeroColumnas = matriz[0].length;

    var dimensionMayor = Math.max(numeroFilas, numeroColumnas);
    potenciaDe2AlaNActual = Math.ceil(Math.log(dimensionMayor) / Math.log(2));

    return potenciaDe2AlaNActual;
}
function calcularNuevaPotenciaDe2AlaN(potenciaDe2AlaNActual) {

    var nuevoExponente2AlaN = potenciaDe2AlaNActual;

    while (nuevoExponente2AlaN % Math.pow(2, potenciaDe2AlaNActual)) {
        nuevoExponente2AlaN += 1;
    }
    return nuevoExponente2AlaN;
}

//------------

function completarConCeros(matriz) {

    var nuevaMatriz = matriz;

    var numeroFilas = matriz.length;
    var numeroColumnas = matriz[0].length;

    var nuevaDimension = calcularNuevaPotenciaDe2AlaN(calcularPotenciaDe2AlaN(matriz));

    nuevaMatriz = completarConCerosFilas(nuevaMatriz, nuevaDimension, numeroFilas, numeroColumnas);
    nuevaMatriz = completarConCerosColumnas(nuevaMatriz, nuevaDimension, numeroFilas);

    return nuevaMatriz;
}

function completarConCerosFilas(matriz, nuevaDimension, numeroFilas, numeroColumnas) {

    var matrizFilasCompletadas = matriz;
    for (let i = 0; i < numeroFilas; i++) {
        for (let j = numeroColumnas; j < nuevaDimension; j++) {
            matrizFilasCompletadas[i].push(0);
        }
    }
    return matrizFilasCompletadas;
}

function completarConCerosColumnas(matriz, nuevaDimension, numeroFilas) {
    var matrizColumnasCompletadas = matriz;
    for (let i = numeroFilas; i < nuevaDimension; i++) {
        matrizColumnasCompletadas.push([0]);
        for (let j = 0; j < nuevaDimension; j++) {
            matrizColumnasCompletadas[i].push(0);
        }

    }
    return matrizColumnasCompletadas;
}
//---------------

function reorganizarMatriz(matriz) {
    var matrizReorganizada = [];
    for (var i = 0; i < matriz.length; i++) {

        for (var j = 0; j < matriz[0].length; j++) {
            matrizReorganizada.push([]);
            for (var k = 0; k < matriz[0][0].length; k++) {
                //matrizReorganizada[j].push(matriz[i][j][k]);
                console.log('matriz[i][j][k]: ' + matriz[i][j][k]);
            }
        }

    }

    return matrizReorganizada;
}


//---------------- Multiplicar por Strassen-------------

function Strassenn(matrizA, matrizB) {


    if (verificarSiSePuedenMultiplicar(matrizA, matrizB)) {


        var matrizACompletada = completarConCeros(matrizA);
        var matrizBCompletada = completarConCeros(matrizB);


        //A= matrizA Subdividida
        var A = subDividir(matrizACompletada);
        //B= matrizB Subdividida
        var B = subDividir(matrizBCompletada);

        if (matrizA.length == 2 && matrizB.length == 2) {
            //A11= matrizA[0] ; A12= matrizA[1] ; A21= matrizA[2] ; A22= matrizA[3]
            //B11= matrizB[0] ; B12= matrizB[1] ; B21= matrizB[2] ; B22= matrizB[3]

            var m1 = multiplicar(sumarMatrices(A[0], A[3]), sumarMatrices(B[0], B[3]));
            var m2 = multiplicar(sumarMatrices(A[2], A[3]), B[0]);
            var m3 = multiplicar(A[0], restarMatrices(B[1], B[3]));
            var m4 = multiplicar(A[3], restarMatrices(B[2], B[0]));
            var m5 = multiplicar(sumarMatrices(A[0], A[1]), B[3]);
            var m6 = multiplicar(restarMatrices(A[2], A[0]), sumarMatrices(B[0], B[1]));
            var m7 = multiplicar(restarMatrices(A[1], A[3]), sumarMatrices(B[2], B[3]));

        } else {
            //A11= matrizA[0] ; A12= matrizA[1] ; A21= matrizA[2] ; A22= matrizA[3]
            //B11= matrizB[0] ; B12= matrizB[1] ; B21= matrizB[2] ; B22= matrizB[3]

            var m1 = Strassenn(sumarMatrices(A[0], A[3]), sumarMatrices(B[0], B[3]));
            var m2 = Strassenn(sumarMatrices(A[2], A[3]), B[0]);
            var m3 = Strassenn(A[0], restarMatrices(B[1], B[3]));
            var m4 = Strassenn(A[3], restarMatrices(B[2], B[0]));
            var m5 = Strassenn(sumarMatrices(A[0], A[1]), B[3]);
            var m6 = Strassenn(restarMatrices(A[2], A[0]), sumarMatrices(B[0], B[1]));
            var m7 = Strassenn(restarMatrices(A[1], A[3]), sumarMatrices(B[2], B[3]));
        }



        var c11 = sumarMatrices(restarMatrices(sumarMatrices(m1, m4), m5), m7);
        var c12 = sumarMatrices(m3, m5);
        var c21 = sumarMatrices(m2, m4);
        var c22 = sumarMatrices(sumarMatrices(restarMatrices(m1, m2), m3), m6);


    } else {
        alert('No se pueden multiplicar las matrices; filas de A[i]: ' + matrizACompletada.length + ' diferentes de columnas de B[j]: ' + matrizBCompletada[0].length);
    }

    var matrizC = [c11, c12, c21, c22];
    var matrizMultiplicada = reorganizarMatriz(matrizC);
    return matrizMultiplicda;
}


//-----------------------Operaciones Varias-------------------

function imprimirMatriz(texto, matriz) {
    for (var i = 0; i < matriz.length; i++) {
        console.log(texto + matriz[i]);
    }
}

function sumarMatrices(matriz1, matriz2) {
    var matrizSumada = [];

    for (var i = 0; i < matriz1.length; i++) {
        matrizSumada.push([]);
        for (var j = 0; j < matriz1[i].length; j++) {
            matrizSumada[i].push(matriz1[i][j] + matriz2[i][j]);
        }
    }

    return matrizSumada;
}

function restarMatrices(matriz1, matriz2) {
    var matrizRestada = [];

    for (var i = 0; i < matriz1.length; i++) {
        matrizRestada.push([]);
        for (var j = 0; j < matriz1[i].length; j++) {
            matrizRestada[i].push(matriz1[i][j] - matriz2[i][j]);
        }
    }

    return matrizRestada;
}

function multiplicar(matriz1, matriz2) {
    var matrizMultiplicada = [];

    for (var i = 0; i < matriz1.length; i++) {
        matrizMultiplicada.push([]);
        for (var j = 0; j < matriz2[0].length; j++) {
            var matrizAuxiliar = 0;
            matrizMultiplicada[i].push([]);
            for (var k = 0; k < matriz1[i].length; k++) {
                matrizAuxiliar += (matriz1[i][k] * matriz2[k][j]);
            }
            matrizMultiplicada[i][j] = matrizAuxiliar;
        }
    }

    return matrizMultiplicada;
}

function verificarSiSePuedenMultiplicar(matriz1, matriz2) {
    var sePuedeMultiplicar;

    if (matriz1[0].length == matriz2.length) {
        sePuedeMultiplicar = true;
    } else {
        sePuedeMultiplicar = false;
    }

    return sePuedeMultiplicar;

}


