package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int startX = this.position().getX();
        int startY = this.position().getY();
        int size = Math.abs(startX - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = Integer.compare(dest.getX(), this.position.getX());
        int deltaY = Integer.compare(dest.getY(), this.position.getY());
        for (int index = 0; index < size; index++) {
            startX += deltaX;
            startY += deltaY;
            steps[index] = Cell.findBy(startX, startY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
