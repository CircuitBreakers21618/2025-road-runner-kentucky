package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class chaseintialization {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    public void init(HardwareMap hwMap){

        leftFront = hwMap.get(DcMotor.class, "leftFront");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        leftBack = hwMap.get(DcMotor.class, "leftBack");
        rightBack = hwMap.get(DcMotor.class, "rightBack");
    }


    public void RightTurn(double power, long time) throws InterruptedException {
        leftBack.setPower(-power);
        rightBack.setPower(-power);
        leftFront.setPower(power);
        rightFront.setPower(-power);
        //how long it waits
        sleep(time);

    }
    public void LeftTurn(double power, long time) throws InterruptedException {
        leftBack.setPower(-power);
        rightBack.setPower(power);
        leftFront.setPower(-power);
        rightFront.setPower(-power);
        //how long it waits
        sleep(time);

    }

    public void stopmotor(){
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);

    }

    public void moveforward(double power, long time) throws InterruptedException {
        leftBack.setPower(-power);
        rightBack.setPower(power);
        leftFront.setPower(power);
        rightFront.setPower(power);
        //how long it waits
        sleep(time);

    }
}

