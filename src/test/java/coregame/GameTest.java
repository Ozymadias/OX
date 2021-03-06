package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import player.LocalPlayer;

import java.io.PrintStream;

import static coregame.Result.WIN;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class GameTest {
    @DataProvider
    public static Object[][] dummyGame() {
        return new Object[][]{
                {"3 3", "1", "0 0"}
        };
    }

    @DataProvider
    public static Object[][] classicGamesX() {
        return new Object[][]{
                {"3 3", "3", "0 0", "0 1", "0 2", "1 0", "1 1", "1 2", "2 0", "2 1", "2 2"},
                {"3 3", "3", "1 1", "0 1", "0 2", "1 0", "0 0", "1 2", "2 0", "2 1", "2 2"},
                {"3 3", "3", "0 1", "0 0", "2 1", "2 2", "0 2", "1 0", "1 1", "1 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "1 2", "2 0", "0 2", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 2", "0 1", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 2", "1 0", "0 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 2", "1 0", "1 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 2", "0 1", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 2", "1 0", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 2", "1 0", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "0 2", "1 0", "1 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "0 2", "1 0", "2 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "0 2", "1 1", "1 0", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "0 2", "1 1", "2 0", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "0 2", "2 0", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "0 2", "2 0", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 0", "0 2", "1 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 0", "0 2", "2 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 0", "1 1", "0 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 0", "1 1", "2 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 0", "2 0", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 1", "0 2", "1 0", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 1", "0 2", "2 0", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 1", "1 0", "0 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 1", "1 0", "2 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 1", "2 0", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "2 0", "0 2", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "2 0", "0 2", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "2 0", "1 0", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "2 0", "1 0", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "2 0", "1 1", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "2 0", "1 1", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "0 1", "1 0", "2 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "0 1", "1 1", "1 0", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "0 1", "1 1", "2 0", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "0 1", "2 0", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 0", "0 1", "1 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 0", "0 1", "2 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 0", "1 1", "0 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 0", "1 1", "2 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 0", "2 0", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 1", "0 1", "1 0", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 1", "0 1", "2 0", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 1", "1 0", "2 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "2 0", "0 1", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "2 0", "0 1", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "2 0", "1 0", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "2 0", "1 0", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "2 0", "1 1", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "2 0", "1 1", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 1", "0 2", "2 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 1", "1 1", "0 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 1", "1 1", "2 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 1", "2 0", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 1", "2 0", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 2", "0 1", "1 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 2", "0 1", "2 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 2", "1 1", "0 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 2", "1 1", "2 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 2", "2 0", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 2", "2 0", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "1 1", "0 1", "0 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "1 1", "0 1", "2 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "1 1", "0 2", "2 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "1 1", "2 0", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "1 1", "2 0", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "2 0", "0 1", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "2 0", "0 1", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "2 0", "0 2", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "2 0", "0 2", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "2 0", "1 1", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "2 0", "1 1", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 1", "0 2", "1 0", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 1", "0 2", "2 0", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 1", "1 0", "0 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 1", "1 0", "2 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 1", "2 0", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 1", "2 0", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 2", "0 1", "1 0", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 2", "0 1", "2 0", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 2", "1 0", "0 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 2", "1 0", "2 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 2", "2 0", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "0 2", "2 0", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "1 0", "0 1", "0 2", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "1 0", "0 1", "2 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "1 0", "0 2", "0 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "1 0", "0 2", "2 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "1 0", "2 0", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "1 0", "2 0", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "2 0", "0 1", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "2 0", "0 1", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "2 0", "0 2", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "2 0", "0 2", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "2 0", "1 0", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 1", "2 0", "1 0", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 1", "0 2", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 1", "1 0", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 1", "1 0", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 1", "1 1", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 1", "1 1", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 2", "0 1", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 2", "0 1", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 2", "1 0", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 2", "1 0", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 2", "1 1", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 2", "1 1", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 0", "0 1", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 0", "0 2", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 0", "1 1", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 0", "1 1", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 1", "0 1", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 1", "1 0", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 1", "1 0", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "0 2", "1 0", "1 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "0 2", "1 1", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "0 2", "1 1", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "0 2", "1 2", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 0", "0 2", "1 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 0", "0 2", "1 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 0", "1 1", "0 2", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 0", "1 1", "1 2", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 0", "1 2", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 0", "1 2", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 1", "0 2", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 1", "0 2", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 1", "1 0", "1 2", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 1", "1 2", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 2", "0 2", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 2", "0 2", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 2", "1 0", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 2", "1 0", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 2", "1 1", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 2", "1 1", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "0 1", "1 0", "1 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "0 1", "1 1", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "0 1", "1 1", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "0 1", "1 2", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "0 1", "1 2", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 0", "0 1", "1 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 0", "0 1", "1 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 0", "1 1", "0 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 0", "1 1", "1 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 0", "1 2", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 0", "1 2", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 1", "0 1", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 1", "0 1", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 1", "1 0", "1 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 1", "1 2", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 1", "1 2", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 2", "0 1", "1 0", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 2", "0 1", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 2", "1 0", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 2", "1 0", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 2", "1 1", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 2", "1 1", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 1", "0 2", "1 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 1", "1 1", "0 2", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 1", "1 1", "1 2", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 1", "1 2", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 2", "0 1", "1 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 2", "1 1", "0 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 2", "1 1", "1 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 2", "1 2", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 1", "0 1", "1 2", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 1", "0 2", "1 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 2", "0 1", "0 2", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 2", "0 1", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 2", "0 2", "0 1", "1 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 2", "0 2", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 2", "1 1", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 2", "1 1", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 1", "0 1", "0 2", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 1", "0 1", "0 2", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 1", "0 1", "1 0", "0 2", "1 2"}
        };
    }

    @DataProvider
    public static Object[][] classicGamesY() {
        return new Object[][]{
                {"3 3", "3", "2 2", "0 0", "0 1", "0 2", "1 0", "1 1", "1 2", "2 0", "2 1"},
                {"3 3", "3", "0 1", "0 0", "2 2", "0 2", "1 0", "1 1", "1 2", "2 0", "2 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "1 2", "2 0", "1 0", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "1 2", "2 0", "1 0", "0 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 1", "0 2", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 1", "0 2", "1 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 1", "1 0", "0 2", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 1", "1 0", "1 2", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 1", "1 2", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 1", "1 2", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 2", "1 2", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 0", "0 1", "1 2", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 0", "0 2", "0 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 0", "0 2", "1 2", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 0", "1 2", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 2", "0 1", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 2", "0 2", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 2", "0 2", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 0", "2 0", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 1", "1 1", "2 0", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "0 1", "2 0", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "0 1", "1 0", "1 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 0", "2 0", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "0 1", "0 2", "1 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 1", "1 0", "0 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 1", "2 0", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "0 2", "1 1", "2 0", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "1 0", "1 1", "0 2", "0 1", "2 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "0 1", "0 2", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 0", "0 1", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 0", "0 2", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 1", "0 1", "1 0", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 1", "0 2", "0 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 2", "2 0", "1 1", "0 2", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "0 2", "1 0", "1 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "0 2", "1 2", "1 1", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "0 1", "1 0", "1 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 1", "1 0", "0 2", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 1", "1 1", "1 2", "0 2", "1 0"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "0 2", "1 1", "1 0", "0 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 1", "0 2", "1 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 1", "1 2", "1 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 2", "0 1", "1 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "0 2", "1 2", "1 1", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 1", "0 1", "0 2", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 1", "0 2", "0 1", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 1", "1 2", "0 1", "0 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "2 0", "1 0", "1 1", "1 2", "0 2", "0 1"},

        };
    }

    @DataProvider
    public static Object[][] classicGamesDraw() {
        return new Object[][]{
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 2", "0 1", "1 0", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "0 2", "1 2", "1 0", "0 1"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 0", "0 1", "0 2", "1 2"},
                {"3 3", "3", "2 2", "2 1", "0 0", "1 1", "2 0", "1 0", "1 2", "0 2", "0 1"},
        };
    }

    @Test(dataProvider = "dummyGame")
    public void oneMoveGame(String[] inputString) {
        Output.printStream = mock(PrintStream.class);
        Input input = new MockInput(inputString);
        Messenger.provide("polish");
        LocalPlayer first = new LocalPlayer("first", input);
        LocalPlayer second = new LocalPlayer("second", input);
        Game game = new Game(first, second);
        GameResults gameResults = game.play(input);
        assertEquals(WIN, gameResults.get(first));
    }

    @Test(dataProvider = "classicGamesX")
    public void classicGameX(String[] inputString) {
        Output.printStream = mock(PrintStream.class);
        Input input = new MockInput(inputString);
        Messenger.provide("polish");
        LocalPlayer first = new LocalPlayer("first", input);
        LocalPlayer second = new LocalPlayer("second", input);
        Game game = new Game(first, second);
        GameResults gameResults = game.play(input);
        assertEquals(WIN, gameResults.get(first));
    }

    @Test(dataProvider = "classicGamesY")
    public void classicGameY(String[] inputString) {
        Output.printStream = mock(PrintStream.class);
        Input input = new MockInput(inputString);
        Messenger.provide("polish");
        LocalPlayer first = new LocalPlayer("first", input);
        LocalPlayer second = new LocalPlayer("second", input);
        Game game = new Game(first, second);
        GameResults gameResults = game.play(input);
        assertEquals(WIN, gameResults.get(second));
    }
}
