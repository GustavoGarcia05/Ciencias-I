function dijsktra1(n, mat) {
    let marcados = [];
    let distancias = [];
    let padres = [];
    let ad = [];
    console.log("de aqui para abajo es dijkstra");
    var matPrueba = [
        [0, 1, 2, 0, 0, 0, 0],
        [1, 0, 3, 0, 0, 0, 0],
        [2, 3, 0, 2, 9, 7, 2],
        [0, 0, 2, 0, 1, 0, 0],
        [0, 0, 9, 1, 0, 1, 0],
        [0, 0, 7, 0, 1, 0, 1],
        [0, 0, 2, 0, 0, 1, 0]
    ]
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

function dijsktra2(marcados, distancias, padres, ad, size) {
    console.log(marcados);
    console.log(distancias);
    let menor;
    for (let i = 0; i < size; i++) {
        if (distancias[i] != 0 && marcados[i] == 0) {
            menor = i;
        }
    }
    //console.log("el menor de momento es "+menor);
    for (let i = 0; i < size; i++) {
        if (distancias[i] != 0 && distancias[menor] != 0) {
            //console.log("son diferentes de 0 las distancias para i y menor "+distancias[i]+distancias[menor]); 
            if (distancias[i] < distancias[menor]) {
                //console.log("el i finalista es: "+i+marcados[i]);
                if (marcados[i] == 0) {
                    menor = i;
                }
            }
        }
    }
    marcados[menor] = 1;
    console.log("se ha marcado " + menor);
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
        console.log("resultados:")
        console.log(marcados);
        console.log(distancias);
        console.log(padres);
        console.log(ad);
        var resultados = document.getElementById("resultados");
        var etiqueta = document.createElement("div");
        var etiqueta2 = document.createElement("div");
        var etiqueta3 = document.createElement("div");
        var salto = document.createElement("br")
        etiqueta.id = "distancias";
        etiqueta2.id = "marcados";
        etiqueta3.id = "padres";
        etiqueta.innerHTML = distancias;
        etiqueta2.innerHTML = marcados;
        etiqueta3.innerHTML = padres;
        resultados.appendChild(etiqueta);
        resultados.appendChild(salto);
        resultados.appendChild(etiqueta2);
        resultados.appendChild(salto);
        resultados.appendChild(etiqueta3);
        resultados.appendChild(salto);
        return distancias;
    } else {
        return dijsktra2(marcados, distancias, padres, ad, size)
    }
}

function dijsktraInicial(marcados, distancias, padres, ad, nodo, size) {
    for (let i = 0; i < size; i++) {
        if (ad[nodo - 1][i] != 0) {
            distancias[i] = ad[nodo - 1][i];
            padres[i] = nodo - 1;
        }
    }
    marcados[nodo - 1] = 1;
    console.log("los marcados iniciales" + marcados);
    console.log("las distancias iniciales " + distancias);
    console.log("los padres iniciales son")
    dijsktra2(marcados, distancias, padres, ad, size);
}

//dijsktra1(1);
function dibujaMatriz() {
    var matriz = document.getElementById("matriz");
    var n = parseInt(document.getElementById("n").value);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            var casilla = document.createElement("input");
            casilla.type = "text";
            casilla.id = i.toString() + j.toString();
            casilla.value = "0";
            casilla.size = "4";
            matriz.appendChild(casilla);
        }
        var division = document.createElement("br");
        matriz.appendChild(division);
    }
}

function matWrap() {
    var arr = [];
    var n = parseInt(document.getElementById("n").value);
    console.log("de aca para abajo es el wrap")
    for (let i = 0; i < n; i++) {
        arr.push([]);
        for (let j = 0; j < n; j++) {
            arr[i].push(parseInt(document.getElementById(i.toString() + j.toString()).value));
            console.log(document.getElementById(i.toString() + j.toString()).value);
        }
    }
    console.log(arr);
    dijsktra1(n, arr);
}
//un comentario aleatorio