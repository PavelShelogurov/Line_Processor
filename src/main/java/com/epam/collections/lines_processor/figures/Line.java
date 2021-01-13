package com.epam.collections.lines_processor.figures;

import java.util.*;

/**
 * Class that stores lines data, represents by equation y = kx + b
 */
public class Line {
    private double k;
    private double b;

    private Set<Point> pointsSet = new HashSet<>();

    public Line(Point point1, Point point2) {
        pointsSet.add(point1);
        pointsSet.add(point2);
        if (point1.getX() == point2.getX()) {
            //если две точки имеют одинаковые зничения по х
            //прямая будет иметь коэффициент к равный бесконечности
            k = Double.POSITIVE_INFINITY;
            b = point2.getX();
        } else if (point1.getY() == point2.getY()) {
            k = 0;
            b = point2.getY();
        } else {
            k = (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
            b = point2.getY() - (k * point2.getX());
        }
    }

    @Override
    public String toString() {
        return getLineEquation() + " points: " + pointsSet.toString();
    }

    public String getLineEquation() {
        if (k != 0 && k != Double.POSITIVE_INFINITY) {
            if (b != 0) {
                return "Line: y = " + getK() + "x +" + getB();
            } else {
                return "Line: y = " + getK() + "x";
            }
        } else if (k == 0) {
            return "Line: y = " + getB();
        } else {
            return "Line : x = " + getB();
        }
    }


    public Set<Point> getPoints() {
        return pointsSet;
    }

    public double getK() {

        return roundTheNumber(k);
    }

    public double getB() {

        return roundTheNumber(b);
    }

    private double roundTheNumber(double d) {
        return Double.parseDouble(String.format("%.2f", d).replace(",", "."));
    }


    public void setPoints(Set<Point> points) {
        pointsSet = new HashSet<>(points);
    }

    public void addPoints(Set<Point> points) {
        pointsSet.addAll(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Double.compare(line.getK(), this.getK()) == 0 &&
                Double.compare(line.getB(), this.getB()) == 0 &&
                Objects.equals(pointsSet, line.pointsSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, b, pointsSet);
    }

}
