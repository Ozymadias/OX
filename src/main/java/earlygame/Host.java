package earlygame;

import coregame.Input;
import coregame.Output;
import coregame.Position;

public class Host {
    private Input input = new Input();
    private Validator validator = new Validator();
    private Output output = new Output();
    private Parser Parser = new Parser();
    private IntValidator intValidator = new IntValidator();

    public Position decideBoardSize() {
        String move;
        move = input.getString();
        while (!validator.isValid(move)) {
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            move = input.getString();
        }
        return Parser.parse(move);
    }

    public int provideWinningNumber() {
        String winningNb;
        winningNb = input.getString();
        while (!intValidator.isValid(winningNb)) {
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            winningNb = input.getString();
        }
        return IntParser.parse(winningNb);
    }

    public int decideNumberOfGames() {
        output.print("Wybierz liczbe po sobie nastepujacych gier w kolko i krzyzyk ktore beda tworzyc te rozgrywke");
        String nbOfGames;
        nbOfGames = input.getString();
        while (!intValidator.isValid(nbOfGames)) {
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            nbOfGames = input.getString();
        }
        return IntParser.parse(nbOfGames);
    }
}
