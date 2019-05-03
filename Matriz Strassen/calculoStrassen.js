var c;

function crearMatrizA() {
    var filas = document.getElementById("filasA").value;
    var columnas = document.getElementById("columnasA").value;
    var tabla = document.getElementById("tablaA");
    armarMatriz(filas, columnas, tabla, "A");
}

function crearMatrizB() {
    var filas = document.getElementById("filasB").value;
    var columnas = document.getElementById("columnasB").value;
    var tabla = document.getElementById("tablaB");
    armarMatriz(filas, columnas, tabla, "B");

}


//crea la matriz usando las filas y las columnas que le ingresan como parametro
function armarMatriz(filas, columnas, tabla, id) {
    for (var i = 0; i < filas; i++) {
        var f = tabla.insertRow(-1);
        for (var j = 0; j < columnas; j++) {
            var nid = "" + id + i + j;
            var z = f.insertCell(-1);
            var CELDA = "<input type=\"text\"";
            CELDA = CELDA + "id=\"" + nid + "\"";
            CELDA = CELDA + "size=\"1\">";
            z.innerHTML = CELDA;
        }
    }
}

function limpiarMatrizA() {
    var t = document.getElementById("tablaA");
    limpiarMatriz(t);
}

function limpiarMatrizB() {
    var t = document.getElementById("tablaB");
    limpiarMatriz(t);
}

//limpia la creacion de celdas de la tabla que le ingresen
function limpiarMatriz(tabla) {
    for (var i = tabla.rows.length - 1; i >= 0; i--) {
        tabla.deleteRow(i);
    }
}

//captura los datos ingresados por el usuario
function capturarmatriz(filas, columnas, tabla) {
    var mat = new Array(filas);
    for (var i = 0; i < filas; i++) {
        mat[i] = new Array(columnas);
        for (var j = 0; j < columnas; j++) {
            var temp = document.getElementById("" + tabla + i + j).value;
            mat[i][j] = Number(temp);
        }
    }
    return mat;
}

function prueba() {
    //var matrizA = capturarmatriz(document.getElementById("filasA").value, document.getElementById("columnasA").value, "A");
    //var matrizB = capturarmatriz(document.getElementById("filasB").value, document.getElementById("columnasB").value, "B");

    var matrizA = [[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]];
    var matrizB = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18, 19, 20]];

    var matrizA1 = [[1, 2, 1, 2], [4, 4, 5, 6], [6, 5, 3, 7], [7, 8, 9, 8]];
    var matrizB2 = [[2, 3, 4, 7], [6, 2, 6, 5], [5, 1, 7, 1], [4, 3, 8, 9]];

    var matrizOperada = strassenCasobase(matrizA1, matrizB2);

    for (var i = 0; i < matrizOperada.length; i++) {
        console.log('matriz por straseen: ' + matrizOperada[i]);
    }

}


//Aqui empieza el codigo que estoy escribiendo 


//-------Operaciones entre matrices-------
function sumarMatrices(matriz1, matriz2) {
    var matrizSumada = Array(matriz1.length); // crea una matriz de longitud 4
    for (var i = 0; i < matriz1.length; i++) {
        matrizSumada[i] = new Array(matriz2.length); // define cada elemento como una matriz de longitud 4
        for (var j = 0; j < matriz2.length; j++) {
            matrizSumada[i][j] = "[" + i + "," + j + "]"; // asigna a cada elemento de la matriz bidimensional 
            // los valores de i y j
        }
    }
    for (var i = 0; i < matriz1.length; i++) {
        for (var j = 0; j < matriz2.length; j++) {
            matrizSumada[i][j] = matriz1[i][j] + matriz2[i][j];
        }
    }
    return matrizSumada;
}
function restarMatrices(matriz1, matriz2) {
    var matrizRestada = Array(matriz1.length); // crea una matriz de longitud 4
    for (var i = 0; i < matriz1.length; i++) {
        matrizRestada[i] = new Array(matriz1.length); // define cada elemento como una matriz de longitud 4
        for (var j = 0; j < matriz1.length; j++) {
            matrizRestada[i][j] = "[" + i + "," + j + "]"; // asigna a cada elemento de la matriz bidimensional 
            // los valores de i y j
        }
    }
    for (let i = 0; i < matriz1.length; i++) {
        for (let j = 0; j < matriz1.length; j++) {
            matrizRestada[i][j] = matriz1[i][j] - matriz2[i][j];
        }
    }
    return matrizRestada;
}

function multiplicarMatrices(matriz1, matriz2) {

    var matrizMultiplicada = [];

    for (var i = 0; i < matriz1.length; i++) {
        matrizMultiplicada.push([]);
        for (var j = 0; j < matriz2[0].length; j++) {
            var matrizAuxiliar = 0;
            matrizMultiplicada[i].push([]);
            for (var k = 0; k < matriz1[i].length; k++) {
                matrizAuxiliar += (matriz1[i][k] * matriz2[k][j]);
            }
            matrizMultiplicada[i][j] = matrizAuxiliar;
        }
    }


    /*for (var i = 0; i < matrizMultiplicada.length; i++) {
     console.log('fila [' + i + '] :' + matrizMultiplicada[i]);
     }*/

    return matrizMultiplicada;
}



//----------------------------------------

//-------Operaciones de verificacion-------
function verificarMultiplicacion(matriz1, matriz2) {
    var sePuedeMultiplicar;

    if (matriz1[0].length == matriz2.length) {
        sePuedeMultiplicar = true;
    } else {
        sePuedeMultiplicar = false;
    }

    return sePuedeMultiplicar;

}

function verificarMatrizCuadrada(matriz) {
    var esCuadrada;

    if (matriz[0].length == matriz.length) {
        esCuadrada = true;
    } else {
        esCuadrada = false;
    }

    return esCuadrada;
}
//----------------------------------------


//-------Redimension conceros de la matriz-------
//verifica si el tamaÃ±o es multiplo de 2^n
function completarConCeros(matriz) {

    var numeroFilas;
    var numeroColumnas;
    var dimensionMayor;
    var exponente;
    var nuevaDimension;
    var nuevaMatriz = matriz;

    numeroFilas = matriz.length;
    numeroColumnas = matriz[0].length;

    dimensionMayor = Math.max(numeroFilas, numeroColumnas);
    //ceil redondea por encima (techo), floor por el contario redondea por debajo (piso)
    exponente = Math.ceil(Math.log(dimensionMayor) / Math.log(2));
    nuevaDimension = exponente;

    while (nuevaDimension % Math.pow(2, exponente)) {
        nuevaDimension += 1;
    }
    nuevaMatriz = completarConCerosFilas(nuevaMatriz, nuevaDimension, numeroFilas, numeroColumnas);
    nuevaMatriz = completarConCerosColumnas(nuevaMatriz, nuevaDimension, numeroFilas);


    return nuevaMatriz;

}

function completarConCerosFilas(matriz, nuevaDimension, numeroFilas, numeroColumnas) {

    var matrizFilasCompletadas = matriz;
    for (let i = 0; i < numeroFilas; i++) {
        for (let j = numeroColumnas; j < nuevaDimension; j++) {
            matrizFilasCompletadas[i].push(0);
        }
    }
    return matrizFilasCompletadas;
}

function completarConCerosColumnas(matriz, nuevaDimension, numeroFilas) {
    var matrizColumnasCompletadas = matriz;
    for (let i = numeroFilas; i < nuevaDimension; i++) {
        matrizColumnasCompletadas.push([0]);
        for (let j = 0; j < nuevaDimension; j++) {
            matrizColumnasCompletadas[i].push(0);
        }

    }
    /*for (let i = 0; i < matrizColumnasCompletadas.length; i++) {
     console.log('matriz[' + i + ']: ' + matrizColumnasCompletadas[i]);
     }*/
    return matrizColumnasCompletadas;
}
//----------------------------------------

//-------Operaciones para Strauss-------
function sacarSeccionMatriz(matriz, coordenadaX, coordenadaY, tamanioSubdivision) { //rango de subdivision = tamanioSubdivision

    var matrizSubdividida = [];

    for (let i = coordenadaX; i < tamanioSubdivision + coordenadaX; i++) {
        var matrizAux = [];
        for (let j = coordenadaY; j < tamanioSubdivision + coordenadaY; j++) {
            matrizAux[j - coordenadaY] = matriz[i][j];
        }
        matrizSubdividida[i - coordenadaX] = matrizAux;

    }
    return matrizSubdividida;
}

function subDividirMatriz(matriz) {

    var subMatriz11, subMatriz12, subMatriz21, subMatriz22;
    var tamanioSeccion = matriz.length / 2;
    var matrizSectorizada = [];

    subMatriz11 = sacarSeccionMatriz(matriz, 0, 0, tamanioSeccion);
    subMatriz12 = sacarSeccionMatriz(matriz, 0, tamanioSeccion, tamanioSeccion);
    subMatriz21 = sacarSeccionMatriz(matriz, tamanioSeccion, 0, tamanioSeccion);
    subMatriz22 = sacarSeccionMatriz(matriz, tamanioSeccion, tamanioSeccion, tamanioSeccion);
    return matrizSectorizada = [subMatriz11, subMatriz12, subMatriz21, subMatriz22];

}

function strassenCasobase(matriz1, matriz2) {

    console.log();

    var matrizA = [];
    var matrizB = [];

    if (verificarMultiplicacion(matriz1, matriz2)) {
        matrizA = completarConCeros(matriz1);
        matrizB = completarConCeros(matriz2);
    }

    matrizA = subDividirMatriz(matrizA);
    matrizB = subDividirMatriz(matrizB);

    var m1 = multiplicarMatrices(sumarMatrices(matrizA[0], matrizA[3]), sumarMatrices(matrizB[0], matrizB[3]));
    var m2 = multiplicarMatrices(sumarMatrices(matrizA[2], matrizA[3]), matrizB[0]);
    var m3 = multiplicarMatrices(matrizA[0], restarMatrices(matrizB[1], matrizB[3]));
    var m4 = multiplicarMatrices(matrizA[3], restarMatrices(matrizB[2], matrizB[0]));
    var m5 = multiplicarMatrices(sumarMatrices(matrizA[0], matrizA[1]), matrizB[3]);
    var m6 = multiplicarMatrices(restarMatrices(matrizA[2], matrizA[0]), sumarMatrices(matrizB[0], matrizB[1]));
    var m7 = multiplicarMatrices(restarMatrices(matrizA[1], matrizA[3]), sumarMatrices(matrizB[2], matrizB[3]));

    var c11 = sumarMatrices(restarMatrices(sumarMatrices(m1, m4), m5), m7);
    var c12 = sumarMatrices(m3, m5);
    var c21 = sumarMatrices(m2, m4);
    var c22 = sumarMatrices(sumarMatrices(restarMatrices(m1, m2), m3), m6);

    //var matricesOperadas = [c11, c12, c21, c22];
    var matricesOperadas = reorganizarMatrisOperada(c11,c12,c21,c22);
    
    
    
    return matricesOperadas;
}

function reorganizarMatrisOperada(c11, c12, c21, c22) {
    var matrizReoganizada=[];
    matrizReoganizada.push(c11[0]+','+c12[0]);
    matrizReoganizada.push(c11[1]+','+c12[1]);
    matrizReoganizada.push(c21[0]+','+c22[0]);
    matrizReoganizada.push(c21[1]+','+c22[1]);
    
    for(var i=0;i<matrizReoganizada.length;i++){
        console.log('matriz: '+matrizReoganizada[i]);
    }
    
    return matrizReoganizada;
}

function iprimirMatriz(matriz) {
    for (var i = 0; i < matriz.length; i++) {
        console.log('matriz: ' + matriz[i]);
    }
}
//----------------------------------------
