function comenzar() {

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
    var ma = subDividir(matriz8x8);
    
    for (var i = 0; i < 4; i++) {
        imprimirMatriz('mat sub: ', ma[i]);
        console.log('-------------------------------');
    }

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