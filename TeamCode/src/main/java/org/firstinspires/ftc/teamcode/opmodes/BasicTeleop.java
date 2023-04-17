package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.subsystems.XDrive;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")
public class BasicTeleop extends OpMode {

    private XDrive m_xDrive;

    @Override
    public void init() {
        m_xDrive = new XDrive("front", "back",  "left", "right");
        m_xDrive.resetOdometry();
    }

    @Override
    public void loop() {
    }
}
