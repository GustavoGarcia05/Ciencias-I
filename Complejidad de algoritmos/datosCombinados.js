function generarDatosCombinados() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (var i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcular(i), calcularS(i), calcularI(i), calcularR(i), calcularQ(), calcularM()];
        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;

}

