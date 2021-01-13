package com.epam.collections.lines_processor.parser;

import com.epam.collections.lines_processor.figures.Point;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Parser {
    private static final String REGEX_KEY = "spliter";

    public List<Point> parse(String filePath) throws FileNotFoundException {
        return parseToPointList(readStringFromFile(filePath));
    }

    //метод считывающий строки из файла и возвращиющий массив строк
    private List<String> readStringFromFile(String filePath) throws FileNotFoundException {
        FileReader scrFile;
        Scanner scanner;
        List<String> lineListFromFile = new LinkedList<>();

        scrFile = new FileReader(filePath);
        scanner = new Scanner(scrFile);

        //разбараем исходный файл по строчкам и записываем в массив строк
        while (scanner.hasNext()) {
            lineListFromFile.add(scanner.nextLine());
        }

        return lineListFromFile;
    }

    //метод который разбиваетс строку на пару ключ-значение, создаёт объект Product и добавляет в ArrayList
    private List<Point> parseToPointList(List<String> listOfString) {
        List<Point> pointsList = new ArrayList<>();
        for (String line : listOfString) {
            String[] pairXAndY = line.split(RegexProvider.get(REGEX_KEY));
            pointsList.add(new Point(Integer.parseInt(pairXAndY[0]), Integer.parseInt(pairXAndY[1])));
        }
        return pointsList;
    }

}
