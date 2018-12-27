package Game.Components;

import Engine.Entities.Component;
import Engine.Entities.Entity;
import Engine.Input;

public class MovePositionComponent extends Component {

    public MovePositionComponent(Entity parentEntity) {
        super(parentEntity);
    }

    @Override
    public void update() {
        parent.positionY = Input.getMouseY();
        parent.positionX = Input.getMouseX();
    }
}
