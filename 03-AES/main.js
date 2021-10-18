
// imports
require('dotenv').config();
const express = require('express');
const bodyparser = require('body-parser');

// imports de otros archivos
const cifrador = require('./js/cifrador');
const generarArchivo = require('./js/archivo');

// servidor
const port = '3000';
const host = 'localhost';
const app = express();

// app setings
app.use(express.static('html'));
app.use(bodyparser.urlencoded({extended: true}));

// Para cuando se abra la página
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/html/index.html');
});

// Para cualquier otro caso
app.get('*', (req, res) => {
    res.sendFile(__dirname + '/html/404.html')
});

// /descargar
app.post('/descargar', (req, res) => {
    const datos = req.body;
    const data = cifrador( datos.accion, datos.texto, datos.llave );
    generarArchivo(datos.accion, data);
        if(datos.accion == 'cifrar'){
            res.download( '../archivo.txt.cifrado' );
        }else if(datos.accion == 'descifrar'){
            res.download( '../archivo.txt.descifrado' );
        }else{
            app.get( '*', (req, res) => {
                res.sendFile(__dirname + '/html/404.html')
            });
        };
});

// listen
app.listen(port, () => {
    console.log(`El servidor se está ejecutando en http://${host}:${port}`);
});
