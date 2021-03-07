package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
    	pawn.setChessBoard( this );
    	pawn.setPieceColor(pieceColor);
    	if ( !isLegalBoardPosition( xCoordinate, yCoordinate ) )
        {
    		pawn.setXCoordinate( -1 );
        	pawn.setYCoordinate( -1 );
        } else 
        {
    	pawn.setXCoordinate( xCoordinate );
    	pawn.setYCoordinate( yCoordinate );
    	this.pieces[xCoordinate][yCoordinate] = pawn;
        }
    
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	if(xCoordinate < 0 || xCoordinate >= MAX_BOARD_WIDTH || yCoordinate < 0 || yCoordinate >= MAX_BOARD_HEIGHT) {
    		return false;
    	}
    	if ( null != this.pieces[xCoordinate][yCoordinate] )
        {
            return false;
        }

        return true;
    	
    }
    
   
}
