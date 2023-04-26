package org.example.CalcPosition;

import java.util.Objects;

public class LocationPoint {

    public static Point2D getPosition(Point2D p1, Point2D p2, Side side, double vector_dist, double width_dist){

        double angle = calculateAngleFrom(p1, p2);
        System.out.println(angle);
        double radian1 = 0;
        double radian2 = 0;
        double x = 0;
        double y = 0;

        if (Objects.requireNonNull(side) == Side.BACK) {
            radian1 = Math.toRadians(angle + 90);
            radian2 = Math.toRadians(angle - 90);
            x = (p1.x - Math.sin(radian1) * vector_dist) + (Math.cos(radian2));
            y = (p1.y + Math.cos(radian1) * vector_dist) +  (Math.sin(radian2));
        } else if (side == Side.FRONT) {
            radian1 = Math.toRadians(angle - 90);
            radian2 = Math.toRadians(angle + 90);
            x = (p1.x - Math.sin(radian1) * vector_dist) + (Math.cos(radian2));
            y = (p1.y + Math.cos(radian1) * vector_dist) +  (Math.sin(radian2));
        } else if (side == Side.LEFT) {
//            return sidePoint(p1, p2, width_dist, side);
        } else if (side == Side.RIGHT) {
//            return sidePoint(p1, p2, width_dist, side);
        }
        return new Point2D( x, y);
    }
    public static Point2D getNSWEPoint(Point2D origin, Point2D ref, double dist, Side side){
        double radian;
        if (side == Side.RIGHT){
            radian = Math.toRadians(calculateAngleFrom(origin, ref) + 90);
            return new Point2D(origin.x  + (Math.cos(radian)) * dist, origin.y + (Math.sin(radian)) * dist);
        }else if (side == Side.LEFT){
            radian = Math.toRadians(calculateAngleFrom(origin, ref) - 90);
            return new Point2D(origin.x + (Math.cos(radian)) * dist, origin.y + (Math.sin(radian)) * dist);
        } else if (side == Side.BACK) {
            radian = Math.toRadians(calculateAngleFrom(origin, ref) + 90);
            return new Point2D(origin.x - Math.sin(radian) * dist, origin.y + Math.cos(radian) * dist);
        } else if (side == Side.FRONT) {
            radian = Math.toRadians(calculateAngleFrom(origin, ref) - 90);
            return new Point2D(origin.x - Math.sin(radian) * dist, origin.y + Math.cos(radian) * dist);
        }
        return origin;
    }


    public static double calculateAngleFrom(Point2D p1, Point2D p2) {
//        double angleTarget = Math.toDegrees(Math.atan2(p2.y - p1.y, p2.x - p1.x));
        double angleTarget = Math.toDegrees(Math.atan2(p2.y - p1.y, p2.x - p1.x));
        if(angleTarget < 0)
            angleTarget = 360 + angleTarget;
        return angleTarget;
    }



}
