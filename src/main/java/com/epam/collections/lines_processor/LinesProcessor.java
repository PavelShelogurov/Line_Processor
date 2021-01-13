package com.epam.collections.lines_processor;

import com.epam.collections.lines_processor.figures.Line;
import com.epam.collections.lines_processor.figures.Point;
import com.epam.collections.lines_processor.parser.Parser;
import com.epam.collections.lines_processor.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class for working with inventory
 */
public class LinesProcessor {
    private static final String FILE_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "points.txt";
    private static final Logger logger = Logger.getLogger(LinesProcessor.class.getName());

    public static void main(String[] args) {
        LinesProcessor linesProcessor = new LinesProcessor();
        linesProcessor.start(linesProcessor.getCorrectFilePath(args));
    }

    private void start(String filePath) {
        Parser parser = new Parser();
        View view = new View();

        List<Point> pointsList = new ArrayList<>();
        try {
            pointsList = parser.parse(filePath);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, View.getFileNotFound());
        }

        view.showToScreen(reduceLines(mapPointsToLines(pointsList)));

    }

    /**
     * Generate all available lines by list of points (with duplicates). Result size should be equals to (n ^ 2) - n
     *
     * @param points Points to generate lines
     * @return List of all available lines
     */
    public List<Line> mapPointsToLines(Iterable<Point> points) {
        List<Line> lineListWithDuplicates = new ArrayList<>();
        for (Point p1 : points) {
            for (Point p2 : points) {
                if (!p1.equals(p2)) {
                    lineListWithDuplicates.add(new Line(p1, p2));
                }
            }
        }
        return lineListWithDuplicates;
    }

    /**
     * Reduce amount of lines - unite same lines build by different points in one line
     *
     * @param lines List of lines to be reduced
     * @return List of lines without duplicates
     */
    public List<Line> reduceLines(Iterable<Line> lines) {

        Map<String, Line> reduceLinesMap = new HashMap<>();
        Iterator<Line> lineIterator = lines.iterator();
        while (lineIterator.hasNext()) {
            Line currentLine = lineIterator.next();
            Line duplicateLine = reduceLinesMap.get(currentLine.getLineEquation());
            if (duplicateLine == null) {
                reduceLinesMap.put(currentLine.getLineEquation(), currentLine);
            } else {
                duplicateLine.addPoints(currentLine.getPoints());
            }
        }
        return new ArrayList<Line>(reduceLinesMap.values());

    }

    private String getCorrectFilePath(String[] args) {
        if (args.length == 0) {
            return FILE_PATH;
        } else {
            if (args[0] == null || args[0].equals("") || args[0].length() == 0) {
                return FILE_PATH;
            } else {
                return args[0];
            }
        }
    }


}
