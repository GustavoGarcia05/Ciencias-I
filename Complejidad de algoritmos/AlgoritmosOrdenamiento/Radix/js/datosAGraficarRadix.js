function generarDatosRadix() {

    var pareja = [];
    var filas = [];

    var constanteAumento = 1;
    var constanteTamanio = 100;

    for (i = 0; i < constanteTamanio; i += constanteAumento) {
        pareja = [i, calcularR(i)];

        if (i == 0) {
            filas[i] = pareja;
        }
        filas[i / constanteAumento] = pareja;
    }
    return filas;
}

function calcularR(tam) {

    var arreglo = [];
    var cont = 0;

    if (tam == 0) {
        cont = 0;

    } else {

        for (i = 0; i < tam; i++) {
            arreglo[i] = Math.round(Math.random() * tam);
        }

        /*NOTA: si utilizo (i) en un for en el siguiente for no puedo usarla 
         porque el programa no la entiende como otra (i) diferente 
         (o por lo menos de la forma como escribi el codigo sucede de esa manera) */

        var contador = 0;
        let maxValue = arreglo[0]
        contador += 4;
        for (let i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maxValue) {
                maxValue = arreglo[i]
                contador += 4;
            }
            contador += 2;
        }
        const iterationCount = maxValue.toString().length
        contador += 1;
        for (let digit = 0; digit < iterationCount; digit++) {
            const bucketArray = Array.from({ length: 10 }, () => [])
            for (let i = 0; i < arreglo.length; i++) {
                const digitValue = Math.floor(arreglo[i] / Math.pow(10, digit)) % 10
                bucketArray[digitValue].push(arreglo[i])
                contador += 11;
            }
            arreglo = [].concat(...bucketArray)
            arregloRadix = arreglo;
            contador += 10;
        }
        contador += 2;
        return contador;
    }
}