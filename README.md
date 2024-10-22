# Salud Domiciliaria

## Descripción General

Este proyecto busca desarrollar un sistema para controlar en tiempo real el cumplimiento de visitas médicas, de enfermería y de kinesiología pactadas con las obras sociales de pacientes de internación domiciliaria. El sistema proporcionará una herramienta para gestionar la asignación y consumo de prestaciones por parte de los profesionales de salud, asegurando un registro preciso del momento y lugar donde se llevan a cabo las visitas, incluso en entornos con conectividad limitada.

## Etapas del Proceso

1. **Solicitud de Prestaciones**  
   La obra social (OS) solicita un conjunto de prestaciones para un paciente (PX), que pueden incluir atención de enfermería, visitas médicas y prácticas de kinesiología. Estas prestaciones deben realizarse en un periodo estipulado, generalmente distribuidas por semana o mes.

2. **Asignación de Prestaciones**  
   Un administrador, a través de la aplicación web, asigna las prestaciones a los profesionales de la salud. Estos profesionales podrán ver las prestaciones asignadas en la aplicación móvil y proceder a realizarlas según el calendario establecido.

3. **Registro de Ejecución de Prestaciones**  
   A medida que los profesionales realizan las visitas, el sistema registrará tanto el momento como la ubicación geográfica en que se lleva a cabo la prestación. Esta información es vital para la correcta facturación y el seguimiento del cumplimiento.

4. **Manejo de Desconexiones**  
   Dado que en algunas zonas no siempre hay conectividad, el sistema deberá permitir registrar la ubicación y el estado de la prestación aun sin conexión, sincronizando los datos cuando se restablezca la señal.

5. **Alertas de Incumplimiento**  
   El sistema generará alertas en caso de posibles incumplimientos, como cuando se acerque la fecha límite para completar una cantidad específica de visitas y no se hayan realizado las suficientes. Esto permitirá tomar acciones correctivas a tiempo.

## Requerimientos Funcionales

1. **Autenticación de Profesionales**  
   Los profesionales de la salud podrán autenticarse en la aplicación móvil para ver las prestaciones asignadas y registrar su realización.

2. **Visualizacion de lasAsignaciones de Prestaciones**  
   El administrador, desde la aplicación web, podrá asignar prestaciones a los profesionales, que estarán disponibles en la aplicación móvil.

3. **Registro de Prestaciones en Tiempo Real**  
   El sistema permitirá registrar las prestaciones realizadas, incluyendo la fecha, hora y ubicación geográfica de las mismas.

4. **Geolocalización de Profesionales**  
   Se capturará la ubicación del profesional al realizar cada visita, validando que la prestación fue realizada en el domicilio del paciente.

5. **Soporte para Modo Offline**  
   En caso de pérdida de conectividad, el sistema permitirá almacenar localmente los registros de prestaciones y enviarlos cuando la conexión sea restablecida.

6. **Alertas Proactivas**  
   El sistema emitirá alertas si se detectan posibles incumplimientos en la programación de visitas, permitiendo al administrador tomar medidas antes de que se cierre el periodo de prestaciones.

## Conclusión

Este prototipo móvil proveerá una solución funcional para gestionar el cumplimiento de visitas domiciliarias de manera eficiente, asegurando el registro de la información necesaria para la facturación y el control de las prestaciones brindadas.
