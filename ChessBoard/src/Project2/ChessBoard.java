package Project2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application
{
    final GridPane board = new GridPane();
    
    @Override
    public void start(Stage primaryStage)
    {
        //Uncomment the method calls to test your methods
        
        colorBoard();
        setupBoard();


        Scene scene = new Scene(board, 320, 320);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void colorBoard()
    {
        //TODO complete this method as required in the instructions
        StackPane stack = new StackPane();

        //setting the chess board
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Rectangle rec = new Rectangle();
                if((i+j)%2==0)
                    rec.setFill(Color.WHITE);
                else rec.setFill(Color.GREY);
                stack.setAlignment(rec, Pos.TOP_LEFT);
                double x = rec.getX();
                double y = rec.getY();
                rec.translateXProperty().bind(board.widthProperty().divide(8).multiply(i).add(x));
                rec.translateYProperty().bind(board.heightProperty().divide(8).multiply(j).add(y));

                rec.widthProperty().bind(board.widthProperty().divide(8));
                rec.heightProperty().bind(board.heightProperty().divide(8));
                stack.getChildren().add(rec);
            }
        }

        board.add(stack,0,0);

    }

    public void setupBoard()
    {
        //TODO complete this method as required in the instructions

        Image img[] =new Image[12];
        ImageView view [] = new ImageView[12];

        ImageView bpawnV[]=new ImageView[8];
        ImageView brookV[]=new ImageView[2];
        ImageView bknightV[]=new ImageView[2];
        ImageView bbishopV[]=new ImageView[2];
        ImageView wpawnV[]=new ImageView[8];
        ImageView wrookV[]=new ImageView[2];
        ImageView wknightV[]=new ImageView[2];
        ImageView wbishopV[]=new ImageView[2];

        img[0]= new Image("file:images/BlackQueen.png");
        img[1]= new Image("file:images/BlackKing.png");
        img[2]= new Image("file:images/WhiteQueen.png");
        img[3]= new Image("file:images/WhiteKing.png");

        for (Node node : board.getChildren()) { //get the stackpane of colorBoard method
            if (node instanceof StackPane) {
                StackPane stack = (StackPane) node;
                //putting every image into imageview
                for(int i=0;i<4;i++){
                    view[i]=new ImageView(img[i]);
                    stack.getChildren().add(view[i]);
                    view[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    view[i].fitWidthProperty().bind(board.widthProperty().divide(8));
                }
                for(int i=0; i<2;i++){
                    //black
                    Image brook= new Image("file:images/BlackRook.png");
                    brookV[i]=new ImageView(brook);
                    stack.getChildren().add(brookV[i]);
                    brookV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    brookV[i].fitWidthProperty().bind(board.widthProperty().divide(8));

                    Image bknight= new Image("file:images/BlackKnight.png");
                    bknightV[i]=new ImageView(bknight);
                    stack.getChildren().add(bknightV[i]);
                    bknightV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    bknightV[i].fitWidthProperty().bind(board.widthProperty().divide(8));

                    Image bbishop= new Image("file:images/BlackBishop.png");
                    bbishopV[i]=new ImageView(bbishop);
                    stack.getChildren().add(bbishopV[i]);
                    bbishopV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    bbishopV[i].fitWidthProperty().bind(board.widthProperty().divide(8));
                    // white
                    Image wrook= new Image("file:images/WhiteRook.png");
                    wrookV[i]=new ImageView(wrook);
                    stack.getChildren().add(wrookV[i]);
                    wrookV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    wrookV[i].fitWidthProperty().bind(board.widthProperty().divide(8));

                    Image wknight= new Image("file:images/WhiteKnight.png");
                    wknightV[i]=new ImageView(wknight);
                    stack.getChildren().add(wknightV[i]);
                    wknightV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    wknightV[i].fitWidthProperty().bind(board.widthProperty().divide(8));

                    Image wbishop= new Image("file:images/WhiteBishop.png");
                    wbishopV[i]=new ImageView(wbishop);
                    stack.getChildren().add(wbishopV[i]);
                    wbishopV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    wbishopV[i].fitWidthProperty().bind(board.widthProperty().divide(8));
                }
                for(int i=0;i<8;i++){
                    Image bpawn=new Image("file:images/BlackPawn.png");
                    bpawnV[i]=new ImageView(bpawn);
                    Image wpawn=new Image("file:images/WhitePawn.png");
                    wpawnV[i]=new ImageView(wpawn);
                    stack.getChildren().add(bpawnV[i]);
                    stack.getChildren().add(wpawnV[i]);
                    bpawnV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    bpawnV[i].fitWidthProperty().bind(board.widthProperty().divide(8));
                    wpawnV[i].fitHeightProperty().bind(board.heightProperty().divide(8));
                    wpawnV[i].fitWidthProperty().bind(board.widthProperty().divide(8));
                }

                // putting imageviews into right position-------------------------------------------

                //black pieces
                stack.setAlignment(brookV[0], Pos.TOP_LEFT);
                double x = brookV[0].getX();
                double y = brookV[0].getY();
                bknightV[0].translateXProperty().bind(board.widthProperty().divide(8).multiply(1).add(x));
                bbishopV[0].translateXProperty().bind(board.widthProperty().divide(8).multiply(2).add(x));
                view[0].translateXProperty().bind(board.widthProperty().divide(8).multiply(3).add(x));;
                view[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(4).add(x));;
                bbishopV[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(5).add(x));
                bknightV[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(6).add(x));
                brookV[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(7).add(x));
                for(int i=0;i<8;i++){
                    bpawnV[i].translateXProperty().bind(board.widthProperty().divide(8).multiply(i).add(x));
                    bpawnV[i].translateYProperty().bind(board.heightProperty().divide(8).multiply(1).add(y));
                }

                // white pieces
                wrookV[0].translateXProperty().bind(board.widthProperty().divide(8).multiply(0).add(x));
                wrookV[0].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                wknightV[0].translateXProperty().bind(board.widthProperty().divide(8).multiply(1).add(x));
                wknightV[0].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                wbishopV[0].translateXProperty().bind(board.widthProperty().divide(8).multiply(2).add(x));
                wbishopV[0].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                view[2].translateXProperty().bind(board.widthProperty().divide(8).multiply(3).add(x));
                view[2].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                view[3].translateXProperty().bind(board.widthProperty().divide(8).multiply(4).add(x));
                view[3].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                wbishopV[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(5).add(x));
                wbishopV[1].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                wknightV[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(6).add(x));
                wknightV[1].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                wrookV[1].translateXProperty().bind(board.widthProperty().divide(8).multiply(7).add(x));
                wrookV[1].translateYProperty().bind(board.heightProperty().divide(8).multiply(7).add(y));
                for(int i=0;i<8;i++){
                    wpawnV[i].translateXProperty().bind(board.widthProperty().divide(8).multiply(i).add(x));
                    wpawnV[i].translateYProperty().bind(board.heightProperty().divide(8).multiply(6).add(y));
                }
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}