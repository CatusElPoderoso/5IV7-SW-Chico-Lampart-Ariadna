
// imports
const colors = require('colors');
const fs = require('fs');

const archivo = (accion, data) => {
    const path = '../archivo.txt';
    console.log('\n',`${data.green}`,'\n');
    if(accion == 'cifrar'){
        fs.writeFileSync( path + '.cifrado', data );
    }if(accion == 'descifrar'){
        fs.writeFileSync( path + '.descifrado', data );
    }else{
        console.log('xd')
    }
};

// exports
module.exports = archivo;


