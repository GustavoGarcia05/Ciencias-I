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
    var MatrizA = capturarmatriz(document.getElementById("filasA").value, document.getElementById("columnasA").value, "A");
    console.log(MatrizA);
    alert(MatrizA);
}

/**
 * tamano es un multiplo de 2^n
 * 
 * */
function multiplicacionStrassen(matrizA, matrizB, c, tamano) {
    // c es por referencia
    if (tamano == 1) {
        c[0][0] = a[0][0] * b[0][0];
        return;
    }
    var tama = tamano / 2;
    a11 = array();
    a12 = array();
    a21 = array();
    a22 = array();
    b11 = array();
    b12 = array();
    b21 = array();
    b22 = array();
    c11 = array();
    c12 = array();
    c21 = array();
    c22 = array();
    p1 = array();
    p2 = array();
    p3 = array();
    p4 = array();
    p5 = array();
    p6 = array();
    p7 = array();
    aResult = array();
    bResult = array();
    for (let i = 0; i < tama; i++) {
        for (let j = 0; j < tama; j++) {
            //calcula a11, a12, a21, a22, b11, b12, b21, b22
        }
    }

    sum(a11, a22, aResult, tama); // a11 + a22
    sum(b11, b22, bResult, tama); // b11 + b22

    strassen(aResult, bResult, p1, tama); // p1 = (a11+a22) * (b11+b22)
    sum(a21, a22, aResult, tama); // a21 + a22

    strassen(aResult, b11, p2, tama); // p2 = (a21+a22) * (b11)
    subtract(b12, b22, bResult, tama); // b12 - b22

    strassen(a11, bResult, p3, tama); // p3 = (a11) * (b12 - b22)
    subtract(b21, b11, bResult, tama); // b21 - b11

    strassen(a22, bResult, p4, tama); // p4 = (a22) * (b21 - b11)
    sum(a11, a12, aResult, tama); // a11 + a12

    strassen(aResult, b22, p5, tama); // p5 = (a11+a12) * (b22)
    subtract(a21, a11, aResult, tama); // a21 - a11
    sum(b11, b12, bResult, tama); // b11 + b12

    strassen(aResult, bResult, p6, tama); // p6 = (a21-a11) * (b11+b12)
    subtract(a12, a22, aResult, tama); // a12 - a22
    sum(b21, b22, bResult, tama); // b21 + b22

    strassen(aResult, bResult, p7, tama); // p7 = (a12-a22) * (b21+b22)
    sum(p3, p5, c12, tama); // c12 = p3 + p5
    sum(p2, p4, c21, tama); // c21 = p2 + p4
    sum(p1, p4, aResult, tama); // p1 + p4
    sum(aResult, p7, bResult, tama); // p1 + p4 + p7
    subtract(bResult, p5, c11, tama); // c11 = p1 + p4 - p5 + p7
    sum(p1, p3, aResult, tama); // p1 + p3
    sum(aResult, p6, bResult, tama); // p1 + p3 + p6
    subtract(bResult, p2, c22, tama); // c22 = p1 + p3 - p2 + p6
    for (let i = 0; i < tama; i++) {
        for (let j = 0; j < tama; j++) {
            // almacena en c las submatrices
            // c11, c12, c21, c22
        }
    }
}


function mostrarDeterminante() {
    var cont = c;
    var tamano = document.getElementById("dimension").value;
    var determ = document.getElementById("prueba");
    var contador = document.getElementById("formula");
    var formula = document.getElementById("contador");

    determ.textContent = determinante(capturarmatriz(tamano), tamano);
    /*    contador.textContent = c;
     formula.textContent = (1 / 6) * ((32 * (tamano * tamano * tamano)) - (33 * (tamano * tamano)) + (73 * tamano));
     */
}

//Aqui empieza el codigo que estoy escribiendo 


//-------Operaciones entre matrices-------
function sumarMatrcices(matriz1, matriz2) {
    var matrizSumada = [];

    for (let i = 0; i < matriz1.length; i++) {
        for (let j = 0; j < matriz1.length; i++) {
            matrizSumada[i][j] = matriz1[i][j] + matriz2[i][j];
        }

    }

    return matrizSumada;
}
function restarMatrcices(matriz1, matriz2) {
    var matrizRestada = [];

    for (let i = 0; i < matriz1.length; i++) {
        for (let j = 0; j < matriz1.length; i++) {
            matrizRestada[i][j] = matriz1[i][j] - matriz2[i][j];
        }

    }

    return matrizRestada;
}

function multiplicarMatrices(matriz1, matriz2) {
    var matrizMultiplicada = [];

    var numeroFilas=matriz1.length;
    var numeroColumnas=matriz2[0].length;
    console.log('matriz2: '+matriz2);
    
    for (let i = 0; i < numeroFilas; i++) {
        console.log('matriz2: '+matriz2[i]);
        for (let j = 0; j < numeroColumnas; j++) {
            //matrizMultiplicada[i][j] = matriz1[i][j]*matriz2[j][i];
        }

    }

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
//verifica si el tamaño es multiplo de 2^n
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

    for (let i = 0; i < matrizColumnasCompletadas.length; i++) {
        console.log('matriz[' + i + ']: ' + matrizColumnasCompletadas[i]);
    }
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

//----------------------------------------

function probarPrograma() {
    var matrizPrueba = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]];
    var matrizPrueba2 = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16], [17, 18, 19, 20]];
    var matrizPrueba3=[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]];
    //console.log('exponente ' + completarConCeros(matrizPrueba2));
    console.log('multiplicaion' + multiplicarMatrices(matrizPrueba3,matrizPrueba));


}
