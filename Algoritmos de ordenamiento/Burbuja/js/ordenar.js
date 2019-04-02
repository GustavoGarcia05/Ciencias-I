

var tamanio;
var vector;

function iniciarBurbuja() {

    tamanio = document.getElementById('entradaBurbuja').value;
    if (tamanio <= 0 || tamanio == "") {
        alert('expresion no valida');
    } else {
        vector = [];

        generarArreglo(vector);
        ordenarPorBurbujaCasoNormal(vector);
        ordenarPorBurbujaMejorcaso(vector);
        ordenarPorBurbujaPeorcaso(vector);
        calculoPeorCaso();
        calculoCasoNormal();
        calculoMejorCaso();



        var arregloOrdenado = document.getElementById('arregloOrdenado');
        arregloOrdenado.innerHTML = vector;

    }

}

function generarArreglo(arreglo) {
    for (i = 0; i < tamanio; i++) {
        arreglo[i] = Math.round(Math.random() * tamanio);

    }

    console.log(arreglo);
    var arregloGenerado = document.getElementById('vectorGeneradoB:');
    arregloGenerado.innerHTML = arreglo;
}



//--------- Funciones de ordenamiento-------

function ordenarPorBurbuja(arreglo) {
    var contador = 0;

    for (i = 0; i < tamanio - 1; i++) {
        contador += 2;
        contador += 1;
        for (j = i + 1; j < tamanio; j++) {
            contador += 5;
            if (arreglo[i] >= arreglo[j]) {
                temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
                contador += 7;

            }
        } contador += 1;

    } contador += 2;
    contador += 9;
    return contador;
}

//caso real(menor a mayor)
function ordenarPorBurbujaCasoNormal(vector) {
    var contadorCasoNormal = ordenarPorBurbuja(vector);

    var prueba = document.getElementById('resultadoCNBC');
    prueba.innerHTML = contadorCasoNormal;
    return contadorCasoNormal;
}



//mejor caso (ya esta ordenado)
function ordenarPorBurbujaMejorcaso(arreglo) {
    var contadorMejorcaso = ordenarPorBurbuja(arreglo);

    var prueba = document.getElementById('resultadoMCBC');
    prueba.innerHTML = contadorMejorcaso;

    return contadorMejorcaso;
}

//peor caso (mayor a menor)

function ordenarPorBurbujaPeorcaso(arreglo) {

    for (i = 0; i < tamanio - 1; i++) {

        for (j = i + 1; j < tamanio; j++) {

            if (arreglo[i] < arreglo[j]) {
                temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;


            }
        }

    }
    var contadorPeorCaso = ordenarPorBurbuja(arreglo);

    var prueba = document.getElementById('resultadoPCBC');
    prueba.innerHTML = contadorPeorCaso;

    return contadorPeorCaso;

}
//------------------------------------------

//---Calculo del numero de operaciones elementales mediante la funcion---

function calculoPeorCaso() {
    var calculo = 6 * (Math.pow(tamanio, 2)) - 3;
    var prueba = document.getElementById('resultadoPCBF');
    prueba.innerHTML = calculo;
    return calculo
}

function calculoCasoNormal() {

    var calculo = (17 * (Math.pow(tamanio, 2)) + (7 * tamanio) - 12) / 4;
    var prueba = document.getElementById('resultadoCNBF');
    prueba.innerHTML = calculo;
    return calculo;

}

function calculoMejorCaso() {
    var calculo = (5 * (Math.pow(tamanio, 2)) + (7 * tamanio) - 6) / 2;
    var prueba = document.getElementById('resultadoMCBF');
    prueba.innerHTML = calculo;
    return calculo;
}

//---------------------------------------------------------------------

