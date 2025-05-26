package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class chaseintialization {

    public DcMotor topleft;
    public DcMotor topright;
    public DcMotor backleft;
    public DcMotor backright;

    public void init(HardwareMap hwMap){

        topleft = hwMap.get(DcMotor.class, "topleft");
        topright = hwMap.get(DcMotor.class, "topright");
        backleft = hwMap.get(DcMotor.class, "backleft");
        backright = hwMap.get(DcMotor.class, "backright");
    }
}

