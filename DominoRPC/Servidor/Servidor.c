/*
*
*@Autores:
*			El presenta proyecto fue desrrollado por las siguientes personas.
*			Jhonnier Kevin Chantré
*			David Santiago Garcia.
*
 */

#include "interfaz.h"
#include <dirent.h>
#include <stdlib.h>
#include <time.h>
#define FALSO 0
#define VERDAD 1

//Declaracion de Variables locales a Utilizar
FILE * usuarios=NULL;
proxNodo cabeza=NULL,sigUsuario;
fichas Todas_Fichas;
fichas Validas_Fichas;
fichas Servidor_fichas;
fichas Cliente_Fichas;
fichas Tablero;
fichas Tablero_Actual;
int vector_aux[28];
int lados_validos[2];
int tam_tablero=0;
int tam_servidor=0;
int tam_cliente=0;
int fichasColocadas_usuario;
int fichasColocadas_servidor;
int pasanAmbos=0;

//Declaracion de Funciones locales a Utilizar
void iniciar_app();
void Llenar_Todas_Fichas();
void Llenar_Validas_Fichas(int);
ficha* buscar_Ficha(int);
void dividir(fichas, int);
ficha* buscar_Ficha_v2(fichas, int, int, int);
ficha* buscar_Ficha_v3(fichas , int, int);
int Actualizar_Tablero(ficha*);
void lados_Tablero(fichas, int);
ficha* Jugada_Servidor();
void Imprimir_Fichas(fichas, int);
void Actualizar_Fichas_Usuarios(ficha*);
void Actualizar_Fichas_Servidor(ficha*);
void quitar_basura();
void Pintar_Tablero();
int existe(int[],int,int);
void guardar_estadistica(int);
int estado_fichas_cliente();
/*
*Función encargada de autenticar a los usuarios, de acuardo a un rol Administrador o Usuario
*retorna un boleano, que determina si los datos resividos por la funcion son validos o no..
*/
bool_t *
autenticar_usuario_1_svc(datosValidar *argp, struct svc_req *rqstp)
{
	static bool_t  result;
	result = FALSE;
	int permisos = argp->permiso;
	DIR *dir;

	if(permisos==0){

		printf("Buscando Administrador %d...\n",argp->login);
	    proxNodo nuevoUsuario;
		dir = opendir ("Administrador");
	    /* Miramos que no haya error */
		if (dir == NULL){
			printf("Error: No se puede abrir el directorio\n");
			return FALSE;;
		}
		/* Una vez nos aseguramos de que no hay error, se procede a  */

		char path[100]="./Administrador/admin.txt";
		FILE * usuarioarchivo = fopen(path,"r");
		nodo_usuario temp;
		fread(&temp,sizeof(nodo_usuario),1,usuarioarchivo);
		nuevoUsuario = &temp;
		if(nuevoUsuario->login == argp->login &&  strncmp(nuevoUsuario->contrasena,argp->contrasena,10)==0){
			printf("Administrador Encontrado\n");
			result = TRUE;
		}else{
			printf("Administrador No Encontrado\n");
			result = FALSE;
		}

	}else{
		printf("\nBuscando Usuario %d...",argp->login);
		DIR *dir;
		struct dirent *ent;
    	proxNodo nuevoUsuario;

		dir = opendir ("Usuarios");
    	/* Miramos que no haya error */
		if (dir == NULL){
			printf("Error: No se puede abrir el directorio\n");
			return FALSE;;
		}	
		/* Una vez nos aseguramos de que no hay error, se procede a  */
		/* leer uno a uno todos los archivos que hay */
	
	if (dir!=NULL){
		while ((ent = readdir (dir)) != NULL){
			if ( (strcmp(ent->d_name, ".")!=0) && (strcmp(ent->d_name, "..")!=0) ){
				char path[100]="./Usuarios/";
				nodo_usuario temp;
				strcat(path,ent->d_name);
				FILE * usuarioarchivo = fopen(path,"r");
				fflush(stdout);
				fread(&temp,sizeof(nodo_usuario),1,usuarioarchivo);
				nuevoUsuario = &temp;
				if(nuevoUsuario->login == argp->login &&  strncmp(nuevoUsuario->contrasena,argp->contrasena,10)==0){
					printf("Usuario Encontrado\n");
					Llenar_Todas_Fichas();
					result = TRUE;
					return &result;
				}
			}
			
		}
	}
	
	printf("Usuario NO Encontrado....\n");
	result = FALSE;
	return &result;
	}

	return &result;
}

/*
*Resive como parametro los datos de un usuario y los almacena en un archivo de texto
*retorna un boleano indicando si la operacion tubo exito o no....!
*/
bool_t *
registrarusuario_1_svc(proxNodo *argp, struct svc_req *rqstp)
{
	printf("\nRegistrando...");
	static bool_t  result = FALSE;
	printf("\nCreando nuevo Usuario: ");
	fflush(stdout);
	nodo_usuario Nuevo_Usuario;
	printf("%s",(*argp)->nombres);
	fflush(stdout);
	strcpy(Nuevo_Usuario.nombres,(*argp)->nombres);
	strcpy(Nuevo_Usuario.apellidos,(*argp)->apellidos);
	Nuevo_Usuario.login = (*argp)->login;
	strcpy(Nuevo_Usuario.contrasena,(*argp)->contrasena);
	Nuevo_Usuario.permiso = (*argp)->permiso;
	Nuevo_Usuario.nodoSiguiente = NULL;
	FILE * archivoAux;

	char archivo[100];
	char numero[30];
	if(Nuevo_Usuario.permiso == 0){
		/*Se va a registrar un administrador*/
		strcpy(archivo,"./Administrador/admin.txt");
	}else{
		/*Se va a registrar un usuario*/
		strcpy(archivo,"./Usuarios/usuario_");
		/*Pasar  login a cadena*/
		sprintf(numero, "%d", (*argp)->login);
		strcat(archivo,numero);
		strcat(archivo,".txt");
	}
	printf("\nComprobar que el id con que se va a registrar no existe\n");
	archivoAux = fopen(archivo,"r");
	if(archivoAux != NULL){
		/*El archivo se encuentra. Se procede a eliminarlo*/
		fclose(archivoAux);
		printf("Ya se encuentra registrado un archivo con el id %d\n",Nuevo_Usuario.login);
		fflush(stdout);
		result = FALSE;
	}else{
		/*El archivo no es encuentra*/
		printf("El archivo a eliminar no se encuentra\n");
		//fclose(archivoAux);
		usuarios = fopen(archivo,"a+b"); 
		if(usuarios!=NULL){
			fwrite(&Nuevo_Usuario,sizeof(nodo_usuario),1,usuarios);
			fclose(usuarios);
			printf("\n Registro creado correctamente");
			fflush(stdout);
			result = TRUE;
		}else{
			printf("\n Error al abrir el archivo");
			result = FALSE;	
		}
	}

	return &result;
}

/*
Funcion encargada de listar todos los usuarios almacenados en la carpeta "Usuarios"
retorna una lista con los datos de todos los usuarios encontrados...
*/
proxNodo *
listarusuarios_1_svc(void *argp, struct svc_req *rqstp)
{
	static proxNodo  result;
	
	free (cabeza);
	printf("\nListando usuarios...\n");
	/* Con un puntero a DIR abriremos el directorio */
	DIR *dir;
	/* en *ent habrá información sobre el archivo que se está "sacando" a cada momento */
	struct dirent *ent;
    proxNodo nuevoUsuario;
	char bufer [sizeof(nodo_usuario)] ;
	dir = opendir ("Usuarios");

	/* Miramos que no haya error */
	if (dir == NULL){
		printf("Error: No se puede abrir el directorio\n");
		return FALSE;;
	}	 
	/* Una vez nos aseguramos de que no hay error, se procede a  */
	/* leer uno a uno todos los archivos que hay */

	if (dir!=NULL){
			nodo_usuario temp;
		    while ((ent = readdir (dir)) != NULL){
				if ( (strcmp(ent->d_name, ".")!=0) && (strcmp(ent->d_name, "..")!=0) ){
					char path[1000]="./Usuarios/";
					strcat(path,ent->d_name);
					printf("%s \n",path);
					FILE * usuarioarchivo = fopen(path,"r");
					fread(&temp,sizeof(nodo_usuario),1,usuarioarchivo);
					nuevoUsuario = (proxNodo) malloc(sizeof(nodo_usuario));
					strcpy(nuevoUsuario->nombres,temp.nombres);
					strcpy(nuevoUsuario->apellidos,temp.apellidos);
					nuevoUsuario->login = temp.login;
					strcpy(nuevoUsuario->contrasena,temp.contrasena);
					nuevoUsuario->permiso = temp.permiso;
					
					if(cabeza==NULL){
						cabeza = nuevoUsuario;
						sigUsuario = cabeza;
					}else{
						sigUsuario->nodoSiguiente=nuevoUsuario;
						sigUsuario=nuevoUsuario;
					}
					printf("Login: %d\n",nuevoUsuario->login);
					sigUsuario->nodoSiguiente=NULL;
					fclose(usuarioarchivo); 
			    }
			}
	}
	closedir (dir);
	result = cabeza;
	printf("\nUsuarios listados correctamente...\n");

	return &result;
}

/*
*Elimina el archivo que contiene la informacion de un usuario e particular
*retorna un boleano indicando si la operacion fue exitosa o no....
*/
bool_t *
eliminar_usuario_1_svc(datosValidar *argp, struct svc_req *rqstp)
{
	static bool_t  result =FALSE;

	DIR *dir;
	/* en *ent habrá información sobre el archivo que se está "sacando" a cada momento */
	struct dirent *ent;
	proxNodo nuevoUsuario;
	if(argp->permiso == 1){
		dir = opendir ("Usuarios");
	}else{
		dir = opendir ("Administrador");
	}
	
	/* Miramos que no haya error */
	if (dir == NULL){
		printf("Error: No se puede abrir el directorio\n");
		return FALSE;;
	}
	/* Una vez nos aseguramos de que no hay error, se procede a  */
	/* leer uno a uno todos los archivos que hay */

	if (dir!=NULL){
		char path[100];
		char numero[30];
		FILE * usuarioarchivo;	
		if(argp->permiso == 1){
			/*Eliminar archivo usuario*/
			strcpy(path,"./Usuarios/usuario_");
			sprintf(numero, "%d", argp->login);
			strcat(path,numero);
			strcat(path,".txt");
		}else{
			/*Eliminar archivo administrado*/
			strcpy(path,"./Administrador/admin.txt");
		}
		//printf("\nPATH: %s \n",path);
		usuarioarchivo = fopen(path,"r");
		if(usuarioarchivo != NULL){
			/*El archivo se encuentra. Se procede a eliminarlo*/
			fclose(usuarioarchivo);
			if(remove(path)==0){
				printf("El archivo del usuario a sido eliminado\n");
				result = TRUE;
			}else{
				result = FALSE;			
			}
		}else{
			/*El archivo no es encuentra*/
			printf("El archivo a eliminar no se encuentra");
		}
		
	}
	return &result;
}

/*
Modifica la informacion de un suario en el arcivo donde se almacenan sus datos
retoena un boleano indicando si la operacion tubo exit o no
*/
bool_t *
modificar_usuario_1_svc(proxNodo *argp, struct svc_req *rqstp)
{
	static bool_t  result;
	/*
	 * insert server code here
	 */
	return &result;
}

/*
Busca un usuario deacuerdo a su login y contraseña en los archivos de la carpeta "Usuarios"
retorna la informacion de dicho usuario
*/
nodo_usuario *
consultarusuario_1_svc(datosValidar *argp, struct svc_req *rqstp)
{
	static nodo_usuario result;

	DIR *dir;
	printf("Buscando usuario %d...\n",argp->login);
	/* en *ent habrá información sobre el archivo que se está "sacando" a cada momento */
	struct dirent *ent;
    proxNodo nuevoUsuario;

	dir = opendir ("Usuarios");
    /* Miramos que no haya error */
	if (dir == NULL){
		printf("Error: No se puede abrir el directorio\n");
		return FALSE;;
	}	 
	/* Una vez nos aseguramos de que no hay error, se procede a  */
	/* leer uno a uno todos los archivos que hay */
	
	if (dir!=NULL){
		while ((ent = readdir (dir)) != NULL){
			if ( (strcmp(ent->d_name, ".")!=0) && (strcmp(ent->d_name, "..")!=0) ){
				char path[1000]="./Usuarios/";
				nodo_usuario temp;
				strcat(path,ent->d_name);
				FILE * usuarioarchivo = fopen(path,"r");
				fflush(stdout);
				fread(&temp,sizeof(nodo_usuario),1,usuarioarchivo);
				nuevoUsuario = &temp;
				//if(nuevoUsuario->login == argp->login &&  strncmp(nuevoUsuario->contrasena,argp->contrasena,30)==0){
				if(nuevoUsuario->login == argp->login ){
					strcpy(result.nombres,nuevoUsuario->nombres);
					strcpy(result.apellidos,nuevoUsuario->apellidos);
					result.login = nuevoUsuario->login;
					strcpy(result.contrasena,nuevoUsuario->contrasena);
					result.permiso = nuevoUsuario->permiso;
					printf("\n Usuario Encontrado\n");

					return &result;
				}
			}
			
		}
	}
	printf("Usuario NO Encontrado....\n");
	return &result;
}

/*
Funcion que resive como parametro el numero de fichas con las cuales se va a desarrollar el juego.
retorna las fichas con las cuales empezara el cliente..
*/
fichas *
repartir_fichas_1_svc(int *argp, struct svc_req *rqstp)
{
	printf("Funcion repartir fichas en ejecución...\n");
	int tam = (*argp);
	printf("El servidor esta repartiendo las %d fichas...\n", tam);
	iniciar_app();
	Llenar_Validas_Fichas(tam);
	dividir(Validas_Fichas, tam);
	printf("\nSe han repartido las fichas.\n");
	printf("\nFICHAS SERVIDOR.\n");
	Imprimir_Fichas(Servidor_fichas, tam_servidor);

	return &Cliente_Fichas;
}


/*
Decide quien inicia el juego, si el cliente o el servidor deacuardo a  quien posea la ficha 6|6
retorna el Tablero con un estado inicial.(vacio o con la ficha 6|6 colocada)
*/
fichas *
empezar_partida_1_svc(void *argp, struct svc_req *rqstp)
{
	static fichas aux_tablero;
	ficha *Nueva_Ficha;
	printf("Tamaño vector Servidor_fichas :%d\n",tam_servidor);
	Nueva_Ficha = buscar_Ficha_v3(Servidor_fichas, 27, tam_servidor);
	printf("\nEMPIEZA EL JUEGO\n");
	if(Nueva_Ficha == (ficha *) NULL){
		printf("\nInicia el Usuario...\n");
		aux_tablero.fichasJugadores[0].id = -1;
		return &aux_tablero;
	}else{
		printf("\nInicia el Servidor...\n");
		Tablero.fichasJugadores[0].lado_A = (*Nueva_Ficha).lado_A;
		Tablero.fichasJugadores[0].lado_B = (*Nueva_Ficha).lado_B;
		Tablero.fichasJugadores[0].id = (*Nueva_Ficha).id;
		Tablero.fichasJugadores[0].estado = VERDAD;
		printf("El servidor ha colocado: [%d|%d]\n",(*Nueva_Ficha).lado_A,(*Nueva_Ficha).lado_B);
		printf("Sigue turno del usuario\n");
		Actualizar_Fichas_Servidor(Nueva_Ficha);
		Pintar_Tablero();
		tam_tablero = 0;
		tam_tablero++;
		Imprimir_Fichas(Tablero, tam_tablero);
		return &Tablero_Actual;
	}
}

/*
Recibe el identificador de una ficha escogida por el cliente, la coloca en el tablero e invoca a la funcion jugada_servidor
para retornar una respuesta al cliente en el tablero actualizado con las dos nuevas fichas.
*/
fichas *
enviar_jugada_1_svc(int *argp, struct svc_req *rqstp)
{
	int id_Ficha = (*argp);
	int repintar;
	static ficha Nueva_Ficha;
	static ficha Nueva_Ficha_Servidor;
	static fichas aux_tablero;

	printf("Se ha recebido la jugada del usuario.....\n");

	if (id_Ficha == -1){
		printf("El usuario pasa.\n");
		printf("El servidor esta pensando su jugada....\n");
		Nueva_Ficha_Servidor = (*Jugada_Servidor());
		printf("Ficha[%d]	lado_A=%d 	lado_B=%d estado : %d \n",
			Nueva_Ficha_Servidor.id, Nueva_Ficha_Servidor.lado_A, Nueva_Ficha_Servidor.lado_B, Nueva_Ficha_Servidor.estado);

		if (Nueva_Ficha_Servidor.estado == FALSO){
			printf("El servidor pasa .\n");
			aux_tablero.fichasJugadores[0].estado = 2;
			return &aux_tablero;
		}else{
			repintar = Actualizar_Tablero(&Nueva_Ficha_Servidor);
			tam_tablero++;
			Pintar_Tablero();
			if (repintar == VERDAD){
				printf("Ficha del servidor colocada en el Tablero...\n");
				Imprimir_Fichas(Tablero, tam_tablero);
				return &Tablero_Actual;
			}else{
				printf("\nError.....Al colocar la ficha seleccionada por el Servidor....\n");		
			}
		}
		return NULL;

	}else{
		Nueva_Ficha = (*buscar_Ficha(id_Ficha));  //Funcion
		printf("Ficha[%d]	lado_A=%d 	lado_B=%d estado : %d \n",
			Nueva_Ficha.id, Nueva_Ficha.lado_A, Nueva_Ficha.lado_B, Nueva_Ficha.estado);
		//Encargada de colocar la ficha en el arreglo Tablero, retorna un entero.
		repintar = Actualizar_Tablero(&Nueva_Ficha);
		Actualizar_Fichas_Usuarios(&Nueva_Ficha);

		if (repintar == VERDAD){
			printf("Ficha del usuario colocada en el Tablero...\n");
			tam_tablero++;
			printf("El servidor esta pensando su jugada....\n");
			Nueva_Ficha_Servidor = (*Jugada_Servidor());
			printf("Ficha[%d]	lado_A=%d 	lado_B=%d  estado : %d \n",
				Nueva_Ficha_Servidor.id, Nueva_Ficha_Servidor.lado_A, Nueva_Ficha_Servidor.lado_B, Nueva_Ficha_Servidor.estado);

			if (Nueva_Ficha_Servidor.estado == FALSO){
				printf("El servidor pasa .....\n");
				aux_tablero.fichasJugadores[0].estado = 2;
				return &aux_tablero;
			}else{
				repintar = Actualizar_Tablero(&Nueva_Ficha_Servidor);
				if (repintar == VERDAD){
					printf("Ficha del servidor colocada en el Tablero...\n");
					tam_tablero++;
					Pintar_Tablero();
					Imprimir_Fichas(Tablero, tam_tablero);
					return &Tablero_Actual;
				}else{
					printf("La Ficha recibida es invalida");
					aux_tablero.fichasJugadores[0].estado = 3;
					return &aux_tablero;		
				}
			}

		}else{
			printf("La Ficha resibida no es valida para el Juego...\n");
			aux_tablero.fichasJugadores[0].estado = 3;
			return &aux_tablero;
		}	
	}	

	return &Tablero;
}

fichas *
estado_tablero_1_svc(void *argp, struct svc_req *rqstp)
{
	Pintar_Tablero();
	return &Tablero_Actual;
}

fichas *
estado_cliente_1_svc(void *argp, struct svc_req *rqstp)
{
	static fichas aux_cliente;
	int estado = 0;
	estado = estado_fichas_cliente();
	if(estado == VERDAD){
		return &Cliente_Fichas;
	}else{
		aux_cliente.fichasJugadores[0].estado = -1;
		return &aux_cliente;
	}
	
}

int *
contar_puntos_1_svc(void *argp, struct svc_req *rqstp)
{
	static int  result;
	int puntos_cliente = 0;
	int puntos_servidor = 0;
	int i = 0;
	while(i < tam_cliente){
		if(Cliente_Fichas.fichasJugadores[i].estado != 1){
			puntos_cliente = puntos_cliente + Cliente_Fichas.fichasJugadores[i].lado_A;
			puntos_cliente = puntos_cliente + Cliente_Fichas.fichasJugadores[i].lado_B;
		}
		i++;
	}
	i = 0;
	while(i < tam_servidor){
		if(Servidor_fichas.fichasJugadores[i].estado != 1){
			puntos_servidor = puntos_servidor + Servidor_fichas.fichasJugadores[i].lado_A;
			puntos_servidor = puntos_servidor + Servidor_fichas.fichasJugadores[i].lado_B;
		}
		i++;
	}

	if (puntos_cliente < puntos_servidor){
		printf("El ganador es el cliente....\n");
		guardar_estadistica(0);
		result = 0;
	}else{
		if (puntos_cliente > puntos_servidor){
			printf("El ganador es el Servidor....\n");
			guardar_estadistica(0);
			result = 1;	
		}else{
			printf("A ocurrido un empate....\n");
			guardar_estadistica(0);
			result = 2;
		}	
	}
	return &result;
}

char **
consultar_estadisticas_1_svc(void *argp, struct svc_req *rqstp)
{
	static char * result;

	return &result;
}

bool_t *
salir_1_svc(void *argp, struct svc_req *rqstp)
{
	static bool_t  result;
	printf("El cliente se ha desconectado....\n");
	return &result;
}

int *
suma_piezas_cliente_1_svc(void *argp, struct svc_req *rqstp)
{
	static int puntos_cliente = 0;
	int i = 0;
	while(i < tam_cliente){
		if(Cliente_Fichas.fichasJugadores[i].estado != 1){
			puntos_cliente = puntos_cliente + Cliente_Fichas.fichasJugadores[i].lado_A;
			puntos_cliente = puntos_cliente + Cliente_Fichas.fichasJugadores[i].lado_B;
		}
		i++;
	}

	return &puntos_cliente;
}

fichas *
repartidas_servidor_1_svc(void *argp, struct svc_req *rqstp)
{
	return &Servidor_fichas;
}

fichas *
repartidas_cliente_1_svc(void *argp, struct svc_req *rqstp)
{
	return &Cliente_Fichas;
}

void guardar_estadistica(int ganador){

	printf("\nGuardando resultados de la partida...");
	fflush(stdout);
	char numero[10];
	sprintf(numero, "%d", ganador);
	FILE * archivoAux;

	char archivo[100];

		/*Se va a registrar un usuario*/
	strcpy(archivo,"./Estadisticas/usuario_123.txt");

		usuarios = fopen(archivo,"a+b"); 
		if(usuarios!=NULL){
			fwrite(numero,sizeof(char),1,usuarios);
			fclose(usuarios);
			printf("\n Registro creado correctamente");
			fflush(stdout);
		}else{
			printf("\n Error al abrir el archivo");
		}

}
/*Las Funciones Locales que utilizare*/

/*Llena el vector de estructuras con todas las fichas validas del juego
*@params void
*@return void
*/

void Llenar_Todas_Fichas(){
	int pos = 0, k = 0, p = 0;
	for(k=0; k<7; k++){
		for(p=k; p<7; p++){
			Todas_Fichas.fichasJugadores[pos].lado_A=k;
			Todas_Fichas.fichasJugadores[pos].lado_B=p;
			Todas_Fichas.fichasJugadores[pos].id=pos;
			Todas_Fichas.fichasJugadores[pos].estado=FALSO;
			pos++;
			}
		}
}
/*Fucnción encargada de seleccionar las fichas con las cuales se iniciara el juego
*@params entero que representa el numero de fichas con las cuales se iniciara el juego
*@return void
*/
void Llenar_Validas_Fichas(int tam){
	srand(time(NULL));
	int i=0;
	vector_aux[i] = 27;
	i++;

	while(i<tam){
		int randon = rand()%27;
		if(existe(vector_aux, randon, i) != FALSO){
			vector_aux[i] = randon;
			i++;
		}			 
	}
	i=0;
	while(i < tam){
		ficha *Nueva_Ficha;
		Nueva_Ficha = buscar_Ficha(vector_aux[i]);
		Validas_Fichas.fichasJugadores[i].lado_A = (*Nueva_Ficha).lado_A;
		Validas_Fichas.fichasJugadores[i].lado_B = (*Nueva_Ficha).lado_B;
		Validas_Fichas.fichasJugadores[i].id = (*Nueva_Ficha).id;
		i++;
	}
	printf("Fichas para el juego seleccionadas...\n");
}

/*Funcion que determina la ficha que usara el servidor como respesta a una jugada del cliente
*@params void
*@return un apuntador a una ficha elegida por el servidor
*/
ficha* Jugada_Servidor(){
	static ficha Nueva_Ficha;
	Nueva_Ficha.estado = FALSO;
	lados_Tablero(Tablero, tam_tablero);
	printf("lados_validos[0] = %d \n", lados_validos[0]);
	printf("lados_validos[1] = %d \n", lados_validos[1]);
	int i = 0;
	while(i < tam_servidor){
		if ((Servidor_fichas.fichasJugadores[i].estado != 1) && (Servidor_fichas.fichasJugadores[i].lado_A == lados_validos[0] || 
			Servidor_fichas.fichasJugadores[i].lado_B == lados_validos[0] || Servidor_fichas.fichasJugadores[i].lado_A == lados_validos[1] || 
			Servidor_fichas.fichasJugadores[i].lado_B == lados_validos[1])){
			
			Nueva_Ficha.lado_A = Servidor_fichas.fichasJugadores[i].lado_A;
			Nueva_Ficha.lado_B = Servidor_fichas.fichasJugadores[i].lado_B;
			Nueva_Ficha.id = Servidor_fichas.fichasJugadores[i].id;
			Nueva_Ficha.estado = VERDAD;

			Servidor_fichas.fichasJugadores[i].estado = Nueva_Ficha.estado;

			return &Nueva_Ficha;
		}

		i++;
	}

	return &Nueva_Ficha;
}

/*Busca una ficha dentro del vector que contiene las 28 piezas que conforman el Juego
*@params identificador de una ficha en particulas
*@return una ficha 
*/
ficha* buscar_Ficha(int id_Ficha){
	static ficha Nueva_Ficha;

	Nueva_Ficha.lado_A = Todas_Fichas.fichasJugadores[id_Ficha].lado_A;
	Nueva_Ficha.lado_B = Todas_Fichas.fichasJugadores[id_Ficha].lado_B;
	Nueva_Ficha.id = Todas_Fichas.fichasJugadores[id_Ficha].id;
	
	return &Nueva_Ficha;
}

/*Busca una ficha deacuerdo a los lados de la misma*/
ficha* buscar_Ficha_v2(fichas vector_aux, int lad_A, int lad_B, int tam){
	static ficha Nueva_Ficha;

	return &Nueva_Ficha;
}

/*Busca una ficha deacuerdo al id de la misma
*@params vector de fichas, identificador de una ficha, tamaño del vector
*@return una ficha
*/
ficha* buscar_Ficha_v3(fichas vector_aux, int id_Ficha, int tam){
	static ficha Nueva_Ficha;
	int i=0;
	while(i<tam){
		if ((vector_aux.fichasJugadores[i].id == id_Ficha)){
			Nueva_Ficha.lado_A = vector_aux.fichasJugadores[i].lado_A;
			Nueva_Ficha.lado_B = vector_aux.fichasJugadores[i].lado_B;
			Nueva_Ficha.id = vector_aux.fichasJugadores[i].id;
			return &Nueva_Ficha;
		}
		i++;
	}
	return NULL;
}

/*determina si un numero existe dentro de un vector o no.
*@params vector de tipo entro, numero a buscar, tamaño del vector
*@Return entero.
*/
int existe(int vector[], int numero, int tam){
	int i = 0;
	while(i < tam){
		if(vector[i] == numero)
			return FALSO;
		i++;
	}
	return VERDAD;
} 

/*Funcion encargada de dividir las fichas con las cuales se aya elegido iniciar a partida
en dos partes iguales de manera aleatoria.
*/
void dividir(fichas obj_fichas, int tam){
	printf("Empezamos a repartir las %d Piezas....\n",tam );

	srand(time(NULL));
	int v_aux1[14];
	int v_aux2[14];
	int v_aux_usadas[28];
	int i=0, j=0, k=0;

	while(i<tam){
		int randon = rand()%(tam);
		if(existe(v_aux_usadas, randon, i) != FALSO){
			if((i%2)==0){
				v_aux1[j] = randon;
				j++;
			}else{
				v_aux2[k] = randon;
				k++;
			}
			v_aux_usadas[i] = randon;
			i++;
		}
	}

	i=0;
	printf("Llenando Cliente_Fichas...\n");
	while(i < j){
		Cliente_Fichas.fichasJugadores[i].lado_A = Validas_Fichas.fichasJugadores[v_aux1[i]].lado_A;
		Cliente_Fichas.fichasJugadores[i].lado_B = Validas_Fichas.fichasJugadores[v_aux1[i]].lado_B;
		Cliente_Fichas.fichasJugadores[i].id = Validas_Fichas.fichasJugadores[v_aux1[i]].id;
		i++;
	}
	i = 0;
	printf("Llenando Servidor_fichas..\n");
	while(i < k){		
		Servidor_fichas.fichasJugadores[i].lado_A = Validas_Fichas.fichasJugadores[v_aux2[i]].lado_A;
		Servidor_fichas.fichasJugadores[i].lado_B = Validas_Fichas.fichasJugadores[v_aux2[i]].lado_B;
		Servidor_fichas.fichasJugadores[i].id = Validas_Fichas.fichasJugadores[v_aux2[i]].id;
		i++;
	}
	tam_cliente = j;
	tam_servidor = k;
}

int tam_Vector(fichas vector){
	int tam = 0;
	while(((vector.fichasJugadores[tam].id == '\0') && (vector.fichasJugadores[tam].lado_A == '\0') && (vector.fichasJugadores[tam].lado_B == '\0'))
		|| ((vector.fichasJugadores[tam].id != '\0') && (vector.fichasJugadores[tam].lado_A != '\0') && (vector.fichasJugadores[tam].lado_B != '\0')))
		tam++;
	return tam;
}

/*Funcion encargada de colocar una nueva ficha en el tablero*/
/*retorna un entero*/
int Actualizar_Tablero(ficha *Nueva_Ficha){
	lados_Tablero(Tablero, tam_tablero); //Llamado a funcion que ctualiza los posibles valores que puede recibir el tablero
	printf("Colocando la ficha en el Tablero...\n");
	//printf("lados_validos izq = %d \n", lados_validos[0]);
	//printf("lados_validos der = %d \n", lados_validos[1]);
	int i = 0;
	if(lados_validos[0]!=-1 && lados_validos[1]!=-1){
		if(lados_validos[1] == (*Nueva_Ficha).lado_A || lados_validos[1] == (*Nueva_Ficha).lado_B ||
			lados_validos[0] == (*Nueva_Ficha).lado_A || lados_validos[0] == (*Nueva_Ficha).lado_B){

				Tablero.fichasJugadores[tam_tablero].lado_A = (*Nueva_Ficha).lado_A;
				Tablero.fichasJugadores[tam_tablero].lado_B = (*Nueva_Ficha).lado_B;
				Tablero.fichasJugadores[tam_tablero].id = (*Nueva_Ficha).id;
				Tablero.fichasJugadores[tam_tablero].estado = VERDAD;
				return VERDAD;
		}else{
			return FALSO;
		}
		
	}else{
		Tablero.fichasJugadores[0].lado_A = (*Nueva_Ficha).lado_A;;
		Tablero.fichasJugadores[0].lado_B = (*Nueva_Ficha).lado_B;
		Tablero.fichasJugadores[0].id = (*Nueva_Ficha).id;
		Tablero.fichasJugadores[tam_tablero].estado = VERDAD;
		return VERDAD;
	}
	
	return FALSO;
}

/*Busca los lados validos de un tablero qe se resibe como parametro, es decir las posibles 2 fichas que se pueden
colocar sobre dicho tablero
*/
void lados_Tablero(fichas Tbl, int tam){
	int i=0;
	int izq, der, aux_izq, aux_der;

	if(tam > 0){
		while(i < tam){
			if(i==0){
				izq = Tbl.fichasJugadores[i].lado_A;
				der = Tbl.fichasJugadores[i].lado_B;
			}else{
				aux_izq = Tbl.fichasJugadores[i].lado_A;
				aux_der = Tbl.fichasJugadores[i].lado_B;

				if(der == aux_der)
					der = aux_izq;
				else
					if(der == aux_izq)
						der = aux_der;
					else
						if (izq == aux_izq)
							izq = aux_der;
						else
							if(izq == aux_der)
								izq = aux_izq;
			}
			i++;
		}
	lados_validos[0] = izq;
	lados_validos[1] = der;
	
	}else{
		lados_validos[0] = -1;
		lados_validos[1] = -1;	
	}
}

/*Imprime las fichas de un vector que se resibe como parametro*/
void Imprimir_Fichas(fichas Fichas_Imprimibles, int tam){
	int i = 0;
	printf("Fichas Tablero.....\n");
	while(i < tam){
		printf("Ficha[%d]	lado_A = %d   |   Lado_B = %d\n", Fichas_Imprimibles.fichasJugadores[i].id, 
			Fichas_Imprimibles.fichasJugadores[i].lado_A, Fichas_Imprimibles.fichasJugadores[i].lado_B);
		i++;
	}
	printf("================================\n");
}

/*Cambia el estado de las fichas que se vayan utilizando en el vector de fichas del Cliente*/
void Actualizar_Fichas_Usuarios(ficha *Nueva_Ficha){
	int i = 0;
	while(i < tam_cliente){
		if(Cliente_Fichas.fichasJugadores[i].id == (*Nueva_Ficha).id){
			Cliente_Fichas.fichasJugadores[i].estado = VERDAD;
		}
		i++;
	}
}

/*Determina si el cliente tiene fichas disponibles para jugar o si termino sus fichas...
retorna un entero
*/
int estado_fichas_cliente(){
	int i = 0;
	while(i < tam_cliente){
		if(Cliente_Fichas.fichasJugadores[i].estado == FALSO){
			return VERDAD;
		}
		i++;
	}
	return FALSO;
}

/*Cambia el estado de las fichas que se vayan utilizando en el vector de fichas del servidor*/
void Actualizar_Fichas_Servidor(ficha *Nueva_Ficha){
	int i = 0;
	while(i < tam_servidor){
		if(Servidor_fichas.fichasJugadores[i].id == (*Nueva_Ficha).id){
			Servidor_fichas.fichasJugadores[i].estado = VERDAD;
		}
		i++;
	}

}

/*Reinicia las  variables globales para atender nuevos jugadores*/
void iniciar_app(){
	tam_tablero = 0;
	tam_cliente = 0;
	tam_servidor = 0;
}

void quitar_basura(){
	int tam, i = 0;
	tam = sizeof(vector_aux) / sizeof(int);
	while(i < tam){
		vector_aux[i] = -1;
		i++;
	}
}

/*Retorna los lados disponibles del tablero en un vector de tipo entero de tamaño 2*/
void Pintar_Tablero(){
	int i = 0, j = 0;
	fichas aux_tablero;
	static ficha Nueva_Ficha;
	Tablero_Actual.fichasJugadores[i].lado_A = Tablero.fichasJugadores[i].lado_A;
	Tablero_Actual.fichasJugadores[i].lado_B = Tablero.fichasJugadores[i].lado_B;
	Tablero_Actual.fichasJugadores[i].id = Tablero.fichasJugadores[i].id;
	Tablero_Actual.fichasJugadores[i].estado = Tablero.fichasJugadores[i].estado;
	i++;
	while(i < tam_tablero){
		Nueva_Ficha.lado_A = Tablero.fichasJugadores[i].lado_A;
		Nueva_Ficha.lado_B = Tablero.fichasJugadores[i].lado_B;
		Nueva_Ficha.id = Tablero.fichasJugadores[i].id;
		Nueva_Ficha.estado = Tablero.fichasJugadores[i].estado;

		lados_Tablero(Tablero_Actual, i);
		//printf("lados_Tablero_actual[0] = %d \n", lados_validos[0]);
		//printf("lados_Tablero_actual[1] = %d \n", lados_validos[1]);

		if(lados_validos[1] == Nueva_Ficha.lado_A || lados_validos[1] == Nueva_Ficha.lado_B){
			//Se inserta la ficha en el lado derecho
			Tablero_Actual.fichasJugadores[i].lado_A = Nueva_Ficha.lado_A;
			Tablero_Actual.fichasJugadores[i].lado_B = Nueva_Ficha.lado_B;
			Tablero_Actual.fichasJugadores[i].id = Nueva_Ficha.id;
			Tablero_Actual.fichasJugadores[i].estado = Nueva_Ficha.estado;
			
		}else{
			if (lados_validos[0] == Nueva_Ficha.lado_A || lados_validos[0] == Nueva_Ficha.lado_B){
				//Se inserta la ficha en el lado izquierdo
				for (j = 0; j < i; j++){
					aux_tablero.fichasJugadores[j].lado_A = Tablero_Actual.fichasJugadores[j].lado_A;
					aux_tablero.fichasJugadores[j].lado_B = Tablero_Actual.fichasJugadores[j].lado_B;
					aux_tablero.fichasJugadores[j].id = Tablero_Actual.fichasJugadores[j].id;
					aux_tablero.fichasJugadores[j].estado = Tablero_Actual.fichasJugadores[j].estado;
				}
				Tablero_Actual.fichasJugadores[0].lado_A = Nueva_Ficha.lado_A;
				Tablero_Actual.fichasJugadores[0].lado_B = Nueva_Ficha.lado_B;
				Tablero_Actual.fichasJugadores[0].id = Nueva_Ficha.id;
				Tablero_Actual.fichasJugadores[0].estado = Nueva_Ficha.estado;
				
				for (j = 1; j < i; j++){
					Tablero_Actual.fichasJugadores[j].lado_A = aux_tablero.fichasJugadores[j-1].lado_A;
					Tablero_Actual.fichasJugadores[j].lado_B = aux_tablero.fichasJugadores[j-1].lado_B;
					Tablero_Actual.fichasJugadores[j].id = aux_tablero.fichasJugadores[j-1].id;
					Tablero_Actual.fichasJugadores[j].estado = aux_tablero.fichasJugadores[j-1].estado;
				}
					Tablero_Actual.fichasJugadores[j].lado_A = aux_tablero.fichasJugadores[j-1].lado_A;
					Tablero_Actual.fichasJugadores[j].lado_B = aux_tablero.fichasJugadores[j-1].lado_B;
					Tablero_Actual.fichasJugadores[j].id = aux_tablero.fichasJugadores[j-1].id;
					Tablero_Actual.fichasJugadores[j].estado = aux_tablero.fichasJugadores[j-1].estado;
			}else{
				printf("Error....en Pintar_Tablero....\n");
			}
		}
		i++;
	}
}
