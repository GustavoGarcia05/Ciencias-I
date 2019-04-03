function generarDatosSeleccion() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcularS(i)];

        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;
}

function calcularS(tam) {

    var array = [];
    var cont = 0;

    if (tam == 0) {
        cont = 0;

    } else {

        for (i = 0; i < tam; i++) {
            array[i] = Math.round(Math.random() * tam);
        }

        /*NOTA: si utilizo (i) en un for en el siguiente for no puedo usarla 
         porque el programa no la entiende como otra (i) diferente 
         (o por lo menos de la forma como escribi el codigo sucede de esa manera) */

        cont = 1;
        for (j = 0; j < tam - 1; j++) {
            cont += 6;
            min = j;
            for (k = j + 1; k < tam; k++) {
                cont += 5;
                if (array[k] < array[min]) {
                    min = k;
                    cont += 1;
                }
            }
            cont += 1;
            cont += 1;
            if (j != min) {
                cont += 7;
                var aux = array[j];
                array[j] = array[min];
                array[min] = aux;
            }
        }
        cont += 2;
    }
    return cont;
}