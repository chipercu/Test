package org.example;

public class Vector {

    public static double calculateAngleFrom(int obj1X, int obj1Y, int obj2X, int obj2Y)
    {
        double angleTarget = Math.toDegrees(Math.atan2(obj2Y - obj1Y, obj2X - obj1X));
        if(angleTarget < 0)
            angleTarget = 360 + angleTarget;
        return angleTarget;
    }











}
