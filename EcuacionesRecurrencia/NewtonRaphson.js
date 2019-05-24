function newtonRaphson(coeficientes) {
    var xn = 1, xnSig;
    /*    for (let i = 0; i < 100; i++) {
     xnSig = xn + evaluarPolinomio(coeficientes, xn) / derivada(coeficientes, xn);
     xn = xnSig;
     }
     */    return evaluarPolinomio(coeficientes, xn);
}

function derivada(coeficientes, valor) {
    var h = 0.000000000001;
    var deriva = (evaluarPolinomio(coeficientes, valor + h) - evaluarPolinomio(coeficientes, valor)) / h;
    return deriva;
}

function evaluarPolinomio(coeficientes, valor) {
    var grado = coeficientes.length - 1;
    var resultado = 0;
    for (let i = 0; i < grado + 1; i++) {
        resultado = resultado + coeficientes[i] * Math.pow(valor, grado - i);
    }
    return resultado;
}

console.log(newtonRaphson([1, 2, 3, 4]));