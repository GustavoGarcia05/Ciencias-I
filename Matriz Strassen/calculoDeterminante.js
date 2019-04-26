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

//Aqui enpieza el codigo que estoy escribiendo 

function sumarMatrcices(matriz1, matriz2) {
    var matrizSumada=[];

    for (let i = 0; i < matriz1.length; i++) {
        for (let j = 0; j < matriz1.length; i++) {
            matrizSumada[i][j] = matriz1[i][j] + matriz2[i][j];
        }

    }

    return matrizSumada;
}

function sacarSeccionMatriz(matriz, coordenadaX, coordenadaY, tamanioSubdivision) { //rango de subdivision = tamanioSubdivision
    
    console.log('matriz: '+matriz);
    var matrizSubdividida=[];

    for (let i = coordenadaX; i < tamanioSubdivision + coordenadaX; i++) {
        for (let j = coordenadaY; i < tamanioSubdivision + coordenadaY; j++) {
            matrizSubdividida[i - coordenadaX][j - coordenadaY] = matriz[i][j];

        }
    }

    return matrizSubdividida;
}

function subDividirMatriz(matriz) {

    var a11, a12, a21, a22;
    var tamanioSeccion = matriz.length;

    a11 = sacarSeccionMatriz(matriz, 0, 0, tamanioSeccion);
    a12 = sacarSeccionMatriz(matriz, 0, tamanioSeccion, tamanioSeccion);
    a21 = sacarSeccionMatriz(matriz, tamanioSeccion, 0, tamanioSeccion);
    a22 = sacarSeccionMatriz(matriz, tamanioSeccion, tamanioSeccion, tamanioSeccion);
    
    console.log('matriz a11: '+a11);
    console.log('matriz a12: '+a12);
    console.log('matriz a21: '+a21);
    console.log('matriz a22: '+a22);

}

function probarPrograma(){
    var matrizPrueba=[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]];
    subDividirMatriz(matrizPrueba);
}
