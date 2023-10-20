package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    public void whenCreateF8ToF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell rsl = bishopBlack.position();
        assertThat(rsl).isEqualTo(Cell.F8);
    }

    @Test
    public void whenCopyF8ToB4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.B4);
        Cell rsl = bishopBlackCopy.position();
        assertThat(rsl).isEqualTo(Cell.B4);
    }

    @Test
    public void isDiagonalTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        boolean rsl = bishopBlack.isDiagonal(Cell.C8, Cell.G4);
        assertThat(rsl).isTrue();
    }

    @Test
    public void isNoDiagonalTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        boolean rsl = bishopBlack.isDiagonal(Cell.F8, Cell.D4);
        assertThat(rsl).isFalse();
    }

    @Test
    public void whenBishopC1MovesToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rsl = bishopBlack.way(Cell.G5);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenBishopF4MovesToB8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F4);
        Cell[] expected = {Cell.E5, Cell.D6, Cell.C7, Cell.B8};
        Cell[] rsl = bishopBlack.way(Cell.B8);
        assertThat(rsl).isEqualTo(expected);
    }
}