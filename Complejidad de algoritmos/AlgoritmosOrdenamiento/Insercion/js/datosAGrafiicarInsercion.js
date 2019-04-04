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

    var arreglo = [];
    var contador = 0;

    if (tam == 0) {
        contador = 0;

    } else {
        for (i = 0; i < tam; i++) {
            arreglo[i] = Math.round(Math.random() * tam);
        }    var actual, contador = 0;

        for (var i = 1; i < tam; i++) {
            actual = arreglo[i];
            for (var j = i; j > 0 && arreglo[j - 1] > actual; j--) {
                arreglo[j] = arreglo[j - 1];
                contador += 10;
            }
            contador += 2;
            arreglo[j] = actual;
            contador += 4;
        }
        contador += 2;


    }
    return contador;
}

