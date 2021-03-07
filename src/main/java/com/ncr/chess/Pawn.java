package com.ncr.chess;

public class Pawn {

	private ChessBoard chessBoard;
	private int xCoordinate;
	private int yCoordinate;
	private PieceColor pieceColor;

	public Pawn(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(int value) {
		this.xCoordinate = value;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int value) {
		this.yCoordinate = value;
	}

	public PieceColor getPieceColor() {
		return this.pieceColor;
	}

	public void setPieceColor(PieceColor value) {
		this.pieceColor = value;
	}

	public void move(MovementType movementType, int newX, int newY) {

		switch (movementType) {
		case MOVE: {
			if (isValidMoveForPawn(newX, newY)) {
				this.setXCoordinate(newX);
				this.setYCoordinate(newY);
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + movementType);
		}

	}

	@Override
	public String toString() {
		return getCurrentPositionAsString();
	}

	protected String getCurrentPositionAsString() {
		String eol = System.lineSeparator();
		return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate,
				pieceColor);
	}

	public boolean isValidMoveForPawn(int xCoordinate, int yCoordinate) {
		
		if (this.getYCoordinate() - 2 < 0) {
			return (yCoordinate - this.getYCoordinate() == 1);
		} else {
			return (yCoordinate - this.getYCoordinate()) == -1;
		}
	}
}
