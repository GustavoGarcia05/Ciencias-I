// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages': ['corechart']});

function graficar(arreglo, id) {

    var data = new google.visualization.DataTable();
    data.addColumn('number', 'tamanio');
    data.addColumn('number', 'Opereciones elementales');
    data.addRows(arreglo);
    // Set chart options
    var options = {
        'title': 'Tamaño Vs OPeraciones Fundamentales',
        // 'width': 400,
        'height': 300,
        hAxis: {
            title: 'Tamaño'
        },
        vAxis: {
            title: 'Operaciones Fundamentales'
        }
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.LineChart(document.getElementById(id));
    chart.draw(data, options);
}

function graficarTodos(){

    var data = new google.visualization.DataTable();
    data.addColumn('number', 'tamanio');
    data.addColumn('number', 'Burbuja');
    data.addColumn('number', 'Seleccion');
    data.addColumn('number', 'Insercion');
    data.addColumn('number','Radix');
    
    data.addRows(generarDatosCombinados());
    // Set chart options
    var options = {
        'title': 'Tamaño Vs OPeraciones Fundamentales',
        // 'width': 400,
        'height': 600,
        hAxis: {
            title: 'Tamaño'
        },
        vAxis: {
            title: 'Operaciones Fundamentales'
        }
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.LineChart(document.getElementById('graficaComparativa'));
    chart.draw(data, options);
}