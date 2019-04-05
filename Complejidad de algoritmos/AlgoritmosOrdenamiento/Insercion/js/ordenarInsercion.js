var tamanioI;
function iniciarInsercion() {

    var vector = [];

    tamanioI = document.getElementById('entradaInsercion').value;
    if (tamanioI <= 0 || tamanioI == "") {
        alert('expresion no valida');
    } else {
        vector = generarArreglo(tamanioI, 'vectorGeneradoI');

        ordenarPorInsercionCasoNormal(vector);
        ordenarPorInsercionMejorcaso(vector);
        ordenarPorInsercionPeorcaso(vector);
        calculoPeorCasoI();
        calculoCasoNormalI();
        calculoMejorCasoI();

        var arregloOrdenado = document.getElementById('arregloOrdenadoI');
        arregloOrdenado.innerHTML = vector;

    }

}


//--------- Funciones de ordenamiento-------

function ordenarPorInsercion(arreglo) {
    var actual, contador = 0;

    for (var i = 1; i < tamanioI; i++) {
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

    return contador;
}

//caso real(menor a mayor)
function ordenarPorInsercionCasoNormal(vector) {
    var contadorCasoNormal = ordenarPorInsercion(vector);

    var prueba = document.getElementById('resultadoCNIC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}

//mejor caso (ya esta ordenado)
function ordenarPorInsercionMejorcaso(arreglo) {
    var contadorMejorcaso = ordenarPorInsercion(arreglo);

    var prueba = document.getElementById('resultadoMCIC');
    prueba.innerHTML = (5 * (Math.pow(tamanioI, 2)) + (7 * tamanioI) - 6) / 2;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)

function ordenarPorInsercionPeorcaso(arreglo) {

    var contadorPeorCaso = ordenarPorInsercion(arreglo.reverse());

    var prueba = document.getElementById('resultadoPCIC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;

}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante formulas---

function calculoPeorCasoI() {
    var calculo = (5.036 * Math.pow(tamanioI, 2) - 5.507 * tamanioI + 23);
    var prueba = document.getElementById('resultadoPCIF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoCasoNormalI() {

    var calculo = (Math.pow(tamanioI, 2));
    calculo = (calculoMejorCasoI() + calculoPeorCasoI()) / 2
    var prueba = document.getElementById('resultadoCNIF');
    prueba.innerHTML = calculo;
    return calculo;
}

function calculoMejorCasoI() {
    var calculo = (2.5 * Math.pow(tamanioI, 2) + (3.5 * tamanioI) - 3);
    var prueba = document.getElementById('resultadoMCIF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

function graficarInsercion() {
    graficar(generarDatosInsercion(), 'graficaInsercion');
}
