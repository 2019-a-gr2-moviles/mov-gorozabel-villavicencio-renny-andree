/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type:'string'
    },
    // CONFIGURACON DEL HIJO
    fkUsuario:{ //NOMBRE DEL FK PARA LA RELACION
      model:'usuario' // MODELO CON EL QUE SE VA A RELACIONAR
      // required:true  //OPCIONAL -> Siempre ingresar el FK
    }
  },

};

