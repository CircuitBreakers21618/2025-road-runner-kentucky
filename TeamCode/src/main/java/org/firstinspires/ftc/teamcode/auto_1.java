package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class auto_1 extends LinearOpMode {
    armintialization LineraMecanizmeteleop = new armintialization();


    @Override
    public void runOpMode(){




        Pose2d beginPose = new Pose2d(-71, -5, 0);

        //calling hardwareMap
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        LineraMecanizmeteleop.init(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .afterTime(.1,LineraMecanizmeteleop.hang_specimen())
                        .lineToX(-50)
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-65, -71, Math.toRadians(0)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )
                        .build());

    }

}
