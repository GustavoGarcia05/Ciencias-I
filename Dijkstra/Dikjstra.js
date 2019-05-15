function crearMatrizA() {
    var filas = document.getElementById("filasA").value;
    var columnas = filas;
    var tabla = document.getElementById("tablaA");
    armarMatriz(filas, columnas, tabla, "A");
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

function verticeInicio() {
    var verticeInicio = document.getElementById("verticeInicio").value;
}



//-------------------------------- aca va mi codigo -----------------------//

/**Recibe una matriz y su tama�o para usar el algoritmo de Dijkstra
 * @param {type} n
 * @param {type} matriz
 * */
function dijkstra1(n, matriz) {
    let marcados = [];
    let distancias = [];
    let padres = [];
    let ad = [];
    console.log("de aqui para abajo es dijkstra");
    for (let i = 0; i < n; i++) {
        ad.push([]);
        marcados.push(0);
        distancias.push(0);
        padres.push(0);
        for (let j = 0; j < n; j++) {
            ad[i].push(0);
        }
    }
    dijkstraInicial(marcados, distancias, padres, matriz, 1, n);
}

function dijkstra2(marcados, distancias, padres, ad, size) {
    console.log(marcados);
    console.log(distancias);
    let menor;
    for (let i = 0; i < size; i++) {
        if (distancias[i] !== 0 && marcados[i] === 0) {
            menor = i;
        }
    }
    //console.log("el menor de momento es " + menor);
    for (let i = 0; i < size; i++) {
        if (distancias[i] !== 0 && distancias[menor] !== 0) {
            //console.log("son diferentes de 0 las distancias para i y menor "+distancias[i]+distancias[menor]); 
            if (distancias[i] < distancias[menor]) {
                //console.log("el i finalista es: "+i+marcados[i]);
                if (marcados[i] === 0) {
                    menor = i;
                }
            }
        }
    }
    marcados[menor] = 1;
    console.log("se ha marcado " + menor);
    for (let j = 0; j < size; j++) {
        if (ad[menor][j] !== 0) {
            if (marcados[j] === 0) {
                if (distancias[j] > distancias[menor] + ad[menor][j] && distancias[j] !== 0) {
                    distanciasObj[j] = distancias[menor] + ad[menor][j];
                    padresObj[j] = menor;
                    //console.log("se ha cambiado la distancia de "+j+" A "+distancias[menor] + ad[menor][j])
                } else if (distancias[j] === 0) {
                    distanciasObj[j] = distancias[menor] + ad[menor][j];
                    padresObj[j] = menor;
                    //console.log("se ha cambiado la distancia de "+j+" A "+distancias[menor] + ad[menor][j])
                }
            }
        }
    }
    let bool = true;
    for (let k = 0; k < size; k++) {
        if (marcados[k] === 0) {
            bool = false;
        }
    }
    if (bool) {
        console.log("resultados:");
        console.log("marcados: " + marcados);
        console.log("distancias: " + distancias);
        for (let i = 0; i < ad.length; i++) {
            padres[i] += 1;
        }
        console.log("padres: " + padres);
        console.log("matriz adya" + ad);
        var resultados = document.getElementById("resultados");
        var distanciasObj = document.getElementById("distancias");
        var padresObj = document.getElementById("padres");
        //var etiqueta3 = document.createElement("div");
        /*        var salto = document.createElement("br")
         etiqueta.id = "distancias";
         //etiqueta2.id = "marcados";
         etiqueta2.id = "padres";
         etiqueta.innerHTML = distancias;
         //etiqueta2.innerHTML = marcados;
         etiqueta2.innerHTML = padres;
         resultados.appendChild(etiqueta);
         resultados.appendChild(salto);
         resultados.appendChild(etiqueta2);
         resultados.appendChild(salto);
         resultados.appendChild(etiqueta3);
         resultados.appendChild(salto);
         */
        distanciasObj.textContent = "Distancias: " + distancias;
        padresObj.textContent = "Padres: " + padres;
        return distancias;
    } else {
        return dijkstra2(marcados, distancias, padres, ad, size);
    }
}

function dijkstraInicial(marcados, distancias, padres, ad, nodo, size) {
    for (let i = 0; i < size; i++) {
        if (ad[nodo - 1][i] !== 0) {
            distancias[i] = ad[nodo - 1][i];
            padres[i] = nodo - 1;
        }
    }
    marcados[nodo - 1] = 1;
    console.log("los marcados iniciales" + marcados);
    console.log("las distancias iniciales " + distancias);
    console.log("los padres iniciales son");
    dijkstra2(marcados, distancias, padres, ad, size);
}

function prueba() {
    var matrizA = capturarmatriz(document.getElementById("filasA").value, document.getElementById("filasA").value, "A");
    alert(matrizA);
    dijkstra1(matrizA.length, matrizA);
    //mostrarGrafo(matrizA);
}

function mostrarGrafo(Matriz) {
    var cy = cytoscape({
        container: document.getElementById('cy')
    });
    for (var i = 0; i < Matriz.length; i++) {
        cy.add({
            data: {id: 'node' + i}
        }
        );
        for (var j = 0; j < Matriz.length; j++) {
            if (Matriz[i][j] > 0) {
                var source = 'node' + i;
                var target = 'node' + j;
                cy.add({
                    data: {
                        id: 'edge' + i + j,
                        source: source,
                        target: target
                    }
                });

            }
        }
    }
}
