package TicTacToeDev;

import java.util.Scanner;

public class TicTacToePractice {

    static  char[][]game={  {'1','2','3'}     , {'4','5','6'},         {'7','8','9'}};

    static  int moves=0;

    static char player='x';

    public static void main(String[] args) {

        while (true) {

            print();

            Scanner s = new Scanner(System.in);

            System.out.println( "player "+player +"  press 1 to 9\n");

            int input = s.nextInt();


            if (!move(input)) {
                System.out.println("invalid move  retry");
                continue;
            }

            moves++;



           if (winCheck()){
               return;
           }
           else if (moves==9){
               System.out.println("draw");
           }

            if (player=='x')
                player='o';
            else player='x';

        }

    }

    public static  void print(){

        System.out.println(game[0][0]+"  "+game[0][1]+"  "+game[0][2]+"  "+"\n"
                           +game[1][0]+"  "+game[1][1]+"  "+game[1][2]+"  "+"\n"
                           +game[2][0]+"  "+game[2][1]+"  "+game[2][2]+"  "+"\n" );
    }

    public  static  boolean  move(int a){

        for (int i=0;i<3;i++){

            for (int j=0;j<3;j++){

                if (game[i][j]==(char) a+'0'){

                    game[i][j] =player;
                    return true;
                }
            }


        }
        return false;

    }

    public  static  boolean winCheck(){

       for (int i=0;i<3;i++){

           if (game[i][0]==player&&game[i][1]==player&&game[i][2]==player)
           {System.out.println(player+" wins");
               return true;}


           if (game[0][i]==player&&game[1][i]==player&&game[2][i]==player)    {System.out.println(player+" wins");
               return true;}
       }

        if (game[0][0]==player&&game[1][1]==player&&game[2][2]==player)    {System.out.println(player+" wins");
            return true;}

        if (game[2][0]==player&&game[1][1]==player&&game[0][2]==player)   {System.out.println(player+" wins");
        return  true;}

        return false;
    }
}
