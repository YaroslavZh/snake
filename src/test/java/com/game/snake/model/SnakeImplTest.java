package com.game.snake.model;

import com.game.snake.model.api.Position;
import com.game.snake.model.api.Snake;
import com.game.snake.model.enums.MoveDirection;
import com.game.snake.model.impl.PositionImpl;
import com.game.snake.model.impl.SnakeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SnakeImplTest {

    private Snake snake;

    @BeforeEach
    void setUp() {
        snake = new SnakeImpl(new PositionImpl(0, 0), 1);
    }

    @Test
    public void whenMoveDirectionIsUpMoveSnakeUp() {
        Position initPosition = snake.move();
        snake.changeDirection(MoveDirection.UP);
        Position newPosition = snake.move();
        Assertions.assertEquals(initPosition.getX(), newPosition.getX());
        Assertions.assertEquals(initPosition.getY() - 1, newPosition.getY());
    }

    @Test
    public void whenMoveDirectionIsDownMoveSnakeDown() {
        Position initPosition = new PositionImpl(snake.move());
        snake.changeDirection(MoveDirection.DOWN);
        Position newPosition = snake.move();
        Assertions.assertEquals(initPosition.getX(), newPosition.getX());
        Assertions.assertEquals(initPosition.getY() + 1, newPosition.getY());
    }

    @Test
    public void whenMoveDirectionIsLeftMoveSnakeLeft() {
        Position initPosition = snake.move();
        snake.changeDirection(MoveDirection.LEFT);
        Position newPosition = snake.move();
        Assertions.assertEquals(initPosition.getX() - 1, newPosition.getX());
        Assertions.assertEquals(initPosition.getY(), newPosition.getY());
    }

    @Test
    public void whenMoveDirectionIsRightMoveSnakeRight() {
        Position initPosition = snake.move();
        snake.changeDirection(MoveDirection.RIGHT);
        Position newPosition = snake.move();
        Assertions.assertEquals(initPosition.getX() + 1, newPosition.getX());
        Assertions.assertEquals(initPosition.getY(), newPosition.getY());
    }

    @Test
    public void whenGrowThanSnakeIncrementSize() {
        int initSize = snake.getSegments().size();
        snake.grow();
        int newSize = snake.getSegments().size();
        Assertions.assertEquals(initSize, newSize);
        // змейка вырастет, только когда сойдет с поля на котром была еда
        snake.move();
        newSize = snake.getSegments().size();
        Assertions.assertEquals(initSize + 1, newSize);
    }
}