import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class process extends ai{
    public static void start(){

        if (!reset){
            resetButton.setEnabled(false);
            info.setText("Can't reset...");
        } else {
            c = 1;
            N = 0;
            n = 0;
            countDraw = 0;
            play = true;
            one = false;
            two = false;
            three = false;
            four = false;
            five = false;
            six = false;
            seven = false;
            eight = false;
            nine = false;
            One.setText(null);
            One.setBackground(Color.white);
            One.setForeground(Color.black);
            Two.setText(null);
            Two.setBackground(Color.white);
            Two.setForeground(Color.black);
            Three.setText(null);
            Three.setBackground(Color.white);
            Three.setForeground(Color.black);
            Four.setText(null);
            Four.setBackground(Color.white);
            Four.setForeground(Color.black);
            Five.setText(null);
            Five.setBackground(Color.white);
            Five.setForeground(Color.black);
            Six.setText(null);
            Six.setBackground(Color.white);
            Six.setForeground(Color.black);
            Seven.setText(null);
            Seven.setBackground(Color.white);
            Seven.setForeground(Color.black);
            Eight.setText(null);
            Eight.setBackground(Color.white);
            Eight.setForeground(Color.black);
            Nine.setText(null);
            Nine.setBackground(Color.white);
            Nine.setForeground(Color.black);
            info.setText(enterLetter() + "'s Turn");
            letter = enterLetter();
        }
    }

    public static void setColor(){
        if (letter.equals("X")){
            switch (N){
                case 1 -> One.setForeground(Color.blue);
                case 2 -> Two.setForeground(Color.blue);
                case 3 -> Three.setForeground(Color.blue);
                case 4 -> Four.setForeground(Color.blue);
                case 5 -> Five.setForeground(Color.blue);
                case 6 -> Six.setForeground(Color.blue);
                case 7 -> Seven.setForeground(Color.blue);
                case 8 -> Eight.setForeground(Color.blue);
                case 9 -> Nine.setForeground(Color.blue);
            }
        } else {
            switch (N){
                case 1 -> One.setForeground(Color.red);
                case 2 -> Two.setForeground(Color.red);
                case 3 -> Three.setForeground(Color.red);
                case 4 -> Four.setForeground(Color.red);
                case 5 -> Five.setForeground(Color.red);
                case 6 -> Six.setForeground(Color.red);
                case 7 -> Seven.setForeground(Color.red);
                case 8 -> Eight.setForeground(Color.red);
                case 9 -> Nine.setForeground(Color.red);
            }
        }
    }

    public static void display() {
        writeBox(N);
        setColor();
        c++;
        letter = enterLetter();
        info.setText(letter + "'s Turn");
        countDraw++;
        checkWin();
    }

    public static void onClickBox() { // this method is activated everytime a box is clicked. It controls series of algorithms and methods (na lie oh...na just 3 main methods with 3 sub methods lol) everytime a box is clicked
        if (play){
            if (!checkBox()) {
                display();


                AI();
            } else {
                info.setText("Invalid input!");
            }
        }
    }

    public static boolean checkXO() { // this method alternates the turns of the players with a very simple algorithm. Remember the c variable at the beginning? It keeps increasing by 1 after every loop...this is because if it's even in a particular loop, it's O's turn and if it's odd, it's X's turn. But this method just makes it return a true value if it's even and a false one if it's false
        return c % 2 == 0;
    }

    public static String enterLetter() { // this method relies on the one above (checkXO) to decide which letter to be displayed. It also decides which player's turn it is
        if (checkXO()) return "O"; else return "X";
    }

    public static int rand() {
        randomNumber = ThreadLocalRandom.current().nextInt(1, 9);
        return randomNumber;
    }

    public static void writeBox(int c) { // this method displays either an "X" or an "0" in a box using the logic above
        switch (c) { // I used the enhanced switch statement to shorten the code...
            case 1 -> One.setText(letter);
            case 2 -> Two.setText(letter);
            case 3 -> Three.setText(letter);
            case 4 -> Four.setText(letter);
            case 5 -> Five.setText(letter);
            case 6 -> Six.setText(letter);
            case 7 -> Seven.setText(letter);
            case 8 -> Eight.setText(letter);
            case 9 -> Nine.setText(letter);
        }
    }

    public static boolean checkBox() { // this checks whether the selected box is empty or not. If it returns a false value, its empty. If it returns otherwise, it's occupied
        switch (N) {
            case 1:
                if (!one) {
                    one = true; // if it's empty, it returns a false value after changing the boolean variable to true so that it returns true if it's clicked a second time
                    return false;
                } else return true;
            case 2:
                if (!two) {
                    two = true;
                    return false;
                } else return true;
            case 3:
                if (!three) {
                    three = true;
                    return false;
                } else return true;
            case 4:
                if (!four) {
                    four = true;
                    return false;
                } else return true;
            case 5:
                if (!five) {
                    five = true;
                    return false;
                } else return true;
            case 6:
                if (!six) {
                    six = true;
                    return false;
                } else return true;
            case 7:
                if (!seven) {
                    seven = true;
                    return false;
                } else return true;
            case 8:
                if (!eight) {
                    eight = true;
                    return false;
                } else return true;
            case 9:
                if (!nine) {
                    nine = true;
                    return false;
                } else return true;
            default:
                return false;
        }

    }

    public static void winColor() {
        if (winNumber("X") != -1){
            switch (winNumber("X")){
                case 123 -> {
                    One.setBackground(Color.blue);
                    One.setForeground(Color.white);
                    Two.setBackground(Color.blue);
                    Two.setForeground(Color.white);
                    Three.setBackground(Color.blue);
                    Three.setForeground(Color.white);
                }
                case 456 -> {
                    Four.setBackground(Color.blue);
                    Four.setForeground(Color.white);
                    Five.setBackground(Color.blue);
                    Five.setForeground(Color.white);
                    Six.setBackground(Color.blue);
                    Six.setForeground(Color.white);
                }
                case 789 -> {
                    Seven.setBackground(Color.blue);
                    Seven.setForeground(Color.white);
                    Eight.setBackground(Color.blue);
                    Eight.setForeground(Color.white);
                    Nine.setBackground(Color.blue);
                    Nine.setForeground(Color.white);
                }
                case 147 -> {
                    One.setBackground(Color.blue);
                    One.setForeground(Color.white);
                    Four.setBackground(Color.blue);
                    Four.setForeground(Color.white);
                    Seven.setBackground(Color.blue);
                    Seven.setForeground(Color.white);
                }
                case 258 -> {
                    Two.setBackground(Color.blue);
                    Two.setForeground(Color.white);
                    Five.setBackground(Color.blue);
                    Five.setForeground(Color.white);
                    Eight.setBackground(Color.blue);
                    Eight.setForeground(Color.white);
                }
                case 369 -> {
                    Three.setBackground(Color.blue);
                    Three.setForeground(Color.white);
                    Six.setBackground(Color.blue);
                    Six.setForeground(Color.white);
                    Nine.setBackground(Color.blue);
                    Nine.setForeground(Color.white);
                }
                case 159 -> {
                    One.setBackground(Color.blue);
                    One.setForeground(Color.white);
                    Five.setBackground(Color.blue);
                    Five.setForeground(Color.white);
                    Nine.setBackground(Color.blue);
                    Nine.setForeground(Color.white);
                }
                case 357 -> {
                    Three.setBackground(Color.blue);
                    Three.setForeground(Color.white);
                    Five.setBackground(Color.blue);
                    Five.setForeground(Color.white);
                    Seven.setBackground(Color.blue);
                    Seven.setForeground(Color.white);
                }
            }
        } else if (winNumber("O") != -1){
            switch (winNumber("O")){
                case 123 -> {
                    One.setBackground(Color.red);
                    One.setForeground(Color.white);
                    Two.setBackground(Color.red);
                    Two.setForeground(Color.white);
                    Three.setBackground(Color.red);
                    Three.setForeground(Color.white);
                }
                case 456 -> {
                    Four.setBackground(Color.red);
                    Four.setForeground(Color.white);
                    Five.setBackground(Color.red);
                    Five.setForeground(Color.white);
                    Six.setBackground(Color.red);
                    Six.setForeground(Color.white);
                }
                case 789 -> {
                    Seven.setBackground(Color.red);
                    Seven.setForeground(Color.white);
                    Eight.setBackground(Color.red);
                    Eight.setForeground(Color.white);
                    Nine.setBackground(Color.red);
                    Nine.setForeground(Color.white);
                }
                case 147 -> {
                    One.setBackground(Color.red);
                    One.setForeground(Color.white);
                    Four.setBackground(Color.red);
                    Four.setForeground(Color.white);
                    Seven.setBackground(Color.red);
                    Seven.setForeground(Color.white);
                }
                case 258 -> {
                    Two.setBackground(Color.red);
                    Two.setForeground(Color.white);
                    Five.setBackground(Color.red);
                    Five.setForeground(Color.white);
                    Eight.setBackground(Color.red);
                    Eight.setForeground(Color.white);
                }
                case 369 -> {
                    Three.setBackground(Color.red);
                    Three.setForeground(Color.white);
                    Six.setBackground(Color.red);
                    Six.setForeground(Color.white);
                    Nine.setBackground(Color.red);
                    Nine.setForeground(Color.white);
                }
                case 159 -> {
                    One.setBackground(Color.red);
                    One.setForeground(Color.white);
                    Five.setBackground(Color.red);
                    Five.setForeground(Color.white);
                    Nine.setBackground(Color.red);
                    Nine.setForeground(Color.white);
                }
                case 357 -> {
                    Three.setBackground(Color.red);
                    Three.setForeground(Color.white);
                    Five.setBackground(Color.red);
                    Five.setForeground(Color.white);
                    Seven.setBackground(Color.red);
                    Seven.setForeground(Color.white);
                }
            }
        }
    }

    public static int winNumber (String a){
        if ((One.getText() == a & Two.getText() == a & Three.getText() == a)) {
            return 123;
        } else if ((Four.getText() == a & Five.getText() == a & Six.getText() == a)) {
            return 456;
        } else if ((Seven.getText() == a & Eight.getText() == a & Nine.getText() == a)) {
            return 789;
        } else if ((One.getText() == a & Four.getText() == a & Seven.getText() == a)) {
            return 147;
        } else if ((Two.getText() == a & Five.getText() == a & Eight.getText() == a)) {
            return 258;
        } else if ((Three.getText() == a & Six.getText() == a & Nine.getText() == a)) {
            return 369;
        } else if ((One.getText() == a & Five.getText() == a & Nine.getText() == a)) {
            return 159;
        } else if ((Three.getText() == a & Five.getText() == a & Seven.getText() == a)){
            return 357;
        }
        return -1;
    }

    public static void checkWin() { // the second most tedious method in this program after the AI method... this checks if any of the players have won the game
        if ((One.getText() == "X" & Two.getText() == "X" & Three.getText() == "X") | (Four.getText() == "X" & Five.getText() == "X" & Six.getText() == "X") | (Seven.getText() == "X" & Eight.getText() == "X" & Nine.getText() == "X") | (One.getText() == "X" & Four.getText() == "X" & Seven.getText() == "X") | (Two.getText() == "X" & Five.getText() == "X" & Eight.getText() == "X") | (Three.getText() == "X" & Six.getText() == "X" & Nine.getText() == "X") | (One.getText() == "X" & Five.getText() == "X" & Nine.getText() == "X") | (Three.getText() == "X" & Five.getText() == "X" & Seven.getText() == "X")) {
            play = false;
            info.setText("X wins!"); //X wins if it forms a complete row, column or diagonal. Same goes for O.
            winNumber("X");
        } else if ((One.getText() == "O" & Two.getText() == "O" & Three.getText() == "O") | (Four.getText() == "O" & Five.getText() == "O" & Six.getText() == "O") | (Seven.getText() == "O" & Eight.getText() == "O" & Nine.getText() == "O") | (One.getText() == "O" & Four.getText() == "O" & Seven.getText() == "O") | (Two.getText() == "O" & Five.getText() == "O" & Eight.getText() == "O") | (Three.getText() == "O" & Six.getText() == "O" & Nine.getText() == "O") | (One.getText() == "O" & Five.getText() == "O" & Nine.getText() == "O") | (Three.getText() == "O" & Five.getText() == "O" & Seven.getText() == "O")) {
            play = false;
            info.setText("O wins!");
            winNumber("O");
        } else if (countDraw == 9) { //a tie is accomplished if the countDraw variable records 9 turns without a win. This means that the board is filled up
            play = false;
            info.setText("It's a draw!");
            reset = false;
        }
        winColor();
    }
}