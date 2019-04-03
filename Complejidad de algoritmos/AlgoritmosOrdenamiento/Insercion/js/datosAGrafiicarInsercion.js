function generarDatosInsercion() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (var i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcularI(i)];

        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;
}

function calcularI(tam) {

    var array = [];
    var cont = 0;

    if (tam == 0) {
        cont = 0;

    } else {
        cont = ordenarPorInsercion(generarArreglo(tam,""));
    }
    return cont;
}

