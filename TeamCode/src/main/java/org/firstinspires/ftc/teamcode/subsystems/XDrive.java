package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.utilities.Pose2D;
import org.firstinspires.ftc.teamcode.utilities.Rotation2D;
import org.firstinspires.ftc.teamcode.utilities.Translation2D;

public class XDrive {
    private DcMotor front;
    private DcMotor back;
    private DcMotor left;
    private DcMotor right;
    private IMU imu;

    private Pose2D m_robotPose;

    public XDrive(String frontName, String backName, String leftName, String rightName, HardwareMap hardwareMap) {
        // Initialize hardware
        front = hardwareMap.get(DcMotor.class, frontName);
        back = hardwareMap.get(DcMotor.class, backName);
        left = hardwareMap.get(DcMotor.class, leftName);
        right = hardwareMap.get(DcMotor.class, rightName);
        

        // The wheel directions should exist such that applying equal power to opposite wheels moves the robot in one direction.
        // Positive left/right moves forward. Positive front/back moves to the right.
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        front.setDirection(DcMotorSimple.Direction.REVERSE);
        back.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public void fieldRelativeDrive(double velocityX, double velocityY, double angularSpeed) {
        front.setPower(0);
        back.setPower(0);
        left.setPower(0);
        right.setPower(0);
    }

    public void robotRelativeDrive(double velocityX, double velocityY, double angularSpeed) {
        front.setPower(velocityX);
        back.setPower(velocityX);
        right.setPower(velocityY);
        left.setPower(velocityY);
    }

    public void driveToPosition(double x, double y, double angleRadians) {

    }

    public void resetRobotPose(Translation2D translation, Rotation2D rotation) {
        m_robotPose = new Pose2D(translation, rotation);
    }

    public Translation2D getTranslation() {
        return m_robotPose.getTranslation();
    }

    public Pose2D getRobotPose() {
        return m_robotPose;
    }
}
