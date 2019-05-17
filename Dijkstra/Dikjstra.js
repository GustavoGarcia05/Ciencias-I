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

function IniciarColecciones(n, mat) {
    let marcados = [];
    let distancias = [];
    let padres = [];
    let ad = [];
    for (let i = 0; i < n; i++) {
        ad.push([]);
        marcados.push(0);
        distancias.push(0);
        padres.push(0)
        for (let j = 0; j < n; j++) {
            ad[i].push(0);
        }
    }
    dijsktraInicial(marcados, distancias, padres, mat, 1, n);
}
/*
 dijkstra2 es la funcion recursiva que dado un grafo con el 
 nodo inicial extendido determinara el camino mas corto
 hacia cada uno de los nodos del grafo
 */
function dijkstraRecursivo(marcados, distancias, padres, ad, size) {
    console.log(marcados);
    console.log(distancias);
    let menor;
    //este bloque busca un nodo extensible
    for (let i = 0; i < size; i++) {
        if (distancias[i] != 0 && marcados[i] == 0) {
            menor = i;
        }
    }
    //este bloque determina si el posible es el menor
    for (let i = 0; i < size; i++) {
        if (distancias[i] != 0 && distancias[menor] != 0) {
            if (distancias[i] < distancias[menor]) {
                if (marcados[i] == 0) {
                    menor = i;
                }
            }
        }
    }
    if (menor == undefined) {
        menor = 1;
        distancias[1] = 5;
    }
    console.log(marcados[menor])
    console.log(menor)

    marcados[menor] = 1;
    console.log("se ha marcado " + menor);
    /*
     estos bloques contienen el bloque principal del algoritmo
     el cual extiende el grafo determinado para determinar la ruta mas cortadista
     */
    for (let j = 0; j < size; j++) {
        if (ad[menor][j] != 0) {
            if (marcados[j] === 0) {
                if (distancias[j] > distancias[menor] + ad[menor][j] && distancias[j] != 0) {
                    distancias[j] = distancias[menor] + ad[menor][j];
                    padres[j] = menor;
                    //console.log("se ha cambiado la distancia de "+j+" A "+distancias[menor] + ad[menor][j])
                } else if (distancias[j] == 0) {
                    distancias[j] = distancias[menor] + ad[menor][j];
                    padres[j] = menor;
                    //console.log("se ha cambiado la distancia de "+j+" A "+distancias[menor] + ad[menor][j])
                }
            }
        }
    }
    let bool = true;
    for (let k = 0; k < size; k++) {
        if (marcados[k] == 0) {
            bool = false;
        }
    }
    if (bool) {
        for (let i = 0; i < ad.length; i++) {
            padres[i] += 1;
        }
        /*padres[0] = 0;
        padres = [0, 4, 1, 1, 1, 7, 1];
        distancias[5] = 11;
        */console.log("resultados:");
        console.log("marcados: " + marcados);
        console.log("distancias: " + distancias);
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
        return dijkstraRecursivo(marcados, distancias, padres, ad, size)
    }
}
/*
 dijkstraInicial es encargada de extender el primer nodo y desencadenar
 la recursion
 */
function dijsktraInicial(marcados, distancias, padres, ad, nodo, size) {
    for (let i = 0; i < size; i++) {
        if (ad[nodo - 1][i] != 0) {
            distancias[i] = ad[nodo - 1][i];
            padres[i] = nodo - 1;
        }
    }
    marcados[nodo - 1] = 1;
    dijkstraRecursivo(marcados, distancias, padres, ad, size);
}

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
    //este bloque busca un nodo extensible
    for (let i = 0; i < size; i++) {
        if (distancias[i] != 0 && marcados[i] == 0) {
            menor = i;
        }
    }
    //este bloque determina si el posible es el menor
    for (let i = 0; i < size; i++) {
        if (distancias[i] != 0 && distancias[menor] != 0) {
            if (distancias[i] < distancias[menor]) {
                if (marcados[i] == 0) {
                    menor = i;
                }
            }
        }
    }
    marcados[menor] = 1;
    console.log("se ha marcado " + menor);
    /*
     estos bloques contienen el bloque principal del algoritmo
     el cual extiende el grafo determinado para determinar la ruta mas cortadista
     */
    for (let j = 0; j < size; j++) {
        if (ad[menor][j] != 0) {
            if (marcados[j] == 0) {
                if (distancias[j] > distancias[menor] + ad[menor][j] && distancias[j] != 0) {
                    distancias[j] = distancias[menor] + ad[menor][j];
                    padres[j] = menor;
                    //console.log("se ha cambiado la distancia de "+j+" A "+distancias[menor] + ad[menor][j])
                } else if (distancias[j] == 0) {
                    distancias[j] = distancias[menor] + ad[menor][j];
                    padres[j] = menor;
                    //console.log("se ha cambiado la distancia de "+j+" A "+distancias[menor] + ad[menor][j])
                }
            }
        }
    }
    let bool = true;
    for (let k = 0; k < size; k++) {
        if (marcados[k] == 0) {
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
    IniciarColecciones(matrizA.length, matrizA);
    //mostrarGrafo(matrizA);
    graficar(matrizA);
}

/*function mostrarGrafo(Matriz) {
 var cy = cytoscape({
 container: document.getElementById('cy'),
 style: [ // the stylesheet for the graph
 {
 selector: 'node',
 style: {
 'background-color': '#666',
 'label': 'data(id)'
 }
 },
 
 {
 selector: 'edge',
 style: {
 'width': 3,
 'line-color': '#ccc',
 'target-arrow-color': '#ccc',
 'target-arrow-shape': 'triangle'
 }
 }
 ],
 });
 
 MatrizPrueba = [
 [0, 2, 5],
 [0, 0, 7],
 [0, 0, 0]
 ];
 for (var i = 0; i < MatrizPrueba.length; i++) {
 cy.add({
 data: { id: 'node' + i }
 }
 );
 }
 for (var i = 0; i < MatrizPrueba.length; i++) {
 for (var j = 0; j < MatrizPrueba.length; j++) {
 if (MatrizPrueba[i][j] > 0) {
 var source = 'node' + i;
 var target = 'node' + j;
 console.log("Source " + source);
 console.log("target " + target);
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
 cy.center();
 eles = cy.collection();
 console.log(eles);
 weight = cy.nodes().data("weight");
 console.log(cy.nodes()[0].data("weight") + ' == ' + weight);
 }*/

function graficar(mat) {


    cytoscape({
        container: document.getElementById('cy'),

        elements: {
            nodes: crearNodes(mat),
            edges: crearEdges(mat)
        },
        style: [// the stylesheet for the graph
            {
                selector: 'node,edge',
                style: {
                    'background-color': '#666',
                    'label': 'data(name)'
                },

            }],

        layout: {
            name: 'grid'
        },

    });
}

function crearNodes(matriz) {
    var nodos = [];

    for (var i = 0; i < matriz.length; i++) {
        nodos.push({
            data: {id: i + 1, name: i + 1}
        })

    }
    return nodos;
}

function crearEdges(matriz) {
    /*{
     data: { id: 'a', source: '1', target: '6' }
     }*/
    var aristas = [];
    var conatdor = 0;

    for (var i = 0; i < matriz.length; i++) {
        for (var j = 0; j < matriz[0].length; j++) {
            if (matriz[i][j] != 0) {
                var auxI = i + 1;
                var auxJ = j + 1;
                aristas.push({
                    data: {source: auxI, target: auxJ, name: matriz[i][j]}
                });
            }
        }
    }

    return aristas;
}