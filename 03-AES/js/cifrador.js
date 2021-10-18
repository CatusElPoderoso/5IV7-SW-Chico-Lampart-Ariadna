
// imports
const CryptoJS = require( 'crypto-js' );


// cifrador
const cifrador = ( accion, texto, contraseña ) => {

    if ( accion == 'cifrar' ) {
        const textoCifrado = CryptoJS.AES.encrypt( texto, contraseña ).toString();
        return textoCifrado;
    };
    if ( accion = 'descifrar' ) {
        const textoDescifrado = CryptoJS.AES.decrypt( texto, contraseña );
        const txtDesFormato = textoDescifrado.toString(CryptoJS.enc.Utf8);
        return txtDesFormato;
    };

};


// exports
module.exports = cifrador;








