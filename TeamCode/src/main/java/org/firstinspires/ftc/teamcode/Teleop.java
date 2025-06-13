package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import com.qualcomm.hardware.ams.AMSColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name ="teleop", group = "2024-25 SP")
//naming it
public class Teleop extends OpMode {
    chaseintialization driveteleop = new chaseintialization();
    armintialization LineraMecanizmeteleop = new armintialization();



    Gamepad currentGamepad2 = new Gamepad();
    Gamepad previousGamepad2 = new Gamepad();
    int Armclose_open = 0;
    int Armmove = 0;
    double clawTargetPosition = 0;
    double clawCurrentPosition = 0;


    double arm1TargetPosition = 0;
    double arm1CurrentPosition = 0;

    double arm2TargetPosition = 0;
    double arm2CurrentPosition = 0;



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

        previousGamepad2.copy(currentGamepad2);
        currentGamepad2.copy(gamepad2);


        if (gamepad2.x) {//fast transition
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


        if (gamepad2.x) {//fast transition
            LineraMecanizmeteleop.topclaw.setPosition(0.6);
        }

        if (gamepad2.b) {//fast transition
            LineraMecanizmeteleop.bottomarm1.setPosition(0.6);
            LineraMecanizmeteleop.bottomarm2.setPosition(0.6);
        }




        if (currentGamepad2.b && !previousGamepad2.b) {
            Armmove++;
            if (Armmove < 2){
                Armmove = 0;
            }
            if (Armmove == 0) { //position 0 -> 1

                //wrist adjust
                arm1TargetPosition = 0.45;
                LineraMecanizmeteleop.bottomarm2.setPosition(arm1TargetPosition);

                arm2TargetPosition = 0.45;
                LineraMecanizmeteleop.bottomarm1.setPosition(arm2TargetPosition);

                arm1CurrentPosition = arm1TargetPosition;
                arm2CurrentPosition = arm2TargetPosition;

                //ArmHighPosition to 1
                Armmove = 1;

            } else if (Armmove == 1) { //position 1 -> 0

                //wrist adjust

                //wrist adjust
                arm1TargetPosition = 0.45;
                LineraMecanizmeteleop.bottomarm2.setPosition(arm1TargetPosition);

                arm2TargetPosition = 0.45;
                LineraMecanizmeteleop.bottomarm1.setPosition(arm2TargetPosition);

                arm1CurrentPosition = arm1TargetPosition;
                arm2CurrentPosition = arm2TargetPosition;
                //ArmHighPosition to 2
                Armmove = 0;

            }
        }




        if (currentGamepad2.a && !previousGamepad2.a) {
            Armclose_open++;
            if (Armclose_open < 2){
                Armclose_open = 0;
            }
            if (Armclose_open == 0) { //position 0 -> 1

                //wrist adjust
                clawTargetPosition = 0.45;
                LineraMecanizmeteleop.bottomclaw.setPosition(clawTargetPosition);

                clawCurrentPosition = clawTargetPosition;

                //ArmHighPosition to 1
                Armclose_open = 1;

            } else if (Armclose_open == 1) { //position 1 -> 0

                //wrist adjust
                clawTargetPosition = 0.4;
                LineraMecanizmeteleop.bottomclaw.setPosition(clawTargetPosition);

                clawCurrentPosition = clawTargetPosition;

                //ArmHighPosition to 2
                Armclose_open = 0;

            }
        }

        if (gamepad2.a) {//hanges specimen
            LineraMecanizmeteleop.topclaw.setPosition(0.6);//open top claw
            LineraMecanizmeteleop.toparm2.setPosition(1);//move to transfer position
            LineraMecanizmeteleop.toparm1.setPosition(0);
        }

    }}