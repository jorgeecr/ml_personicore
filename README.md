# ml_personicore

En este repo voy a subir el código a medias de reconocimiento de grid y de texto, y las instrucciones para completarlo.

El código está basado (semi-plagiado) en el siguiente repo:
https://github.com/tensorflow/examples/tree/master/lite/examples/image_classification/android


## Dependencias de Tensorflow

El primer paso para incorporar tensorflow al proyecto es importar las dependencias en Gradle, copio el link de las instrucciones
https://github.com/tensorflow/tensorflow/blob/master/tensorflow/lite/experimental/support/java/README.md#Import-Gradle-dependency-and-other-settings

## Estructura del proyecto

Vamos a modificar las siguientes clases:
* app/src/main/CameraActivity.java
* app/src/main/ClassifierActivity.java
* app/src/main/tflite/Classifier.java
* app/src/main/tflite/ClassifierFloatEfficientNet.java

En el caso de la clase CameraActivity, es semejante a la clase del mismo nombre en la app de los chinos, pero la parte de 
```java
OnPreviewFrame 
```
nosotros la incluimos en la clase CameraController.java. Entonces, lo ideal será incluir nuestro código de la clase CameraActivity dentro de CameraController, pero esto es una de las cosas que quisiera discutir.
