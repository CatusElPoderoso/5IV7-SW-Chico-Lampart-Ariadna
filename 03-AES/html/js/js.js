// imports de otros archivos
const datos = require('../../main');

let data = cifrador( datos.accion, datos.texto, datos.llave );
document.getElementById("rs").innerHTML = `${data}`