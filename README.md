
## Задание
На плоскости задано N точек (файл points.txt в скелете задания, формат “X;Y”). Вывести на консоль описания всех прямых (уравнение прямой), которые проходят более чем через одну точку из заданных. Для каждой прямой указать, через сколько точек она проходит.

## Пример ввода/вывода
```
Line: x = 7, points: [Point{x=7, y=7}, Point{x=7, y=-2}]
Line: y = -2.00, points: [Point{x=-2, y=-2}, Point{x=7, y=-2}]
Line: y = -1.25x + 6.75, points: [Point{x=3, y=3}, Point{x=7, y=-2}]
Line: y = 1.00x, points: [Point{x=-2, y=-2}, Point{x=3, y=3}, Point{x=7, y=7}]
```

## Подсказка
Методы в классе LinesProcessor соответствуют шаблону для распределенных вычислений MapReduce наиболее популярному по Java Stream API и фреймворку для работы с большими данными Apache Hadoop, так что если есть проблемы с пониманием того что каждый метод должен делать можно посмотреть описание этих операций на примере [Java Stream API](https://easyjava.ru/java/language/java-8-stream-api-chast-vtoraya-map-reduce/) или [Apache Hadoop MapReduce](https://ru.bmstu.wiki/MapReduce)
