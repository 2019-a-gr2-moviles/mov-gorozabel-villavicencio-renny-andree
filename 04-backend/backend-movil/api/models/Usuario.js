/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes:{
    nombreAtributo:{
        type:'string'
    },
    nombre:{
      type:'string',
      required:true
  },
  cedula:{
      type:'string',
      required:true,
      unique:true
  },
  username:{
      type:'string',
      required:true,
      unique:true
  },
  fechaNacimiento:{
      type:'string'
  },
  sueldo:{
      type:'number',
      min:100.00,
      max:5000,
      defaultsTo: 100.00
  },
  estaCasado:{
      type:'boolean',
      defaultsTo:false
  },
  latitudCasa:{
      type:'string'
  },
  longitudCasa:{
      type:'string'
  },
  tipoUsuario:{
      type:'string',
      enum:['normal','pendiente','premiun']
  },
  correo:{
      type:'string',
      isEmail:true
  }
}

};


// htto://localhost:1337/usuario

// ESTANDAR RESTFUL
// CREAR
// http://localhost:1337/usuario
// METODO HTTP: POST
// Body Params:usuario


// Actualizar
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// METODO HTTP: PUT
// Body Params:usuario

// Eliminar
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// METODO HTTP: DELETE

// Buscar por ID
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// METODO HTTP: GET

// Obtener todos (ENVIAR PARAMETROS DE BUSQUEDA)
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// METODO HTTP: GET

// EJEMPLOS
// 1) Buscar al usuario con nombre Renny Gorozabel
// http://localhost:1337/usuario?nombre=Renny Gorozabel
// 2) Buscar al usuario con nombre Renny Gorozabel y con cedula 1313305136
// http://localhost:1337/usuario?nombre=Renny Gorozabel&cedula=1313305136
// 3) Traer los primeros 5 despues de los primeros 10
// http://localhost:1337/usuario?limit=5&skip=10
// 4) Trae los registros ordenados por nombre
// http://localhost:1337/usuario?sort=nombre
// http://localhost:1337/usuario?sort=nombre DESC
// http://localhost:1337/usuario?sort=nombre ASC
// 5) Trae los registros que contengan en el nombre la letra "a"
// http://localhost:1337/usuario?where={"nombre":{"contains":"a"}}
// http://localhost:1337/usuario?where={"sueldo":{"<=":3000}}
// http://localhost:1337/usuario?where={"nombre":{"<=":"2018-01-01"}}
// http://localhost:1337/usuario?where={"nombre":{"endsWith":"@gmail.com"}}
