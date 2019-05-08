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
    var matrizA = capturarmatriz(document.getElementById("filasA").value, document.getElementById("columnasA").value, "A");
    var matrizB = capturarmatriz(document.getElementById("filasB").value, document.getElementById("columnasB").value, "B");


    multiplicarStrassen(matrizA, matrizB);
    //imprimirMatriz(' ', matrizC);

}


//Aqui empieza el codigo que estoy escribiendo 


//---------------------Operaciones internas de Strassen------------------
function subDividir(matriz) {
    var matrizSubdividida = [];
    var numeroSubMatrices = 4;
    var tamanioSubDivisiones = matriz.length / 2;

    var coordenadaX = 0;
    var coordenadaY = 0;

    for (var k = 0; k < numeroSubMatrices; k++) {
        var matrizAuxiliar = [];
        if (k < 2) {
            coordenadaX = 0;
            coordenadaY = k * (tamanioSubDivisiones);
        } else {
            coordenadaX = tamanioSubDivisiones;
            var kAux = k - (numeroSubMatrices / 2);
            coordenadaY = kAux * (tamanioSubDivisiones);
        }
        //console.log('x,y: ' + coordenadaX + ',' + coordenadaY);
        for (var i = coordenadaX; i < tamanioSubDivisiones + coordenadaX; i++) {
            matrizAuxiliar.push([]);
            for (var j = coordenadaY; j < tamanioSubDivisiones + coordenadaY; j++) {
                matrizAuxiliar[i - coordenadaX].push(matriz[i][j]);
            }
        }
        matrizSubdividida.push(matrizAuxiliar);
    }
    return matrizSubdividida;
}

function calcularPotenciaDe2AlaN(matriz) {
    var potenciaDe2AlaNActual;


    var numeroFilas = matriz.length;
    var numeroColumnas = matriz[0].length;

    var dimensionMayor = Math.max(numeroFilas, numeroColumnas);
    potenciaDe2AlaNActual = Math.ceil(Math.log(dimensionMayor) / Math.log(2));

    return potenciaDe2AlaNActual;
}
function calcularNuevaPotenciaDe2AlaN(potenciaDe2AlaNActual) {

    var nuevoExponente2AlaN = potenciaDe2AlaNActual;

    while (nuevoExponente2AlaN % Math.pow(2, potenciaDe2AlaNActual)) {
        nuevoExponente2AlaN += 1;
    }
    return nuevoExponente2AlaN;
}

//------------

function completarConCeros(matriz) {

    var nuevaMatriz = matriz;

    var numeroFilas = matriz.length;
    var numeroColumnas = matriz[0].length;

    var nuevaDimension = calcularNuevaPotenciaDe2AlaN(calcularPotenciaDe2AlaN(matriz));

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
    return matrizColumnasCompletadas;
}
//---------------

function reorganizarMatriz(matriz) {
    var matrizReorganizada = [];

    for (var i = 0; i < matriz[0].length; i++) {
        matrizReorganizada.push([matriz[0][i].concat(matriz[1][i])]);
    }

    for (var i = 0; i < matriz[2].length; i++) {
        matrizReorganizada.push([matriz[2][i].concat(matriz[3][i])]);
    }

    return matrizReorganizada;
}


//---------------- Multiplicar por Strassen-------------

function Strassenn(matrizA, matrizB) {


    if (verificarSiSePuedenMultiplicar(matrizA, matrizB)) {

        imprimirMatriz('matriz A: ', matrizA);
        console.log('------------------------');
        imprimirMatriz('matriz B: ', matrizB);
        console.log('+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-');

        var matrizACompletada = completarConCeros(matrizA);
        var matrizBCompletada = completarConCeros(matrizB);


        //A= matrizA Subdividida
        var A = subDividir(matrizACompletada);
        //B= matrizB Subdividida
        var B = subDividir(matrizBCompletada);

        if (matrizA.length == 2 && matrizB.length == 2) {
            //A11= matrizA[0] ; A12= matrizA[1] ; A21= matrizA[2] ; A22= matrizA[3]
            //B11= matrizB[0] ; B12= matrizB[1] ; B21= matrizB[2] ; B22= matrizB[3]

            var m1 = multiplicar(sumarMatrices(A[0], A[3]), sumarMatrices(B[0], B[3]));
            var m2 = multiplicar(sumarMatrices(A[2], A[3]), B[0]);
            var m3 = multiplicar(A[0], restarMatrices(B[1], B[3]));
            var m4 = multiplicar(A[3], restarMatrices(B[2], B[0]));
            var m5 = multiplicar(sumarMatrices(A[0], A[1]), B[3]);
            var m6 = multiplicar(restarMatrices(A[2], A[0]), sumarMatrices(B[0], B[1]));
            var m7 = multiplicar(restarMatrices(A[1], A[3]), sumarMatrices(B[2], B[3]));

        } else {
            //A11= matrizA[0] ; A12= matrizA[1] ; A21= matrizA[2] ; A22= matrizA[3]
            //B11= matrizB[0] ; B12= matrizB[1] ; B21= matrizB[2] ; B22= matrizB[3]

            var m1 = Strassenn(sumarMatrices(A[0], A[3]), sumarMatrices(B[0], B[3]));
            var m2 = Strassenn(sumarMatrices(A[2], A[3]), B[0]);
            var m3 = Strassenn(A[0], restarMatrices(B[1], B[3]));
            var m4 = Strassenn(A[3], restarMatrices(B[2], B[0]));
            var m5 = Strassenn(sumarMatrices(A[0], A[1]), B[3]);
            var m6 = Strassenn(restarMatrices(A[2], A[0]), sumarMatrices(B[0], B[1]));
            var m7 = Strassenn(restarMatrices(A[1], A[3]), sumarMatrices(B[2], B[3]));
        }



        var c11 = sumarMatrices(restarMatrices(sumarMatrices(m1, m4), m5), m7);
        var c12 = sumarMatrices(m3, m5);
        var c21 = sumarMatrices(m2, m4);
        var c22 = sumarMatrices(sumarMatrices(restarMatrices(m1, m2), m3), m6);


    } else {
        alert('No se pueden multiplicar las matrices; filas de A[i]: ' + matrizACompletada.length + ' diferentes de columnas de B[j]: ' + matrizBCompletada[0].length);
    }

    var matrizC = [c11, c12, c21, c22];
    var matrizMultiplicda = reorganizarMatriz(matrizC);

    return matrizMultiplicda;
}


//-----------------------Operaciones Varias-------------------

function imprimirMatriz(texto, matriz) {
    for (var i = 0; i < matriz.length; i++) {
        console.log(texto + matriz[i]);
    }
}

function sumarMatrices(matriz1, matriz2) {
    var matrizSumada = [];

    for (var i = 0; i < matriz1.length; i++) {
        matrizSumada.push([]);
        for (var j = 0; j < matriz1[i].length; j++) {
            matrizSumada[i].push(matriz1[i][j] + matriz2[i][j]);
        }
    }

    return matrizSumada;
}

function restarMatrices(matriz1, matriz2) {
    var matrizRestada = [];

    for (var i = 0; i < matriz1.length; i++) {
        matrizRestada.push([]);
        for (var j = 0; j < matriz1[i].length; j++) {
            matrizRestada[i].push(matriz1[i][j] - matriz2[i][j]);
        }
    }

    return matrizRestada;
}

function multiplicar(matriz1, matriz2) {
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

    return matrizMultiplicada;
}


function verificarSiSePuedenMultiplicar(matriz1, matriz2) {
    var sePuedeMultiplicar;

    if (matriz1[0].length == matriz2.length) {
        sePuedeMultiplicar = true;
    } else {
        sePuedeMultiplicar = false;
    }

    return sePuedeMultiplicar;

}

function mostrarMatriz(matriz) {
    // Obtener la referencia del elemento body
    //var body = document.getElementsByTagName("body")[0];

    var body = document.getElementById("resultado");

    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    // Crea las celdas
    for (var i = 0; i < matriz.length; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");

        for (var j = 0; j < matriz[0].length; j++) {
            // Crea un elemento <td> y un nodo de texto, haz que el nodo de
            // texto sea el contenido de <td>, ubica el elemento <td> al final
            // de la hilera de la tabla
            var celda = document.createElement("td");
            var textoCelda = document.createTextNode(matriz[i][j]);
            celda.appendChild(textoCelda);
            hilera.appendChild(celda);
        }
        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera);
    }

    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "2");
}

function limpiarCampo(){
    var limpia = document.getElementById("resultado");
    limpia.textContent= "Resultado AxB";
}






































function multiplicarStrassen(matrizA, matrizB) {

    if (verificarSiSePuedenMultiplicar(matrizA, matrizB)) {
        var matrizC = multiplicar(matrizA, matrizB);
        //imprimirMatriz(' ', matrizC);
        mostrarMatriz(matrizC);
        return matrizC;


    } else {
        alert('no se pueden multiplicar');
    }



}