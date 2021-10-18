
// imports
require( 'dotenv' ).config();
const express = require('express');
const bodyparser = require('body-parser');

// imports de otros archivos
const cifrador = require( './js/cifrador' );
const generarArchivo = require( './js/archivo' );


// app
const port = '3000';
const host = 'localhost';
const app = express();


// setings
app.use( express.static( 'html' ) );
app.use( bodyparser.urlencoded({ extended: true }) )


// get /
app.get( '/', ( req, res ) => {
    res.sendFile( __dirname + '/html/index.html' );
});

/* 
// get /cifrador
app.get( '/cifrador', ( req, res ) => {
    res.sendFile( __dirname + '/html/cifrador.html' )
}); */


// get *
app.get( '*', ( req, res ) => {
    res.sendFile( __dirname + '/html/404.html' )
});


// post /descargar
app.post( '/descargar', ( req, res ) => {
    const datos = req.body;
    const data = cifrador( datos.accion, datos.texto, datos.contraseña );
    generarArchivo(datos.accion, data);
        if(datos.accion == 'cifrar'){
            res.download( '../archivo.txt.cifrado' );
        }if(datos.accion == 'descifrar'){
            res.download( '../archivo.txt.descifrado' );
        }else{
            app.get( '*', ( req, res ) => {
                res.sendFile( __dirname + '/html/404.html' )
            });
        }
        
});


// listen
app.listen( port, () => {
    console.log( `http://${host}:${port}` );
});
