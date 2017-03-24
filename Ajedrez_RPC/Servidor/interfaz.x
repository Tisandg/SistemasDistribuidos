/*Declaracion de datos a transferir entre el cliente y el servidor*/

/*Declaracion de constantes*/

const MAXNOM = 30;
const MAXAPEL = 30;
const MAXCONT = 10;
const NUM_FICHAS = 28;

typedef struct nodo_usuario *proxNodo;

/*Declaracion de la estructura que permite almacenar los datos del usuario*/

struct nodo_usuario{
	char nombres[MAXNOM];
	char apellidos[MAXAPEL];
	int login;
	char contrasena[MAXCONT];
	int permiso;
	proxNodo nodoSiguiente; /*Atributo de usuario que le permite guardar la referencia al siguiente nodo*/
};

/*Declaracion de la estructura que permite guardar los datos para consultar un usuario*/

struct datosValidar{
	int login;
	char contrasena[MAXCONT];
	int permiso;
};

/*Declaracion de la estructura que permite almacenar una ficha*/

struct ficha{
	int lado_A;
	int lado_B;
	int id;	
};
typedef struct ficha ficha;

struct fichas{
	ficha fichasJugadores[NUM_FICHAS];	
};
typedef struct fichas fichas;


/*Definicion de las operaciones que se pueden realizar*/

program gestion_usuario{
	version gestion_usuario_version{
		bool autenticar_usuario(datosValidar)=1;
		bool registrarUsuario(proxNodo usuario)=2;
		proxNodo listarUsuarios(void)=3;
		bool eliminar_Usuario(datosValidar)=4;
		bool modificar_usuario(proxNodo usuario)=5;
		nodo_usuario consultarUsuario(datosValidar)=6;

		fichas repartir_fichas(int tamano)=7;
		fichas empezar_partida(void)=8;
		fichas enviar_jugada(int id_ficha)=9;
		fichas estado_tablero(void)=10;
		fichas estado_cliente(void)=11;
		int contar_puntos()=12;
		string consultar_estadisticas(void)=13;		
		bool salir()=14;

	}=1;
}=0x20000001;