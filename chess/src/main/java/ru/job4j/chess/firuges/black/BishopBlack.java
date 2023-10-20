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
        int deltaX = this.position.getX() - dest.getX();
        int deltaY = this.position.getY() - dest.getY();
        for (int index = 0; index < size; index++) {
            int x = deltaX > 0 ? startX - 1 - index : startX + 1 + index;
            int y = deltaY > 0 ? startY - 1 - index : startY + 1 + index;
            steps[index] = Cell.findBy(x, y);
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
