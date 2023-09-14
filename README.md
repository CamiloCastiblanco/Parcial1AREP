# Parcial 1 AREP Fachada ReflexCalculator
Construir una  aplicación web usando sockets que reciba un operación  matemática y una lista de parámetros separados por coma y retorne el valor correspondiente. El comando puede ser cualquiera de la libería clase Math de java o el comando "qck". La aplicación asume que los números que recibe siempre son de tipo Double. El comando se debe invocar usando reflexión. Si la calculadora recibe el comando es "qck" los parámetros serán una a lista de números desordenada y los retorna de manera ordenada usando quicksort.
Arquitectura:
La aplicación tendrá tres componentes distribuidos: Una fachada de servicios, un servicio de calculadora, y un cliente web (html +js).
Los servicios de la fachada y de la calculadora deben estar desplegados en máquinas virtuales  diferentes.
El cliente es un cliente web que usa html y js. Se descarga desde un servicio en la fachada (Puede entregar el cliente directamente desde un método no es necesario que lo lea desde el disco).
La comunicación se hace usando http y las respuestas de los servicios son en formato JSON.
La caculadora  (ReflexCalculator) es la que hace el computo real de las funciones. La fachada de servicios (ServiceFacade) solo delega el computo al ReflexCalculator.
El diseño de los servicios WEB debe tener en cuenta buenas prácticas de diseño OO.
Despliegue los servicios en máquinas virtuales separadas.
Los llamados al servicio de calculadora desde el cliente deben ser asíncronos usando el mínimo JS prosible. No actualice la página en cada llamado, solo el resultado.
El API de la fachada será
[url de la app]/calculadora : Este servicio entrega el cliente web en formato html + js.
[url de la app]/computar?comando=[comando con parámetros separados por coma entre paréntesis] : retorna el valor solicitado en formato JSON
El API de la calculadora será
[url de la calculadora]/compreflex =[comando con parámetros separados por coma entre paréntesis] :retorna el valor solicitado en formato JSON
Asegúrese de retornar los encabezados correctos en HTTP y de responder mensajes válidos de HTTP ante solicitudes inesperadas
