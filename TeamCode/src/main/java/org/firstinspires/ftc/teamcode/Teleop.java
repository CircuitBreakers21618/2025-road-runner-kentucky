package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name ="teleop", group = "2024-25 SP")
//naming it
public class Teleop extends OpMode {
    chaseintialization driveteleop = new chaseintialization();
    armintialization LineraMecanizmeteleop = new armintialization();

    @Override
    public void init() {

        //calling hardwareMap
        driveteleop.init(hardwareMap);
        LineraMecanizmeteleop.init(hardwareMap);



    }

    @Override
    public void loop() {

        //seting powers
        driveteleop.topleft.setPower(-gamepad1.right_stick_y / 1.1 + -gamepad1.left_stick_x * 1.1 + gamepad1.right_stick_x);
        driveteleop.backleft.setPower(gamepad1.right_stick_y / 1.1 + -gamepad1.left_stick_x * 1.1 -gamepad1.right_stick_x);
        driveteleop.topright.setPower(-gamepad1.right_stick_y * 1.1 + gamepad1.left_stick_x * 1.2 -gamepad1.right_stick_x);
        driveteleop.backright.setPower(gamepad1.right_stick_y * 1.1 + gamepad1.left_stick_x * 1.1 + gamepad1.right_stick_x);
        LineraMecanizmeteleop.leftliner.setPower(-gamepad2.right_stick_y);
        LineraMecanizmeteleop.rightliner.setPower(gamepad2.right_stick_y);
        LineraMecanizmeteleop.forwardliner.setPower(gamepad2.left_stick_y);

    }
}