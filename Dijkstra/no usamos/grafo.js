
function graficar() {
    var algo = {
        data: { id: '1' }
    };
    cytoscape({
        container: document.getElementById('cy'),

        elements: {
            nodes: [
                algo,

                {
                    data: { id: '2' }
                },
                {
                    data: { id: '3' }
                },
                {
                    data: { id: '4' }
                },
                {
                    data: { id: '5' }
                },
                {
                    data: { id: '6' }
                },
                {
                    data: { id: '7' }
                },
            ],
            edges: [
                {
                    data: { id: 'a', source: '1', target: '6' }
                },
                {
                    data: { id: 'b', source: '6', target: '3' }
                },
                {
                    data: { id: 'c', source: '6', target: '5' }
                },
                {
                    data: { id: 'd', source: '6', target: '7' }
                },
                {
                    data: { id: 'e', source: '1', target: '5' }
                },
                {
                    data: { id: 'f', source: '1', target: '2' }
                },
                {
                    data: { id: 'g', source: '2', target: '3' }
                },
                {
                    data: { id: 'h', source: '3', target: '4' }
                },
                {
                    data: { id: 'i', source: '4', target: '7' }
                },
                {
                    data: { id: 'j', source: '7', target: '5' }
                },
            ]
        },
        style: [ // the stylesheet for the graph
            {
                selector: 'node',
                style: {
                    'background-color': '#666',
                    'label': 'data(id)'
                }

            }],

        layout: {
            name: 'grid',
            rows: 1
        },


    });
}