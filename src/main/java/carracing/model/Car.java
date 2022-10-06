package carracing.model;


public class Car {
    private MoveResult moveResult;

    public Car() {
        this.moveResult = new MoveResult();
    }

    public void tryMove(MovableStrategy movableStrategy) {
        moveResult = moveResult.applyMoveResult(movableStrategy.canMove());
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
