var boC = document.getElementById('cifCesar');
boC.addEventListener('click',method2);
function method2(){
  if(document.getElementById('desp').value > 26){
    document.getElementById("msjCesar").innerHTML = `Para el cifrado César solo puedes ingresar números entre 1 y 26`;
    console.log("evento prevenido")
    event.preventDefault();
  }
}