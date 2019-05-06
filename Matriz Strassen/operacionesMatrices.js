function comenzar() {

    var matrizPrueva = [
        [['a', 'b'], ['c', 'd']],
        [[1, 2], [3, 4]],
        [['A', 'B'], ['C', 'D']],
        [[11, 22], [33, 44]]
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
    imprimirMatriz('matriz: ', subDividir(matriz8x8));
}

function imprimirMatriz(texto, matriz) {
    for (var i = 0; i < matriz.length; i++) {
        console.log(texto + matriz[i]);
    }
}

function subDividir(matriz) {
    var matrizSubdividida = [];
    var numeroSubMatrices = 4;
    var tamanioSubDivisiones = matriz.length / 2;

    var coordnenadaX = 0;
    var coordnenadaY = 0;

    for (var k = 0; k < numeroSubMatrices; k++) {
        if (k < 2) {
            coordnenadaX = 0;
            coordnenadaY = k * (tamanioSubDivisiones - 1);
        } else {
            coordnenadaX = tamanioSubDivisiones - 1;
            var kAux = k - (numeroSubMatrices / 2);
            coordnenadaY = kAux * (tamanioSubDivisiones - 1);
        }

        for (var i = coordnenadaX; i < tamanioSubDivisiones + coordnenadaX; i++) {
            for (var j = coordnenadaY; j < tamanioSubDivisiones + coordnenadaY; j++) {

            }
        }
        console.log('x,y: ' + coordnenadaX + ',' + coordnenadaY);


    }




    return matrizSubdividida;
}