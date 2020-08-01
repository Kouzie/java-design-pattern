package command;


import java.util.Stack;

// 복수의 명령을 모아둔 명령
public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack();

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
