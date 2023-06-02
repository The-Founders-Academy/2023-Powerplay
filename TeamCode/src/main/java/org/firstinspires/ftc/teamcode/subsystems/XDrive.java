package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.utilities.Pose2D;
import org.firstinspires.ftc.teamcode.utilities.Rotation2D;
import org.firstinspires.ftc.teamcode.utilities.Translation2D;

public class XDrive {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private IMU imu;
    private Pose2D m_robotPose;

    public XDrive(DcMotor iFrontRight, DcMotor iFrontLeft, DcMotor iBackRight, DcMotor iBackLeft, IMU iImu) {
        frontRight = iFrontRight;
        frontLeft = iFrontLeft;
        backRight = iBackRight;
        backLeft = iBackLeft;
        imu = iImu;
        m_robotPose = new Pose2D(new Translation2D(0, 0), new Rotation2D(0, 0));

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void fieldRelativeDrive(double velocity, double linearAngle, double angularSpeed) {
        double velocityX = velocity * cos(linearAngle + m_robotPose.getRotation().getAngleRadians());
        double velocityY = velocity * sin(linearAngle + m_robotPose.getRotation().getAngleRadians());
    }

    public void robotRelativeDrive(double velocityX, double velocityY, double angularSpeed) {
    }

    public void driveToPosition(double x, double y, double angleRadians) {

    }

    public void resetAngle() {
        imu.resetYaw();
        m_robotPose.setRotation(new Rotation2D(0));
    }

    public Pose2D getRobotPose() {
        return m_robotPose;
    }

    public void update() {
    }

}
