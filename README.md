# Sistema de Rondas de Seguridad (SRS) 

   Esta API backend corresponde al proyecto presentado como trabajo final para la carrera de Ingeniería en Sistemas de Información - Facultad Regional Buenos Aires.
El proyecto completo tiene una interfaz Mobile y Web, pero en este repositorio solo se presenta la parte backend.

## Índice

- [Motivación](#-motivacin)
- [Documentación Técnica de la Solución](#-documentacin-tcnica-de-la-solucin)
  - [Diagrama de Arquitectura](#diagrama-de-arquitectura)
  - [Diagrama de Componentes](#diagrama-de-componentes)
  - [Modelo de Base de Datos](#-modelo-de-base-de-datos)
  - [Tecnologías](#-tecnologas)
  - [Endpoints](#-endpoints)
- [Ejecución](#-ejecucin)

## 🚀 Motivación

   El proyecto tuvo como objetivo la creación de un Sistema de Rondas de Seguridad (SRS) en el que se diseñan rondas de seguridad con ayuda de checkpoint con tecnología NFC.
Primero se crean los checkpoint en un lugar abierto, que son puntos de control por donde debe pasar la ronda de seguridad, y luego se crea a través de la web, dicha ronda.
Las rondas de seguridad por lo general, tienen una planificación ya estipulada, para ejecutarse X cantidad de veces por día y también por semana. 
A través de la aplicación web, el agente de seguridad, va a hacer el recorrido pasando por todos los checkpoint y leyendo el código NFC de cada punto de control. 
Una vez finalizada la ronda de seguridad, cierra la misma, dejando asentado en el sistema que se hizo el recorrido correspondiente. 

## 🚀 Documentación Técnica de la Solución
### Diagrama de Arquitectura
![Diagrama de Despligue](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/Arquitectura.png)


* Base de Datos Relacional: se usó como motor de base de datos Mysql
* Eventos: se usan para la planificación constante de las ejecuciones de las rondas. También para recibir y procesar de manera asincrónica
los llamados a los endpoints correspondientes para la ejecución de una ronda de seguridad. El caso de uso de esos endpoints, es que el agente de seguridad,
desde su app mobile, notifique ubicación en tiempo real, checkpoints que va marcando y cuando inicia y finaliza la ronda. 
Para los eventos se usó la cola de mensajes de Kafka

### Diagrama de Componentes
![Diagrama de Componentes](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/componentes.png)



### Modelo de Base de datos
![DER](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/der.png)



###  Tecnologías

* JDK 17
* Spring Boot 2.7.5
* Maven
* Mysql
* Kafka
* RestAssured
* Spring JPA
* Spring Kafka
* Mapstruct
* Docker (BBDD Mysql y Kafka)

###  Endpoints

<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST    </td><td>/api/v1/srs/checkpoint </td></tr>
  <tr><td>PUT     </td><td>/api/v1/srs/checkpoint </td></tr>
  <tr><td>DELETE  </td><td>/api/v1/srs/checkpoint/{nfcCode} </td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/checkpoint/findBySubsidiary/{subsidiaryId} </td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST    </td><td>/api/v1/srs/company-security</td></tr>
  <tr><td>PUT     </td><td>/api/v1/srs/company-security</td></tr>
  <tr><td>DELETE  </td><td>/api/v1/srs/company-security/{companySecurityId}</td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/company-security/all</td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/company-security/findById/{companySecurityId}</td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/company-security/findByDocument/{type}/{value}</td></tr>
</tbody>
</table>

<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>  /api/v1/srs/customers</td></tr>
  <tr><td>PUT    </td><td>  /api/v1/srs/customers</td></tr>
  <tr><td>DELETE </td><td> /api/v1/srs/customers/{customerId}</td></tr>
  <tr><td>GET    </td><td> /api/v1/srs/customers/all</td></tr>
  <tr><td>GET    </td><td> /api/v1/srs/customers/findById/{customerId}</td></tr>
  <tr><td>GET    </td><td> /api/v1/srs/customers/findByDocument/{type}/{value}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>/api/v1/srs/round</td></tr>
  <tr><td>PUT    </td><td>/api/v1/srs/round</td></tr>
  <tr><td>DELETE </td><td>/api/v1/srs/round/{roundId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/round/findBySubsidiary/{subsidiaryId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/round/findByCustomer/{customerId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/round/findById/{roundId}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/startRound</td></tr>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/markCheckpoint</td></tr>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/finishRound</td></tr>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/notifyLocationAgentOnline</td></tr>
  <tr><td>GET </td><td>/api/v1/srs/round-execute/findOnlineById/{roundExecuteId}</td></tr>
  <tr><td>GET </td><td>/api/v1/srs/round-execute/findRoundPendingBySubsidiary/{subsidiaryId}</td></tr>
  <tr><td>GET </td><td>/api/v1/srs/round-execute/findByStateRevision</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST  </td><td> /api/v1/srs/round-planning</td></tr>
  <tr><td>PUT   </td><td> /api/v1/srs/round-planning</td></tr>
  <tr><td>DELETE</td><td> /api/v1/srs/round-planning/{roundPlanningId}</td></tr>
  <tr><td>GET   </td><td> /api/v1/srs/round-planning/findById/{roundPlanningId}</td></tr>
  <tr><td>GET   </td><td> /api/v1/srs/round-planning/findByRoundId/{roundId}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>/api/v1/srs/subsidiaries</td></tr>
  <tr><td>PUT    </td><td>/api/v1/srs/subsidiaries</td></tr>
  <tr><td>DELETE </td><td>/api/v1/srs/subsidiaries/{subsidiaryId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/subsidiaries/findByCustomer/{customerId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/subsidiaries/findById/{subsidiaryId}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>/api/v1/srs/users</td></tr>
  <tr><td>PUT    </td><td>/api/v1/srs/users</td></tr>
  <tr><td>DELETE </td><td>/api/v1/srs/users/{userId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/findByRol/{rol}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/findById/{userId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/findByDocument/{type}/{value}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/roles</td></tr>
</tbody>
</table>


## 🚀 Ejecución

* Si es la primera vez que va a ejecutar el proyecto en su máquina, ejecutar el archivo execute-1-instalacion.sh
* Para inicializar el entorno de datos ejecutar execute-2-configuracion.sh
* Por último, debe ejecutar execute-3-execute.sh




