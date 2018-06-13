function numeros (e) {
    /* es un´parámetro de entrada
     * 
     */
     tecla=(document.all)?e-keyCode:e.which;
     if(tecla==8)return true;
     /*corresponde a la tecla de retroceso para borar*/
     if(tecla==44)return true;
     /*corresponde a una coma (,) en el caso de decimales*/
   if(tecla==48)return true;//0
   if(tecla==49)return true;//1
   if(tecla==50)return true;//2
   if(tecla==51)return true;//3
   if(tecla==52)return true;//4
   if(tecla==53)return true;//5
   if(tecla==54)return true;//6
   if(tecla==55)return true;//7
   if(tecla==56)return true;//8
   if(tecla==57)return true;//9
   if(tecla==09)return true;//9
   if(tecla==11)return true;//9
  
  patron=/1/;
  te=String.fromCharCode(tecla);
  return patron.test(te);      
 }

function separador(donde, caracter) {
            pat = /[\*,\+,\(,\),\?,\,$,\[,\],\^]/
            valor = donde.value;
            largo = valor.length;
            crtr = true;
            if (isNaN(caracter) || pat.test(caracter) == true) {
                if (pat.test(caracter) == true) {
                    caracter = "/" + caracter;
                    //			caracter = "\" + caracter
                }
                carcter = new RegExp(caracter, "g");
                valor = valor.replace(carcter, "");
                donde.value = valor;
                crtr = false;
            }
            else {
                var nums = new Array()
                cont = 0;
                for (m = 0; m < largo; m++) {
                    if (valor.charAt(m) == "." || valor.charAt(m) == " ")
                    { continue; }
                    else {
                        nums[cont] = valor.charAt(m);
                        cont++
                    }
                }
            }
            var cad1 = "", cad2 = "", tres = 0
            if (largo > 3 && crtr == true) {
                for (k = nums.length - 1; k >= 0; k--) {
                    cad1 = nums[k];
                    cad2 = cad1 + cad2;
                    tres++
                    if ((tres % 3) == 0) {
                        if (k != 0) {
                            cad2 = "." + cad2;
                        }
                    }
                }
                donde.value = cad2;
            }
        }	