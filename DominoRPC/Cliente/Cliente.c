/*
*
*@Author	Jhonnier Kevin Chantré
*@Author	David Santiago Garcia.
*
 */

	#include "interfaz.h"
	#include <stdio.h>

	/*Variable para contar el numero de fichas asiganadas para el usuario*/
	int tam_usuario = 0;
	/*Variable para guardar la cantidad de fichas*/
	int tam_tablero = 0;

	/*Menu principal. El primer que se muestra en pantalla una vez ejecutado*/
	void menuInicio(){
		printf("\n\n*****************  Bienvenido  ******************\n");
		printf("| 1. Administrador                              |\n");
		printf("| 2. Usuario                                    |\n");
		printf("| 3. Salir                                      |\n");
		printf("*************************************************\n");
	}
	/*Menu del administrador, antes de identificarse en el sistema*/
	void menuInicioAdmin(){
		printf("\n\n**************  Menu Administrador  **************\n");
		printf("| 1. Iniciar Sesion                             |\n");
		printf("| 2. Salir                                      |\n");
		printf("*************************************************\n");
	}

	/*Menu del usuario. Se muestra una vez seleccione en el menu Inicio
	* la opcion Usuario*/
	void menuInicioUser(){
		printf("\n\n****************  Menu Usuario  ****************\n");
		printf("| 1. Iniciar Sesion                             |\n");
		printf("| 2. Registrarse                                |\n");
		printf("| 3. Salir                                      |\n");
		printf("*************************************************\n");
	}

	/*Menu del usuario una ves se identifique en el sistema*/
	void menuJuego()
	{
		printf("\n\n*****************  Domino RPC  *****************\n");
		printf("| 1. Empezar partida                            |\n");
		printf("| 2. Consultar estadisticas                     |\n");
		printf("| 3. Salir del juego                            |\n");
		printf("*************************************************\n");
	}


	/*Menu de las opciones del administrador una vez se halla identificado*/
	void menuAdministrador(){
		printf("\n\n***********  Funciones administrador  ***********\n");
		printf("| 1. Modificar datos usuario                    |\n");
		printf("| 2. Listar Usuarios                            |\n");
		printf("| 3. Eliminar Usuario                           |\n");
		printf("| 4. Modificar mi informacion                   |\n");
		printf("| 5. Salir                                      |\n");
		printf("| 6. informacion partida actual                 |\n");
		printf("*************************************************\n");
	}
	/*Menu para que el administrador decida que datos modificar de los usuario
	* @return opcion del campo a editar*/
	int menuModificarUsuario(){
		int opcion;
		printf("\nQue datos desea modificar del usuario?\n");
		printf("	1. Nombres\n");
		printf("	2. Apellidos\n");
		printf("	3. Contraseña\n");
		printf("	4. Atras\n");
		printf("Eliga una opcion: ");
		scanf("%d",&opcion);
		printf("\n");
		return opcion;
	}

	/*Menu para elegir la cantidad de fichas a jugar*/
	void menuTamFichas(){
		printf("\nPor favor, elija una opcion para el tamaño de las fichas \n");
		printf("| 1. 16                 |\n");
		printf("| 2. 18                 |\n");
		printf("| 3. 20                 |\n");
		printf("| 4. 22                 |\n");
		printf("| 5. 24                 |\n");
		printf("| 6. 26                 |\n");
		printf("| 7. 28                 |\n");
	}

	/*Menu que aparece cuando se esta jugando la partida de domino
	* @param Nombre jugador
	* @return opcion*/
	int menu_jugando(char nombre[]){
		int opc = 0;
		printf("\n\n********* %s Vs Servidor ********\n",nombre);
		printf("| 1. Elegir ficha                 |\n");
		printf("| 2. Salir de juego               |\n");
		printf("Elige una opcion: ");
		scanf("%d",&opc);
		printf("\n");
		return opc;
	}


	/*Procedimiento para imprimir las fichas. Imprime las que no se han utilizado
	* @param fichas, tamaño*/
	void Imprimir_Fichas(fichas *estado, int tam){
		int i = 0;
		while(i < tam){
			if((*estado).fichasJugadores[i].id != -1){
				printf("Ficha[%d] =	[ %d | %d ]\n", (*estado).fichasJugadores[i].id, 
				(*estado).fichasJugadores[i].lado_A,(*estado).fichasJugadores[i].lado_B);
			}
			i++;
		}
	}

	/*Procedimiento que imprimer todas las fichas, sin condicion
	* @param fichas, tamaño fichas*/
	void ImprimirTodas(fichas *estado, int tam){
		int i = 0;
		while(i < tam){
				printf("Ficha[%d] =	[ %d | %d ]\n", (*estado).fichasJugadores[i].id, 
				(*estado).fichasJugadores[i].lado_A,(*estado).fichasJugadores[i].lado_B);
			i++;
		}
	}

	/*funcion para imprimir el tablero. Solo imprime los valores de las fichas
	* @param fichas a imprimir, numero de fichas*/
	void imprimir_tablero(fichas *estado, int tam){
		int i = 0;
		while(i < tam){
			if((*estado).fichasJugadores[i].estado == 1){
				printf(" [%d|%d] ",(*estado).fichasJugadores[i].lado_A,(*estado).fichasJugadores[i].lado_B);
			}
			i++;
		}
	}

	/*confirmar procedimiento*/
	void Imprimir_Fichas_Usuario(fichas *usuario, int tam){
		int i = 0;
		while(i < tam){
			if((*usuario).fichasJugadores[i].estado != 1){
				printf("Ficha[%d]	lado_A = %d   |   Lado_B = %d\n", (*usuario).fichasJugadores[i].id, 
					(*usuario).fichasJugadores[i].lado_A,(*usuario).fichasJugadores[i].lado_B);
			}
			i++;
		}
	} 

	/*Valida que el usuario juegue fichas validas
	* @param arreglo de fichas, id ficha
	* @return respuesta validacion*/
	int validarFicha(fichas *usuario, int id_ficha){
		int rta=2, i = 0;
		while(i < tam_usuario){
			if((*usuario).fichasJugadores[i].id == id_ficha && (*usuario).fichasJugadores[i].estado == 1){
				return 0;
			}
			i++;
		}
		i = 0;
		while(i < tam_usuario){
			if((*usuario).fichasJugadores[i].id == id_ficha){
				return 1;
			}
			i++;
		}
		return rta;
	}


	/*Funcion para calcular el tamaño un arreglo de tipo char
	* @param arreglo char
	* @return tamaño arreglo*/
	int tamanoChar(char tabla[]){
		int tam=0;
		while (tabla[tam]!='\0'){ 
			tam++;
		}
		return tam;
	}

	/*Funcion para calcular el tamaño del fichas
	* @param Fichas
	* @return tamañoVector*/
	int tam_Vector(fichas *vector){
		int tam = 0;
		while(((*vector).fichasJugadores[tam].id != '\0')){ 
			tam++;
		}
		printf("Tamaño vector: %d\n",tam);
		return tam;
	}

void
gestion_usuario_1(char *host)
{
	CLIENT *clnt;
	bool_t  *result_1;
	datosValidar  autenticar_usuario_1_arg;
	bool_t  *result_2;
	proxNodo  registrarusuario_1_arg;
	proxNodo  *result_3;
	char *listarusuarios_1_arg;
	bool_t  *result_4;
	datosValidar  eliminar_usuario_1_arg;
	bool_t  *result_5;
	proxNodo  modificar_usuario_1_arg;
	nodo_usuario  *result_6;
	datosValidar  consultarusuario_1_arg;
	fichas  *result_7;
	int  repartir_fichas_1_arg;
	fichas  *result_8;
	char *empezar_partida_1_arg;
	fichas  *result_9;
	int  enviar_jugada_1_arg;
	fichas  *result_10;
	char *estado_tablero_1_arg;
	fichas  *result_11;
	char *estado_cliente_1_arg;
	int  *result_12;
	char *contar_puntos_1_arg;
	char * *result_13;
	char *consultar_estadisticas_1_arg;
	bool_t  *result_14;
	char *salir_1_arg;
	int  *result_15;
	char *suma_piezas_cliente_1_arg;
	fichas  *result_16;
	char *repartidas_servidor_1_arg;
	fichas  *result_17;
	char *repartidas_cliente_1_arg;

	/*Estructuras auxiliares*/
	nodo_usuario usuarionuevo;
	datosValidar  datos;
	/*Variables utilizadas en los menus*/
	int opcion1, opcionAux = 0, indice;
	/*Para contar el numero de jugadas realizadas por los jugadores*/
	int jugadas = 0;


	#ifndef	DEBUG
		clnt = clnt_create (host, gestion_usuario, gestion_usuario_version, "udp");
		if (clnt == NULL) {
			clnt_pcreateerror (host);
			exit (1);
		}
	#endif	/* DEBUG */


	do{
		/*Menu para seleccion si es usuario o administrador*/			
		menuInicio();
		printf("Seleccione una opcion: ");
		scanf("%d",&opcion1);
		printf("\n");
		switch(opcion1){

			/*ADMINISTRADOR*/
			case  1:
				do{
					/*Menu para que el administrador se identifique*/
					menuInicioAdmin();
					printf("Seleccione una opcion: ");
					scanf("%d",&opcionAux);
					printf("\n");
					switch(opcionAux){

					/*Iniciar sesion*/
					case 1:
						/*Se leen los datos ingresados por el administrador para iniciar sesion
						* Se validan los campos*/
						printf("Por favor ingrese los siguientes datos:");
						printf("\nLogin Administrador: ");
						scanf("%d",&datos.login);

						/*Se valida el campo login de administrador*/
						int nlogin = sizeof(datos.login)/sizeof(char);
						while(nlogin < 2 || nlogin > 15){
							printf("El login no puede ser menor a 3 y mayor a 15 caracteres!\n");
							printf("Vuelva a digitar el login: ");
							scanf("%d",&datos.login);
							nlogin = sizeof(datos.login)/sizeof(char);
						}

						printf("Contraseña administrador: ");
						scanf("%s",datos.contrasena);

						/*Se valida el campo contraseña de administrador*/
						int ncontrasena = sizeof(datos.contrasena)/sizeof(char);
						while(ncontrasena < 6 || ncontrasena > 15){
							printf("La contraseña no puede ser menor a 6 y mayor a 15 caracteres!\n");
							printf("Vuelva a digitar la contrasena: ");
							scanf("%s",datos.contrasena);
							ncontrasena = sizeof(datos.contrasena)/sizeof(char);
						}
						/*Permiso 0 para administrador*/
						datos.permiso = 0;
						autenticar_usuario_1_arg = (datos);

						/*Se llama a la funcion remota para autenticar el administrador*/
						result_1 = autenticar_usuario_1(&autenticar_usuario_1_arg, clnt);
						if (*result_1 == FALSE) {
							printf("No se ha encontrado el administrador\n");
							printf("Revisa que los datos esan correctos");
							clnt_perror (clnt, "call failed");//No se encuentra el administrador
						}else{
							printf("\n		SESION INICIADA");
							printf("\n	   ¡Bienvenido Administrador!");
							int opcionAdmin;
							datosValidar datosAuxiliar;
							do{
								/*Una vez identificado en el sistema se mostrara el menu 
								* con las opciones que puede realizar*/
								menuAdministrador();
								printf("Seleccione una opcion: ");
								scanf("%d",&opcionAdmin);
								printf("\n");
								switch(opcionAdmin){

									/*Modificar datos*/
									case 1:
										printf("\n-------MODIFICAR USUARIOS-------\n");
										char * contrasena = (char*)malloc(sizeof(char));
										int login;

										/*Se piden para buscar el usuario a modificar*/
										printf("\nDigite el login del usuario: ");
										scanf("%d",&consultarusuario_1_arg.login);
										fflush(stdin);
										consultarusuario_1_arg.permiso=1;

										/*Se llama a la funcion remota para consultar si el
										* usuario esta registrado*/
										result_6 = consultarusuario_1(&consultarusuario_1_arg, clnt);
										if (result_6->login == (int)NULL) {//Aqui presentaba un warning
											printf("Usuario no encontrado");
											clnt_perror (clnt, "call failed");
									
										}else{
											printf("\nUSUARIO ENCONTRADO");
											/*Imprimiendo datos del usuario*/
											printf("\nNombre del usuario: %s \n",(*result_6).nombres);
											printf("Apellido del usuario: %s \n",(*result_6).apellidos);
											printf("login del usuario: %d\n", (*result_6).login);

											/*Mantenemos los datos en usuario nuevo. 
											* Modificamos los que decida el administrador*/
											usuarionuevo = *result_6;
											
											/*Al modificar, se piden los nuevos datos del usuario*/
											int respuestaModificar;
											do{
												printf("\nMODIFICAR DATOS USUARIO:");
												respuestaModificar =menuModificarUsuario();
												switch(respuestaModificar){

													case 1:
														printf("\nMODIFICANDO NOMBRE");
														printf("\nPor favor, digite el nuevo nombre: ");
														scanf("%s", usuarionuevo.nombres);
														fflush(stdin);
														/*Se Valida el campo nombre del usuario*/
														int nnombre = tamanoChar(usuarionuevo.nombres);
														while(nnombre > 30){
															printf("El nombre no debe superar los 30 caracteres!\n");
															printf("Vuelva a digitar el nombre: ");
															scanf("%s", usuarionuevo.nombres);
															nnombre = tamanoChar(usuarionuevo.nombres);
														}

														eliminar_usuario_1_arg = consultarusuario_1_arg;
														/*Se llama a la funcion remota para eliminar el registro del usuario*/
														result_4 = eliminar_usuario_1(&eliminar_usuario_1_arg, clnt);
														if (result_4 == (bool_t *) NULL || result_4 == FALSE) {
															printf("No se ha podido modificar el usuario");
															clnt_perror (clnt, "call failed");
														}else{
															/*Se ha eliminado el registro del usuario
															* Se procede a crear un nuevo registro con los datos actualizados*/	
															registrarusuario_1_arg = &usuarionuevo;
															result_2 = registrarusuario_1(&registrarusuario_1_arg, clnt);
															if (result_2 == (bool_t *) NULL) {
																clnt_perror (clnt, "call failed");
															}else{
																printf("\nRegistro se ha modificado correctamente\n");
															}						
														}
														break;

													case 2:
														printf("\nMODIFICANDO APELLIDO");
														printf("\nPor favor, digite el nuevo apellido: ");
														scanf("%s", usuarionuevo.apellidos);
														fflush(stdin);
														/*Se Valida el campo apellido del usuario*/
														int napellido = tamanoChar(usuarionuevo.apellidos);
														while(napellido > 20){
															printf("El apellido no debe superar los 20 caracteres!\n");
															printf("Vuelva a digitar el apellido: ");
															scanf("%s", usuarionuevo.apellidos);
															fflush(stdin);
															napellido = tamanoChar(usuarionuevo.apellidos);
														}

														eliminar_usuario_1_arg = consultarusuario_1_arg;
														/*Se llama a la funcion remota para eliminar el registro del usuario*/
														result_4 = eliminar_usuario_1(&eliminar_usuario_1_arg, clnt);
														if (result_4 == (bool_t *) NULL || result_4 == FALSE) {
															printf("No se ha podido modificar el usuario");
															clnt_perror (clnt, "call failed");
														}else{
															/*Se ha eliminado el registro del usuario
															* Se procede a crear un nuevo registro con los datos actualizados*/	
															registrarusuario_1_arg = &usuarionuevo;
															result_2 = registrarusuario_1(&registrarusuario_1_arg, clnt);
															if (result_2 == (bool_t *) NULL) {
																clnt_perror (clnt, "call failed");
															}else{
																printf("\nRegistro se ha modificado correctamente\n");
															}						
														}
														break;

													case 3:
														printf("\nMODIFICANDO CONTRASEÑA");
														printf("Digite la contraseña del usuario: ");
														scanf("%s", usuarionuevo.contrasena);
														fflush(stdin);
														/*Se valida el campo contrasena del usuario*/
														int ncontrasena = tamanoChar(usuarionuevo.contrasena);
														while(ncontrasena < 8 || ncontrasena > 15){
															printf("La contraseña no puede ser menor a 8 y mayor a 15 caracteres!\n");
															printf("Vuelva a digitar la contrasena: ");
															scanf("%s", usuarionuevo.contrasena);
															ncontrasena = tamanoChar(usuarionuevo.contrasena);
														}

														eliminar_usuario_1_arg = consultarusuario_1_arg;
														/*Se llama a la funcion remota para eliminar el registro del usuario*/
														result_4 = eliminar_usuario_1(&eliminar_usuario_1_arg, clnt);
														if (result_4 == (bool_t *) NULL || result_4 == FALSE) {
															printf("No se ha podido modificar el usuario");
															clnt_perror (clnt, "call failed");
														}else{
															/*Se ha eliminado el registro del usuario
															* Se procede a crear un nuevo registro con los datos actualizados*/	
															registrarusuario_1_arg = &usuarionuevo;
															result_2 = registrarusuario_1(&registrarusuario_1_arg, clnt);
															if (result_2 == (bool_t *) NULL) {
																clnt_perror (clnt, "call failed");
															}else{
																printf("\nRegistro se ha modificado correctamente\n");
															}						
														}
														break;

													case 4:
														break;

													default:
														printf("\nOpcion Invalida!\n");
														break;
												}

											}while(respuestaModificar != 4);
										}

										break;
	
									/*Listar Usuarios*/
									case 2:
										printf("\n-------LISTADO DE USUARIOS-------\n");
										int cont = 1;
										/*Se llama a la funcion remota para mostrar en pantalla
										* la lista de todos los usuarios registrados en el sistema*/
										result_3 = listarusuarios_1((void*)&listarusuarios_1_arg, clnt);
										if (result_3 == (proxNodo *) NULL) {
											printf("No se han encontrado usuarios");
											clnt_perror (clnt, "call failed");
										}else{
											while((*result_3) != NULL)
											{
												printf("Identificacion del usuario %d: [%d] %s %s\n", 
												cont, (*result_3)->login,(*result_3)->nombres, (*result_3)->apellidos);
												(*result_3) = (*result_3)->nodoSiguiente;
												cont++;
											}
										}
										break;

									/*Eliminar usuario*/
									case 3:
										printf("\n-------ELIMINAR USUARIO-------\n");
										printf("\nPor favor, digite el login del usuario a eliminar");
										printf("\nDigite el login del usuario: ");
										scanf("%d", &datosAuxiliar.login);
										fflush(stdin);
										/*Se valida el campo login*/
										int nlogin = sizeof(datosAuxiliar.login)/sizeof(int);
										if(nlogin > 10){
											printf("El login no debe superar los 10 caracteres!\n");
											break;
										}

										datosAuxiliar.permiso = 1;
										consultarusuario_1_arg = (datosAuxiliar);
										/*Consultar si existe el usuario*/
										result_6 = consultarusuario_1(&consultarusuario_1_arg, clnt);
										if (result_6 == (nodo_usuario *) NULL) {
											clnt_perror (clnt, "call failed");
										}else{
											printf("\n El usuario exite");
											printf("\nNombre del usuario: %s \n",(*result_6).nombres);
											printf("Apellido del usuario: %s \n",(*result_6).apellidos);
											printf("login del usuario: %d\n", (*result_6).login);
											printf("\nEsta seguro que desea eliminarlo?");
											printf("\n 	1. Si 		2. No");
											printf("\nOpcion: ");
											int respuesta;
											scanf("%d",&respuesta);
											if(respuesta == 1){
												eliminar_usuario_1_arg = (datosAuxiliar);
												/*Se ha encontrado el usuario
												* Se llama a la funcion remota para eliminarlo*/
												result_4 = eliminar_usuario_1(&eliminar_usuario_1_arg, clnt);
												if (result_4 == (bool_t *) NULL) {
													printf("Problemas al momento de eliminar usuario");
													clnt_perror (clnt, "call failed");
												}else{
													printf("\nEl usuario ha sido eliminado!.");									
												}
											}else{
												printf("\nVolviendo Atras...");
											}
										}
										
										break;

									/*Salir*/
									case 4:
										printf("\n-------MODIFICAR MI INFORMACION-------\n");

										printf("A continuacion, digite los nuevos valores.");

										printf("\nDigite el nombre: ");
										scanf("%s", usuarionuevo.nombres);
										fflush(stdin);
										/*Se Valida el campo nombre del usuario*/
										int nnombre = tamanoChar(usuarionuevo.nombres);
										while(nnombre > 30){
											printf("El nombre no debe superar los 30 caracteres!\n");
											printf("Vuelva a digitar el nombre: ");
											scanf("%s", usuarionuevo.nombres);
											nnombre = tamanoChar(usuarionuevo.nombres);
										}

										printf("Digite el apellido: ");
										scanf("%s", usuarionuevo.apellidos);
										fflush(stdin);
										/*Se Valida el campo apellido del usuario*/
										int napellido = tamanoChar(usuarionuevo.apellidos);
										while(napellido > 20){
											printf("El apellido no debe superar los 20 caracteres!\n");
											printf("Vuelva a digitar el apellido: ");
											scanf("%s", usuarionuevo.apellidos);
											fflush(stdin);
											napellido = tamanoChar(usuarionuevo.apellidos);
										}

										/*Se asigna el mismo login ya que este no puede cambiar*/
										usuarionuevo.login = autenticar_usuario_1_arg.login;

										printf("Digite la contraseña: ");
										scanf("%s", usuarionuevo.contrasena);
										fflush(stdin);
										/*Se valida el campo contraseña de administrador*/
										int ncontrasena = sizeof(usuarionuevo.contrasena)/sizeof(char);
										while(ncontrasena < 6 || ncontrasena > 15){
											printf("La contraseña no puede ser menor a 6 y mayor a 15 caracteres!\n");
											printf("Vuelva a digitar la contrasena: ");
											scanf("%s",usuarionuevo.contrasena);
											ncontrasena = sizeof(usuarionuevo.contrasena)/sizeof(char);
										}
										usuarionuevo.permiso = 0;
										usuarionuevo.nodoSiguiente = NULL;

										
										/*Se llama a la funcion remota para eliminar el registro del usuario
										* Se envia la estructura autenticar_usuario_1_arg ya que estan
										* los datos de la sesion actual del administrador*/
										result_4 = eliminar_usuario_1(&autenticar_usuario_1_arg, clnt);
										if (result_4 == (bool_t *) NULL || result_4 == FALSE) {
											printf("No se ha podido modificar su informacion");
											clnt_perror (clnt, "call failed");
										}else{
											/*Se ha eliminado el registro del usuario
											* Se procede a crear un nuevo registro con los datos actualizados*/	
											printf("Se elimino el registro anterior\n");
											registrarusuario_1_arg = &(usuarionuevo);
											result_2 = registrarusuario_1(&registrarusuario_1_arg, clnt);
											if (result_2 == (bool_t *) NULL) {
												printf("ERROR: no se ha podido modificar la informacion");
												clnt_perror (clnt, "call failed");
											}else{
												printf("\nInformacion se ha modificado correctamente");
											}
										}
										break;	

									/*Salir al menu anterior*/
									case 5:
										printf("\nVolviendo al menu de inicio del administrador...");
										break;

									/*Funciones para mostrar e imprimir las fichas asignadas al cliente y servidos
									* en la partida que se juega actualmente.*/
									case 6:
										printf("Informacion para evaluar\n");
										result_17 = repartidas_cliente_1((void*)&repartidas_cliente_1_arg, clnt);
										if (result_17 == (fichas *) NULL) {
											clnt_perror (clnt, "call failed");
										}
										else{
											printf("FICHAS REPARTIDAS AL USUARIO\n");
											int fichasCliente = tam_Vector(result_17);
											ImprimirTodas(result_17,fichasCliente);
										}

										result_16 = repartidas_servidor_1((void*)&repartidas_servidor_1_arg, clnt);
										if (result_16 == (fichas *) NULL) {
											clnt_perror (clnt, "call failed");
										}else{
											printf("FICHAS REPARTIDAS SERVIDOR\n");
											int fichasServidor = tam_Vector(result_16);
											ImprimirTodas(result_16,fichasServidor);
										}

										break;
									default:
										printf("\nOpcion invalida");
										break;						
								}	
							}while(opcionAdmin != 5);							

						}

						break;
		
					/*SALIR*/
					case 2:
						printf("\nVolviendo al menu principal...");
						break;

					default:
						printf("\nOpcion no valida");
						break;
				}
				}while(opcionAux != 2);
				break;
			
			/*USUARIO*/
			case  2:
				opcionAux = 0;
				int nlogin;
				int ncontrasena;
				do{
					/*Menu mostrado una vez que elige entrar al sistema como usuario*/
					menuInicioUser();
					printf("Seleccione una opcion: ");
					scanf("%d",&opcionAux);
					printf("\n");
					switch(opcionAux){

						/*Iniciar sesion*/
						case 1:
							/*Se solicitan los datos requeridos para el inicio de sesion*/
							printf("Por favor ingrese los siguientes datos\n");
							printf("Login: ");
							scanf("%d",&datos.login);
							/*Se valida el campo login*/
							nlogin = sizeof(datos.login)/sizeof(char);
							if(nlogin > 10){
								printf("El login no puede ser menor a 10 caracteres!\n");
								break;
							}

							printf("Contraseña: ");
							scanf("%s",datos.contrasena);
							/*Se valida el campo contraseña*/
							int ncontrasena = sizeof(datos.contrasena)/sizeof(char);
							if(ncontrasena > 30){
								printf("La contraseña no puede ser menor a 8 y mayor a 15 caracteres!\n");
								break;
							}
							/*Se asigna permiso 1 ya que es usuario*/
							datos.permiso = 1;
							autenticar_usuario_1_arg = (datos);

							/*Se llama a la funcion remota para identificar al usuario*/
							result_1 = autenticar_usuario_1(&autenticar_usuario_1_arg, clnt);
							if (*result_1 == FALSE) {
								printf("\nUsuario no encontrado\n");
								clnt_perror (clnt, "call failed");
							}else{
								printf("\n		SESION INICIADA");
								/*Consultar informacion del usuario*/
								result_6 = consultarusuario_1(&autenticar_usuario_1_arg, clnt);
								if (result_6 == (nodo_usuario *) NULL) {
									clnt_perror (clnt, "call failed");
								}else{
									printf("\n	   ¡Bienvenido %s %s!",(*result_6).nombres,(*result_6).apellidos);
								}
								int opcionJuego;
								int opcionFichas = 0;
								do{ 
									/*Menu del juego*/
									menuJuego();
									printf("Seleccione una opcion: ");
									scanf("%d",&opcionJuego);
									printf("\n");
									switch(opcionJuego){

										/*Iniciar  partida*/
										case 1:
											printf("\n-------REPARTIR FICHAS-------\n");
											do{
												/*Se debe elegir una cantidad de fichas para empezar la partida*/
												menuTamFichas();
												printf("Seleccione una opcion: ");
												scanf("%d",&opcionFichas);
												printf("\n");
												switch(opcionFichas){
													case 1:
														repartir_fichas_1_arg = 16;
														break;
													case 2:
														repartir_fichas_1_arg = 18;
														break;
													case 3:
														repartir_fichas_1_arg = 20;
														break;
													case 4:
														repartir_fichas_1_arg = 22;
														break;
													case 5:
														repartir_fichas_1_arg = 24;
														break;
													case 6:
														repartir_fichas_1_arg = 26;
														break;
													case 7:
														repartir_fichas_1_arg = 28;
														break;
													default:
														printf("Tamaño invalido!.");
														break;
							
												}
											}while(opcionFichas< 1 || opcionFichas > 7);
	
											printf("Nuero de fichas selesccionadas :%d\n", repartir_fichas_1_arg);
											/*guardamos la cantidad de fichas, y la cantidad de fichas del usuario*/
											tam_usuario = repartir_fichas_1_arg/2;
											tam_tablero = repartir_fichas_1_arg;

											/*Una vez se tiene el tamaño de las fichas que ha elegido el usuario
											* las repartimos para empezar la partida*/
											result_7 = repartir_fichas_1(&repartir_fichas_1_arg, clnt);

											if (result_7 == (fichas *) NULL) {
												clnt_perror (clnt, "call failed");
											}else{
												printf("\nLas fichas se han repartido...\n");
												printf("Estas son tus Fichas:  \n");
												Imprimir_Fichas(result_7,tam_usuario);
												//Imprimir_Fichas_Usuario(result_7,tam_usuario);
											}

											/*Empieza la partida!
											* empezamos por comprobar quien tiene la ficha 6|6. quien la tiene
											* inicia la partida*/

 											result_8 = empezar_partida_1((void*)&empezar_partida_1_arg, clnt);
											if (result_8 == (fichas *) NULL) {
												clnt_perror (clnt, "call failed");
											
											}else{	
												printf("\nEMPIEZA EL JUEGO\n");
												if((*result_8).fichasJugadores[0].id == -1){
													/*Inicia el usuario. Coloca la ficha y la envia al servidor*/
													printf("\nINICIA EL USUARIO.....\n");
													printf("\nSeleccione la ficha 6|6 para iniciar la partida: ");
													scanf("%d",&enviar_jugada_1_arg);
													while(enviar_jugada_1_arg != 27){
														printf("Por favor, digite el id de la ficha 6|6: ");
														scanf("%d",&enviar_jugada_1_arg);	
													}
													jugadas++;
													result_9 = enviar_jugada_1(&enviar_jugada_1_arg, clnt);
													if (result_9 == (fichas *) NULL) {
													clnt_perror (clnt, "call failed");
													}else{
														/*Se imprime la informacion del tablero*/
														jugadas++;	
														printf("\n**********  TABLERO  **********\n");
														imprimir_tablero(result_9,jugadas);
													}

												}else{
													/*Inicia el servidor. Se muestra en pantalla la fichas colocada por el
													* servidor. Tambien se imprime el estado del tablero*/
													jugadas++;
													printf("\nINICIA EL SERVIDOR\n");
													printf("El servidor ha colocado: [%d|%d]\n",(*result_8).fichasJugadores[0].lado_A,
													(*result_8).fichasJugadores[0].lado_B);
													result_10 = estado_tablero_1((void*)&estado_tablero_1_arg, clnt);
													if (result_10 == (fichas *) NULL){
														clnt_perror (clnt, "call failed");
													}
													else{
														printf("\n**********  TABLERO  **********\n");
														imprimir_tablero(result_10, jugadas);
														jugadas++;
													}

												}
												int opc = 0, id_ficha;
												/*Mientras no halla una condicion de empate ganador o que no puedan
												* mover fichas se seguiran colocando fichas*/
												do{
													opc = menu_jugando((*result_6).nombres);
													int fich = 0;
													switch(opc){
														case 1:
															//imprimir las fichas del usuario.
															result_11 = estado_cliente_1((void*)&estado_cliente_1_arg, clnt);
															if (result_11 == (fichas *) NULL)
																clnt_perror (clnt, "call failed");
															else{
																if((*result_11).fichasJugadores[0].estado == -1){
																	printf("EL usuario se quedo sin fichas........\n");
																	printf("Ganador el usuario\n");
																}else{
																	/*se imprimen las fichas disponibles por el usuario*/
																	Imprimir_Fichas_Usuario(result_11,tam_usuario);	
																	do{
																		printf("\nDigite el id de la Ficha a colocar : \n");
																		scanf("%d",&id_ficha);
																		/*Si la ficha es diferente de -1 se comprueba que es valida*/
																		if (id_ficha != -1){
																			/*Se llama a la funcion validar para verificar
																			* que la ficha digita por el usuario se puede jugar*/
																			fich = validarFicha(result_11, id_ficha);
																			if(fich == 0){
																				printf("Ya usaste esta Ficha....\n");
																			}else{
																				if(fich == 2){
																					printf("Ficha No valida.....\n");
																				}else{
																					/*Si la ficha es valida, se envia la jugada*/
																					result_9 = enviar_jugada_1(&id_ficha, clnt);
																					if ((*result_9).fichasJugadores[0].estado == 2) {
																						printf("El servidor pasa...\n");
																						result_10 = estado_tablero_1((void*)&estado_tablero_1_arg, clnt);
																						if (result_10 == (fichas *) NULL){
																							clnt_perror (clnt, "call failed");
																						}
																						else{
																							jugadas++;
																							imprimir_tablero(result_10, jugadas);
																						}
																					}else{
																						if((*result_9).fichasJugadores[0].estado == 3){
																							printf("La Ficha que enviaste no es valida.....\n");
																						}else{
																							jugadas = jugadas+2;
																							imprimir_tablero(result_9, jugadas);
																						}
																					}
																				}
																			}
																		}else{
																			/*El cliente ha digitado -1. Pasa la jugada*/
																			result_9 = enviar_jugada_1(&id_ficha, clnt);
																			if (result_9 == (fichas *) NULL){
																				clnt_perror (clnt, "call failed");
																			}
																			else{
																				if((*result_9).fichasJugadores[0].estado == 2){
																					printf("Ningun jugador puede Colocar Fichas....\n");
																					/*Como no se pueden colocar fichas se llama a la funcion
																					* contar_puntos_1 para saber el resultado de la partida*/
																					result_12 = contar_puntos_1((void*)&contar_puntos_1_arg, clnt);
																					if (result_12 == (int *) NULL) {
																						clnt_perror (clnt, "call failed");
																					}else{
																						if((*result_12) == 0)
																							printf("El ganador es el Usuario....\n");
																						else
																							if((*result_12) == 1)
																								printf("El ganador es el Servidor....\n");
																							else
																								if((*result_12) == 3)
																									printf("A ocurrido un empate......\n");
																						opc = 2;
																					}
																				}else{
																					jugadas++;
																					imprimir_tablero(result_9, jugadas);
																				}																	
																			}
																			fich = 1;
																		}
																	}while(fich == 2 || fich == 0);
																}
															}															

															break;

														case 2:
															printf("Seguro de terminar el juego....\n");
															break;

														default:
															printf("Opcion invalida....\n");
															break;
													}
												} while (opc != 2);
											}//fin else
											break;
										/*Consultar estadisticas*/
										case 2:

											/*Se solicitan las estadisticas. Se imprimen en pantalla*/
											printf("\n-------CONSULTANDO ESTADISTICAS-------\n");
											result_13 = consultar_estadisticas_1((void*)&consultar_estadisticas_1_arg, clnt);
											if (result_13 == (char **) NULL) {
												clnt_perror (clnt, "call failed");
											}else{
												printf("\nImprimiendo Estadisticas");
												printf("\n %s",*result_13);
											}
											break;

										/*Salir*/
										case 3:
											printf("\nVolviendo al menu de usuario...");
											break;

										default: 
											printf("\nOpcion no valida");
											break;
									}	
								}while(opcionJuego != 3);
							}
							break;

						/*Registrarse*/
						case 2:
							/*Se piden los datos nesesarios para el registro de un nuevo usuario*/
							printf("\n-------REGISTRO DE USUARIO-------\n");

							printf("\nDigite nombre del usuario: ");
							scanf("%s", usuarionuevo.nombres);
							fflush(stdin);

							/*Se valida el campo nombre*/
							int nnombre = sizeof(usuarionuevo.nombres)/sizeof(char);
							if(nnombre > 30)
							{
								printf("El nombre no debe superar los 30 caracteres!\n");
								break;
							}


							printf("Digite apellido del usuario: ");
							scanf("%s", usuarionuevo.apellidos);
							fflush(stdin);

							/*Se valida el campo apellido*/
							int napellido = sizeof(usuarionuevo.apellidos)/sizeof(char);
							if(napellido > 30)
							{
								printf("El apellido no debe superar los 20 caracteres!\n");
								break;
							}

							printf("Digite el login del usuario: ");
							scanf("%d", &usuarionuevo.login);
							fflush(stdin);
							/*Se valida el campo login*/
							nlogin = sizeof(usuarionuevo.login)/sizeof(int);
							if(nlogin > 10){
								printf("El login no debe superar los 10 caracteres!\n");
								break;
							}

							printf("Digite la contraseña del usuario: ");
							scanf("%s", usuarionuevo.contrasena);
							fflush(stdin);
							/*Se valida el campo contraseña*/
							ncontrasena = sizeof(usuarionuevo.contrasena)/sizeof(char);
							if(ncontrasena < 8 || ncontrasena > 15){
								printf("La contraseña no puede ser menor a 8 y mayor a 15 caracteres!\n");
								break;
							}
							/*Se asigna permiso 1 ya que es usuario*/
							usuarionuevo.permiso = 1;
							usuarionuevo.nodoSiguiente = NULL;

							registrarusuario_1_arg = &(usuarionuevo);
							/*Llamada a funcion remota para registralo el nuevo usuario en el sistema*/
							result_2 = registrarusuario_1(&registrarusuario_1_arg, clnt);
							if (result_2 == (bool_t *) NULL) {
								clnt_perror (clnt, "call failed");
							}
							if((*result_2) == TRUE){
								printf("\nUsuario registrado!");
							}else{
								printf("\nEl id ya existe. Intente con uno nuevo");
							}
							break;

						/*Salir*/
						case 3:
							printf("\nVolviendo al menu principal...");
							break;

						default:
							printf("\nOpcion no valida");
							break;
					}
				}while(opcionAux != 3);
				break;
				

			case  3:
				/*Funcion para notificar el cierre de la sesion*/
				result_14 = salir_1((void*)&salir_1_arg, clnt);
				if (result_14 == (bool_t *) NULL) {
					clnt_perror (clnt, "call failed");
				}else{
					printf("\n Hasta pronto!");
				}

				break;
			default :
				printf("Opcion invalida");
				break;
		}

	}while(opcion1 != 3);

	#ifndef	DEBUG
		clnt_destroy (clnt);
	#endif	 /* DEBUG */
	}
	


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	gestion_usuario_1 (host);
exit (0);
}