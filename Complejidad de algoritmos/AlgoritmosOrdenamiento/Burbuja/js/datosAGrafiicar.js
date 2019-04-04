function generarDatosBurbuja() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (var i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcular(i)];

        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;
}

function calcular(tam) {

    var array = [];
    var cont = 0;

    if (tam == 0) {
        cont = 0;

    } else {

        for (var i = 0; i < tam; i++) {
            array[i] = Math.round(Math.random() * tam);
        }
        /*NOTA: si utilizo (i) en un for en el siguiente for no puedo usarla 
         porque el programa no la entiende como otra (i) diferente 
         (o por lo menos de la forma como escribi el codigo sucede de esa manera) */
        for (var j = 0; j < tam - 1; j++) {
            cont += 5;
            for (var k = j + 1; k < tam; k++) {
                cont += 5;
                if (array[j] > array[k]) {
                    temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                    cont += 7;
                }
            }
            cont += 1;
        }
        cont += 2;
    }

    return cont;
}

