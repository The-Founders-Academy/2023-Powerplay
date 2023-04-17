package org.firstinspires.ftc.teamcode.utilities;

public class Pose2D {
    private Translation2D m_translation;
    private Rotation2D m_rotation;

    public Pose2D(Translation2D translation, Rotation2D rotation) {
        this.m_translation = translation;
        this.m_rotation = rotation;
    }

    public Pose2D(double x, double y, Rotation2D rotation) {
        this.m_translation = new Translation2D(x, y);
        this.m_rotation = rotation;
    }

    public Translation2D getTranslation() {
        return m_translation;
    }


}
