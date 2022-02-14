# AssessmentTests
Решение тестовых заданий.
## Task1: CompressSequence
Код решения лежит в modules/CompressSequence

### Описание структуры проекта
Код написан без использования сторонних библиотек (за исключением ScalaTest для тестирования)
Основное решение находится в modules/CompressSequence/Process
* Compressor - код функции
* Empty - тайп-класс для абстракции наличия "нулевого элемента" для оьеспечения тайп-полиморфизма функции compress
* SlidingWindow - вспомогательная структура для обработки последовательностей

### Сборка
sbt project task1; assembly

## Task2: 
TBD