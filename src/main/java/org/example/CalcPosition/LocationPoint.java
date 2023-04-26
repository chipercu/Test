package org.example.CalcPosition;

import java.util.Objects;

public class LocationPoint {

    public static Point2D getPosition(Point2D p1, Point2D p2, Side side, int vector_dist, int width_dist){

        double angle = calculateAngleFrom(p1, p2);
        double radian1 = 0;
        double radian2 = 0;
        double x = 0;
        double y = 0;

        if (Objects.requireNonNull(side) == Side.BACK) {
            radian1 = Math.toRadians(angle + 90);
            radian2 = Math.toRadians(angle - 90);
            x = (int)(p1.x - Math.sin(radian1) * vector_dist) + (Math.cos(radian2));
            y = (int)(p1.y + Math.cos(radian1) * vector_dist) +  (Math.sin(radian2));

        } else if (side == Side.FRONT) {
            radian1 = Math.toRadians(angle - 90);
            radian2 = Math.toRadians(angle + 90);
            x = (p1.x - Math.sin(radian1) * vector_dist) + (Math.cos(radian2));
            y = (p1.y + Math.cos(radian1) * vector_dist) +  (Math.sin(radian2));
        } else if (side == Side.LEFT) {
            radian1 = Math.toRadians(angle - 90);
            radian2 = Math.toRadians(angle + 90);
            x = (p1.x - Math.sin(radian1)) + (Math.cos(radian2)) * width_dist;
            y = (p1.y + Math.cos(radian1)) +  (Math.sin(radian2)) * width_dist;
        } else if (side == Side.RIGHT) {
            radian1 = Math.toRadians(angle - 90);
            radian2 = Math.toRadians(angle + 90);
            x = (p1.x - Math.sin(radian1)) + (Math.cos(radian1)) * width_dist;
            y = (p1.y + Math.cos(radian1)) +  (Math.sin(radian1)) * width_dist;
        }
//        double sqrt = Math.sqrt(getXYDeltaSq(x1, y1, x2, y2));

        double c_x =  (p1.x - Math.sin(radian1) * vector_dist);
        double c_y =  (p1.y + Math.cos(radian1) * vector_dist);

//        double x = c_x + (Math.cos(radian2) * width_dist);
//        double y = c_y +  (Math.sin(radian2) * width_dist);
//        double x = x1 + (Math.cos(radian1) * width);
//        double y = y1 + (Math.sin(radian1) * width);
        return new Point2D((int) x, (int) y);
    }

    public static double calculateAngleFrom(Point2D p1, Point2D p2) {
        double angleTarget = Math.toDegrees(Math.atan2(p2.y - p1.y, p2.x - p1.y));
        if(angleTarget < 0)
            angleTarget = 360 + angleTarget;
        return angleTarget;
    }



}
