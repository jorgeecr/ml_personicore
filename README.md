# ml_personicore

En este repo voy a subir el código a medias de reconocimiento de grid y de texto, y las instrucciones para completarlo.

El código está basado (semi-plagiado) en el siguiente repo:
https://github.com/tensorflow/examples/tree/master/lite/examples/image_classification/android

Esta sample app reconoce imagenes de la camara y tiene una interfaz gráfica para poder elegir entre cuatro opciones de modelos y los resultados de la inferencia se pueden ver directamente en la pantalla. Nosotros obviamente no necesitaremos estas opciones (sólo necesitamos un modelo y no necesitamos mostrar nada en la pantalla), pero hay que ser cuidadoso al momento de borrar líneas de código, porque hay muchas interdependencias, y esto fue lo que más me costó trabajo.


## Dependencias de Tensorflow

El primer paso para incorporar tensorflow al proyecto es importar las dependencias en Gradle, copio el link de las instrucciones
https://github.com/tensorflow/tensorflow/blob/master/tensorflow/lite/experimental/support/java/README.md#Import-Gradle-dependency-and-other-settings

Como se indica en este link, el modelo se ubicará en el directorio /assets.

## Estructura del proyecto

Vamos a modificar las siguientes clases:
* app/src/main/CameraActivity.java
* app/src/main/ClassifierActivity.java
* app/src/main/tflite/Classifier.java
* app/src/main/tflite/ClassifierFloatEfficientNet.java

En el caso de la clase CameraActivity, es semejante a la clase del mismo nombre en la app de los chinos, pero la parte de 
```java
OnPreviewFrame()
```
nosotros la incluimos en la clase CameraController.java. Entonces, lo ideal será incluir nuestro código de la clase CameraActivity dentro de CameraController, pero esto es una de las cosas que quisiera discutir.
ClassifierFloatEfficientNet en nuestro caso será llamado GridClassifier.

### Cosas que faltan por hacer:

- [x] Obviamente probar que todo el codigo funcione.
- [x] Probar que el resultado de la inferencia es un array de 1x1. (Mañana te diré a qué me refiero exactamente).
- [x] ClassifierActivity es una activity que extiende CameraActivity y hay que ver cómo se incorporaría en la app de los chinos.


