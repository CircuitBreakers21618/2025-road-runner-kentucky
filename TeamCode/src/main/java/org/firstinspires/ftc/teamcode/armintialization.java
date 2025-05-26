package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

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
    }
}
