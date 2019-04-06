function calcularDeterminante(array) {
    var tam=array.length;//tamanio de la matriz cuadradada
    console.log("tamanio: "+tam);

    for (var i = 0; i < tam - 1; i++) {

        for (var j = i + 1; j < tam; j++) {

            for (var k = i + 1; k < tam; k++) {
                array[k][j] = array[k][j] - (array[k][i] * array[i][j]) / array[i][i];
            }
        }
    }

    var traza=1;

    for(var h=0; h<tam; h++){
        traza=traza*array[h][h];
    }
    


    console.log("matriz resultante: "+array);
    console.log("determinante: "+traza);
}

function iniciar() {

    matriz = [
        [1, 2, 3, 4],
        [5, 1, 7, 8],
        [9, 8, 1, 6],
        [5, 4, 3, 1]
    ];

    console.log("matriz inicial"+matriz);

    calcularDeterminante(matriz);


}