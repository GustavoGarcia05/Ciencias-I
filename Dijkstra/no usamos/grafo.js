function run() {
    var matAux = [
        [0, 4, 0, 0, 1, 7, 0],
        [0, 0, 3, 0, 0, 0, 0],
        [0, 0, 0, 2, 0, 2, 0],
        [0, 0, 0, 0, 0, 0, 5],
        [0, 0, 0, 0, 0, 4, 5],
        [0, 0, 0, 0, 0, 0, 1],
        [0, 0, 0, 0, 0, 0, 0]
    ];
    var MatrizPrueba = [
        [0, 2, 5],
        [0, 0, 7],
        [0, 0, 0]
    ];

    var matAux2 = [
        [0, 0, 5, 2, 7, 0, 0],
        [0, 0, 0, 3, 4, 0, 0],
        [0, 0, 0, 0, 0, 7, 1],
        [0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 5],
        [0, 0, 0, 0, 0, 0, 0]
    ];

    graficar(matAux);
}

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