package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class armintialization {

    public DcMotor leftliner;
    public DcMotor rightliner;
    public DcMotor forwardliner;

    public Servo toparm1;
    public Servo toparm2;
    public Servo topclaw;

    public Servo bottomarm1;
    public Servo bottomarm2;
    public Servo bottomrotator;
    public Servo bottomclaw;

    public void init(HardwareMap hwMap){

        leftliner = hwMap.get(DcMotor.class, "leftliner");
        rightliner = hwMap.get(DcMotor.class, "rightliner");
        forwardliner = hwMap.get(DcMotor.class, "forwardliner");

        leftliner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftliner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftliner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightliner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightliner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightliner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        forwardliner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        forwardliner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        forwardliner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        toparm1 = hwMap.get(Servo.class, "toparm1");
        toparm2 = hwMap.get(Servo.class, "toparm2");
        topclaw = hwMap.get(Servo.class, "topclaw");

        bottomarm1 = hwMap.get(Servo.class, "bottomarm1");
        bottomarm2 = hwMap.get(Servo.class, "bottomarm2");
        bottomrotator = hwMap.get(Servo.class, "bottomrotator");
        bottomclaw = hwMap.get(Servo.class, "bottomclaw");
    }

    public class hang_specimen implements Action {
        @Override

        public boolean run(@NonNull TelemetryPacket packet) {
            topclaw.setPosition(0.15);
            sleep(500);
            toparm1.setPosition(0.7);//moves to hang position
            toparm2.setPosition(0.06);//moves to hang position
            sleep(1000);
            rightliner.setPower(-.5);
            leftliner.setPower(.5);
            sleep(2000);
            topclaw.setPosition(0.6);

            return false;
        }

    }
        public Action hang_specimen(){
        return new hang_specimen();
    }

    public class smoth_trans implements Action {
        @Override

        public boolean run(@NonNull TelemetryPacket packet) {
            topclaw.setPosition(0.6);//open top claw
            toparm2.setPosition(1);//move to transfer position
            toparm1.setPosition(0);//move to transfer position
            bottomarm1.setPosition(0);
            bottomarm2.setPosition(.75);
            bottomrotator.setPosition(1);
            bottomclaw.setPosition(.3);

            sleep(1000);

            topclaw.setPosition(0.15);//closes claw
            sleep(400);
            bottomclaw.setPosition(.8);
            sleep(200);
            toparm1.setPosition(0.7);//moves to hang position
            toparm2.setPosition(0);//moves to hang position
            bottomarm2.setPosition(.4825);
            bottomarm1.setPosition(.4625);
            bottomrotator.setPosition(1);

            return false;
        }


    }
    public Action smoth_trans(){
        return new smoth_trans();
    }


    public class push_block implements Action {
        @Override

        public boolean run(@NonNull TelemetryPacket packet) {
            forwardliner.setPower(1);
            sleep(400);
            forwardliner.setPower(0);

            bottomarm1.setPosition(.95);
            bottomarm2.setPosition(0);
            bottomrotator.setPosition(1);
            bottomclaw.setPosition(.3);


            return false;
        }


    }
    public Action push_block(){
        return new push_block();
    }



    public class up_claw implements Action {
        @Override

        public boolean run(@NonNull TelemetryPacket packet) {
            bottomarm2.setPosition(.4825);
            bottomarm1.setPosition(.4625);
            return false;
        }


    }
    public Action up_claw(){
        return new up_claw();
    }


    public class down_claw implements Action {
        @Override

        public boolean run(@NonNull TelemetryPacket packet) {
            bottomarm1.setPosition(.95);
            bottomarm2.setPosition(0);

            return false;
        }


    }
    public Action down_claw(){
        return new down_claw();
    }




    public class retracked_claw implements Action {
        @Override

        public boolean run(@NonNull TelemetryPacket packet) {
            bottomarm2.setPosition(.4825);
            bottomarm1.setPosition(.4625);
            sleep(500);
            forwardliner.setPower(0);
            sleep(400);
            forwardliner.setPower(1);
            return false;
        }


    }
    public Action retracked_claw(){
        return new retracked_claw();
    }

}
