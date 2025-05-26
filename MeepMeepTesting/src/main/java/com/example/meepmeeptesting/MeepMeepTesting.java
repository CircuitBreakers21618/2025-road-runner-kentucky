package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(500);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(0, 71, -Math.PI / 2))
                        .forward(35)
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-20, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(0)                      // Tangent angle
                        )
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-32, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .waitSeconds(0.1)
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-40, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-47, 60, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .forward(11)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-0.8, 36, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-44, 48, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .back(15)
                        .forward(7)
                        .splineToLinearHeading(
                                new Pose2d(-0.8, 36, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-44, 48, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .back(15)
                        .forward(7)
                        .splineToLinearHeading(
                                new Pose2d(-0.8, 36, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-44, 48, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .back(15)
                        .forward(7)
                        .splineToLinearHeading(
                                new Pose2d(-0.8, 36, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                       .build());
        myBot.setDimensions(16, 16.5);
        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}