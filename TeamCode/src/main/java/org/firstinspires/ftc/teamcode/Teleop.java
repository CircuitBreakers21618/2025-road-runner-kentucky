package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import com.qualcomm.hardware.ams.AMSColorSensor;
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
        driveteleop.leftFront.setPower(gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 + -gamepad1.right_stick_x);
        driveteleop.leftBack.setPower(-gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 + gamepad1.right_stick_x);
        driveteleop.rightFront.setPower(gamepad1.right_stick_y + gamepad1.left_stick_x * 1.1 + gamepad1.right_stick_x);
        driveteleop.rightBack.setPower(gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 + -gamepad1.right_stick_x);
        LineraMecanizmeteleop.leftliner.setPower(-gamepad2.right_stick_y);
        LineraMecanizmeteleop.rightliner.setPower(gamepad2.right_stick_y);
        LineraMecanizmeteleop.forwardliner.setPower(gamepad2.left_stick_y);

        if (gamepad2.y) {//fast transition
            LineraMecanizmeteleop.topclaw.setPosition(0.6);//open top claw
            LineraMecanizmeteleop.toparm2.setPosition(1);//move to transfer position
            LineraMecanizmeteleop.toparm1.setPosition(0);//move to transfer position
            LineraMecanizmeteleop.bottomarm1.setPosition(0);
            LineraMecanizmeteleop.bottomarm2.setPosition(.75);
            LineraMecanizmeteleop.bottomrotator.setPosition(1);
            LineraMecanizmeteleop.bottomclaw.setPosition(.3);

            sleep(1000);

            LineraMecanizmeteleop.topclaw.setPosition(0.15);//closes claw
            sleep(400);
            LineraMecanizmeteleop.bottomclaw.setPosition(.8);
            sleep(200);
            LineraMecanizmeteleop.toparm1.setPosition(0.7);//moves to hang position
            LineraMecanizmeteleop.toparm2.setPosition(0);//moves to hang position
            LineraMecanizmeteleop.bottomarm2.setPosition(.4825);
            LineraMecanizmeteleop.bottomarm1.setPosition(.4625);
            LineraMecanizmeteleop.bottomrotator.setPosition(1);
        }


        if (gamepad2.x) {//grab sample/specimen
            LineraMecanizmeteleop.bottomclaw.setPosition(.8);
            LineraMecanizmeteleop.bottomarm1.setPosition(.95);
            LineraMecanizmeteleop.bottomarm2.setPosition(0);
            LineraMecanizmeteleop.bottomrotator.setPosition(1);
        }

        if (gamepad2.b) {//pree pare to grap sample/specimen
            LineraMecanizmeteleop.toparm2.setPosition(1);//move to transfer position
            LineraMecanizmeteleop.toparm1.setPosition(0);//move to transfer position
            LineraMecanizmeteleop.bottomarm2.setPosition(.4825);
            LineraMecanizmeteleop.bottomarm1.setPosition(.4625);
            LineraMecanizmeteleop.bottomrotator.setPosition(1);
            LineraMecanizmeteleop.bottomclaw.setPosition(.3);
        }


        if (gamepad2.a) {//hanges specimen
            LineraMecanizmeteleop.topclaw.setPosition(0.6);//open top claw
            LineraMecanizmeteleop.toparm2.setPosition(1);//move to transfer position
            LineraMecanizmeteleop.toparm1.setPosition(0);
        }

    }}