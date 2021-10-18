
// imports
const CryptoJS = require('crypto-js');

// cifrador
const cifrador = (accion, texto, llave) => {
    // en caso de cifrar
    if(accion == 'cifrar'){
        const textoCifrado = CryptoJS.AES.encrypt(texto, llave).toString();
        return textoCifrado;
    };
    // en caso de descifrar
    if(accion == 'descifrar'){
        const textoDescifrado = CryptoJS.AES.decrypt(texto, llave);
        const txtDesFormato = textoDescifrado.toString(CryptoJS.enc.Utf8);
        return txtDesFormato;
    };

};

// exports
module.exports = cifrador;








