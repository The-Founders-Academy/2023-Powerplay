package org.firstinspires.ftc.teamcode.utilities;

public class Rotation2D {
    private double m_angleRadians;
    private double m_angleDegrees;

    /**
     * A constructor that takes in one parameter
     * @param angle the angle, in radians, that this Rotation2D object should represent
     */
    public Rotation2D(double angle) {
        this.m_angleRadians = angle;
        this.m_angleDegrees = Math.toDegrees(angle);
    }

    /**
     * A constructor that takes rectangular coordinates instead of an angle
     * @param x The horizontal component of the corresponding angle
     * @param y The vertical component of the corresponding angle
     */
    public Rotation2D(double x, double y) {
        double angle = Math.atan2(y, x);
        if(angle < 0) {
            angle += 2*Math.PI; // Find an equivalent positive angle. This will make math elsewhere easier.
        }
        this.m_angleRadians = angle;
        this.m_angleDegrees = Math.toDegrees(angle);
    }

    /**
     * Converts a given angle in radians to an equivalent angle in degrees
     * @param angleRadians
     * @return angleRadians in degrees
     */
    public static double toDegrees(double angleRadians) {
        return Math.toDegrees(angleRadians);
    }

    /**
     * Converts a given angle in degrees to an equivalent angle in radians
     * @param angleDegrees
     * @return angleRadians in radians
     */
    public static double toRadians(double angleDegrees) {
        return Math.toRadians(angleDegrees);
    }


}
