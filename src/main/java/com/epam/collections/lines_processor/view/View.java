package com.epam.collections.lines_processor.view;

import com.epam.collections.lines_processor.figures.Line;

import java.util.List;

public class View {
    private final static String FILE_NOT_FOUND = "File not found!";

    public static String getFileNotFound() {
        return FILE_NOT_FOUND;
    }

    public void showToScreen(List<Line> lineList) {
        for (Line l : lineList) {
            System.out.println(l);
        }
    }
}
