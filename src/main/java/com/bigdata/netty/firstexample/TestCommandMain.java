package com.bigdata.netty.firstexample;

import java.nio.charset.CoderMalfunctionError;
import java.util.LinkedList;
import java.util.Queue;

public class TestCommandMain {
    public static void main(String[] args) {
        Receiver receiver = new Receiver("andrew", "回旋打击");

        MoveCommand command1 = new MoveCommand(receiver, 10.0, 20.0);
        SkillCommand command2 = new SkillCommand(receiver);
        MoveCommand command3 = new MoveCommand(receiver, 30.0, 30.0);
        SkillCommand command4 = new SkillCommand(receiver);
        MoveCommand command5 = new MoveCommand(receiver, 40.0, 40.0);
        SkillCommand command6 = new SkillCommand(receiver);


        Queue<Command> queue = new LinkedList<>();
        queue.offer(command1);
        queue.offer(command2);
        queue.offer(command3);  queue.offer(command4);  queue.offer(command5);  queue.offer(command6);

        while (!queue.isEmpty()){
            Command command = queue.poll();
            Invoker invoker = new Invoker(command);
            invoker.action();
            System.out.println();


        }


    }
}

class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public  void action(){
        command.execute();
    }


}


interface  Command{
    void execute();
}

class Receiver{
    private String  name;
    private String  skill;

    public Receiver(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void action(){
        System.out.println(String.format("%s do action", this.getName()));
    }


}

class MoveCommand implements Command{
    private Receiver receiver;

    private double locX;
    private double locY;

    public MoveCommand(Receiver receiver, double locX, double locY) {
        this.receiver = receiver;
        this.locX = locX;
        this.locY = locY;
    }

    @Override
    public void execute() {
        this.receiver.action();
        System.out.println(String.format("move to (%f, %f)", locX, locY));

    }
}

class SkillCommand implements Command{
    private Receiver receiver;

    public SkillCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
        System.out.println(String.format("use skill: %s", receiver.getSkill()));
    }
}
