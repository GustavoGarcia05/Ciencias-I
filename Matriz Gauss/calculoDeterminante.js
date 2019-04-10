var c;

//crea la matriz cuadrada segun el numero de la dimension
function armarMatriz(tamanio = document.getElementById("dimension").value) {
    var n = tamanio;
    var tabla = document.getElementById("tablaA");
    for (var i = 0; i < n; i++) {
        var f = tabla.insertRow(-1);
        for (var j = 0; j < n; j++) {
            var nid = "" + i + j;
            var z = f.insertCell(-1);
            var CELDA = "<input type=\"text\"";
            CELDA = CELDA + "id=\"" + nid + "\"";
            CELDA = CELDA + "size=\"1\">";
            z.innerHTML = CELDA;
        }
    }
}

//limpia la creacion de celdas de la tabla
function limpiarMatriz() {
    var t = document.getElementById("tablaA");
    for (var i = t.rows.length - 1; i >= 0; i--) {
        t.deleteRow(i);
    }
}

//captura los datos ingresados por el usuario
function capturarmatriz(n) {
    var mat = new Array(n);
    for (var i = 0; i < n; i++) {
        mat[i] = new Array(n);
        for (var j = 0; j < n; j++) {
            var temp = document.getElementById("" + i + j).value;
            mat[i][j] = Number(temp);
        }
    }
    return mat;
}

function calcularDeterminante(array) {
    var tam = array.length;//tamanio de la matriz cuadradada
    console.log("tamanio: " + tam);

    for (var i = 0; i < tam - 1; i++) {

        for (var j = i + 1; j < tam; j++) {

            for (var k = i + 1; k < tam; k++) {
                array[k][j] = array[k][j] - (array[k][i] * array[i][j]) / array[i][i];
            }
        }
    }

    var traza = 1;

    for (var h = 0; h < tam; h++) {
        traza = traza * array[h][h];
    }
    console.log("matriz resultante: " + array);
    console.log("determinante: " + traza);

    return traza;
}

function determinante(mat, n) {
    var negativo = false;
    c = 1;
    for (var i = 0; i < n - 1; i++) {
        c = c + 5;
        //Aqui cambia filas cada vez que el pivote da 0 
        for (var r = i + 1; r < n; r++) {
            if (mat[i][i] == 0) {
                h = mat[i];
                mat[i] = mat[r];
                mat[r] = h;
                negativo = !negativo;
            }
        }

        // si no hay pivotes en 0 Reduce la Matriz Normalmente
        for (var j = i + 1; j < n; j++) {
            c = c + 4;
            for (var k = i + 1; k < n; k++) {
                c = c + 16;
                mat[j][k] = mat[j][k] - ((mat[j][i] * mat[i][k]) / mat[i][i]);
            }
            c = c + 1
        }
        c = c + 1;
    }
    c = c + 2;
    var det = 1;
    c = c + 2;


    //este for hace la multiplicacion de la diagonal principal reducida
    for (i = 0; i < n; i++) {
        c = c + 6;
        det = det * mat[i][i];
    }

    // Cada Cambio de fila multiplica todo el determinante por -1
    if (negativo) {
        det = -det;
    }
    c = c + 1;

    if (Number.isNaN(det)) {
        alert("�El determinante no existe!");
    }

    // muestra el determinante redondeado en 2 decimales
    var h = document.getElementById('detr');
    h.innerHTML = "" + Math.round((det * 100)) / 100;
    //muestra el contador del algoritmo
    var p = document.getElementById("contador");
    p.color = "white";
    p.innerHTML = "Contador=" + c;
    // muestra el calculo de la formula del algoritmo
    var res = (1 / 6) * ((32 * (n * n * n)) - (33 * (n * n)) + (73 * n));
    var K = document.getElementById('formula');
    K.innerHTML = "Formula=" + res;

    return det;
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